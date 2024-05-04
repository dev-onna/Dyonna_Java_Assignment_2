import warrior.*;
import weapon.*;
import armour.*;
import utility.*;
import weather.*;

import java.util.Scanner;
import java.util.Random;

public class Warsim {

  // Objects
  public static Scanner input = new Scanner(System.in);
  public static Random randNum = new Random();
  public static Message message = new Message();
  public static Weather weather;


  // Player Objects
  public static Warrior player; // player
  public static Weapon pWeapon;
  public static Armour pArmour; // player armour

  // Enemy Objects
  public static Warrior enemy; // enemy
  public static Weapon eWeapon; // enemy weapon
  public static Armour eArmour; // enemy armour
  public static int getRandomAttackType() {
    Random random = new Random();
    int attackType = random.nextInt(10) + 1; 
    return attackType;
}

  // Variables
  public static boolean gameOver = false;
  public static boolean playerTurn = true;
  public static int choice = 0;
  public static int attackType = 0;
  public static int damage = 0;
  public static int enemyDamage = 50;
  public static String who = "Player";
  public static String winner = "";

  public static void main(String[] args) {


    message.WelcomeMessage();


    //====================>>
    // Player Setup
    // Warrior
    message.printWarriorMenu();
    int choice = input.nextInt(); // 1, 2 or 3
    createWarrior(who, choice);

    // Weapon
    message.printWeaponMenu();
    choice = input.nextInt(); // 1, 2 or 3
    createWeapon(who, choice);

    // Armour
    message.printArmourMenu();
    choice = input.nextInt(); // 1, 2 or 3
    createArmour(who, choice);

    who = "Enemy"; // swap the who with the what

    //====================>>
    // Enemy Setup
    // Warrior
    message.printWarriorMenu();
    choice = randNum.nextInt(3) + 1;
    createWarrior(who, choice);

    // Weapon
    message.printWeaponMenu();
    choice = randNum.nextInt(3) + 1;
    createWeapon(who, choice);

    // Armour
    message.printArmourMenu();
    choice = randNum.nextInt(3) + 1;
    createArmour(who, choice);

    int weatherType = randNum.nextInt(4) + 1;
    createWeather(weatherType);

    message.printStats(player, enemy, pWeapon, eWeapon, pArmour, eArmour);
    
    // main game loop
    while (!gameOver) { // while the game is NOT over
        if (playerTurn) {
            // Player's turn 
            message.printAttackMenu();
            attackType = input.nextInt();
            damage = pWeapon.strike(weather.getSeverity(), attackType, player.getStrength(), player.getDexterity());
            damage = eArmour.reduceDamage(damage);
            enemy.takeDamage(damage);
            if (!enemy.isAlive()) {
                winner = "Player";
                gameOver = !gameOver;
            }
        } else {
            // Enemy's turn code
            System.out.println("Enemy Turn!");
            int enemyAttackType = getRandomAttackType();
            int enemyDamage = eWeapon.strike(weather.getSeverity(), enemyAttackType, enemy.getStrength(), enemy.getDexterity());
            enemyDamage = pArmour.reduceDamage(enemyDamage);
            player.takeDamage(enemyDamage);
            System.out.println("Enemy attacks! Player takes " + enemyDamage + " damage.");
            
            // Check if the player is alive
            if (!player.isAlive()) {
                winner = "Enemy";
                gameOver = true;
                System.out.println("Oh No! Player Out!");
            } else {
                playerTurn = true; // if player is alive game continues
            }
        }
    
        message.printStats(player, enemy, pWeapon, eWeapon, pArmour, eArmour);
    
        playerTurn = !playerTurn; // toggle turns
        System.out.println(playerTurn ? "Player's Turn" : "Enemy's Turn");
    } // while
    
    message.printGameOver(winner);
}
    

  // Helper Method public static void createWarrior(String who, int choice) {
    public static void createWarrior(String who, int choice) {
        if(who.equals("Player")) {
          switch (choice) {
            case 1: // Human
              player = new Human("Human");
              break;
            case 2: // Elf
              player = new Elf("Elf");
              break;
            case 3: // Orc
              player = new Orc("Orc");
              break;
            default:
              System.out.println("oops!");
              break;
          } // switch
        }
        else {
          switch(choice) {
            case 1: // Human
              enemy = new Human("Human");
              break;
            case 2: // Elf
              enemy = new Elf("Elf");
              break;
            case 3: // Orc
              enemy = new Orc("Orc");
              break;
            default:
              System.out.println("oops!");
              break;
          } // switch
        }
      } // createWarrior()



public static void createWeapon(String who, int choice) {
    switch (choice) {
      case 1: // Dagger
        if(who.equals("Player")) {
          pWeapon = new Dagger("Dagger");
        }
        else {
          eWeapon = new Dagger("Dagger");
        }
        break;
      case 2: // Sword
        if(who.equals("Player")) {
          pWeapon = new Sword("Sword");
        }
        else {
          eWeapon = new Sword("Sword");
        }
        break;
      case 3: // Axe
        if(who.equals("Player")) {
          pWeapon = new Axe("Axe");
        }
        else {
          eWeapon = new Axe("Axe");
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createWeapon()

  public static void createArmour(String who, int choice) {
    switch (choice) {
      case 1: // Leather
        if(who.equals("Player")) {
          pArmour = new Leather("Leather");
        }
        else {
          eArmour = new Leather("Leather");
        }
        break;
      case 2: // Chainmail
        if(who.equals("Player")) {
          pArmour = new Chainmail("Chainmail");
        }
        else {
          eArmour = new Chainmail("Chainmail");
        }
        break;
      case 3: // Platemail
        if(who.equals("Player")) {
          pArmour = new Platemail("Platemail");
        }
        else {
          eArmour = new Platemail("Platemail");
        }
        break;
      default:
        System.out.println("oops!");
        break;
    } // switch
  } // createArmour()
  public static void createWeather(int weatherType) {
    switch (weatherType) {
      case 1: // sun 
        weather = new Sun();
        break;
      case 2: // rain
        weather = new Rain();
        break;
      case 3: // wind
        weather = new Wind();
        break;
      case 4: // storm
        weather = new Storm();
        break;
      default:
        System.out.println("Run!! Godzilla!!!");
        break;
    } // switch
  } // createWeather()
} // class