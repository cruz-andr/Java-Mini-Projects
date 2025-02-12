import tester.*;

interface IEntertainment {
  //compute the total price of this Entertainment
  double totalPrice();
  
  //computes the minutes of entertainment of this IEntertainment
  int duration();
 
  //produce a String that shows the name and price of this IEntertainment
  String format();
  
  //is this IEntertainment the same as that one?
  boolean sameEntertainment(IEntertainment that);
}

abstract class AEntertainment implements IEntertainment {
  String name;
  double price;
  int installments;

  AEntertainment(String name, double price, int installments) {
    this.name = name;
    this.price = price;
    this.installments = installments;
  }

  //computes the price of a yearly subscription to this Magazine
  public double totalPrice() {
    return this.price * this.installments;
  }

  //computes the minutes of entertainment of this TVSeries
  public int duration() {
    // 50 min per episode
    return 50 * this.installments;
  }

  //is this Magazine the same as that IEntertainment?
  public boolean sameEntertainment(IEntertainment that) {
    return this == that;
  }

  //produce a String that shows the name and price of this Podcast
  public String format() {
    return this.name + ", " + Double.toString(this.price) + ".";
  }

}

class Magazine extends AEntertainment {
  String genre;
  int pages;

  Magazine(String name, double price, String genre, int pages, int installments) {
    super(name,price,installments);
    this.genre = genre;
    this.pages = pages;
  }

  //computes the minutes of entertainment of this Magazine, (includes all installments)
  public int duration() {
    // 5 min per page
    return 5 * this.pages * this.installments;
  }
}

class TVSeries extends AEntertainment {
  String corporation;

  TVSeries(String name, double price, int installments, String corporation) {
    super(name,price,installments);
    this.corporation = corporation;
  }
}

class Podcast extends AEntertainment {

  Podcast(String name, double price, int installments) {
    super(name,price,installments);
  }
}

class ExamplesEntertainment {
  IEntertainment rollingStone = new Magazine("Rolling Stone", 2.55, "Music", 60, 12);
  IEntertainment houseOfCards = new TVSeries("House of Cards", 5.25, 13, "Netflix");
  IEntertainment serial = new Podcast("Serial", 0.0, 8);
  IEntertainment highlights = new Magazine("Highlights", 1.50, "Kids", 50, 16);
  IEntertainment severence = new TVSeries("Severence", 1.99, 9, "Apple TV");
  IEntertainment hPOE = new Podcast("Happiest Podcast on Earth", 0.0, 436);



  //testing total price method
  boolean testTotalPrice(Tester t) {
    return t.checkInexact(this.rollingStone.totalPrice(), 2.55 * 12, .0001) 
        && t.checkInexact(this.houseOfCards.totalPrice(), 5.25 * 13, .0001)
        && t.checkInexact(this.serial.totalPrice(), 0.0, .0001)
        && t.checkInexact(this.highlights.totalPrice(), 1.50 * 16, .0001)
        && t.checkInexact(this.hPOE.totalPrice(), 0.0, .0001);

  }

  boolean testSameEntertainment(Tester t) {
    return t.checkExpect(this.rollingStone.sameEntertainment(rollingStone), true)
        && t.checkExpect(this.rollingStone.sameEntertainment(highlights), false);
  }

  boolean testFormat(Tester t) {
    return t.checkExpect(this.rollingStone.format(), "Rolling Stone, 2.55.")
        && t.checkExpect(this.highlights.format(), "Highlights, 1.50.");
  }

  boolean testDuration(Tester t) {
    return t.checkExpect(this.rollingStone.duration(), 120)
        && t.checkExpect(this.highlights.duration(), 160);
  }

}