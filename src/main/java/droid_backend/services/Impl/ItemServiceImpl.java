package droid_backend.services.Impl;

import droid_backend.domain.shop.Item;
import droid_backend.repository.ItemRepository;
import droid_backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siraaj on 08/17/2016.
 */
@Service
public class ItemServiceImpl implements ItemService{
    @Autowired
    ItemRepository repository;



    @Override
    public Item create(Item entity) {
        return repository.save(entity);
    }

    @Override
    public Item readById(Long aLong) {
        return repository.findOne(aLong);
    }

    @Override
    public List<Item> readAll() {
        List<Item> itemList = new ArrayList<Item>();
        Iterable<Item> items = repository.findAll();
        for (Item i : items){
            itemList.add(i);
        }
        return itemList;
    }

    @Override
    public Item update(Item entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Item entity) {
        repository.delete(entity);
    }
}
