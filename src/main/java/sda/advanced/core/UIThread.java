package sda.advanced.core;

import sda.advanced.inbound.ZtmDataProvider;

import java.time.LocalTime;
import java.util.Map;
import java.util.Scanner;

public class UIThread extends Thread {

    private final DataStorage dataStorage;
    private boolean running;

    public UIThread(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public synchronized void start() {
        System.out.println("UIThread " + getName() + " Started at " + LocalTime.now());
        super.start();
    }

    @Override
    public void run() {
        super.run();
        running = true;
        while (running) {
            System.out.println("Chose option:");
            System.out.println("1. Print all vehicles");
            System.out.println("2. Update");
            System.out.println("3. Calculate all vehicles average speed");
            System.out.println("4. Calculate all vehicles average speed and group by lines");
            System.out.println("5. Close app");

            Scanner scanner = new Scanner(System.in);
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    dataStorage.getVehicleList().forEach(System.out::println);
                    break;
                case "2":
                    dataStorage.update(ZtmDataProvider.getData().orElseThrow());
                    break;
                case "3":
                    System.out.println("Average vehicles speed: " + Calculator.calculateAllVehiclesAverageSpeed(dataStorage.getVehicleList()));
                    break;
                case "4":
                    Map<String, Double> linesAverageSpeedMap = Calculator.calculateAllVehiclesAverageSpeedGroupedByLines(dataStorage.getVehicleList());
                    for (String line : linesAverageSpeedMap.keySet()) {
                        System.out.println(String.format("Line %s average speed it: %f", line, linesAverageSpeedMap.get(line)));
                    }
                    break;
                case "5":
                    running = false;
                    break;
            }
        }

    }
}
