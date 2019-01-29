# ActivityScheduling

Activity Scheduling is a java project which creates a schedule for various teams from a list of activities.

# Author
    Ranjana Jha (ranjanajha003@gmail.com)

### Tech-Stack

Activity Scheduling uses the following :

* Java 8 [JDK Version : 1.8.0_191] - The programming language 
* Gradle [GRADLE Version : 4.10.2]- Build Tool
* Junit [JUNIT : 4.12] - Unit Testing

### DESIGN

![alt text](https://github.com/RanjanaJha/ActivityScheduling/blob/master/Design.png)


### EXECUTION

As a pre-requisite for executing the Activity Scheduling application you must have gradle 4+ and Java 8+ .
After the pre-requisite, please follow the below steps for excution :

```sh
//Clone the git repo
$ git clone https://github.com/RanjanaJha/ActivityScheduling.git
//Go to the project root folder
$ cd ./ActivityScheduling
//Build the project
$ gradlew build
//Go to the /build/libs directory
$ java -jar ActivityScheduling.jar "ActivityFilepath,eg C:\ActivityScheduling\src\main\resources\Activities.txt"
//The output will be generated in the "libs" directory with naming as schedule_EPOCHSeconds.txt , //eg : schedule_1548790088.txt
```