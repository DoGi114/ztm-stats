package sda.advanced;

import sda.advanced.core.DataStorage;
import sda.advanced.inbound.QueryThread;

public class App 
{
    public static void main( String[] args )
    {
        QueryThread queryThread = new QueryThread(new DataStorage());
        queryThread.start();
    }
}
