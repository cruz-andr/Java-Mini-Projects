import java.awt.Color;
import javalib.funworld.WorldScene;
import javalib.worldimages.TextImage;
import tester.Tester;


//represents a list of words
interface ILoWord {

  //produces a new list with sorted words A-Z
  ILoWord sort();

  //helper that inserts words A-Z in that order
  ILoWord helperS(IWord word); 

  // determines if this list of IWord(s) is sorted
  boolean isSorted();

  // helper for isSorted
  boolean helperIS(boolean sorted);

  // helper for helperIS(): compares the first 2 words
  boolean helperSquared(IWord word1);

  // Takes this list and a given list -> new list 1,3,5,... from this list, 
  // new list 2,4,6,... from given, equal # of words
  ILoWord interleave(ILoWord low);

  // this sorted list and given sorted list -> sorted new list
  ILoWord merge(ILoWord sortedLow);

  // this list -> new list where every word that starts with that 
  // letter gets rid of that beginning letter
  ILoWord checkAndReduce(String letter);

  // this list -> new list [(this list) + word]
  ILoWord addToEnd(IWord word);

  // this list -> new list without empty strings
  ILoWord filterOutEmpties();

  // draws a world scene
  WorldScene draw(WorldScene start);



}

//represents an empty list of words
class MtLoWord implements ILoWord {

  /*
   * fields:
   * N/A
   * 
   * methods:
   * this.sort             ... ILoWord
   * this.helperS          ... ILoWord
   * this.isSorted         ... boolean
   * this.helperIS         ... boolean
   * this.helperSquared    ... boolean
   * this.interleave       ... ILoWord
   * this.merge            ... ILoWord
   * this.checkAndReduce   ... ILoWord
   * this.addToEnd         ... ILoWord
   * this.filterOutEmpties ... ILoWord
   * this.draw             ... WorldScene
   * 
   * methods on fields:
   * N/A
   */

  //produces a new list with sorted words A-Z 
  public ILoWord sort() {
    return new MtLoWord();
  }

  public ILoWord helperS(IWord word) {
    /*
     * Class Temp.
     * 
     * fields:
     * this.word   ... String
     * this.x      ... int
     * this.y      ... int
     * 
     * methods:
     * this.compare(String)                 ... int
     * this.thisWordBeforeGiven(IWord)      ... boolean
     * this.adjustLetter(String)            ... IWord
     * this.emptyHuh                        ... boolean
     * this.wsText(WorldScene)              ... WorldScene
     * 
     * methods on fields:
     * N/A
     */

    return new ConsLoWord(word, this);
  }


  //determines if this list of IWord(s) is sorted  
  public boolean isSorted() {
    return true;
  }

  // helper for isSorted
  public boolean helperIS(boolean sorted) {
    return sorted;
  }

  //helper for helperIS(): compares the first 2 words
  public boolean helperSquared(IWord word1) {
    /*
     * Class Temp.
     * 
     * fields:
     * this.word   ... String
     * this.x      ... int
     * this.y      ... int
     * 
     * methods:
     * this.compare(String)                 ... int
     * this.thisWordBeforeGiven(IWord)      ... boolean
     * this.adjustLetter(String)            ... IWord
     * this.emptyHuh                        ... boolean
     * this.wsText(WorldScene)              ... WorldScene
     * 
     * methods on fields:
     * N/A
     */

    return true;
  }

  //Takes this list and a given list -> new list 1,3,5,... from this list, 
  //new list 2,4,6,... from given, equal # of words 
  public ILoWord interleave(ILoWord low) {
    return low;
  }

  // this sorted list and given sorted list -> sorted new list
  public ILoWord merge(ILoWord sortedLow) {
    return sortedLow;
  }

  // this list -> new list where every word that starts with that 
  //letter gets rid of that beginning letter
  public ILoWord checkAndReduce(String letter) {
    return new MtLoWord();
  }

  // this list -> new list [(this list) + word]
  public ILoWord addToEnd(IWord word) {
    return new ConsLoWord(word, this);
  }

