package sirma.academy.employeepairs;

import sirma.academy.employeepairs.controller.MenuController;
import sirma.academy.employeepairs.repository.EmployeeProjectRepository;

public class EmployeePairsApplication {
    EmployeeProjectRepository repository = EmployeeProjectRepository.getInstance();

    public static void main(String[] args) {
        MenuController.showMenu();

    }
}
