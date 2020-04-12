[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.denisgasparoto.chucknorrisfacts&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.denisgasparoto.chucknorrisfacts)

# Facts

Android app written in Kotlin, integrated with [chucknorris.io](https://api.chucknorris.io/)

## Continuous Integration

Run Detekt
```
./gradlew detekt
```

Run Unit Tests
```
./gradlew test
```

Run Jacoco Reports
```
./gradlew clean build jacocoUnitTestReport
```

## Tech Specs
- Kotlin
- Retrofit | HTTP Requests
- RxJava | Reactive Programming
- Koin | Dependency Injection
- MockK | mocking library for Kotlin