  // this list -> new list without empty strings
  public ILoWord filterOutEmpties() {
    return new MtLoWord();
  }

  // draws a world scene
  public WorldScene draw(WorldScene start) {
    return start;
  }

}

class ConsLoWord implements ILoWord {
  IWord first;
  ILoWord rest;

  /*
   * Fields:
   * this.first ... IWord
   * this.rest  ... ILoWord
   * 
   * Methods:
   * this.sort             ... ILoWord
   * this.helperS          ... ILoWord
   * this.isSorted         ... boolean
   * this.helperIS         ... boolean
   * this.helperSquared    ... boolean
   * this.interleave       ... ILoWord
   * this.merge            ... ILoWord
   * this.checkAndReduce   ... ILoWord
   * this.addToEnd         ... ILoWord
   * this.filterOutEmpties ... ILoWord
   * this.draw  
   * 
   * Methods on Fields:
   * N/A
   */

  ConsLoWord(IWord first, ILoWord rest) {
    this.first = first;
    this.rest = rest;
  }

  //helper that inserts words A-Z in that order
  public ILoWord helperS(IWord word) {

    /*
     * Class Temp.
     * 
     * fields:
     * this.word   ... String
     * this.x      ... int
     * this.y      ... int
     * 
     * methods:
     * this.compare(String)                 ... int
     * this.thisWordBeforeGiven(IWord)      ... boolean
     * this.adjustLetter(String)            ... IWord
     * this.emptyHuh                        ... boolean
     * this.wsText(WorldScene)              ... WorldScene
     * 
     * methods on fields:
     * N/A
     */

    if (word.thisWordBeforeGiven(this.first)) {
      return new ConsLoWord(word, this);
    } else {
      return new ConsLoWord(this.first, this.rest.helperS(word));
    }
  }

  //produces a new list with sorted words A-Z 
  public ILoWord sort() {
    return this.rest.sort().helperS(this.first);
  }

  //helper for helperIS(): compares the first 2 words
  public boolean helperSquared(IWord word1) {

    /*
     * Class Temp.
     * 
     * fields:
     * this.word   ... String
     * this.x      ... int
     * this.y      ... int
     * 
     * methods:
     * this.compare(String)                 ... int
     * this.thisWordBeforeGiven(IWord)      ... boolean
     * this.adjustLetter(String)            ... IWord
     * this.emptyHuh                        ... boolean
     * this.wsText(WorldScene)              ... WorldScene
     * 
     * methods on fields:
     * N/A
     */
    return word1.thisWordBeforeGiven(this.first);
  }

  //helper for isSorted
  public boolean helperIS(boolean sorted) {
    return this.rest.helperIS(this.rest.helperSquared(this.first) && sorted);
  }

  //determines if this list of IWord(s) is sorted  
  public boolean isSorted() {
    return this.helperIS(true);
  }

  //Takes this list and a given list -> new list 1,3,5,... 
  //from this list, new list 2,4,6,... from given, equal # of words 
  public ILoWord interleave(ILoWord low) {
    return new ConsLoWord(this.first, low.interleave(this.rest));
  }

  // this sorted list and given sorted list -> sorted new list
  public ILoWord merge(ILoWord sortedLow) {
    return this.rest.merge(sortedLow.helperS(this.first));
  }

  // this list -> new list where every word that starts with 
  //that letter gets rid of that beginning letter
  public ILoWord checkAndReduce(String letter) {
    return new ConsLoWord(this.first.adjustLetter(letter), this.rest.checkAndReduce(letter));
  }

  // this list -> new list [(this list) + word]
  public ILoWord addToEnd(IWord word) {
    return new ConsLoWord(this.first, this.rest.addToEnd(word));
  }

  // this list -> new list without empty strings
  public ILoWord filterOutEmpties() {
    if (this.first.emptyHuh()) {
      return this.rest.filterOutEmpties();
    }
    else {
      return new ConsLoWord(this.first, this.rest.filterOutEmpties());
    }
  }

