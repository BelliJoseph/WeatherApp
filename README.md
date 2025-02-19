# My Weather App

## Design
This project uses the MVVM + clean architecture using a repository layer for more abstraction. 
This project uses the recyclerView component to display the list of movies. 
The builder pattern was used to create Moshi, OkHttp, and Retrofit.

![MainScreen](https://github.com/user-attachments/assets/b055b2f8-1517-478d-ac0a-2a2b2db8ad92)

## Libraries
OkHttp, LoggingInterceptor, and Retrofit were used for network calls for ease of use and reliability.
```
implementation 'com.squareup.retrofit2:retrofit:2.11.0'
implementation 'com.squareup.okhttp3:okhttp:5.0.0-alpha.14'
implementation 'com.squareup.okhttp3:logging-interceptor:4.12.0'
```

Moshi was used for converting JSON to Kotlin data class objects.
Moshi was used for it's speed of converting and ease of use.
```
implementation 'com.squareup.retrofit2:converter-moshi:2.11.0'
implementation 'com.squareup.moshi:moshi-kotlin:1.15.2'
```

Coroutines was used for long running tasks for network calls.
```
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-android:1.10.1'
implementation 'org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1'
```

Navigation component was used to navigate between fragments due to its efficiency and ability
to direct user flow.
```
implementation 'androidx.navigation:navigation-fragment-ktx:2.8.7'
implementation 'androidx.navigation:navigation-ui-ktx:2.8.7'
```

Koin was used for dependency injection for its ease in implementing throughout the application.
```
implementation 'io.insert-koin:koin-android:4.0.2'
implementation 'io.insert-koin:koin-core:4.0.2'
```
