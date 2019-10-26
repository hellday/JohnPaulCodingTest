# Coding Test

This repository contains a coding test for the John Paul Kotlin Dev team.

## Instructions

The goal of this coding test is to have a quick overview of how you code. We do not expect a specific way to solve
the exercises.

Do not hesitate to heavily comment your code with any information you deem
remotely important.

We expect the code to be versioned with Git. Please initialize a git repository and commit the current code in
the master branch. Then, write your code in a branch starting from master.

## Exercises

### 1. Writing a staggered grid layout (~ 1h)

The current implementation displays a scrolling list of elements in a RecyclerView.

For this exercise, rewrite this application so that the items are displayed in a staggered way
(see [attached](staggered_layout.png)).

The specs are explained in the image.

- all margins are 15dp
- the two columns have the same width `width = (screen_width - margin * 3) / 2`
- the layout is composed of windows of 4 elements: 2 tall rectangles and 2 short rectangles. A window has an
aspect ratio of 1:2. In other words: `tall_height + margin + short_height = 2 * (width + margin + width)`
- the tall height is twice the short height: `tall_height = 2 * short_height`.

### 2. Improving the code (~ 1h)

The current code does not account for Activity life cycle and does not take advantage of newer
Kotlin coding techniques.

Try and improve the code through any newer programming tools.

Here are a few ideas (this list is NOT exhaustive):
- [`LiveData`](https://developer.android.com/topic/libraries/architecture/livedata)
- [Kotlin Coroutines](https://kotlinlang.org/docs/reference/coroutines/composing-suspending-functions.html)
- [`Observables`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.properties/-delegates/observable.html )
- [`DiffCallback`](https://developer.android.com/reference/android/support/v17/leanback/widget/DiffCallback)
