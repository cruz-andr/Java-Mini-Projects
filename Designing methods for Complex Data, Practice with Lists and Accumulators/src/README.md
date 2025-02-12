# Designing Methods for Complex Data, Practice with Lists and Accumulators

## Goals
- Practice working with lists.
- Learn to design methods.
- Practice designing with accumulators.

#### **Sorting Words (Case-Insensitive)**
**Method:** `sort`
- Produces a new list with words sorted alphabetically.
- Treats all words as lowercase.
- Use insertion sort.
- Use `String.toLowerCase()` for case-insensitive comparison.

#### **Checking if List is Sorted**
**Method:** `isSorted`
- Determines whether the list is sorted alphabetically (case-insensitive).
- Use a helper method.
- Consider accumulator-style functions.

#### **Interleaving Two Lists**
**Method:** `interleave`
- Merges two lists by alternating elements.
- Any leftover elements remain at the end.

#### **Merging Two Sorted Lists**
**Method:** `merge`
- Merges two sorted lists into a single sorted list.
- Maintains duplicates.
- Does **not** use `sort`.
- Treats all words as lowercase.

#### **Reducing Words by Removing First Letter**
**Method:** `checkAndReduce`
- Takes a single-character string as input.
- Removes the first letter of any active word if it matches the input character.

#### **Adding a Word to the End of a List**
**Method:** `addToEnd`
- Takes an `IWord` and returns a new list with the word appended.

#### **Filtering Out Empty Words**
**Method:** `filterOutEmpties`
- Removes any words with an empty string from the list.

#### **Drawing Words on a WorldScene**
**Method:** `draw`
- Draws all words in the list onto a `WorldScene`.
- Uses `TextImage` for displaying words.
- Uses `placeImageXY` to position words on the scene.
- Differentiates active and inactive words using different colors.
- Chooses appropriate background and font sizes.

