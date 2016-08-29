package droid_backend.factory;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.employee.Employee;

/**
 * Created by Siraaj on 08/03/2016.
 */
public class EmployeeFactory {
    public static Employee getEmployee(Long empCode, String name, String surname, AddressVO address){
        return new Employee.EmployeeBuilder()
                .employeeCode(empCode)
                .name(name)
                .surname(surname)
                .address(address)
                .build();
    }
}
