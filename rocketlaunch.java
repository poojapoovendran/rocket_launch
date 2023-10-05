/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

public class RocketLaunchSimulator {
    private static final String INITIAL_STAGE = "Pre-launch";
    private static final int INITIAL_FUEL = 100;
    private static final int FUEL_CONSUMPTION_RATE = 10;
    private static final int INITIAL_ALTITUDE = 0;
    private static final int INITIAL_SPEED = 0;
    private static final int ORBIT_ALTITUDE = 100;
    private static final int ORBIT_SPEED = 1000;

    private enum Stage {
        PRE_LAUNCH, LAUNCH, STAGE_1, STAGE_2, ORBIT
    }

    private Stage currentStage = Stage.PRE_LAUNCH;
    private String stage = INITIAL_STAGE;
    private int fuel = INITIAL_FUEL;
    private int altitude = INITIAL_ALTITUDE;
    private int speed = INITIAL_SPEED;

    public static void main(String[] args) {
        RocketLaunchSimulator simulator = new RocketLaunchSimulator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Rocket Launch Simulator!");
        System.out.println("Initial State: Stage: " + simulator.stage + ", Fuel: " + simulator.fuel + "%, Altitude: "
                + simulator.altitude + " km, Speed: " + simulator.speed + " km/h");

        System.out.println("User Input:");
        System.out.println("1. Pre-Launch Checks: Type 'start_checks' to initiate system checks.");
        System.out.println("2. Launch: Type 'launch' to begin the mission after checks are complete.");
        System.out.println("3. Fast Forward: Type 'fast_forward X' to advance the simulation by X seconds.");
        System.out.println("Enter the command: ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("start_checks")) {
                simulator.startChecks();
            } else if (input.equalsIgnoreCase("launch")) {
                simulator.launch();
            } else if (input.startsWith("fast_forward ")) {
                int seconds = Integer.parseInt(input.substring("fast_forward ".length()));
                simulator.fastForward(seconds);
            } else {
                System.out.println("Invalid command. Try 'start_checks', 'launch', or 'fast_forward X'.");
            }
        }
    }

    private void startChecks() {
        if (currentStage == Stage.PRE_LAUNCH && fuel==100 && altitude==0 && speed==0 ) {
            
            System.out.println("All systems are 'Go' for launch.");
            currentStage = Stage.LAUNCH;
        } else {
            System.out.println("Invalid command at this stage.");
        }
    }

    private void launch() {
        stage = "1";
        System.out.println("Launch initiated!");
        while (fuel > 0 && altitude < 100) {
            try {
                Thread.sleep(1000); // Wait for 1 second to simulate the passage of time
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fuel -= 10;
            altitude += 10;
            speed += 100;
            System.out.println("Stage: " + stage + ", Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: " + speed + " km/h");
            if (altitude >= 30 && stage.equals("1")) {
                stage = "2";
                System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
            }
        }
        if (altitude >= 100) {
            System.out.println("Orbit achieved! Mission Successful.");

        } else {
            System.out.println("Mission Failed due to insufficient fuel.");

        }
    }


   private void fastForward(int seconds) {
    if (currentStage == Stage.LAUNCH) {
        for (int i = 0; i < seconds; i++) {
            if (altitude < ORBIT_ALTITUDE) {
                updateStage();
            }
        }
      
        if (seconds<=10) {
            System.out.println("Fast forward " + seconds + " seconds: Orbit achieved! Mission Successful.");
        } else {
            System.out.println("Fast forward " + seconds + " seconds: Mission Failed due to insufficient fuel.");
        }
    } else {
        System.out.println("Invalid command at this stage.");
    }
}
    private void updateStage() {
        altitude += 10; // Altitude increases based on speed
        speed += 10; // Speed increases by 10 km/h every second
        fuel -= FUEL_CONSUMPTION_RATE; // Fuel decreases every second

        System.out.println("Stage: " + currentStage.ordinal() + ", Fuel: " + fuel + "%, Altitude: " + altitude + " km, Speed: " + speed + " km/h");

        if (altitude >= ORBIT_ALTITUDE && currentStage != Stage.ORBIT) {
            currentStage = Stage.STAGE_1;
            System.out.println("Stage 1 complete. Separating stage. Entering Stage 2.");
        
      
    }
    }
    
    }
