[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.denisgasparoto.chucknorrisfacts&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.denisgasparoto.chucknorrisfacts)

# Facts

Android app written in **Kotlin**, integrated with [chucknorris.io](https://api.chucknorris.io/)

## Architecture Decisions
- **View** - updates UI, observes changes to ViewModel
- **ViewModel** - communicates with Router and Interactor
- **Router** - put the navigation logic in one place
- **Interactor** - useCases aggregator
- **UseCase** - connect to APIs

## Continuous Integration
```
./gradlew build jacocoUnitTestReport sonarqube
```

## Tech Specs
- **Kotlin**
- **Retrofit** - HTTP Requests
- **RxJava** - Reactive Programming
- **Koin** - Dependency Injection
- **MockK** - mocking library for Kotlin


