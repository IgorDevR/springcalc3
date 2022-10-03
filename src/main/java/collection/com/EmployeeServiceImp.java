package collection.com;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImp implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    @Override
    public Employee addEmployee(String firstName, String lastName) {

        //условно максимум который можно добавить это 10. если больше то выбрасывается исключение
        if (employees.size() > 10) {
            throw new EmployeeArrayIsFullException();
        }

        Employee emp = new Employee(firstName, lastName);
        employees.add(emp);
        return emp;

    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {

        for (Employee emp : employees) {
            if (emp.getFirstName().contains(firstName) && emp.getLastName().contains(lastName)) {
                employees.remove(emp);
                return emp;
            }
        }
        throw new EmployeeAlreadyAddedException();
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {

        for (Employee emp : employees) {
            if (emp.getFirstName().contains(firstName) && emp.getLastName().contains(lastName)) {
                return emp;
            }
        }
        throw new EmployeeNotFoundException();

    }

    @Override
    public List<Employee> getAllEmployee() {
        return employees;
    }

    class EmployeeArrayIsFullException extends RuntimeException {
        @Override
        public String toString() {
            return "Массив переполнен";
        }
    }

    class EmployeeAlreadyAddedException extends RuntimeException {
        @Override
        public String toString() {
            return "Такой сотрудник уже имеется";
        }
    }

    class EmployeeNotFoundException extends RuntimeException {
        @Override
        public String toString() {
            return "Сотрудник не найден";
        }
    }


}

