package sda.advanced;

import sda.advanced.core.DataStorage;
import sda.advanced.core.UIThread;

public class App 
{
    public static void main( String[] args ) {
        DataStorage dataStorage = new DataStorage();
//        QueryThread queryThread = new QueryThread(dataStorage);
//        queryThread.start();
        UIThread uiThread = new UIThread(dataStorage);
        uiThread.start();
    }
}
