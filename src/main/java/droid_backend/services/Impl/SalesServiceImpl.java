package droid_backend.services.Impl;

import droid_backend.domain.shop.ShopProcess;
import droid_backend.repository.SalesRepository;
import droid_backend.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siraaj on 08/18/2016.
 */
@Service
public class SalesServiceImpl implements SalesService {
    @Autowired
    SalesRepository repository;


    @Override
    public ShopProcess create(ShopProcess entity) {
        return repository.save(entity);
    }

    @Override
    public ShopProcess readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<ShopProcess> readAll() {
        List<ShopProcess> salesList = new ArrayList<ShopProcess>();
        Iterable<ShopProcess> sales = repository.findAll();
        for (ShopProcess i : sales){
            salesList.add(i);
        }
        return salesList;
    }

    @Override
    public ShopProcess update(ShopProcess entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ShopProcess entity) {
        repository.delete(entity);
    }
}
