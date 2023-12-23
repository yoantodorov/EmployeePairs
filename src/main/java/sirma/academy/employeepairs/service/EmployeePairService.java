package sirma.academy.employeepairs.service;

import sirma.academy.employeepairs.model.EmployeePair;
import sirma.academy.employeepairs.model.ProjectInfo;
import sirma.academy.employeepairs.utils.Constants;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EmployeePairService {

    public static List<EmployeePair> employeePairs = new ArrayList<>();


    public static void sortByTotalDaysTogether(List<EmployeePair> employeePairs) {
        employeePairs.sort(Comparator.comparingLong(EmployeePair::getTotalDaysTogether).reversed());
    }

    public static void showPairWithMostDays() {
        EmployeeProjectService.ProjectEmployeesMapping();
        EmployeeProjectService.getUniquePairs();

        if (!employeePairs.isEmpty()) {
            sortByTotalDaysTogether(employeePairs);
            EmployeePair pairWithMostDays = employeePairs.get(0);
            System.out.println(pairWithMostDays);
        } else {
            System.out.println(Constants.PAIRS_NOT_FOUND_MSG);
        }
        employeePairs.clear();
        EmployeeProjectService.projectEmployeesMap.clear();
    }

    public static void employeePairMapping(int empID, int empID2, int projectID, long days) {
        EmployeePair pair = null;
        boolean hasPair = false;
        for (EmployeePair empPair : employeePairs) {
            if (empPair.equals(empID, empID2)) {
                pair = empPair;
                hasPair = true;
                break;
            }
        }

        if (!hasPair) {
            pair = new EmployeePair(empID, empID2);
        }
        pair.getProjects().add(new ProjectInfo(projectID, days));
        if (!hasPair) {
            employeePairs.add(pair);
        }
        pair.calculateTotalDaysTogether();
    }

    public static void showAllPairs() {
        EmployeeProjectService.ProjectEmployeesMapping();
        EmployeeProjectService.getUniquePairs();
        sortByTotalDaysTogether(employeePairs);
        System.out.println(employeePairs);

        employeePairs.clear();
        EmployeeProjectService.projectEmployeesMap.clear();
    }
}
