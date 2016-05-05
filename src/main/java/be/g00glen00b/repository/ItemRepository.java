package be.g00glen00b.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import be.g00glen00b.model.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, String> {
    public List<Item> findAll();
}
