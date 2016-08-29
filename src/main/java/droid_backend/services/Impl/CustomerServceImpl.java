package droid_backend.services.Impl;

import droid_backend.domain.customer.Customer;
import droid_backend.repository.CustomerRepository;
import droid_backend.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Siraaj on 08/09/2016.
*/

@Service
public class CustomerServceImpl implements CustomerService{

    @Autowired
   private CustomerRepository repository;

    @Override
    public Customer create(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Customer> readAll() {
        List<Customer> customerList = new ArrayList<Customer>();
        Iterable<Customer> customers = repository.findAll();
        for (Customer c : customers){
            customerList.add(c);
        }
        return customerList;
    }

    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);
    }
}