package sda.advanced.inbound;

import sda.advanced.core.DataStorage;

import java.time.LocalTime;

public class QueryThread extends Thread {
    private final DataStorage dataStorage;

    public QueryThread(DataStorage dataStorage) {
        this.dataStorage = dataStorage;
    }

    @Override
    public synchronized void start() {
        System.out.println("Thread " + getName() + " Started at " + LocalTime.now());
        super.start();
    }

    @Override
    public void run() {
        super.run();
        while(true) {
            dataStorage.update(ZtmDataProvider.getData().orElseThrow());
            try {
                Thread.sleep(30000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
