package main;

import database.Database;
import facade.MissionBoardMenu;
import facade.ResourceManagementMenu;
import facade.RobotCustomMenu;
import model.*;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public void startGameMenu() {
        System.out.println("===| ROBO RESCUE |===");
        System.out.println("1. Robot Workshop");
        System.out.println("2. Mission Board");
        System.out.println("3. Resources and Upgrade");
        System.out.println("4. Exit");
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
                RobotCustomMenu robotCustomMenu = new RobotCustomMenu();
                robotCustomMenu.mainMenu();
            } else if(ch1 == 2) {
                MissionBoardMenu missionBoardMenu = new MissionBoardMenu();
                missionBoardMenu.mainMenu();
            } else if(ch1 == 3) {
                ResourceManagementMenu resourceManagementMenu = new ResourceManagementMenu();
                resourceManagementMenu.mainMenu();
            } else if(ch1 == 4) {
                System.out.println("Thank you for playing!");
            } else {
                System.out.println("Invalid choice!");
            }
        } while(ch1 != 4);
    }
    public static void main(String[] args) {
        new Main();
    }
}