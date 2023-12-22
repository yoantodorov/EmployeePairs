package sirma.academy.employeepairs.utils;

import sirma.academy.employeepairs.model.EmployeeProject;
import sirma.academy.employeepairs.model.TimeInterval;
import sirma.academy.employeepairs.repository.EmployeeProjectRepository;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class InputLineParser {

    private static final EmployeeProjectRepository repository = EmployeeProjectRepository.getInstance();


    public static void parse(String line) {
        String[] input = line.split("\\s*,\\s*");
        if (input.length == 4) {
            try {
                int empID = Integer.parseInt(input[0]);
                int projectID = Integer.parseInt(input[1]);
                LocalDate dateFrom = DateFormatParser.parse(input[2]);

                LocalDate dateTo;
                if (input[3].equalsIgnoreCase("NULL")) {
                    dateTo = LocalDate.now();
                } else {
                    dateTo = DateFormatParser.parse(input[3]);
                }

                repository.addEmployeeProject(new EmployeeProject(empID, projectID, new TimeInterval(dateFrom, dateTo)));
            } catch (NumberFormatException e) {
                System.err.println(Constants.EMPID_PROJECTID_PARSE_ERR + line);
                e.printStackTrace();
                System.exit(1);

            } catch (DateTimeParseException e) {
                System.err.println(Constants.INVALID_DATE_FORMAT_ERR + line);
                e.printStackTrace();
                System.exit(1);

            }
        } else {
            System.err.println(Constants.INVALID_CSV_FORMAT_ERR + line);
            System.exit(1);
        }

    }
}
