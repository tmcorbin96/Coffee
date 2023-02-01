package rock.zipcode.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rock.zipcode.demo.model.Coffee;
import rock.zipcode.demo.repository.CoffeeRepository;
import rock.zipcode.demo.service.CoffeeService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@CrossOrigin
@RequestMapping("/coffee")
public class CoffeeController {

    @Autowired
    public CoffeeService coffeeService;

    @PostMapping("/add")
    public String add(@RequestBody Coffee coffee) {
        coffeeService.saveCoffee(coffee);
        return "Coffee has been saved";
    }

    @GetMapping("/all")
    public List<Coffee> getAllCoffee() {
        return coffeeService.getAll();
    }

    @GetMapping("/{id}") // localhost:8080/coffee/id
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Integer id) {
        try {
            Coffee coffee = coffeeService.getCoffeeById(id);
            return new ResponseEntity<Coffee> (coffee, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Coffee>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> update(@RequestBody Coffee coffee,@PathVariable Integer id) {

        try {
            coffeeService.saveCoffee(coffee);
        return new ResponseEntity<Coffee> (coffee, HttpStatus.OK);
    } catch (NoSuchElementException e) {
        return new ResponseEntity<Coffee>(HttpStatus.NOT_FOUND);
    }
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id) {
        coffeeService.delete(id);
        return "Coffee " + id + " has been deleted";
    }
}
