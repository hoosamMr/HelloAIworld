# AI Hello World

A minimal Android app that demonstrates a single artificial neuron in action: drag RGB sliders to pick a background color, and a hand-weighted perceptron decides whether the text on top should be black or white.

## How it works

- `ColorNeuron` ([app/src/main/java/com/meray/aihelloworld/domain/ColorNeuron.kt](app/src/main/java/com/meray/aihelloworld/domain/ColorNeuron.kt)) normalizes the R/G/B values to `0..1`, computes a weighted sum plus bias, and passes it through a sigmoid to produce a confidence score between 0 and 1.
- The UI ([ColorScreen.kt](app/src/main/java/com/meray/aihelloworld/presentation/ColorScreen.kt)) uses that score to flip the text color once confidence crosses 0.5, so you can see the neuron "deciding" as you adjust the color live.
- State flows through a standard MVVM setup — `ColorViewModel` exposes UI state, `ColorRepositoryImpl` wraps the neuron, wired together with Hilt (`AppModule`, `NeuronComponent`).

## Tech stack

- Kotlin, Jetpack Compose, Material 3
- Hilt for dependency injection
- Gradle version catalogs (`gradle/libs.versions.toml`)

## Requirements

- Android Studio (latest stable)
- minSdk 29, targetSdk / compileSdk 36

## Getting started

```bash
git clone https://github.com/hoosamMr/HelloAIworld.git
cd HelloAIworld
./gradlew installDebug
```

Or just open the project in Android Studio and hit Run.
