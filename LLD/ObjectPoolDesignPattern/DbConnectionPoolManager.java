package LLD.ObjectPoolDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class DbConnectionPoolManager {
    private List<DbConnection> availableConnections;
    private List<DbConnection> inUseConnections;
    private int maxConnections = 6;
    private int initialConnections = 3;
    private static DbConnectionPoolManager managerInstance; 

    private DbConnectionPoolManager(){
        availableConnections = new ArrayList<>();
        inUseConnections = new ArrayList<>();
        for(int i = 0; i < initialConnections; i++){
            availableConnections.add(new DbConnection());
        }
    }

    public static DbConnectionPoolManager getInstance(){
        if(managerInstance == null){
            synchronized(DbConnectionPoolManager.class){
                if(managerInstance == null){
                    managerInstance = new DbConnectionPoolManager();
                }
            }
        }
        return managerInstance;
    }

    public synchronized DbConnection getConnection(){
        if(availableConnections.isEmpty() && inUseConnections.size() < maxConnections){
            availableConnections.add(new DbConnection());
        }
        else if(availableConnections.isEmpty() && inUseConnections.size() >= maxConnections){
            System.out.println("Connection pool is full");
            return null;
        }

        DbConnection connection = availableConnections.remove(availableConnections.size() - 1);
        inUseConnections.add(connection);
        return connection;
    }

    public synchronized void returnConnection(DbConnection connection){
        inUseConnections.remove(connection);
        availableConnections.add(connection);
    }
}

