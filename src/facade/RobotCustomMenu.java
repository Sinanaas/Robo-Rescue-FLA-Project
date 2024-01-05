package facade;

import database.Database;
import factory.FirefighterFactory;
import factory.MedicFactory;
import factory.PoliceFactory;
import model.Robot;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class RobotCustomMenu {
    private Database db;
    private Scanner sc;
    public RobotCustomMenu() {
        db = Database.getInstance();
        sc = new Scanner(System.in);
    }
    public void mainMenu(){
        int choice = 0;
        do{
            // Robot Assembly and Customization
            System.out.println("===| ROBOT WORKSHOP |===");
            System.out.println("You have " + db.getRobots().size() + " robots.");
            System.out.println("1. View Robots");
            System.out.println("2. Add Robot");
            System.out.println("3. Update Robot");
            System.out.println("4. Delete Robot");
            System.out.println("5. Back");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    viewRobots();
                    break;
                case 2:
                    addRobot();
                    break;
                case 3:
                    updateRobot();
                    break;
                case 4:
                    deleteRobot();
                    break;
                case 5:
                    System.out.println("Returning you to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        } while (choice != 5);
    }

    public void briefList(){
        AtomicInteger i = new AtomicInteger();
        db.getRobots().forEach(robot -> {
            System.out.println(i.incrementAndGet() + ". " + robot.getName());
        });
    }

    public void viewRobots(){
        AtomicInteger i = new AtomicInteger();
        db.getRobots().forEach(robot -> {
            System.out.println("\nRobot " + i.incrementAndGet());
            robot.printAll();
        });
        System.out.print("Press ENTER to continue...");
        sc.nextLine();
    }

    public void addRobot(){
        if(db.getRobots().size() >= 3){
            System.out.println("You have reached the maximum number of robots.");
            return;
        }
        System.out.println("===| Add Robot |===");
        System.out.println("In this menu, you can add a new robot!");
        int type = 0;
        do{
            System.out.println("Choose a robot type:");
            System.out.println("1. Firefighter");
            System.out.println("2. Police");
            System.out.println("3. Medic");
            System.out.print("> ");
            type = sc.nextInt();
            sc.nextLine();
            if(type < 1 || type > 3){
                System.out.println("Invalid choice!");
            }
        } while(type < 1 || type > 3);
        String name = "";
        do{
            System.out.print("Enter robot name: ");
            name = sc.nextLine();
            if(name.isEmpty()){
                System.out.println("Invalid name. Name cannot be empty.");
            }
        } while(name.isEmpty());
        switch (type){
            case 1:
                FirefighterFactory firefighterFactory = new FirefighterFactory();
                db.getRobots().add(firefighterFactory.createRobot(name));
                break;
            case 2:
                PoliceFactory policeFactory = new PoliceFactory();
                db.getRobots().add(policeFactory.createRobot(name));
                break;
            case 3:
                MedicFactory medicFactory = new MedicFactory();
                db.getRobots().add(medicFactory.createRobot(name));
                break;
        }
        System.out.println("Robot added successfully!");
    }

    public void updateRobot(){
        int ch2 = 0;
        System.out.println("===| Update Robot |===");
        System.out.println("In this menu, you can change your robot name!");
        briefList();

        System.out.print("Which robot you want to customize? : ");
        ch2 = sc.nextInt();
        sc.nextLine();

        // Ensure ch2 is a valid index
        if (ch2 >= 1 && ch2 <= db.getRobots().size()) {
            System.out.println("You have selected Robot " + ch2);
            Robot selectedRobot = db.getRobots().get(ch2 - 1);
            selectedRobot.printAll();
            System.out.print("Enter new name: ");
            String newName = sc.nextLine();
            if(newName.isEmpty()){
                System.out.println("Invalid name. Name cannot be empty.");
                return;
            }
            selectedRobot.setName(newName);
            System.out.println("Robot name changed to `" + newName + "`successfully!");
        } else {
            System.out.println("Invalid selection. Please choose a valid robot.");
        }
    }

    public void deleteRobot(){
        int ch2 = 0;
        System.out.println("===| Delete Robot |===");
        briefList();

        System.out.print("Which robot you want to delete? : ");
        ch2 = sc.nextInt();
        sc.nextLine();

        if (ch2 >= 1 && ch2 <= db.getRobots().size()) {
            System.out.println("You have selected Robot " + ch2);
            Robot selectedRobot = db.getRobots().get(ch2 - 1);
            selectedRobot.printAll();
            System.out.print("Are you sure you want to delete this robot? (Y/N): ");
            String confirm = sc.nextLine();
            if(confirm.equalsIgnoreCase("Y")){
                db.getRobots().remove(selectedRobot);
                System.out.println("Robot deleted successfully!");
            } else {
                System.out.println("Robot not deleted.");
            }
        } else {
            System.out.println("Invalid selection. Please choose a valid robot.");
        }
    }
}
