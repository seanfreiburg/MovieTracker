# MovieTracker by Sean Freiburg

# Focus

I focused on modularity, unit testability and frameworks that increase productivity.
From my experience, I believe these 3 focus areas are the most important to have a
successful technical project. Bugs, time to develop, and QA are reduced when these are focus areas.

# Testing
I built the app using Dependency inversion principle, in order to support testing of each layer of the app.
Notably only navigation and 3rd party services are untested (very difficult to do, or slim wrappers over them to support testing)
All other layers have tests, including rendering views.
There are only unit tests, as I believe as long as you have strong contracts, integration testing is
not good, but actively harmful to developer productivity. This will depend on the project, but starting from
scratch, I knew I had strong contracts in place.

# Frameworks
Mavericks (https://airbnb.io/mavericks/#/README) is the main control library for powering app logic.
Mavericks is an Android MVI framework that is both easy to learn yet powerful enough for the most complex flows
at Airbnb, Tonal, and other large apps.
I believe Netflix does too, looking at open source list in app.


Jetpack Compose is a declarative React like framework used for views.


Jetpack Navigation was used for navigation stack.

Coroutines/Flows were used to do async work

Paparazzi was used to do view snapshot testing - Note due to Coil not working with Paparazzi,
these aren't very useful, but I'm hopeful that it could be fixed.

Dagger-Hilt was used to do dependency injection.

Coil for async image loading and caching.

# Architecture
The app uses MVI (Model-View-Intent) as a base of architecture.

The app is made to be unit testable by default, using Dagger via Hilt to use dependency injection.
Modules should be able to be reused in another app if desired.


MainActivity holds the navigation which launches screens and presenters to handle the logic of the app.

# Modules breakdown

framework: Contains interfaces and wrapper classes for the app to build on.
Namely wrapping navigation so it can be mocked out under test.

app: Initializes app and sets up the navigation stack. Entry point to app.

routes: Contains class defining all routes to screens for navigation stack in app.

screens: Contains mapping classes for connecting composables to presenters.

presenters: Contains logic on how app should handle user inputs and load data. Uses Mavericks.

composables: Contains views that can be reused in screens. Uses Jetpack Compose.


repos: Holds business logic on how to send and receive data to services (network, database, etc)


services: Wraps Networking and Database, and contains Fakes for Unit testing


models: Shared models to be able to send between module layers

# Callouts

UX Transitions / Animation
Basic Compose Animations are used to open screens and crossfades on images

Corner cases
Handles network failure and prints out stacktrace on screen, handles loading states in Trending and Search as well

Stores any results from Trending and Search calls in a local Sqlite DB so it can be used for immediate loading on details screen


Tests

Layers are tested independently, below all have tests and I believe near 100% coverage.

db,
network,
repo,
presenter,
composables,

# Run and install

You should be able to load into Android Studio and just run the app as normal. I built it in AS Eletric Eel Canary 8.

`./gradlew build` from command line to build and run all tests
`./gradlew installDebug` to install to you emulator

# Follow ups

I would like to add better error handling to handle network issues.

Sometimes the images pop in oddly, I would like to figure out if I could load the rows in order.

I could leverage the database to make the app work better offline

Doing scrolling pagination would be nice to keep scrolling through movies, but I avoided to not make code more complex.
