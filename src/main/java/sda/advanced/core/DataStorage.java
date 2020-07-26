package sda.advanced.core;

import lombok.Data;
import sda.advanced.model.Vehicle;
import sda.advanced.model.ZtmData;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Data
public class DataStorage {
//    private static final DataStorage INSTANCE = new DataStorage();

    private LocalDateTime lastUpdateDate;
    private List<Vehicle> vehicleList;

//    private DataStorage() {
    public DataStorage() {
        lastUpdateDate = LocalDateTime.now();
        vehicleList = new ArrayList<>();
    }

//    public static DataStorage getInstance(){
//        return INSTANCE;
//    }

    public void update(ZtmData ztmData){
        System.out.println("Last update was: " + lastUpdateDate );
        System.out.println("Updating...");
        lastUpdateDate = LocalDateTime.parse(ztmData.getLastUpdateDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        vehicleList = ztmData.getVehicleList();
        System.out.println("Finished updating at: " + LocalDateTime.now());
    }
}