  // draws a world scene
  public WorldScene draw(WorldScene start) {
    return this.rest.draw(this.first.wsText(start));
  }

}

//represents a word in the ZType game
interface IWord {

  // gives an int based on word comparison
  int compare(String word);

  //checks if this word goes before given word
  boolean thisWordBeforeGiven(IWord word);

  //if same as the l -> adjusts first letter
  IWord adjustLetter(String l);

  //checks to see if IWord is empty
  boolean emptyHuh();

  // puts this word on a WorldScene
  WorldScene wsText(WorldScene ws);

}

//represents an active word in the ZType game
class ActiveWord implements IWord {
  String word;
  int x;
  int y;

  ActiveWord(String word, int x, int y) {
    this.word = word;
    this.x = x;
    this.y = y;
  }

  /*
   * Fields:
   * this.word ... String
   * this.x    ... Int
   * this.y    ... Int
   * 
   * Methods:
   * this.compare(String)                 ... int
   * this.thisWordBeforeGiven(IWord)      ... boolean
   * this.adjustLetter(String)            ... IWord
   * this.emptyHuh                        ... boolean
   * this.wsText(WorldScene)              ... WorldScene
   * 
   * Methods on Fields:
   * N/A
   * 
   */

  // compares if this IWord would be alphabetically before a give IWord
  public int compare(String word) {
    return this.word.toLowerCase().compareTo(word.toLowerCase());
  }

  public boolean thisWordBeforeGiven(IWord word) {
    return word.compare(this.word.toLowerCase()) >= 0;
  }

  //if same as the l -> adjusts first letter
  public IWord adjustLetter(String l) {
    if (this.word.isEmpty()) {
      return this;
    } else if (this.word.toLowerCase().substring(0, 1).equals(l)) {
      return new ActiveWord(this.word.substring(1), this.x, this.y);
    } else {
      return this;
    }
  }

  // checks to see if IWord is empty
  public boolean emptyHuh() {
    return this.word.isEmpty();
  }

  // puts this word on a WorldScene
  public WorldScene wsText(WorldScene ws) {
    return ws.placeImageXY(new TextImage(this.word, Color.cyan), this.x, this.y);
  }

}

//represents an inactive word in the ZType game
class InactiveWord implements IWord {
  String word;
  int x;
  int y;


  InactiveWord(String word, int x, int y) {
    this.word = word;
    this.x = x;
    this.y = y;
  }

  /*
   * Fields:
   * this.word ... String
   * this.x    ... Int
   * this.y    ... Int
   * 
   * Methods:
   * this.compare(String)                 ... int
   * this.thisWordBeforeGiven(IWord)      ... boolean
   * this.adjustLetter(String)            ... IWord
   * this.emptyHuh                        ... boolean
   * this.wsText(WorldScene)              ... WorldScene
   * 
   * Methods on Fields:
   * 
   * 
   */

  //compares if this IWord would be alphabetically before a give IWord
  public int compare(String word) {
    return this.word.toLowerCase().compareTo(word.toLowerCase());
  }
  
  //checks if this word goes before given word
  public boolean thisWordBeforeGiven(IWord word) {
    return word.compare(this.word.toLowerCase()) >= 0;
  }

  //if same as the l -> adjusts first letter
  public IWord adjustLetter(String l) {
    if (this.word.isEmpty()) {
      return this;
    } else if (this.word.toLowerCase().substring(0, 1).equals(l)) {
      return new InactiveWord(this.word.substring(1), this.x, this.y);
    } else {
      return this;
    }
  }

  // checks to see if IWord is empty
  public boolean emptyHuh() {
    return this.word.isEmpty();
  }

  // puts this word on a WorldScene
  public WorldScene wsText(WorldScene ws) {
    return ws.placeImageXY(new TextImage(this.word, Color.red), this.x, this.y);
  }

}

//all examples and tests for ILoWord
class ExamplesWordLists {

  WorldScene background = new WorldScene(300,400);

