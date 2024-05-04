package utility;

import armour.Armour;
import warrior.Warrior;
import weapon.Weapon;

public class Message {

  public Message() {
    // do nothing
  } // contructor

  // Welcome Message
  public void WelcomeMessage() {
    System.out.printf("*****************************\n");
    System.out.printf(" Welcome to Warsim 2024 Alpha\n");
    System.out.printf("*****************************\n\n");
  }
  // Warrior Menu
  public void printWarriorMenu() {
    System.out.println("Select a Type By Number: \n1) Human\n2) Elf\n3) Orc");
  }

  // Weapon Menu
  public void printWeaponMenu() {
    System.out.println("Select a Weapon By Number: \n1) Dagger\n2) Sword\n3) Axe");
  }
  
  // Armor Menu
  public void printArmourMenu() {
    System.out.println("Armour Pick: \n1) Leather\n2) Chainmail\n3) Platemail");
  }

  // Attack Menu
  public void printAttackMenu() {
    System.out.println("\nAttack Type: \n1) Normal\n2) Heavy\n3 Extreme Damage");
  }

  // Print Stats
  public void printStats(Warrior pWarrior, Warrior eWarrior, Weapon pWeapon, Weapon eWeapon, Armour pArmour, Armour eArmour) {
    System.out.printf("%-25s (%s)\n", "Player: ", pWarrior.getWarriorType());
    System.out.printf("%-25s (%s)\n", "Player: ", pWeapon.getWeaponType());
    System.out.printf("%-25s (%s)\n", "Player: ", pArmour.getArmourType());
    System.out.printf("Health: %-25d\n",
      pWarrior.getHealth());
    System.out.printf("Strength: %-25d\n", 
      pWarrior.getStrength());
    System.out.printf("Dexterity: %-25d\n", 
      pWarrior.getDexterity());
    System.out.printf("%-25s (%s)\n", "Enemy: ", eWarrior.getWarriorType());
    System.out.printf("%-25s (%s)\n", "Enemy: ", eWeapon.getWeaponType());
    System.out.printf("%-25s (%s)\n", "Enemy: ", eArmour.getArmourType());
    System.out.printf("Health: %-25d\n", 
      eWarrior.getHealth());
    System.out.printf("Strength: %-25d\n", 
      eWarrior.getStrength());
    System.out.printf("Dexterity: %-25d\n", 
      eWarrior.getDexterity());
  } // printStats()

 // Enemy Attack Turn
   public void printEnemyAttack(int enemyDamage) {
  System.out.println("Enemy Turn!");
  System.out.println("Enemy attacks! Player takes " + enemyDamage + " damage.");
}
  // GameOver Message
  public void printGameOver(String winner) {
    System.out.println("Game Over!");
    System.out.printf("""
         __ __
      .-',,^,,'.
     / \\(0)(0)/ \\
     )/( ,_"_,)\\(
     `  >-`~(   ' 
   _N\\ |(`\\ |___
   \\' |/ \\ \\/_-,)
    '.(  \\`\\_<
       \\ _\\|
        | |_\\_
        \\_,_>-'
    winner: %s
        """, winner);
  } // printGameOver()

} // class