# Login assignment

This repository contains a basic Android app that only does one use case: a user needs a screen to log in, introducing her username and password, with a fake API which returns a token. This token is stored in the local device so the app knows if the user is logged in. In that case, the app will show the main screen that only has a button to log out. Clicking this log out button removes the token and shows the login screen.

## What the app offers
Based on the use case requirements, the app consists in:
- A login screen, with a user and a password text fields, and a log in button.
- A main screen, that only has one button to log out.
- Functionality to call to login service that only returns a token, no validation nor real log in.
- Capability to persist the token locally, so the user does not have to log in every time it enters the app.

## Main points and decisions
There are a million ways to implement the use case as an app, but these are the main decisions taken within this project:
- Use **Kotlin** as language to make use of a more modern programming language than Java.
- Use **AndroidX** instead of support library because it's now recommended and has more future support.
- Use **Hilt** as the dependency injection library to avoid using constructors and to make it easier to replace the real implementations in the tests, although, because they are so basic, the tests use the same classes as the app.
- Structure the code with a **Model-View-Presenter** approach, to separate business logic from presentation.
- Set up **CI** tooling, through [GitHub Actions](https://github.com/javimolla/login-assignment/actions), to test and build a debug apk to show how these tools can help with automating these tasks before merging any pull request in the master branch.

## Try it
Just go to [Releases](https://github.com/javimolla/login-assignment/releases) and download the latest debug APK in your Android device, or clone the repo and open the project with Android Studio to run it. There is no signed APK for simplicity reasons
