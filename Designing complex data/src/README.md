# Designing Complex Data

## Goals
Practice designing the representation of complex data in Java.

### Problem 1: Statues.java
#### Requirements:
- Define a `Statue` class with the following fields:
  - `name` (String)
  - `artist` (String)
  - `year` (int)
  - `weight` (double, in pounds)
  - `whole` (boolean, whether it has all parts)
- Create at least three statue examples in `ExamplesStatue`, including:
  - `statueOfLiberty`: *Statue of Liberty*, Bartholdi, 1886, 450,000 lbs, whole.
  - `venusDeMilo`: *Venus de Milo*, Alexandros of Antioch, 115 BC, 1984.16 lbs, missing arms.
- Consider implications of adding a "location" field.

### Problem 2: Soups.java
#### Requirements:
- Convert the following DrRacket data definition to Java:
  - `Soup`: Either a `Broth` or an `Ingredient`.
  - `Broth`: Has a `type` (String).
  - `Ingredient`: Has `more` (a `Soup`) and `name` (String).
- Maintain field names and constructor argument order from DrRacket.
- Include these soup examples in `ExamplesSoup`:
  - `yummy`: "chicken" broth with "carrots", "celery", "noodles".
  - `noThankYou`: "vanilla" broth with "horseradish", "hot dogs", "plum sauce".

### Problem 3: OhGiYu.java
#### Requirements:
- Design representations for three resource types:
  - `Monster`: `name` (String), `hp` (int), `attack` (int).
  - `Fusion`: `name` (String), `monster1`, `monster2` (both `Monster`s).
  - `Trap`: `description` (String), `continuous` (boolean).
- Implement two action types:
  - `Attack`: An `attacker` and `defender` (both `Monster`s). Ensure all attack examples are successful (attacker's attack > defender's hp).
  - `Activate`: A `trap` (`Trap`) and a `target` (`Monster` or `Fusion`).
- Define these resource examples:
  - `kuriboh`: "Kuriboh", hp 200, attack 100.
  - `jinzo`: "Jinzo", hp 500, attack 400.
  - `kurizo`: "Kurizo", fusion of `kuriboh` and `jinzo`.
  - `trapHole`: "Kills a monster", not continuous.
  - Two additional resources of your choice.
- Define four action examples (`attack1`, `attack2`, `activate1`, `activate2`).
