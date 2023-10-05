Rocket Launch Simulator Flowchart:

Start
User Input
Is the input "start_checks"?
Yes: Initiate System Checks
Are all systems 'Go' for launch?
Yes: Move to Launch Stage
No: Display Error Message
Is the input "launch"?
Yes: Launch the Rocket
While there is fuel and altitude < 100 km:
Update Fuel, Altitude, and Speed
Is the altitude >= 30 km and stage equals "1"?
Yes: Separate Stage, Enter Stage 2
Is the altitude >= 100 km?
Yes: Mission Successful, End Simulation
No: Mission Failed, Insufficient Fuel, End Simulation
Is the input "fast_forward X"?
Yes: Fast Forward Simulation by X seconds
Update Altitude, Speed, and Fuel for X seconds
Is the altitude >= 100 km?
Yes: Mission Successful, End Simulation
No: Mission Failed, Insufficient Fuel, End Simulation
No: Display Invalid Command Error Message
End
This textual representation provides a basic outline of the flow of the Rocket Launch Simulator.