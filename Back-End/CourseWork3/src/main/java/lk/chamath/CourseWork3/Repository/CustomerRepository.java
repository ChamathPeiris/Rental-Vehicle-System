package lk.chamath.CourseWork3.Repository;

import lk.chamath.CourseWork3.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CustomerRepository extends MongoRepository<Customer,String > {

        @Query("{'vehicleID' : ?0}")
        List<Customer> findByVehicleID (int vehicleID);

}
