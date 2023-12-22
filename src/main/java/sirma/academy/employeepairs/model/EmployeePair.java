package sirma.academy.employeepairs.model;

import java.util.ArrayList;
import java.util.List;

public class EmployeePair {
    private int empID1;
    private int empID2;
    private List<ProjectInfo> projects;
    private long totalDaysTogether;

    public EmployeePair(int empID1, int empID2) {
        this.empID1 = empID1;
        this.empID2 = empID2;
        this.projects = new ArrayList<>();
        this.totalDaysTogether = 0;
    }

    public EmployeePair() {
    }

    public int getEmpID1() {
        return empID1;
    }

    public void setEmpID1(int empID1) {
        this.empID1 = empID1;
    }

    public int getEmpID2() {
        return empID2;
    }

    public void setEmpID2(int empID2) {
        this.empID2 = empID2;
    }

    public List<ProjectInfo> getProjects() {
        return projects;
    }

    public long getTotalDaysTogether() {
        return totalDaysTogether;
    }

    public boolean equals(int empID1, int empID2) {
        return (this.empID1 == empID1 && this.empID2 == empID2) || (this.empID2 == empID1 && this.empID1 == empID2);
    }

    public void calculateTotalDaysTogether() {
        long total = 0;
        for (ProjectInfo projectInfo : projects) {
            total += projectInfo.getDaysTogether();
        }
        this.totalDaysTogether = total;
    }

    @Override
    public String toString() {
        return "EmployeePair: " +
                "empID1=" + empID1 +
                ", empID2=" + empID2 + "    TotalDaysTogether: " + totalDaysTogether +
                "\n    " + projects +
                "\n";
    }
}
