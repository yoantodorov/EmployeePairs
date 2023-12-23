package sirma.academy.employeepairs.controller;

import sirma.academy.employeepairs.csv.CSVReader;
import sirma.academy.employeepairs.model.EmployeeProject;
import sirma.academy.employeepairs.model.TimeInterval;
import sirma.academy.employeepairs.repository.EmployeeProjectRepository;
import sirma.academy.employeepairs.service.EmployeePairService;
import sirma.academy.employeepairs.service.EmployeeProjectService;
import sirma.academy.employeepairs.utils.Constants;
import sirma.academy.employeepairs.utils.DateFormatParser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class MenuController {
    private static final Scanner scanner = new Scanner(System.in);


    public static void showMenu() {
        CSVReader.read();
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("\nEmployee Pairs Application");
            System.out.println("1. Add a new entry");
            System.out.println("2. Save to file");
            System.out.println("3. Show pair with most days together on a common project");
            System.out.println("4. Show all pairs");
            System.out.println("5. Show all entries");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            if (scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1 -> addNewEntry();
                    case 2 -> saveToFile();
                    case 3 -> showPairWithMostDays();
                    case 4 -> showAllPairs();
                    case 5 -> showAll();
                    case 6 -> isRunning = false;
                    default -> System.out.println(Constants.MENU_CHOICE_ERR);
                }
            }
            else {
                scanner.nextLine();
                System.out.println(Constants.INPUT_NOT_NUM_ERR);
            }
        }
    }

    private static void showAll() {
        System.out.println(EmployeeProjectRepository.getInstance().getEmployeeProjectList());
    }

    private static void showAllPairs() {

        EmployeePairService.showAllPairs();
    }
    private static void showPairWithMostDays() {
        EmployeePairService.showPairWithMostDays();
    }
    private static void addNewEntry() {

        try {
            int employeeID = readIntegerInput("Enter EmployeeID:");
            int projectID = readIntegerInput("Enter ProjectID:");

            System.out.println("Enter From Date (yyyy-MM-dd):");
            LocalDate dateFrom = DateFormatParser.parse(scanner.nextLine());

            System.out.println("Enter To Date (yyyy-MM-dd):");
            LocalDate dateTo = DateFormatParser.parse(scanner.nextLine());

            if (dateTo.isAfter(dateFrom)) {
                EmployeeProjectService.add(new EmployeeProject(employeeID, projectID, new TimeInterval(dateFrom, dateTo)));
            } else {
                System.out.println(Constants.DATE_ERR);
            }
        } catch (DateTimeParseException | NumberFormatException e) {
            System.out.println(Constants.INVALID_FORMAT_ERR);
        }

    }

    private static int readIntegerInput(String message) {
        System.out.println(message);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println(Constants.INPUT_NOT_NUM_ERR);
            }
        }
    }

    private static void saveToFile() {
        EmployeeProjectRepository.getInstance().save();
    }


}
