package lk.chamath.CourseWork3.service;

import com.mongodb.DBObject;
import lk.chamath.CourseWork3.models.Vehicle;

public interface RentalVehicleManger {
        public abstract  void addVehicle(Vehicle vehicle, DBObject document) ;
        public abstract void deleteVehicle(String vehicleType) ;
        public abstract void editVehicle(String vehicleType);
        public abstract void printList();
        public abstract void saveFile();
        public abstract boolean runMenu();
}
