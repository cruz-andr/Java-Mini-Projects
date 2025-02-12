import tester.*;

class WebPage {
  String title;
  String url;
  ILoItem items;

  /*
   * Template:
   * 
   * Fields:
   * - this.title ... String
   * - this.url   ... String
   * - this.items   ... ILoItem
   * 
   * Methods:
   * - this.totalImageSize() ... Int
   * - this.textLength()     ... Int
   * - this.images()         ... String
   * 
   * Methods on Fields:
   * - this.items.totalImageSize() ... Int
   * - this.title.length()         ... Int
   * - this.items.textLength()     ... Int
   * - this.items.images()         ... String
   */

  WebPage(String title, String url, ILoItem loi) {
    this.title = title;
    this.url = url;
    this.items = loi;
  }

  int totalImageSize() {
    return this.items.totalImageSize();
  }

  int textLength() {
    return this.title.length() + this.items.textLength();
  }

  String images() {
    return this.items.images();
  }
}

interface ILoItem {
  int totalImageSize();

  int textLength();

  String images();
}

class ConsLoItem implements ILoItem {
  IItem first;
  ILoItem rest;

  /*
   * Template:
   * 
   * Fields:
   * - this.first ... Item
   * - this.rest  ... ILoItem
   * 
   * Methods:
   * - this.totalImageSize() ... Int
   * - this.textLength()     ... Int
   * - this.images()         ... String
   * - this.imagesHelper()   ... String
   * 
   * Methods on Fields:
   * - this.rest.totalImageSize() ... Int
   * - ((Link)this.first).page.totalImageSize()    ... Int
   * - ((Text) this.first).contents.length()       ... Int
   * - this.rest.textLength()                      ... Int
   * - ((Image) this.first).fileName.length()      ... Int
   * - ((Image) this.first).fileType.length()      ... Int
   * - ((Link) this.first).name.length()           ... Int
   * - ((Link)this.first).page.textLength()        ... Int
   * - ((Image) this.first).fileName.concat(".")
          .concat(((Image)this.first).fileType)
          .concat(", ").concat(this.rest.images()) ... String
     - ((Link)this.first).page.images().concat(", ")
          .concat(this.rest.images())              ...String
     - this.rest.images()                          ... String
     - stru.substring(0, stru.length() - 2)        ... String
     - stru.substring(0, stru.length())            ... String
   */

  ConsLoItem(IItem first, ILoItem rest) {
    this.first = first;
    this.rest = rest;
  }

  public int totalImageSize() {

    if (this.first instanceof Image) {
      return ((Image) this.first).size + this.rest.totalImageSize();
    }
    else if (this.first instanceof Link) {
      return ((Link)this.first).page.totalImageSize() + this.rest.totalImageSize();      
    }
    else {
      return this.rest.totalImageSize();
    }
  }

  public int textLength() {

    if (this.first instanceof Text) {
      return ((Text) this.first).contents.length() + this.rest.textLength();
    }
    else if (this.first instanceof Image) {
      return ((Image) this.first).fileName.length() + ((Image)this.first).fileType.length() 
          + this.rest.textLength();
    }
    else if (this.first instanceof Link) {
      return ((Link) this.first).name.length() 
          + ((Link)this.first).page.textLength() + this.rest.textLength();
    }

    else {
      return this.rest.textLength();
    }

  }

  public String imagesHelper() {
    if (this.first instanceof Image) {
      return ((Image) this.first).fileName.concat(".")
          .concat(((Image)this.first).fileType).concat(", ").concat(this.rest.images());
    }
    else if (this.first instanceof Link) {
      return ((Link)this.first).page.images().concat(", ").concat(this.rest.images());
    }
    else {
      return this.rest.images();
    }
  } 

  public String images() {

    if (this.imagesHelper().endsWith(", ")) {
      String stru = this.imagesHelper();
      return stru.substring(0, stru.length() - 2);
    }
    else if (this.imagesHelper().startsWith(", ")) {
      String stru = this.imagesHelper();
      return stru.substring(2 , stru.length());
    }
    else {
      return this.imagesHelper();
    }
  }

} 

class MtLoItem implements ILoItem {

  MtLoItem() {}

  /*
   * Template:
   * 
   * Fields:
   * N/A
   * 
   * Methods:
   * - this.totalImageSize() ... Int
   * - this.textLength()     ... Int
   * - this.images()         ... String
   * 
   * Methods on Fields:
   * N/A
   */

