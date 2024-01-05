package main;

import database.Database;
import model.*;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    static Database db = Database.getInstance();



    public void startGameMenu() {
        System.out.println("===| ROBO RESCUE |===");
        System.out.println("1. Robot Customization");
        System.out.println("2. Mission Board");
        System.out.println("3. Resources and Upgrade");
//        System.out.println("4. Story Progression and Challenge");
        System.out.print("> ");
    }

    public Main() {
        Scanner sc = new Scanner(System.in);
        int ch1 = 0;
        // Start Game
        do {
            startGameMenu();
            ch1 = sc.nextInt();
            if (ch1 == 1) {
                int ch2 = 0;

                // Robot Assembly and Customization
                System.out.println("===| ROBOT CUSTOMIZATION |===");

                AtomicInteger i = new AtomicInteger();
                db.getRobots().forEach(robot -> {
                    System.out.println(i.incrementAndGet() + ". " + robot.getName());
                });

                System.out.print("Which robot you want to customize? : ");
                ch2 = sc.nextInt();

                // Ensure ch2 is a valid index
                if (ch2 >= 1 && ch2 <= db.getRobots().size()) {
                    Robot selectedRobot = db.getRobots().get(ch2 - 1);
                    selectedRobot.printAll();
                } else {
                    System.out.println("Invalid selection. Please choose a valid robot.");
                }
            } else if(ch1 == 2) {
                // Mission Board
//                    Mission mission1 = db.getMissions().get(0);
//                    Carrier carrier1 = (Carrier) db.getRobots().get(0);
//                    int timeToCompleteMission1 = carrier1.calculateMissionTime(mission1);
//                    System.out.println("Carrier 1 can finish Mission 1 in " + timeToCompleteMission1 + " seconds.");
                db.getMissions().forEach(mission -> {
                    String missionInfo = String.format(
                            "%n== %s ==%nDescription: %s\nDifficulty: %d\nReward: %d\nStatus: %d\nTime: %d seconds\n",
                            mission.getName(), mission.getDescription(), mission.getDifficulty(),
                            mission.getReward(), mission.isStatus(), mission.getTime()
                    );

                    System.out.println(missionInfo);
                });

            } else if(ch1 == 3) {
                // Resources and Upgrade

            } else if(ch1 == 4) {
                // Story Progression and Challenge

            } else {
                System.out.println("Invalid choice!");
            }
        } while(ch1 != 4);
    }
    public static void main(String[] args) {
        new Main();
    }
}