package be.g00glen00b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.g00glen00b.model.Item;
import be.g00glen00b.repository.ItemRepository;

@RestController
@RequestMapping("/items")
public class ItemController {
  @Autowired
  private ItemRepository repo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Item> findItems() {
    return repo.findAll();
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Item addItem(@RequestBody Item item) {
    item.setId(null);
    return repo.save(item);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Item updatedItem(@RequestBody Item updatedItem, @PathVariable String id) {
    updatedItem.setId(id);
    return repo.save(updatedItem);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItem(@PathVariable String id) {
    System.out.println("deletingMethod");
    repo.delete(id);
  }
}
