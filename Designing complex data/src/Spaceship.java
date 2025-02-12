import tester.Tester;

class Spaceship {
   Location loc;
   String color;
   int speed;
   
   Spaceship(Location loc, String c, int speed){
     this.loc = loc;
     this.color = c;
     this.speed = speed;          
   }
   
   /*
    * 
    * 
    * fields:
    * this.loc ... Location
    * this.color ... String
    * this.speed ... int
    * 
    * 
    */
   
   
   
   
   
   //returns speed of the spaceship, reduced by given rate
   int reduceSpeed (int rate) {
     return this.speed - this.speed * rate / 100; 
   }
   //moves this spaceship by desired amounts
   Spaceship move(int dx, int dy) {
     //return this;
     return new Spaceship(this.loc.shiftLocation(dx,dy) ,this.color, this.speed);
     
   }
   
 }
 
//represents a point on Cartesian plane
 class Location{
   int x;
   int y;
   
   Location (int x, int y){
     this.x = x;
     this.y = y;
   }
   
   /*
    * this.x ... int
    * this.y ... int
    */
   
   //shifts location by desired amounts
   Location shiftLocation(int x, int y){
     return new Location(this.x + x, this.y + y);
    
   }
   
 }
 
 class ExamplesGamePieces{
   Location loc30_120 = new Location(30,120);
   Location loc80_620 = new Location(80,620);
   Spaceship ship1 = new Spaceship(this.loc30_120, "red", 30);
   Spaceship ship2 = new Spaceship(this.loc80_620, "green", 100);
   
   //test reduceSpeed
   boolean testReduce(Tester t) {
     return t.checkExpect(this.ship2.reduceSpeed (20), 80) &&
         t.checkExpect(this.ship1.reduceSpeed(50), 15);
     
   }
   
   //test move
   boolean test (Tester t) {
     return t.checkExpect(this.ship1.move(10, -5), 
         new Spaceship(new Location (40, 115), "red", 30)) && 
         t.checkExpect(this.ship2.move(20, 50), 
             new Spaceship(new Location(100,670),"green", 100)) &&
         t.checkExpect(this.loc30_120.shiftLocation(20, -20), new Location(50,100));
   }
   
 }
 
 
 
 
 
 
 