package sirma.academy.employeepairs.csv;

import sirma.academy.employeepairs.model.EmployeeProject;
import sirma.academy.employeepairs.utils.Constants;
import sirma.academy.employeepairs.utils.InputLineParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {
    public static List<EmployeeProject> read() {
        List<EmployeeProject> entries = new ArrayList<>();
        try {
            File myObj = new File(Constants.FILE_PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                entries.add(InputLineParser.parse(data));
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(Constants.CSV_READ_ERR);
            e.printStackTrace();
        }
        return entries;
    }

}
