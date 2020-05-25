package lk.chamath.CourseWork3.Controller;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import lk.chamath.CourseWork3.Repository.CustomerRepository;
import lk.chamath.CourseWork3.models.Customer;
import lk.chamath.CourseWork3.service.WestminsterRentalVehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    WestminsterRentalVehicleManager westminsterRentalVehicleManager = new WestminsterRentalVehicleManager();


    //post the customer data
    @PostMapping(value = "/api/customer/{vehicleID}")
    public void createCustomer(@RequestBody Customer customer, @PathVariable int vehicleID) {
        customer.setVehicleID(vehicleID);
        customerRepository.save(customer);
        //return "Added :" + customer.getCusId();

    }
    private static void selectAllRecordByRecordNumber(DBCollection collection)
    {

        BasicDBObject whereQuery = new BasicDBObject();
        whereQuery.put("vehicleID", 1);
        DBCursor cursor = collection.find(whereQuery);
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }

}
