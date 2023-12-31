package sirma.academy.employeepairs.utils;

public class Constants {
    public static final String FILE_PATH = "src/main/resources/example.csv";

    public static final String[] DATE_FORMATS = {
            "yyyy-MM-dd",
            "dd-MM-yyyy",
            "dd-MM-yy",
            "dd/MM/yyyy",
            "dd/MM/yy",
            "dd.MM.yyyy",
            "dd.MM.yyyy"
    };

    public static final String CSV_READ_ERR = "Error when trying to read CSV file";
    public static final String DATE_PARSE_ERR = "Unable to parse the date format: ";
    public static final String EMPID_PROJECTID_PARSE_ERR = "Unable to parse EmpID or ProjectID. Line: ";
    public static final String INVALID_CSV_FORMAT_ERR = "Invalid data format in the CSV line. Line: ";
    public static final String INVALID_DATE_FORMAT_ERR = "Invalid date format. Line: ";
    public static final String DATE_ERR = "DateTo must be after DateFrom";
    public static final String WRITE_SUCCESS_MSG = "Employee projects written to CSV successfully.";
    public static final String WRITE_ERR = "Error writing to CSV file: ";
    public static final String MENU_CHOICE_ERR = "Invalid input, enter a number from 1 to 6.";
    public static final String INPUT_NOT_NUM_ERR = "Invalid input, enter a valid integer: ";
    public static final String INVALID_FORMAT_ERR = "Invalid input format.";
    public static final String PAIRS_NOT_FOUND_MSG = "No pairs found";
}
