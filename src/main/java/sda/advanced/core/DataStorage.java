package sda.advanced.core;

import lombok.Data;
import lombok.Getter;
import sda.advanced.model.Vehicle;
import sda.advanced.model.ZtmData;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataStorage {
//    private static final DataStorage INSTANCE = new DataStorage();

    private String lastUpdateDate;
    private List<Vehicle> vehicleList;

//    private DataStorage() {
    public DataStorage() {
        lastUpdateDate = LocalTime.now().toString();
        vehicleList = new ArrayList<>();
    }

//    public static DataStorage getInstance(){
//        return INSTANCE;
//    }

    public void update(ZtmData ztmData){
        System.out.println("Last update was: " + lastUpdateDate );
        System.out.println("Updating...");
        lastUpdateDate = ztmData.getLastUpdateDate();
        vehicleList = ztmData.getVehicleList();
        System.out.println("Finished updating at: " + LocalTime.now());
    }
}
