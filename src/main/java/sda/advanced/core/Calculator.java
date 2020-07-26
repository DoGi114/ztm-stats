package sda.advanced.core;

import sda.advanced.model.Vehicle;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Calculator {
    public static Double calculateAllVehiclesAverageSpeed(List<Vehicle> vehicleList) {
        return vehicleList.stream().mapToInt(Vehicle::getSpeed).average().orElseThrow();
    }

    public static Map<String, Double> calculateAllVehiclesAverageSpeedGroupedByLines(List<Vehicle> vehicleList) {
        Map<String, Double> vehiclesAverageSpeedGroupedByLanesMap = new HashMap<>();
        vehicleList.stream().collect(Collectors.groupingBy(Vehicle::getLine)).forEach((line, vehicles) -> {
            vehiclesAverageSpeedGroupedByLanesMap.put(line, vehicles.stream().mapToInt(Vehicle::getSpeed).average().orElseThrow());
        });

        return vehiclesAverageSpeedGroupedByLanesMap;
    }
}
