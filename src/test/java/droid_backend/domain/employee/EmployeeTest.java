package droid_backend.domain.employee;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.employee.Employee;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.EmployeeFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;


/**
 * Created by Siraaj on 08/03/2016.
 */
public class EmployeeTest extends TestCase {
    @Test
    public void testCreateEmployee() throws Exception {
        AddressVO employeeAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", employeeAddress);

        Assert.assertEquals("Kashiefa",employee.getName());
        Assert.assertEquals("Rocklands",employee.getSuburb());

    }

    @Test
    public void testUpdateEmployee() throws Exception {
        AddressVO employeeAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Employee employee = EmployeeFactory.getEmployee(0001L, "Kashiefa", "Cottle", employeeAddress);

        Employee updateEmployee = new Employee.EmployeeBuilder()
                .copy(employee)
                .name("Siraaj")
                .surname("Wilkinson")
                .build();

        Assert.assertEquals("Siraaj",updateEmployee.getName());
        Assert.assertEquals("Wilkinson",updateEmployee.getSurname());
    }
}
