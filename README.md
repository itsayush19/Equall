# Equall

A Kotlin Multiplatform (KMP) app targeting **Android** and **iOS**, with a shared UI built in **Compose Multiplatform**.

The Home screen has a top bar, bottom navigation, and a tab bar with three tabs — **Discovery**, **Review**, and **Active** — each backed by its own screen, ViewModel, and API (currently served from in-app mocks).

## Tech stack

- **Kotlin Multiplatform** + **Compose Multiplatform** (shared UI)
- **Koin** — dependency injection
- **Ktor** client + **kotlinx.serialization** — networking / JSON
- **Coroutines / StateFlow** + **AndroidX Lifecycle ViewModel**

## Architecture

Unidirectional, layered:

```
Screen (Compose)  ──>  ViewModel (StateFlow<UiState<T>>)  ──>  Repository (interface)
                                                                     │
                                                          RepositoryImpl + Mapper
                                                                     │
                                                          DTO ──(Mapper)──> Domain model
```

- **DTOs** mirror the API JSON; **Mappers** convert DTO → domain models.
- **Repositories** are `interface` + `Impl`; the impl calls the API (mocked for now) and returns **domain models** directly.
- **ViewModels** expose a single `StateFlow<UiState<T>>` (`Loading` / `Success` / `Error`) and fetch in `init`.

## Project structure

```
shared/src/commonMain/kotlin/com/aktech/equall/
├── common/components/      # Reusable composables (GreetingHeader, TrustIqCard)
├── data/
│   ├── mapper/             # DTO -> domain mappers (Discovery/Review/Active + shared TrustIq)
│   ├── remote/
│   │   ├── dto/            # API DTOs (+ mock payloads, shared CommonDto)
│   │   └── ApiRoutes.kt    # Base URL + endpoints
│   └── repository/         # XRepository (interface) + XRepositoryImpl
├── di/                     # Koin modules (see below)
├── domain/model/           # Domain models (DiscoveryInfo, ReviewInfo, ActiveLoan, TrustIq)
├── screens/
│   ├── MainScreen.kt       # App shell: top bar + bottom navigation
│   └── HomeScreen/presentation/
│       ├── HomeScreen.kt   # Tab bar + routes to the selected tab
│       ├── discovery/      # DiscoveryScreen + DiscoveryViewModel
│       ├── review/         # ReviewScreen + ReviewViewModel
│       └── active/         # ActiveScreen + ActiveViewModel
└── utils/                  # UiState, StateViews, EquallColors, EquallIcons

androidApp/                 # Android entry point (MainActivity, EquallApplication)
iosApp/                     # iOS entry point (Xcode project)
```

## Dependency injection (Koin)

DI is split by layer under `di/`, started via `initKoin()` (called from `EquallApplication` on Android and `MainViewController` on iOS):

| Module | Provides |
|--------|----------|
| `appModule` | The Ktor `HttpClient` (JSON, timeouts, logging, base URL) |
| `mapperModule` | `TrustIqMapper` (shared) + `Discovery` / `Review` / `Active` mappers |
| `repositoryModule` | Binds each repo interface to its impl: `single<XRepository> { XRepositoryImpl(get(), get()) }` |
| `viewModelModule` | The three ViewModels via `viewModel { … }` (resolved in Compose with `koinViewModel()`) |

## Running

- **Android:** `./gradlew :androidApp:assembleDebug` (or run from the IDE)
- **iOS:** open [`/iosApp`](./iosApp) in Xcode and run

## Notes

- All three tabs currently return **mocked data** from `data/remote/dto/*Mock.kt`; the real API call is left as a `TODO` in each `RepositoryImpl`.
- ViewModels are Activity-scoped, so switching tabs and returning **reuses** the loaded data (no re-fetch).
