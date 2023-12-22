package sirma.academy.employeepairs.repository;

import sirma.academy.employeepairs.csv.CSVWriter;
import sirma.academy.employeepairs.model.EmployeeProject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class EmployeeProjectRepository {

    private static final EmployeeProjectRepository INSTANCE = new EmployeeProjectRepository();
    private final List<EmployeeProject> employeeProjectList = new ArrayList<>();

    private EmployeeProjectRepository() {
    }

    public static EmployeeProjectRepository getInstance() {
        return INSTANCE;
    }

    public List<EmployeeProject> getEmployeeProjectList() {
        return Collections.unmodifiableList(employeeProjectList);
    }


    public void addEmployeeProject(EmployeeProject employeeProject) {
        employeeProjectList.add(employeeProject);
    }

    public boolean updateEmployeeProject(EmployeeProject updatedEmployeeProject) {
        for (EmployeeProject employeeProject : employeeProjectList) {
            if (employeeProject.getEmployee().getEmployeeID() == updatedEmployeeProject.getEmployee().getEmployeeID()) {
                employeeProjectList.set(employeeProjectList.indexOf(employeeProject), updatedEmployeeProject);
                return true;
            }
        }
        return false;
    }

    public boolean deleteEmployeeProject(int id) {
        Optional<EmployeeProject> employeeProject = getEmployeeProjectById(id);
        if (employeeProject.isPresent()) {
            employeeProjectList.remove(employeeProject.get());
            return true;
        }
        return false;
    }
    public Optional<EmployeeProject> getEmployeeProjectById(int id) {
        return employeeProjectList.stream()
                .filter(empProj -> empProj.getEmployee().getEmployeeID() == id)
                .findFirst();
    }
    public void save() {
        CSVWriter.writeEmployeeProjectsToCSV(employeeProjectList);
    }
}
