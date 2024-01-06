package facade;

import database.Database;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ResourceManagementMenu {
    Database db;
    Scanner sc;
    public ResourceManagementMenu() {
        db = Database.getInstance();
        sc = new Scanner(System.in);
    }

    public void mainMenu(){
        int choice = 0;
        do{
            System.out.println("===| RESOURCE MANAGEMENT |===");
            System.out.println("1. Item Shop");
            System.out.println("2. Upgrade Shop");
            System.out.println("3. Back");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    itemShop();
                    break;
                case 2:
                    upgradeShop();
                    break;
                case 3:
                    System.out.println("Returning you to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 3);
    }

    public void itemShop(){
        MissionBoardMenu missionBoardMenu = new MissionBoardMenu();
        if(missionBoardMenu.checkCurrentMission() != null){
            System.out.println("You have an active mission!");
            return;
        }
        int choice = 0;
        do{
            System.out.println("===| ITEM SHOP |===");
            System.out.println("1. Buy Weapon");
            System.out.println("2. Buy Armor");
            System.out.println("3. Back");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    buyWeapon();
                    break;
                case 2:
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Returning you to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 3);
    }

    public void buyWeapon(){
        int choice = 0;
        AtomicInteger i = new AtomicInteger();
        System.out.println("===| WEAPON SHOP |===");
        if(db.getWeapons().isEmpty()){
            System.out.println("There are no weapons available!");
            return;
        }
        int[] price = new int[db.getWeapons().size()];
        Random rand = new Random();
        db.getWeapons().forEach(weapon -> {
            price[i.get()] = rand.nextInt(1, 10);
            System.out.println(i.incrementAndGet() + ". " + weapon.getName() + " - " + weapon.getDamage() + " ATK" + " - " + price[i.get() - 1] + " credits");
        });
        System.out.println(i.incrementAndGet() + ". Back");
        System.out.print("> ");
        choice = sc.nextInt();
        sc.nextLine();
        if(choice == i.get()){
            System.out.println("Returning you to main menu...");
            return;
        }
        if(choice < 1 || choice > i.get()){
            System.out.println("Invalid choice!");
            return;
        }
        int robotChoice = 0;
        RobotCustomMenu robotCustomMenu = new RobotCustomMenu();
        if(db.getRobots().isEmpty()){
            System.out.println("You don't have robots yet...");
            return;
        }
        do{
            System.out.println("Select a robot to assign: ");
            robotCustomMenu.briefList();
            System.out.print("> ");
            robotChoice = sc.nextInt();
            sc.nextLine();
            if(robotChoice < 1 || robotChoice > db.getRobots().size()){
                System.out.println("Invalid choice!");
            }
        } while (robotChoice < 1 || robotChoice > db.getRobots().size());
        if(db.getRobots().get(robotChoice - 1).getPoints() < price[choice - 1]){
            System.out.println("Insufficient credits!");
            return;
        }
        db.getRobots().get(robotChoice - 1).setWeapon(db.getWeapons().get(choice - 1));
        db.getRobots().get(robotChoice - 1).setPoints(db.getRobots().get(robotChoice - 1).getPoints() - price[choice - 1]);
        db.getWeapons().remove(choice - 1);
        System.out.println("Weapon purchased!");
    }

    public void buyArmor(){
        int choice = 0;
        AtomicInteger i = new AtomicInteger();
        System.out.println("===| ARMOR SHOP |===");
        if(db.getArmors().isEmpty()){
            System.out.println("There are no armors available!");
            return;
        }
        int[] price = new int[db.getArmors().size()];
        Random rand = new Random();
        db.getArmors().forEach(armor -> {
            price[i.get()] = rand.nextInt(1, 10);
            System.out.println(i.incrementAndGet() + ". " + armor.getName() + " - " + armor.getDefense() + " DEF" + " - " + price[i.get() - 1] + " credits");
        });
        System.out.println(i.incrementAndGet() + ". Back");
        System.out.print("> ");
        choice = sc.nextInt();
        sc.nextLine();
        if(choice == i.get()){
            System.out.println("Returning you to main menu...");
            return;
        }
        if(choice < 1 || choice > i.get()){
            System.out.println("Invalid choice!");
            return;
        }
        if(db.getRobots().isEmpty()){
            System.out.println("You don't have robots yet...");
            return;
        }
        int robotChoice = 0;
        RobotCustomMenu robotCustomMenu = new RobotCustomMenu();
        do{
            System.out.println("Select a robot to assign: ");
            robotCustomMenu.briefList();
            System.out.print("> ");
            robotChoice = sc.nextInt();
            sc.nextLine();
            if(robotChoice < 1 || robotChoice > db.getRobots().size()){
                System.out.println("Invalid choice!");
            }
        } while (robotChoice < 1 || robotChoice > db.getRobots().size());
        if(db.getRobots().get(robotChoice - 1).getPoints() < price[choice - 1]){
            System.out.println("Insufficient credits!");
            return;
        }
        db.getRobots().get(robotChoice - 1).setArmor(db.getArmors().get(choice - 1));
        db.getRobots().get(robotChoice - 1).setPoints(db.getRobots().get(robotChoice - 1).getPoints() - price[choice - 1]);
        db.getArmors().remove(choice - 1);
        System.out.println("Armor purchased!");
    }

    public void upgradeShop(){
        MissionBoardMenu missionBoardMenu = new MissionBoardMenu();
        if(missionBoardMenu.checkCurrentMission() != null){
            System.out.println("You have an active mission!");
            return;
        }
        int choice = 0;
        do{
            System.out.println("===| UPGRADE SHOP |===");
            System.out.println("1. Upgrade Weapon");
            System.out.println("2. Upgrade Armor");
            System.out.println("3. Back");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    upgradeWeapon();
                    break;
                case 2:
                    upgradeArmor();
                    break;
                case 3:
                    System.out.println("Returning you to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 3);
    }

    public void upgradeWeapon(){
        int choice = 0;
        AtomicInteger i = new AtomicInteger();
        System.out.println("===| WEAPON UPGRADE |===");
        if(db.getRobots().isEmpty()){
            System.out.println("You don't have robots yet...");
            return;
        }
        int robotChoice = 0;
        RobotCustomMenu robotCustomMenu = new RobotCustomMenu();
        do{
            System.out.println("Select a robot to upgrade: ");
            robotCustomMenu.briefList();
            System.out.print("> ");
            robotChoice = sc.nextInt();
            sc.nextLine();
            if(robotChoice < 1 || robotChoice > db.getRobots().size()){
                System.out.println("Invalid choice!");
            }
        } while (robotChoice < 1 || robotChoice > db.getRobots().size());
        if(db.getRobots().get(robotChoice - 1).getWeapon() == null){
            System.out.println("This robot has no weapon!");
            return;
        }
        if(db.getRobots().get(robotChoice - 1).getWeapon().getProgress() == 10){
            System.out.println("Weapon is already maxed out!");
            return;
        }
        Random rand = new Random();
        int price = rand.nextInt(1, 7);
        System.out.println("Selected robot: " + db.getRobots().get(robotChoice - 1).getName());
        System.out.println("Robot points: " + db.getRobots().get(robotChoice - 1).getPoints());
        System.out.println("Weapon: " + db.getRobots().get(robotChoice - 1).getWeapon().getName());
        System.out.println("Weapon ATK: " + db.getRobots().get(robotChoice - 1).getWeapon().getDamage());
        System.out.println("Weapon Level: " + db.getRobots().get(robotChoice - 1).getWeapon().getProgress());
        System.out.println("Weapon Upgrade Cost: " + price);
        if(db.getRobots().get(robotChoice - 1).getPoints() < price){
            System.out.println("Insufficient credits!");
            return;
        }
        System.out.println("Upgrade weapon? (Y/N)");
        System.out.print("> ");
        String confirm = sc.nextLine();
        if(confirm.equalsIgnoreCase("Y")){
            db.getRobots().get(robotChoice - 1).getWeapon().setProgress(db.getRobots().get(robotChoice - 1).getWeapon().getProgress() + 1);
            db.getRobots().get(robotChoice - 1).getWeapon().setDamage(db.getRobots().get(robotChoice - 1).getWeapon().getDamage() + rand.nextInt(2,4));
            db.getRobots().get(robotChoice - 1).setPoints(db.getRobots().get(robotChoice - 1).getPoints() - price);
            System.out.println("Weapon upgraded!");
        }
        else{
            System.out.println("Returning you to main menu...");
        }
    }
    public void upgradeArmor() {
        int choice = 0;
        AtomicInteger i = new AtomicInteger();
        System.out.println("===| ARMOR UPGRADE |===");
        if(db.getRobots().isEmpty()){
            System.out.println("You don't have robots yet...");
            return;
        }
        int robotChoice = 0;
        RobotCustomMenu robotCustomMenu = new RobotCustomMenu();
        do {
            System.out.println("Select a robot to upgrade: ");
            robotCustomMenu.briefList();
            System.out.print("> ");
            robotChoice = sc.nextInt();
            sc.nextLine();
            if (robotChoice < 1 || robotChoice > db.getRobots().size()) {
                System.out.println("Invalid choice!");
            }
        } while (robotChoice < 1 || robotChoice > db.getRobots().size());
        if (db.getRobots().get(robotChoice - 1).getArmor() == null) {
            System.out.println("This robot has no armor!");
            return;
        }
        if (db.getRobots().get(robotChoice - 1).getArmor().getProgress() == 10) {
            System.out.println("Armor is already maxed out!");
            return;
        }
        Random rand = new Random();
        int price = rand.nextInt(1, 10);
        System.out.println("Selected robot: " + db.getRobots().get(robotChoice - 1).getName());
        System.out.println("Robot points: " + db.getRobots().get(robotChoice - 1).getPoints());
        System.out.println("Armor: " + db.getRobots().get(robotChoice - 1).getArmor().getName());
        System.out.println("Armor DEF: " + db.getRobots().get(robotChoice - 1).getArmor().getDefense());
        System.out.println("Armor Level: " + db.getRobots().get(robotChoice - 1).getArmor().getProgress());
        System.out.println("Armor Upgrade Cost: " + price);
        if (db.getRobots().get(robotChoice - 1).getPoints() < price) {
            System.out.println("Insufficient credits!");
            return;
        }
        System.out.println("Upgrade armor? (Y/N)");
        System.out.print("> ");
        String confirm = sc.nextLine();
        if (confirm.equalsIgnoreCase("Y")) {
            db.getRobots().get(robotChoice - 1).getArmor().setProgress(db.getRobots().get(robotChoice - 1).getArmor().getProgress() + 1);
            db.getRobots().get(robotChoice - 1).getArmor().setDefense(db.getRobots().get(robotChoice - 1).getArmor().getDefense() + rand.nextInt(2,4));
            db.getRobots().get(robotChoice - 1).setPoints(db.getRobots().get(robotChoice - 1).getPoints() - price);
            System.out.println("Armor upgraded!");
        } else {
            System.out.println("Returning you to main menu...");
        }
    }
}
