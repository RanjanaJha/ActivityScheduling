# ActivityScheduling

Activity Scheduling is a java project which creates a schedule for various teams from a list of activities.

# Author
    Ranjana Jha (ranjanajha003@gmail.com)

## Tech-Stack

Activity Scheduling uses the following :

* Java 8 [JDK Version : 1.8.0_191] - The programming language 
* Gradle [GRADLE Version : 4.10.2]- Build Tool
* Junit [JUNIT : 4.12] - Unit Testing

## Design

![alt text](https://github.com/RanjanaJha/ActivityScheduling/blob/master/Design.png)

The approach used to design the soltion is based on the concept of "All possible subsets of a set." The soltion can we broken down in the following --
            1. First find all possible subsets 
            2. Schedule will be equal to the final subsets obtained after filtering.
            Apply filtering on the subsets based on the problem statement given :
                    a.Non Empty Subset : All the subsets in the final subset should be non empty.
                    b.Lunch Break is all considered as of the activity . Hence all the final subset should contain Lunch as an activity.
                    c.No Single element subset : Final subset was filtered out of all those subsets which had single element,since that meant that it consisted of only Lunch Break an activity because of the condition in "b" above.
                    d. Final subset will contain all those subsets,each of which have a duration time equal to the time difference of the start and end time (in minutes.)
                    E.g. If START_TIME = "09:00 AM" END_TIME = "05:00 PM" ,
                    MAX_DURATION = 480 mins,
                    Hence , all those subsets meeting this 480 mins total duration mark will be a part of the final subset.
                    This is done considering the problem statement that - Motivation Presenation will start no earlier than 4:00 PM and no later than 5:00PM.
                    Here , we have a choice how we wanted to use the filter criteria.
                    We could have used the filtering as MIN_DURATION = 420 mins (considering the 4 PM cut off mark ) as well.
                    We could also have chosen the filtering criteria for duration to be between MIN_DURATION and MAX_DURATION as well but in such a case the time schedule for the final Self Motivation presentation would not start at the same time.
                    Hence , I went with MAX_DURATION = 480 mins i.e. the 5 PM time ,so that the self motivation presentation could start at the same time for all the teams/subsets and all the teams/subsets could attend more activities.

## Execution

As a pre-requisite for executing the Activity Scheduling application you must have gradle 4+ and Java 8+ .
After the pre-requisite, please follow the below steps for excution :

```sh
//Clone the git repo
$ git clone https://github.com/RanjanaJha/ActivityScheduling.git
//Go to the project root folder
$ cd ./ActivityScheduling
//Build the project
$ ./gradlew build
//Go to the /build/libs directory
$ java -jar ActivityScheduling.jar "ActivityFilepath,eg C:\ActivityScheduling\src\main\resources\Activities.txt"
//The output will be generated in the current directory,"libs" in this with naming as schedule_EPOCHSeconds.txt , //eg : schedule_1548790088.txt
```