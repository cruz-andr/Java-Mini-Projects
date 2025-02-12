import tester.*;

class BagelRecipe {
  double water;
  double flour;
  double yeast;
  double salt;
  double malt;

  // Main constructor
  BagelRecipe(double flour, double water, double yeast, double salt, double malt) {
    if (Math.abs(flour - water) > 0.001) {
      throw new IllegalArgumentException("The water weight and flour weight are not equal");
    }
    if (Math.abs(yeast - malt) > 0.001) {
      throw new IllegalArgumentException("The yeast weight and malt weight are not equal");
    }
    if (Math.abs((salt + yeast) - (flour / 20)) > 0.001) {
      throw new IllegalArgumentException(
          "The weight of the salt + yeast is not 1/20th the weight of the flour");
    }
    this.flour = flour;
    this.water = water;
    this.yeast = yeast;
    this.salt = salt;
    this.malt = malt;
  }

  // Constructor with flour and yeast weights
  BagelRecipe(double flour, double yeast) {
    double salt = (flour / 20) - yeast;
    this.flour = flour;
    this.water = flour;
    this.yeast = yeast;
    this.salt = salt;
    this.malt = yeast;
  }

  // Constructor with flour, yeast, and salt volumes
  BagelRecipe(double flourCups, double yeastTsp, double saltTsp) {
    double flourOz = flourCups * 4.25;
    double yeastOz = (yeastTsp / 48) * 5;
    double saltOz = (saltTsp / 48) * 10;

    double waterOz = flourOz;
    double maltOz = yeastOz;

    if (Math.abs((saltOz + yeastOz) - (flourOz / 20)) > 0.001) {
      throw new IllegalArgumentException(
          "The weight of the salt + yeast is not 1/20th the weight of the flour");
    }

    this.flour = flourOz;
    this.water = waterOz;
    this.yeast = yeastOz;
    this.salt = saltOz;
    this.malt = maltOz;
  }

  boolean sameRecipe(BagelRecipe other) {
    return Math.abs(this.flour - other.flour) < 0.001 && Math.abs(this.water - other.water) < 0.001
        && Math.abs(this.yeast - other.yeast) < 0.001 && Math.abs(this.salt - other.salt) < 0.001
        && Math.abs(this.malt - other.malt) < 0.001;
  }
}

class BagelRecipeTest {
  void testBagelRecipe(Tester t) {
    // Valid perfect bagel recipe
    BagelRecipe bagel1 = new BagelRecipe(8.5, 8.5, 0.3, 0.125, 0.3);
    t.checkExpect(bagel1.flour, 8.5);
    t.checkExpect(bagel1.water, 8.5);
    t.checkExpect(bagel1.yeast, 0.3);
    t.checkExpect(bagel1.salt, 0.125);
    t.checkExpect(bagel1.malt, 0.3);

    // Constructor with only flour and yeast
    BagelRecipe bagel2 = new BagelRecipe(10, 0.4);
    t.checkExpect(bagel2.flour, 10.0);
    t.checkExpect(bagel2.water, 10.0);
    t.checkExpect(bagel2.yeast, 0.4);
    t.checkExpect(bagel2.salt, 0.1);
    t.checkExpect(bagel2.malt, 0.4);

    // Constructor using volume measurements
    BagelRecipe bagel3 = new BagelRecipe(2, 1, 1);
    t.checkExpect(bagel3.flour, 2 * 4.25);
    t.checkExpect(bagel3.water, 2 * 4.25);
    t.checkExpect(bagel3.yeast, (1.0 / 48.0) * 5);
    t.checkExpect(bagel3.salt, (1.0 / 48.0) * 5);
    t.checkExpect(bagel3.malt, (1.0 / 48.0) * 5);
  }
}
