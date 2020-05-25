package Phase1;

import com.mongodb.DBObject;

public interface RentalVehicleManger {
        public abstract  void addVehicle(Vehicle vehicle, DBObject document) ;
        public abstract void deleteVehicle(String vehicleType) ;
        public abstract void editVehicle(String vehicleType);
        public abstract void printList();
        public abstract void saveFile();
        public abstract boolean runMenu();
}
