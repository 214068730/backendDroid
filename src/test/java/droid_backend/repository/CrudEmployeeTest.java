package droid_backend.repository;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.employee.Employee;
import droid_backend.factory.AddressFactory;
import droid_backend.factory.EmployeeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.annotations.Test;

/**
 * Created by Siraaj on 08/14/2016.
 */
@SpringApplicationConfiguration(classes= App.class)
@WebAppConfiguration
public class CrudEmployeeTest extends AbstractTestNGSpringContextTests {

    private Long id;
    @Autowired
    EmployeeRepository repo;

    @Test
    public void testCreate() throws Exception {
        AddressVO employeeAddress = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Employee employee = new Employee.EmployeeBuilder()
                .name("Wilkinson")
                .surname("Shireen")
                .address(employeeAddress)
                .build();
        Employee record = repo.save(employee);
    }
}
