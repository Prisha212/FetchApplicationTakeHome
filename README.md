# Fetch Rewards Android App

A native Android application that retrieves and displays data from Fetch's hiring API, built with Jetpack Compose and modern Android architecture components.

## Features

- Fetches data from https://fetch-hiring.s3.amazonaws.com/hiring.json
- Groups items by listId
- Sorts items by listId and name
- Filters out items with blank/null names
- Displays results in an easy-to-read list format

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit for networking
- Coroutines + Flow for async operations
- Material3 components

## Setup

1. Clone the repository
2. Open in Android Studio
3. Build and run on a device/emulator running Android 7.0 (API 24) or higher

## Project Structure

- `MainActivity.kt`: Main UI implementation using Jetpack Compose
- `MainViewModel.kt`: Business logic and data handling
- `Item.kt`: Data model
- Network layer using Retrofit and Coroutines

## Requirements

- Android Studio Hedgehog (2023.1.1) or newer
- Kotlin 1.9.0 or newer
- Android SDK 34
- Android 7.0 (API 24) or higher

