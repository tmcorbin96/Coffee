package rock.zipcode.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import rock.zipcode.demo.model.Coffee;

public interface CoffeeRepository extends JpaRepository <Coffee, Integer>{
}