  IWord hi = new ActiveWord("Hi",0,0);
  IWord bye = new ActiveWord("Bye",0,0);
  IWord hola = new InactiveWord("Hola",0,0);
  IWord dale = new InactiveWord("Dale",0,0);
  IWord nothing = new ActiveWord("",0,0);

  ILoWord unSortedA = new ConsLoWord(this.hi, new ConsLoWord(this.bye, new MtLoWord()));
  ILoWord unSortedI = new ConsLoWord(this.hola, new ConsLoWord(this.dale, new MtLoWord()));
  ILoWord unSortedM = new ConsLoWord(this.hi, new ConsLoWord(this.bye, 
      new ConsLoWord(this.hola,new ConsLoWord(this.nothing, 
          new ConsLoWord(this.dale, new MtLoWord())))));
  ILoWord emptyList = new MtLoWord();
  ILoWord unSortedB = new ConsLoWord(this.hi, new ConsLoWord(this.nothing, 
      new ConsLoWord(this.bye, new MtLoWord())));
  ILoWord sortedA = new ConsLoWord(this.bye,new ConsLoWord(this.hi, new MtLoWord()));
  ILoWord sortedI = new ConsLoWord(this.dale, new ConsLoWord(this.hola, new MtLoWord()));


  boolean testSort(Tester t) {
    // tests sort() on unSortedA
    return t.checkExpect(this.unSortedA.sort(), new ConsLoWord(this.bye, 
        new ConsLoWord(this.hi, new MtLoWord())))
        // tests sort() on unSortedI
        && t.checkExpect(this.unSortedI.sort(), new ConsLoWord(this.dale, 
            new ConsLoWord(this.hola, new MtLoWord())))
        // tests sort() on unSortedM
        && t.checkExpect(this.unSortedM.sort(), 
            new ConsLoWord(this.nothing, new ConsLoWord(this.bye, 
                new ConsLoWord(this.dale,new ConsLoWord(this.hi, 
                    new ConsLoWord(this.hola, new MtLoWord()))))))
        // tests sort() on emptyList
        && t.checkExpect(this.emptyList.sort(), this.emptyList);
  }


  boolean testIsSorted(Tester t) {
    // tests isSorted() on unSortedA
    return t.checkExpect(this.unSortedA.isSorted(), false)
        // tests isSorted() on unSortedI 
        && t.checkExpect(this.unSortedI.isSorted(), false)
        // tests isSorted() on unSortedI
        && t.checkExpect(this.sortedA.isSorted(), true)
        // tests isSorted() on emptyList
        && t.checkExpect(this.emptyList.isSorted(), false);
  }

  boolean testInterleave(Tester t) {
    //tests interleave(unSortedI) on unSortedA
    return t.checkExpect(this.unSortedA.interleave(unSortedI), 
        new ConsLoWord(this.hi, new ConsLoWord(this.hola, 
            new ConsLoWord(this.bye, new ConsLoWord(this.dale, new MtLoWord())))))
        //tests interleave(unSortedA) on unSortedI
        && t.checkExpect(this.unSortedI.interleave(unSortedA), 
            new ConsLoWord(this.hola, new ConsLoWord(this.hi, 
                new ConsLoWord(this.dale, new ConsLoWord(this.bye, new MtLoWord())))))
        //tests interleave(emptyList) on unSortedI
        && t.checkExpect(this.unSortedA.interleave(emptyList),
            new ConsLoWord(this.hi, new ConsLoWord(this.bye, new MtLoWord())))
        //tests interleave(unSortedI) on emptyList
        && t.checkExpect(this.emptyList.interleave(unSortedA), unSortedA); 

  }

