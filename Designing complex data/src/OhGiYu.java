interface IResource {
  
}

interface IAction {
  
}

class Monster implements IResource {
  String name;
  int hp;
  int attack;
  
  Monster(String name, int hp, int attack) {
    this.name = name;
    this.hp = hp;
    this.attack = attack;
  }
  
}

class Fusion implements IResource {
  String name;
  Monster monster1;
  Monster monster2;
  
  Fusion(String name, Monster a, Monster b) {
    this.name = name;
    this.monster1 = a;
    this.monster2 = b;
  }
  
}
  
class Trap implements IResource { 
  String description;
  boolean continuous;
  
  Trap(String des, boolean con) {
    this.description = des;
    this.continuous = con;
    
  }
}

class Attack implements IAction {
  Monster attacker;
  Monster defender;
  
  Attack(Monster attacker, Monster defender) {
    this.attacker = attacker;
    this.defender = defender;
  }
}

class Activate implements IAction {
  Trap trap;
  IResource target;
  
  Activate(Trap trap, IResource target) {
    this.trap = trap;
    this.target = target;
  }
}

class ExamplesGame {
  Monster kuriboh = new Monster("Kuriboh", 200, 100);
  Monster jinzo = new Monster("Jinzo", 500, 400);
  Monster bigjustice = new Monster("Big Justice", 1000, 1000);
  Fusion kurizo = new Fusion("Kurizo",kuriboh, jinzo);
  Trap trapHole = new Trap("Kills a monster", false);
  Trap trapCard = new Trap("Traps a monster", true);
  Attack attack1 = new Attack(bigjustice, jinzo);
  Attack attack2 = new Attack(bigjustice, kuriboh);
  Activate activate1 = new Activate(trapHole, bigjustice);
  Activate activate2 = new Activate(trapCard, jinzo);
  
}




