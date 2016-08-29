package droid_backend.domain.employee;

import droid_backend.domain.address.AddressVO;
import droid_backend.domain.customer.Customer;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Siraaj on 08/03/2016.
 */

@Entity
public class Employee implements Serializable, IEmployeeEvents {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Long empCode;
    String name;
    String surname;

    @Embedded
    AddressVO address;
    Date dateHired;
    //Map<Long,Date> employeeEventsHistory = new HashMap();

    private Employee(){}

    public Employee(EmployeeBuilder employeeBuilder) {
        DateFormat dateFormat;
        this.name = employeeBuilder.name;
        this.surname = employeeBuilder.surname;
        this.empCode = employeeBuilder.empCode;
        this.address = employeeBuilder.address;
        dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        dateHired = new Date();
        //employeeHired();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPostalCode(){
        return address.getPostalCode();
    }

    public String getStreetName(){
        return address.getStreetName();
    }

    public String getSuburb(){
        return address.getSuburb();
    }

    public Long getEmpCode() {
        return empCode;
    }

    public AddressVO getAddress(){
        return address;
    }

    public void viewEmployee() {
        System.out.println(empCode);
        System.out.println(name+" "+surname);
        System.out.println("\n"+"Address:");
        address.viewAddress();

    }

    @Override
    public void employeeHired() {
        //employeeEventsHistory.put(empCode, date);
    }

    public void employeesHistory(Long code){
     /*   if(!employeeEventsHistory.get(code).equals(null)) {
            System.out.println("Employee hired on");
            System.out.println(employeeEventsHistory.get(code));
            System.out.println("Employee ID: "+empCode);
            System.out.println("Employee Name: "+name);
        }*/
    }

    public static class EmployeeBuilder{

        Long empCode;
        String name;
        String surname;
        AddressVO address;

        public EmployeeBuilder name(String name){
            this.name = name;
            return this;
        }

        public EmployeeBuilder surname(String surname){
            this.surname = surname;
            return this;
        }

        public EmployeeBuilder employeeCode(Long empCode){
            this.empCode = empCode;
            return this;
        }

        public EmployeeBuilder address(AddressVO address){
            this.address = address;
            return this;
        }

        public EmployeeBuilder copy(Employee employee){
            this.name = employee.name;
            this.surname = employee.surname;
            this.empCode = employee.empCode;
            this.address = employee.address;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        return empCode == employee.empCode;

    }

    @Override
    public int hashCode() {
        return (int) (empCode ^ (empCode >>> 32));
    }
}
