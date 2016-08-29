package droid_backend.services.Impl;

import droid_backend.domain.shop.Supplier;
import droid_backend.repository.SupplierRepository;
import droid_backend.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siraaj on 08/17/2016.
 */

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    SupplierRepository repository;


    @Override
    public Supplier create(Supplier entity) {
        return repository.save(entity);
    }

    @Override
    public Supplier readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Supplier> readAll() {
        List<Supplier> supplierList = new ArrayList<Supplier>();
        Iterable<Supplier> suppliers = repository.findAll();
        for (Supplier s : suppliers){
            supplierList.add(s);
        }
        return supplierList;
    }

    @Override
    public Supplier update(Supplier entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Supplier entity) {
        repository.delete(entity);
    }
}