  boolean testMerge(Tester t)  {
    //tests merge(sortedI) on sortedA
    return t.checkExpect(this.sortedA.merge(sortedI), 
        new ConsLoWord(this.bye, new ConsLoWord(this.dale, 
            new ConsLoWord(this.hi, new ConsLoWord(this.hola, new MtLoWord())))))
        //tests merge(sortedI) on sortedA
        && t.checkExpect(this.sortedI.merge(sortedA), 
            new ConsLoWord(this.bye, new ConsLoWord(this.dale, 
                new ConsLoWord(this.hi, new ConsLoWord(this.hola, new MtLoWord())))))
        //tests merge(sortedA) on emptyList
        && t.checkExpect(this.emptyList.merge(sortedA), sortedA)
        //tests merge(emptyList) on sortedA
        && t.checkExpect(sortedA.merge(emptyList), sortedA);
  }

  boolean testCheckAndReduce(Tester t) {
    // tests checkAndReduce("h") on unSortedA
    return t.checkExpect(this.unSortedA.checkAndReduce("h"), 
        new ConsLoWord(new ActiveWord("i",0,0), new ConsLoWord(this.bye, new MtLoWord())))
        // tests checkAndReduce("d") on unSortedI
        && t.checkExpect(this.unSortedI.checkAndReduce("d"), 
            new ConsLoWord(this.hola, new ConsLoWord(
                new InactiveWord("ale",0,0), new MtLoWord())))
        // tests checkAndReduce("a") on emptyList
        && t.checkExpect(this.emptyList.checkAndReduce("a"), this.emptyList)

        // tests checkAndReduce("h") on list with this.nothing
        && t.checkExpect(unSortedB.checkAndReduce("h"), 
            new ConsLoWord(new ActiveWord("i", 0, 0), 
                new ConsLoWord(this.nothing, new ConsLoWord(this.bye, new MtLoWord())))); 
  }

  boolean testAddToEnd(Tester t) {
    // tests addToEnd(nothing) on unSortedA
    return t.checkExpect(this.unSortedA.addToEnd(nothing), new ConsLoWord(this.hi,
        new ConsLoWord(this.bye, new ConsLoWord(new ActiveWord("",0,0), new MtLoWord()))))
        //tests addToEnd(bye) on unSortedI
        && t.checkExpect(this.unSortedI.addToEnd(bye),
            new ConsLoWord(this.hola, new ConsLoWord(this.dale,
                new ConsLoWord(this.bye, new MtLoWord()))))
        //tests addToEnd(bye) on emptyList
        && t.checkExpect(this.emptyList.addToEnd(bye),
            new ConsLoWord(this.bye, new MtLoWord()))
        //tests addToEnd(nothing) on unSortedB
        && t.checkExpect(unSortedB.addToEnd(nothing), 
            new ConsLoWord(this.hi, new ConsLoWord(this.nothing, 
                new ConsLoWord(this.bye, new ConsLoWord(nothing, new MtLoWord())))));
  }

  boolean testFilterOutEmpties(Tester t) {
    // tests filterOutEmpties on unSortedB
    return t.checkExpect(this.unSortedB.filterOutEmpties(), this.unSortedA)
        //tests filterOutEmpties on unSortedM
        && t.checkExpect(this.unSortedM.filterOutEmpties(), 
            new ConsLoWord(this.hi, new ConsLoWord(this.bye, 
                new ConsLoWord(this.hola, new ConsLoWord(this.dale, new MtLoWord())))))
        // test filterOutEmpties on emptyList
        && t.checkExpect(this.emptyList.filterOutEmpties(), this.emptyList)
        //tests filterOutEmpties on list with empty words
        && t.checkExpect(new ConsLoWord(nothing, 
            new ConsLoWord(nothing, emptyList)).filterOutEmpties(), emptyList); 
  }

  boolean testDraw(Tester t) {
    // tests draw(this.background) on unSortedA
    return t.checkExpect(this.unSortedA.draw(this.background), new WorldScene(300, 400)
        .placeImageXY(new TextImage("Hi", Color.cyan), 0, 0)
        .placeImageXY(new TextImage("Bye", Color.cyan), 0, 0))
        //tests draw(this.background) on emptyList
        && t.checkExpect(this.emptyList.draw(this.background), this.background);
  }

}
