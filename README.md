This project consists of below source code and executable

The project source code consists of 4 files:
1. Statistics.java - Interface representing all the asked methods
2. StatisticsImpl.java - Implementation of Statistics Interface
3. StatsObject.java - Represents the object being used for storing individual statistics object
4. StatisticsCalculator.java - The main driver class to run the program

Read Comments: details about the methods are provided within the source code.
Assumptions are noted in the code with ASSUMPTION tag
Design TradeOffs are notes in the code with TRADE-OFF tag

How to:
Run the program: 
	1. We can run either by copying the source files
	2. or by running the executable

(1) Run via source files:
    a. Copy the project to ide
    b. Open  StatisticsCalculator.java
    c. Run as java application
    
 (2) Run via executable:
    a. java -jar statsCalculator.jar	
    
 Output: Here is the sample output and its explanation
 //Represents starting of program
 Starting at time:11
 
 //Represents addition of value=70 at time=11th second as a statsObject within StatsList
Stats Object:70 at 11

//Program run until 10 seconds, so this is tracking current times
 CurrentTime: 12 StartTime: 11
 
Stats Object:91 at 11

//Thread counts will show us how many threads we are consuming at this point
Thread Counts: event:1 mean: 1 meanN: 1 variance:1
Stats Object:55 at 11

//Represents mean of  all values present in statsList 
Mean at 12 is 80.5

//Represents variance of all values present in statsList
Variance at 12 is 110.25

//Represents mean at specific time
Mean at N 5 is 80.5
Minimum:55 Maximum:91
 CurrentTime: 13 StartTime: 11
Stats Object:92 at 11
Mean at 13 is 77.0
Thread Counts: event:2 mean: 2 meanN: 2 variance:2
 CurrentTime: 13 StartTime: 11
Mean at N 1 is 77.0
Variance at 13 is 238.5
Stats Object:3 at 11
Minimum:55 Maximum:92
Stats Object:18 at 11
 CurrentTime: 14 StartTime: 11
 CurrentTime: 14 StartTime: 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 14 StartTime: 11
Stats Object:19 at 11
Stats Object:16 at 11
Stats Object:94 at 11
 CurrentTime: 15 StartTime: 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
Stats Object:63 at 11
Variance at 15 is 1238.7654
Minimum:3 Maximum:94
 CurrentTime: 15 StartTime: 11
Stats Object:8 at 11
 CurrentTime: 15 StartTime: 11
Stats Object:1 at 11
Variance at 16 is 1256.8055
Minimum:1 Maximum:94
 CurrentTime: 16 StartTime: 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 16 StartTime: 11
Stats Object:24 at 11
 CurrentTime: 16 StartTime: 11
Stats Object:76 at 11
Stats Object:25 at 11
Mean at N 9 is 43.666668
Mean at 17 is 43.666668
 CurrentTime: 17 StartTime: 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 17 StartTime: 11
Stats Object:53 at 11
Stats Object:7 at 11
 CurrentTime: 17 StartTime: 11
Stats Object:84 at 11
Mean at N 4 is 44.38889
Mean at 18 is 44.38889
Variance at 18 is 1106.3489
Minimum:1 Maximum:94
 CurrentTime: 18 StartTime: 11
Stats Object:85 at 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 18 StartTime: 11
Stats Object:55 at 11
 CurrentTime: 18 StartTime: 11
Stats Object:64 at 11
Variance at 19 is 1039.1338
Minimum:1 Maximum:94
 CurrentTime: 19 StartTime: 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 19 StartTime: 11
Stats Object:76 at 11
 CurrentTime: 19 StartTime: 11
Stats Object:39 at 11
Stats Object:36 at 11
 CurrentTime: 20 StartTime: 11
 CurrentTime: 20 StartTime: 11
Stats Object:22 at 11
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 20 StartTime: 11
Stats Object:60 at 11
Stats Object:73 at 11
Variance at 21 is 898.9163
Minimum:1 Maximum:94
Thread Counts: event:3 mean: 2 meanN: 2 variance:2
 CurrentTime: 21 StartTime: 11
Stats Object:80 at 11

//Represents the end of program
Shutting down threads
About to close the program..
 	