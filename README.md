# Employee Pairs Project

This project is the final exam of Sirma Academy September 2023. 

## Task Requirements
The task is to identify the pair of employees who have worked together on common projects for the longest period of time and the time for each of those projects. 
The output (.3 in the menu) consists of the IDs of the two employees of the pair with a sum of all the days they spent together on every common project they have overlapping time in and each of those project with the respective days.

## Algorithm Explanation

The algorithm operates in the following way:

1. **Reading Data**:
    - The `EmployeeProjectRepository` retrieves the data from the csv file by calling read method of CSVReader class.
    - Each retrieved entry contains Employee ID, Project ID, and Time Interval.

2. **Generating all unique pairs per project**:
    - In the `EmployeeProjectService` a map `employeeProjectList` is created which contains a project and its employees with their time intervals of working on the project (an employee can have multiple time intervals of working on a single project).
    - ProjectEmployeesMapping maps the input data from the repositories to the `employeeProjectList` data structure
    - The `getUniquePairs` method generates all the unique pairs for each project

3. **Overlap Days Calculation**:
    - The `getTotalOverlapDays` method from `TimeIntervalService` calculates the overlap days between the two time intervals of each pair.

4. **Generating all pairs with a list of all the projects in which they worked together**:
    - If a pair in `getUniquePairs` method has more than 0 overlapped days it is mapped in `EmployeePairService` to an entity called 'EmployeePair' which contains both employees' ID, a list of projects on which they worked together and the total time they spent together working on common projects
    - The employee pairs are sorted and the pair of employees who have worked together on common projects for the longest period of time and the time for each of those projects are displayed by `showPairWithMostDays` method (3. in the menu)

## Functionalities
1. Adding a new entry 
2. Saving to file
3. Displaying the pair with most days on a common project
4. Displaying all pairs sorted by days spent together on all common projects by descending order
5. Displaying all the entry lines parsed from the csv file

## Setup
Run the console application from src/main/java/sirma/academy/employeepairs/EmployeePairsApplication.java

## Project Structure

The project consists of several main components:
- `controller`: Contains the main menu and user interaction logic.
- `csv`: Handles reading and writing data to CSV files.
- `model`: Defines the project's data model classes.
- `repository`: Manages data retrieval, storage, and CRUD operations.
- `service`: Implements the core functionalities and business logic.


## Contact

email: y.pl.todorov@gmail.com
   

