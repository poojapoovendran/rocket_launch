Rocket Launch Simulator
Educational Initiatives Campus Drive
Coding Assessment
K.L.N College of Engineering
   Name: Pooja P
    Department: Computer Science and Engineering(Final Year)
    Email: poojapoovendran@gmail.com
    Contact: 9940966565

Problem Statement :

You are to build a terminal-based Rocket Launch Simulator. The goal is to simulate a rocket launch that places a satellite into orbit, while
providing real-time updates to the user. The simulator will operate in discrete time steps, each representing one second of the mission.
Initial State
Stage: "Pre-Launch"
Fuel: 100%
Altitude: 0 km
Speed: 0 km/h
User Input
1. Pre-Launch Checks: User must type start_checks to initiate system checks.
2. Launch: User types launch to begin the mission after checks are complete.
3. Fast Forward: User types fast_forward X to advance the simulation by X seconds.
Console Output
Pre-Launch Checks: "All systems are 'Go' for launch."
Each Second of Flight: "Stage: 1, Fuel: 90%, Altitude: 10 km, Speed: 1000 km/h"
Stage Separation: "Stage 1 complete. Separating stage. Entering Stage 2."
Orbit Placement: "Orbit achieved! Mission Successful."
Mission Failure: "Mission Failed due to insufficient fuel."
Functional Requirements
1. Pre-Launch Checks: Upon typing start_checks , the terminal should output whether all systems are 'Go' for launch.
2. Launch and Stage Updates: When the user types launch , the terminal starts updating the stage, fuel, altitude, and speed every
second.
3. Fast Forward: If the user types fast_forward X , the program will calculate and display the updated parameters after X seconds.

Instruction: 
Rocket Launch Simulator Instructions

Welcome to the Rocket Launch Simulator!

This program allows you to simulate a rocket launch through different stages. Follow these instructions to interact with the simulator:

Pre-Launch Checks:

Type start_checks to initiate system checks.
Ensure the rocket is in the pre-launch stage, fuel is at 100%, altitude is 0 km, and speed is 0 km/h.
If all systems are 'Go' for launch, the simulator will move to the launch stage.

Launch:

Type launch to begin the mission after pre-launch checks are complete.
The rocket will launch and ascend. The simulation will update fuel, altitude, and speed in real-time.
Stage 1 separation occurs when the rocket reaches an altitude of 30 km.
The simulation will end either when the rocket achieves orbit (at 100 km) or when it runs out of fuel.

Fast Forward:

Type fast_forward X to advance the simulation by X seconds.
The simulation will fast forward the rocket's progress based on the specified time.
You will be informed if the rocket achieves orbit or if the mission fails due to insufficient fuel.

Commands:

start_checks: Initiate pre-launch system checks.
launch: Start the rocket launch after successful system checks.
fast_forward X: Fast forward the simulation by X seconds (replace X with the desired number of seconds).

Important Notes:

Ensure you are in the appropriate stage to execute specific commands (e.g., launching after system checks).
Monitor fuel percentage; if it reaches 0% before reaching orbit, the mission will fail.
Enjoy the simulation and observe the rocket's progress through different stages!

 Here,A Java program representing a Rocket Launch Simulator. This simulator simulates a rocket launch through different stages: pre-launch, launch, stage 1, stage 2, and orbit. Users can input commands like starting checks, launching, and fast forwarding the simulation.

Here's a breakdown of the main components and functionality of the program:

Initialization:

Constants like INITIAL_STAGE, INITIAL_FUEL, FUEL_CONSUMPTION_RATE, INITIAL_ALTITUDE, INITIAL_SPEED, ORBIT_ALTITUDE, and ORBIT_SPEED are set for the simulation.
The Stage enum represents different stages of the rocket launch.

Main Method:

The program starts by creating a RocketLaunchSimulator object and a Scanner for user input.
Users can input commands like "start_checks" to initiate system checks, "launch" to start the rocket launch, and "fast_forward X" to fast forward the simulation by X seconds.

Simulation Logic:

startChecks() method checks if all systems are 'Go' for launch and moves to the launch stage.
launch() method simulates the rocket launch, updating fuel, altitude, and speed until the rocket either achieves orbit or runs out of fuel.
fastForward(int seconds) method fast-forwards the simulation by a specified number of seconds, updating the rocket's parameters accordingly.

Helper Methods:

updateStage() method updates the rocket's stage, altitude, speed, and fuel consumption based on the elapsed time.

