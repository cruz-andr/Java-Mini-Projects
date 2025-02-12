# README: Abstraction and Constructors

## Goals
- Learn to abstract common code and use custom constructors.
- Reduce code duplication through abstraction.

## Problem 1: **Working with Custom Constructors & Equality**
### **BagelRecipe Class**
A `BagelRecipe` contains the weight of:
- Flour
- Water
- Yeast
- Salt
- Malt

**Constraints for a perfect bagel recipe:**
1. Flour weight must equal water weight.
2. Yeast weight must equal malt weight.
3. The sum of salt and yeast must be 1/20th of the flour weight.

### **Required Constructors:**
1. **Main constructor:** Accepts all ingredient weights and enforces the constraints.
2. **Simplified constructor:** Accepts only flour and yeast weights and generates a perfect recipe.
3. **Volume-based constructor:** Accepts flour, yeast, and salt as volumes and converts them to weights. Must still enforce a perfect recipe.
   - Conversion factors:
     - 48 teaspoons = 1 cup
     - 1 cup yeast = 5 oz, salt = 10 oz, malt = 11 oz, water = 8 oz, flour = 4.25 oz

If constraints cannot be enforced, throw an `IllegalArgumentException` with a helpful message.

### **Method to Implement:**
- `sameRecipe(BagelRecipe other)`: Returns `true` if the ingredient weights match within `0.001` ounces.

### **File to Submit:**
- `Bagel.java`

### **Contributions:**
- **Siddharth Karani**

---
## Problem 2: **Abstracting over Data Definitions**
### **Entertainment Class Hierarchy**
Entertainment media include:
- Magazines
- TV series
- Podcasts

All have a **name** and **price**, with additional properties depending on the type.

### **Warmup Tasks:**
1. Add **one more example** for each class.
2. Extend `totalPrice()` tests with new examples.
3. Implement the following methods:
   - `duration()`: Computes minutes of entertainment provided:
     - Magazines: `5 minutes per page`
     - TV series & Podcasts: `50 minutes per episode`
   - `format()`: Returns a `String` in the format: `"Name, Price."`
   - `sameEntertainment(Entertainment other)`: Checks if two entertainments are the same.

Save a copy of this work before continuing.

### **Abstracting the Code**
1. Identify and remove duplicated code.
2. Create an abstract class `AEntertainment` to store common fields.
3. Modify derived classes to inherit from `AEntertainment`.
4. **Decide for each method:**
   - Declare as **abstract** if implementations differ across subclasses.
   - Implement in `AEntertainment` if identical across all subclasses.
   - Implement in `AEntertainment` and **override in one subclass** if necessary.

### **File to Submit:**
- `Entertainment.java`

---
## Summary
- **Bagel.java**: Custom constructors and enforcing constraints.
- **Entertainment.java**: Abstract class design and method generalization.
