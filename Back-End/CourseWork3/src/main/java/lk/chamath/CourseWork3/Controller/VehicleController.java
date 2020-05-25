package lk.chamath.CourseWork3.Controller;
import lk.chamath.CourseWork3.models.Car;
import lk.chamath.CourseWork3.models.Motorbike;
import lk.chamath.CourseWork3.service.WestminsterRentalVehicleManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
public class VehicleController {
    @Autowired
    WestminsterRentalVehicleManager westminsterRentalVehicleManager = new WestminsterRentalVehicleManager();

    //Get all cars
    @RequestMapping("/api/cars")
    public List<Car> getCars(){
        return westminsterRentalVehicleManager.getAllCars();
    }

    //Get all motorbikes
    @RequestMapping("/api/motorbikes")
    public List<Motorbike> getMotorbikes(){
        return westminsterRentalVehicleManager.getAllMotorBikes();
    }

    @RequestMapping(value = "/api/check")
    public Map<String, String> check(@RequestParam int vehicleID, Date pickup, Date drop){

     return  westminsterRentalVehicleManager.filterByVehicle(vehicleID, pickup, drop);

    }

}