Design pattern:

 Here, a few design patterns can be applied to improve the structure, maintainability, and extensibility of the code. Here are a couple of design patterns that could be beneficial for this project:

1. State Pattern:

The State Pattern allows an object to alter its behavior when its internal state changes. This can be particularly useful for modeling the different stages of the rocket launch. Each stage of the rocket could be represented as a state, and the rocket object could switch states as it progresses through the launch phases (Pre-launch, Launch, Stage 1, Stage 2, Orbit). This pattern helps in managing state-specific behavior without the need for numerous conditional statements.

Implementation:

Create a RocketState interface defining methods for actions like startChecks(), launch(), and fastForward(int seconds).
Implement concrete classes for each state (PreLaunchState, LaunchState, Stage1State, Stage2State, OrbitState) implementing the RocketState interface.
The RocketLaunchSimulator class maintains a reference to the current state (initially set to PreLaunchState) and delegates state-specific actions to the current state object.

2. Command Pattern:
The Command Pattern encapsulates a request as an object, thereby allowing parameterization of clients with queues, requests, and operations. In this context, each user input command (start_checks, launch, fast_forward) can be encapsulated as a command object. This decouples sender and receiver objects, allowing for a more extensible and flexible design.

Implementation:

Create a Command interface with an execute() method.
Implement concrete command classes for each user command (StartChecksCommand, LaunchCommand, FastForwardCommand) implementing the Command interface.
The RocketLaunchSimulator class contains a map/dictionary where user input strings (commands) are mapped to concrete command objects.
When a command is received, the simulator class looks up the corresponding command object from the map and executes it. This way, new commands can be added without modifying the simulator class.

These patterns can significantly enhance the maintainability and flexibility of the Rocket Launch Simulator by promoting a modular, decoupled design.

OOPS Concept: 

Object-Oriented Programming (OOP) concepts can greatly enhance the design and organization of the Rocket Launch Simulator project. Here's how you can apply various OOP concepts to this project:

1. Encapsulation:

Encapsulation is the concept of bundling data (attributes) and methods (functions) that operate on the data into a single unit known as a class. In the context of the Rocket Launch Simulator, you can create classes to encapsulate the rocket's properties and behaviors.

Example:

java
Copy code
public class Rocket {
    private int fuel;
    private int altitude;
    private int speed;

    public Rocket(int initialFuel, int initialAltitude, int initialSpeed) {
        this.fuel = initialFuel;
        this.altitude = initialAltitude;
        this.speed = initialSpeed;
    }

    // Getter and setter methods for fuel, altitude, and speed properties
    // Additional methods to manipulate rocket properties
}
2. Inheritance:

Inheritance is the mechanism by which one class can inherit properties and methods from another class. In the context of the Rocket Launch Simulator, you might have different types of rockets with common properties and behaviors.

Example:

java
Copy code
public class SpaceRocket extends Rocket {
    // Additional properties and methods specific to space rockets
}

public class LunarModule extends Rocket {
    // Additional properties and methods specific to lunar modules
}
3. Polymorphism:

Polymorphism allows objects of different classes to be treated as objects of a common superclass. This can be useful when you want to perform actions on different types of rockets without knowing their specific types.

Example:

java
Copy code
public void launchRocket(Rocket rocket) {
    rocket.launch();
    // Additional actions after launching the rocket
}
4. Abstraction:
Abstraction is the concept of hiding complex implementation details and showing only necessary features of an object. Abstract classes and interfaces can be used for abstraction.

Example:

java
Copy code
public interface RocketInterface {
    void launch();
    void fastForward(int seconds);
}

public class Rocket implements RocketInterface {
    // Implementation of RocketInterface methods
}
5. Encapsulation:

Encapsulation is the bundling of data with the methods that operate on that data or the restricting of direct access to an object's properties. In the Rocket Launch Simulator, you can encapsulate the rocket's properties and methods, allowing controlled access and modification.

Example:

java
Copy code
public class Rocket {
    private int fuel;
    private int altitude;
    private int speed;

    // Constructors, getters, and setters
    // Methods to manipulate rocket properties

    private void updateAltitude() {
        // Logic to update altitude based on speed and other factors
    }
}
These OOP concepts provide a solid foundation for designing the Rocket Launch Simulator, promoting code reusability, modularity, and maintainability. By organizing the code using classes and objects, you can simulate real-world entities and their interactions, making the program more intuitive and easier to understand and modify.
