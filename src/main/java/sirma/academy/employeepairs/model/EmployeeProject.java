package sirma.academy.employeepairs.model;

import java.time.LocalDate;

public class EmployeeProject {

    private Employee employee;
    private Project project;
    private TimeInterval timeInterval;

    public EmployeeProject(int employeeID, int projectID, TimeInterval timeInterval) {
        this.employee = new Employee(employeeID);
        this.project = new Project(projectID);
        this.timeInterval = timeInterval;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public TimeInterval getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(TimeInterval timeInterval) {
        this.timeInterval = timeInterval;
    }

    @Override
    public String toString() {
        return "\nEmployeeProject{" +
                "EmpID=" + employee.getEmployeeID() +
                ", ProjectID=" + project.getProjectID() +
                ", DateFrom=" + timeInterval.getDateFrom() +
                ", DateTo=" + timeInterval.getDateTo() +
                "}\n";
    }
}
