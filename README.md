# chuck-norris-facts
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=com.denisgasparoto.chucknorrisfacts&metric=alert_status)](https://sonarcloud.io/dashboard?id=com.denisgasparoto.chucknorrisfacts)

# Facts

Android app written in Kotlin.

## Continuous Integration

Runs Detekt
```./gradlew detekt --stacktrace```

Runs Unit Tests
```./gradlew test --stacktrace```

Runs Jacoco
```./gradlew clean build jacocoUnitTestReport```
