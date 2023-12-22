package sirma.academy.employeepairs.csv;

import sirma.academy.employeepairs.utils.Constants;
import sirma.academy.employeepairs.utils.InputLineParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CSVReader {
    public static void read() {
        try {
            File myObj = new File(Constants.FILE_PATH);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                InputLineParser.parse(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println(Constants.CSV_READ_ERR);
            e.printStackTrace();
        }
    }

}
