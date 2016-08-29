package droid_backend.services.Impl;

import droid_backend.domain.shop.Orderline;
import droid_backend.repository.OrderlineRepository;
import droid_backend.services.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siraaj on 08/19/2016.
 */

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    OrderlineRepository repository;

    @Override
    public Orderline create(Orderline entity) {
        return repository.save(entity);
    }

    @Override
    public Orderline readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Orderline> readAll() {
        List<Orderline> list = new ArrayList<Orderline>();
        Iterable<Orderline> orders = repository.findAll();
        for (Orderline o : orders){
            list.add(o);
        }
        return list;
    }

    @Override
    public Orderline update(Orderline entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Orderline entity) {
        repository.delete(entity);
    }
}
