package warrior;

public class Elf extends Warrior {
   private int BaseHealth = 50;
   private int BonusHealth = 75;
   private int baseStrength = 50;
   private int bonusStrength = 75;
   private int baseDexterity = 250;
   private int bonusDexterity = 200;
   
   public Elf (String warriorType) {
    super();
    super.setHealth(super.randNum.nextInt(BonusHealth) + BaseHealth);
    super.setStrength(super.randNum.nextInt(bonusStrength) + baseStrength);
    super.setDexterity(super.randNum.nextInt(bonusDexterity) + baseDexterity);
    super.setWarriorType(warriorType);
   } //constructor
} // class
