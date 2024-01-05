package facade;

import database.Database;
import model.Mission;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MissionBoardMenu {
    private Database db;
    private Scanner sc;
    public MissionBoardMenu() {
        db = Database.getInstance();
        sc = new Scanner(System.in);
    }


    public void mainMenu(){
        int choice = 0;
        do{
            System.out.println("===| MISSION BOARD |===");
            System.out.println("1. Active Missions");
            System.out.println("2. Missions Market");
            System.out.println("3. Back");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 1:
                    currentMission();
                    break;
                case 2:
                    missionList();
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

    public void missionList(){
        if(checkMissionStatus()){
            System.out.println("You have an active mission!");
            return;
        }
        AtomicInteger i = new AtomicInteger();
        db.getMissions().forEach(mission -> {
            i.incrementAndGet();
            if (mission.isStatus() == 0) {
                String missionInfo = String.format(
                        "%d%n== %s ==%nDescription: %s\nDifficulty: %s\nReward: %d\nStatus: %d\nTime: %d seconds\n",
                        i.get(), mission.getName(), mission.getDescription(), mission.getDifficultyString(),
                        mission.getReward(), mission.isStatus(), mission.getTime()
                );
                System.out.println(missionInfo);
            }
        });
        int choice = 0;
        System.out.println("Select a mission to accept: ");
        System.out.print("> ");
        choice = sc.nextInt();
        sc.nextLine();
        System.out.println("Select a robot to assign: ");
        RobotCustomMenu robotCustomMenu = new RobotCustomMenu();
        robotCustomMenu.briefList();
        System.out.print("> ");
        int robotChoice = sc.nextInt();
        sc.nextLine();
        missionConfirmation(choice, robotChoice);
    }

    public void missionConfirmation(int missionId, int robotId){
        // the blueprint
        // Mission mission1 = db.getMissions().get(0);
        // Carrier carrier1 = (Carrier) db.getRobots().get(0);
        // int timeToCompleteMission1 = carrier1.calculateMissionTime(mission1);
        // System.out.println("Carrier 1 can finish Mission 1 in " + timeToCompleteMission1 + " seconds.");
//        Mission selectedMission = db.getMissions().get(missionId - 1);
//        Robot selectedRobot = db.getRobots().get(robotId - 1);
//        int timeToCompleteMission = selectedRobot.calculateMissionTime(selectedMission);
//        System.out.println(selectedRobot.getName() + " can finish " + selectedMission.getName() + " in " + timeToCompleteMission + " seconds.");
//        System.out.println("Do you want to accept this mission? (Y/N)");
//        System.out.print("> ");
//        String choice = sc.nextLine();
//        if(choice.equalsIgnoreCase("Y")){
//            selectedMission.setStatus(1);
//            Thread.sleep(timeToCompleteMission * 1000);
//            db.getMissions().remove(selectedMission);
//            System.out.println("Mission done!");
//        } else {
//            System.out.println("Mission rejected!");
//        }
    }

    public void currentMission(){
        System.out.println("===| ACTIVE MISSIONS |===");
        boolean status = checkMissionStatus();
        if(!status){
            System.out.println("You have no active missions!");
            return;
        }
        db.getMissions().forEach(mission -> {
            if(mission.isStatus() == 1){
                String missionInfo = String.format(
                        "%n== %s ==%nDescription: %s\nDifficulty: %s\nReward: %d\nStatus: %d\nTime: %d seconds\n",
                        mission.getName(), mission.getDescription(), mission.getDifficultyString(),
                        mission.getReward(), mission.isStatus(), mission.getTime()
                );

                System.out.println(missionInfo);
            }
        });
        System.out.print("Press ENTER to continue...");
        sc.nextLine();
    }

    public boolean checkMissionStatus(){
        boolean status = false;
        for (Mission mission : db.getMissions()) {
            if (mission.isStatus() == 1) {
                status = true;
            }
        }
        return status;
    }

}
