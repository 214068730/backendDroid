package droid_backend.services.Impl;

import droid_backend.domain.employee.Employee;
import droid_backend.repository.EmployeeRepository;
import droid_backend.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siraaj on 08/17/2016.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeRepository repository;


    @Override
    public Employee create(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Employee readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Employee> readAll() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Iterable<Employee> employees = repository.findAll();
        for (Employee e : employees){
            employeeList.add(e);
        }
        return employeeList;
    }

    @Override
    public Employee update(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Employee entity) {
        repository.delete(entity);
    }
}
