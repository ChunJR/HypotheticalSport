# HypotheticalSport

Single Activity App with Jetpack Compose, built-in Clean Architecture.

## Features

- Matches screen: 
  - Display all Matches with highlight thumbnails.
  - Previous matches can view highlights. ( not done yet )
  - Upcoming matches can set schedule local notification. ( not done yet )
- Teams screen: 
  - Display all Teams with logo.
  - View matches button to show all matches of specific teams.
- Team Match screen: 
  - Display all matches specified team.
  - All features same as the Match Screen.

## Technical

- **Android Jetpack Component**:
  - **[Compose]** - Android’s recommended modern toolkit for building native UI.
  - **[ViewModel]** - a class designed to store and manage UI-related data in a lifecycle-conscious way.
  - **[StateFlow]** - an observable data holder class.
  - **[Navigation]** - to let users navigate across, into, and back out from the different pieces of content within your app.
  - **[Splash API]** - lets apps launch with animation, including an into-app motion at launch.

- **Design Pattern**:
  - **[MVVM]** a Model-View-ViewModel architecture that removes the tight coupling between each component.
  
 - **Dependency Injection**:
   - **[Hilt]** - a dependency injection library for Android that reduces the boilerplate of doing manual dependency injection in your project.
 
- **Networking**:  
  - **[Retrofit]** - a type-safe REST client for Android that aims to make it easier to consume RESTful web services.
  - **[Coil]** - an image-loading library backed by Kotlin Coroutines.
  
 - **Asynchronous**:
  - **[Coroutine]** - a concurrency design pattern that you can use on Android to simplify code that executes asynchronously.
 
 - **Tesing**:
   - **[Junit]** - a great unit testing platform for Java applications and now it offers special APIs for Android developers.
   - **[Mockito]** - a mocking framework that tastes really good. It lets you write beautiful tests with a clean & simple API.
