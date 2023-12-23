package sirma.academy.employeepairs.csv;

import sirma.academy.employeepairs.model.EmployeeProject;
import sirma.academy.employeepairs.utils.Constants;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class CSVWriter {

    public static void writeEmployeeProjectsToCSV(List<EmployeeProject> employeeProjectList) {

        try (PrintWriter writer = new PrintWriter(new FileWriter(Constants.FILE_PATH))) {

            for (EmployeeProject employeeProject : employeeProjectList) {
                String line = String.format(
                        "%d,%d,%s,%s",
                        employeeProject.getEmployee().getEmployeeID(),
                        employeeProject.getProject().getProjectID(),
                        employeeProject.getTimeInterval().getDateFrom(),
                        employeeProject.getTimeInterval().getDateTo()
                );
                writer.println(line);
            }
            System.out.println(Constants.WRITE_SUCCESS_MSG);
        } catch (IOException e) {
            System.err.println(Constants.WRITE_ERR + e.getMessage());
        }
    }
}
