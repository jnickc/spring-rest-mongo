package spring.rest.repository;
import org.springframework.data.repository.CrudRepository;

import spring.rest.model.Item;

import java.util.List;

public interface ItemRepository extends CrudRepository<Item, String> {
    public List<Item> findAll();
}
