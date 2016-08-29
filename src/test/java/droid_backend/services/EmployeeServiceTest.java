package droid_backend.services;

import droid_backend.App;
import droid_backend.domain.address.AddressVO;
import droid_backend.domain.employee.Employee;
import droid_backend.factory.AddressFactory;
import droid_backend.services.Impl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Siraaj on 08/17/2016.
 */

@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration
public class EmployeeServiceTest  extends AbstractTestNGSpringContextTests {
    @Autowired
    EmployeeServiceImpl service;

    @Test
    public void testCreateEmployee() throws Exception {
        AddressVO address = AddressFactory.getAddress("7798","15 Sparrow","Rocklands");
        Employee employee = new Employee.EmployeeBuilder()
                .employeeCode(0L)
                .name("Bev")
                .surname("Wilkinson")
                .address(address)
                .build();
        Employee recordEmployee = service.create(employee);
        Assert.assertNotNull(recordEmployee);
    }

    @Test(dependsOnMethods = "testCreateEmployee")
    public void testReadAll() throws Exception {
        List<Employee> employees =  service.readAll();
        Assert.assertNotNull(employees);
    }

    @Test(dependsOnMethods = "testReadAll")
    public void testUpdateEmployee() throws Exception {
        Employee employee = service.readById(1L);
        if(employee != null)
        {
            Employee updateEmployee = new Employee.EmployeeBuilder()
                    .copy(employee)
                    .surname("Wilkinson")
                    .build();
            Employee updateEmployeeRecord =service.update(updateEmployee);
            Assert.assertEquals(updateEmployeeRecord.getSurname(),"Wilkinson");
        }
    }

    @Test(dependsOnMethods = "testUpdateEmployee")
    public void testDeleteEmployee() throws Exception {
        Employee employee = service.readById(4L);
        if(employee != null)
        {
            Assert.assertNotNull(employee);
            service.delete(employee);
            Employee deletedRecord = service.readById(4L);
            Assert.assertNull(deletedRecord);
        }
    }
}
