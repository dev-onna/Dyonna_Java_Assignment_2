package weapon;


public class Dagger extends Weapon {
    private int damageAmount = 50;
    private int dexterityCost = 50;
    private int hitPercentage = 90;
  
    public Dagger(String weaponType) {
      super();
      super.setDamageAmount(damageAmount);
      super.setDexterityCost(dexterityCost);
      super.setWeaponType(weaponType);
    } // constructor
  
    public int strike(int weatherIntensity, int attackType, int strength, int dexterity) {
      int amount = 0;
      // roll the dice
      int roll = super.randNum.nextInt(100) + 1; // 1 - 100
  
      // increasing hitPercentage based on player dexterity
      // decreasing the hitPercent based on attackType
      if(roll <= hitPercentage + 
        ((dexterity - dexterityCost) / 10) - (attackType * 5)) { // hit
        if(attackType == 2) {
          amount = this.damageAmount + (strength / 10) + 2;
        }
        else {
          amount = this.damageAmount + (strength / 20);
        }
      }
      return amount;
    } // strike()
  } // class