  public int totalImageSize() {
    return 0;
  }

  public int textLength() {
    return 0;
  }

  public String images() {
    return "";
  }
}

interface IItem {}

class Text implements IItem {
  String contents;

  /*
   * Template:
   * 
   * Fields:
   * - this.contents ... String
   * 
   * Methods:
   * - this.totalImageSize() ... Int
   * - this.textLength()     ... Int
   * - this.images()         ... String
   * 
   * Methods on Fields:
   * - this.contents.length() ...Int
   */

  Text(String contents) {
    this.contents = contents;
  }

  int totalImageSize() {
    return 0;
  }

  int textLength() {
    return this.contents.length();
  }

  String images() {
    return "";
  }
}

class Image implements IItem {
  String fileName;
  int size;
  String fileType;

  /*
   * Template:
   * 
   * Fields:
   * - this.fileName ... String
   * - this.size     ... Int
   * - this.fileType ... String
   * 
   * Methods:
   * - this.totalImageSize() ... Int
   * - this.textLength()     ... Int
   * - this.images()         ... String
   * 
   * Methods on Fields:
   * - this.fileName.length() ... String
   * - this.fileType.length() ... String
   */

  Image(String fn, int s, String ft) {
    this.fileName = fn;
    this.size = s;
    this.fileType = ft;
  }

  int totalImageSize() {
    return this.size;
  }

  int textLength() {
    return this.fileName.length() + this.fileType.length();
  }

  String images() {
    return this.fileName + this.fileType;
  }
}

class Link implements IItem {
  String name;
  WebPage page;

  /*
   * Template:
   * 
   * Fields:
   * - this.name     ... String
   * - this.page     ... WebPage
   * 
   * Methods:
   * - this.totalImageSize() ... Int
   * - this.textLength()     ... Int
   * - this.images()         ... String
   * 
   * Methods on Fields:
   * - this.page.totalImageSize() ... Int
   * - this.name.length()         ... Int
   * - this.page.textLength()     ... Int
   * - this.page.images()         ... String 
   */

  Link(String name, WebPage page) {
    this.name = name;
    this.page = page;
  }

  int totalImageSize() {
    return this.page.totalImageSize();
  }

  int textLength() {
    return this.name.length() + this.page.textLength();
  }

  String images() {
    return this.page.images();
  }
}

class ExamplesWebPage {
  WebPage htdp = new WebPage("HtDP", "htdp.org", 
      new ConsLoItem(new Text("How to Design Programs"),
          new ConsLoItem(new Image("htdp", 4300, "tiff"), new MtLoItem())));

  WebPage ood = new WebPage("OOD", "ccs.neu.edu/OOD", 
      new ConsLoItem(new Text("Stay classy, Java"),
          new ConsLoItem(new Link("Back to the Future", htdp), new MtLoItem())));

  WebPage fundiesWP = new WebPage("Fundies II", "ccs.neu.edu/Fundies2", 
      new ConsLoItem(new Text("Home sweet home"),
          new ConsLoItem(new Image("wvh-lab", 400, "png"), 
              new ConsLoItem(new Text("The staff"),
                  new ConsLoItem(new Image("profs", 240, "jpeg"),
                      new ConsLoItem(new Link("A Look Back", htdp), 
                          new ConsLoItem(new Link("A Look Ahead", ood), new MtLoItem())))))));
  // emptyPage no item WebPage
  WebPage emptyPage = new WebPage("Empty", "idk.com", new MtLoItem());

  // testing the totalImageSize method
  boolean testTotalImageSize(Tester t) {
    return t.checkExpect(fundiesWP.totalImageSize(), 9240)
        && t.checkExpect(ood.totalImageSize(), 4300)
        && t.checkExpect(emptyPage.totalImageSize(), 0);
  }

  // testing the textLength method
  boolean testTextLength(Tester t) {
    return t.checkExpect(ood.textLength(), 72)
        && t.checkExpect(htdp.textLength(), 34) 
        && t.checkExpect(fundiesWP.textLength(), 182)
        && t.checkExpect(emptyPage.textLength(), 21);
  }

  // testing the images method
  boolean testImages(Tester t) {
    return t.checkExpect(fundiesWP.images(), "wvh-lab.png, profs.jpeg, htdp.tiff, htdp.tiff") 
        && t.checkExpect(ood.images(), "htdp.tiff")
        && t.checkExpect(emptyPage.images(), "");
  }
}
