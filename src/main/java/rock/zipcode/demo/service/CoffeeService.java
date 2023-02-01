package rock.zipcode.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rock.zipcode.demo.model.Coffee;
import rock.zipcode.demo.repository.CoffeeRepository;

import java.util.List;

@Service
public class CoffeeService { // create, read, update, delete


    @Autowired
    private CoffeeRepository coffeeRepository;

    public void saveCoffee(Coffee coffee) {
        coffeeRepository.save(coffee);
    }

    public List<Coffee> getAll() {
        return coffeeRepository.findAll();
    }

    public Coffee getCoffeeById (Integer id) {
        return coffeeRepository.findById(id).get();
    }

    public void delete (Integer id) {
        coffeeRepository.deleteById(id);
    }


}
