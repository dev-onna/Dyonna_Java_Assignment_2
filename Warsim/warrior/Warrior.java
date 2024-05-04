package warrior;

import java.util.Random;

// abstract means it CANNOT be directly instantiated!
public abstract class Warrior {
  // public(open to all), private(internal to class)
  // protected(closed outside, open on the inside)
  protected Random randNum = new Random();
  private int health;
  private int strength;
  private int dexterity;
  private String warriorType;

  public Warrior() {
    // do nothing
  } // contructor

  //===============>>
  // GETTERS
  public int getHealth() {
    return this.health;
  }
  public int getStrength() {
    return this.strength;
  }
  public int getDexterity() {
    return this.dexterity;
  }
  public String getWarriorType() {
    return this.warriorType;
  }
  public boolean isAlive() {
    if(this.health > 0)
      return true;
    else 
      return false;
  }

  //===============>>
  // SETTERS
  public void setHealth(int health) {
    this.health = health;
  }
  public void setStrength(int strength) {
    this.strength = strength;
  }
  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }
  public void setWarriorType(String warriorType) {
    this.warriorType = warriorType;
  }
  public void takeDamage(int damageAmount) {
    if(damageAmount > 0)
      this.health -= damageAmount;
  }
} // class
