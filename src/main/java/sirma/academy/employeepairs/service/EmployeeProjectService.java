package sirma.academy.employeepairs.service;

import sirma.academy.employeepairs.repository.EmployeeProjectRepository;
import sirma.academy.employeepairs.model.EmployeeProject;
import sirma.academy.employeepairs.model.TimeInterval;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeProjectService {
    public static Map<Integer, Map<Integer, List<TimeInterval>>> projectEmployeesMap = new HashMap<>();
    private static final EmployeeProjectRepository repository = EmployeeProjectRepository.getInstance();

    public static void ProjectEmployeesMapping() {
        List<EmployeeProject> employeeProjectList = repository.getEmployeeProjectList();
        for (EmployeeProject empProject : employeeProjectList) {
            int projectID = empProject.getProject().getProjectID();
            int empID = empProject.getEmployee().getEmployeeID();
            LocalDate dateFrom = empProject.getTimeInterval().getDateFrom();
            LocalDate dateTo = empProject.getTimeInterval().getDateTo();

            if (!projectEmployeesMap.containsKey(projectID)) {
                projectEmployeesMap.put(projectID, new HashMap<>());
            }

            if (!projectEmployeesMap.get(projectID).containsKey(empID)) {
                projectEmployeesMap.get(projectID).put(empID, new ArrayList<>());
            }

            projectEmployeesMap.get(projectID).get(empID).add(new TimeInterval(dateFrom, dateTo));
        }
    }

    public static void getUniquePairs() {
        for (Integer projectID : projectEmployeesMap.keySet()) {
            Map<Integer, List<TimeInterval>> employeesMap = projectEmployeesMap.get(projectID);
            for (Integer empID : employeesMap.keySet()) {
                for (Integer empID2 : employeesMap.keySet()) {
                    if (empID < empID2) {
                        List<TimeInterval> timeIntervals1 = employeesMap.get(empID);
                        List<TimeInterval> timeIntervals2 = employeesMap.get(empID2);
                        long days = TimeIntervalService.getTotalOverlapDays(timeIntervals1, timeIntervals2);
                        if (days>0){
                            EmployeePairService.employeePairMapping(empID, empID2, projectID, days);
                        }
                    }
                }
            }

        }
    }

    public static void add(EmployeeProject employeeProject) {
        repository.addEmployeeProject(employeeProject);
        repository.save();
    }
}

