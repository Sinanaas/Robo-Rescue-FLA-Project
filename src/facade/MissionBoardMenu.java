package facade;

import database.Database;
import model.Mission;
import model.Robot;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
        if(checkCurrentMission() != null){
            System.out.println("You have an active mission!");
            return;
        }
        System.out.println("===| MISSIONS MARKET |===");
        if(db.getMissions().isEmpty()){
            System.out.println("There are no missions available!");
            return;
        }
        AtomicInteger i = new AtomicInteger();
        db.getMissions().forEach(mission -> {
            i.incrementAndGet();
            if (mission.isStatus() == 0) {
                String missionInfo = String.format(
                        "Entry no. %d%n== %s ==%nDescription: %s\nDifficulty: %s\nReward: %d\nStatus: %d\nTime: %d seconds\n",
                        i.get(), mission.getName(), mission.getDescription(), mission.getDifficultyString(),
                        mission.getReward(), mission.isStatus(), mission.getTime()
                );
                System.out.println(missionInfo);
            }
        });
        int choice = 0;
        do{
            System.out.println("Select a mission to accept (input the entry number): ");
            System.out.print("> ");
            choice = sc.nextInt();
            sc.nextLine();
            if(choice < 1 || choice > db.getMissions().size()){
                System.out.println("Invalid choice!");
            }
        } while (choice < 1 || choice > db.getMissions().size());
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
        missionConfirmation(choice, robotChoice);
    }

    public void missionConfirmation(int missionId, int robotId)  {
        Mission selectedMission = db.getMissions().get(missionId - 1);
        Robot selectedRobot = db.getRobots().get(robotId - 1);
        int timeToCompleteMission = selectedRobot.calculateMissionTime(selectedMission);
        System.out.println(selectedRobot.getName() + " can finish " + selectedMission.getName() + " in " + timeToCompleteMission + " seconds.");
        System.out.println("Do you want to accept this mission? (Y/N)");
        System.out.print("> ");
        String choice = sc.nextLine();
        if(choice.equalsIgnoreCase("Y")){
            selectedMission.setStatus(1);
            System.out.println("Executing mission...");
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            executorService.execute(() -> {
                try{
                    Thread.sleep(timeToCompleteMission * 1000L);
                    selectedRobot.setPoints(selectedRobot.getPoints() + selectedMission.getReward());
                    System.out.println("[INFO] " + selectedMission.getName() + " done!");
                    db.getMissions().remove(selectedMission);
                } catch (InterruptedException e) {
                    System.out.println("Mission interrupted! \n Detail:" + e.getMessage());
                }
            });
        } else {
            System.out.println("Mission rejected!");
        }
    }

    public void currentMission(){
        System.out.println("===| ACTIVE MISSIONS |===");
        if(checkCurrentMission() == null){
            System.out.println("You have no active missions!");
            return;
        }
        Mission mission = checkCurrentMission();
        String missionInfo = String.format(
                "%n== %s ==%nDescription: %s\nDifficulty: %s\nReward: %d\nStatus: %d\nTime: %d seconds\n",
                mission.getName(), mission.getDescription(), mission.getDifficultyString(),
                mission.getReward(), mission.isStatus(), mission.getTime()
        );
        System.out.println(missionInfo);
        System.out.print("Press ENTER to continue...");
        sc.nextLine();
    }

    public Mission checkCurrentMission(){
        for (Mission mission : db.getMissions()) {
            if (mission.isStatus() == 1) {
                return mission;
            }
        }
        return null;
    }

}
