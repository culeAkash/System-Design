package LLD.ObjectPoolDesignPattern;

public class Main{
    public static void main(String[] args) {
        DbConnection dbConnection1 = DbConnectionPoolManager.getInstance().getConnection();
        DbConnection dbConnection2 = DbConnectionPoolManager.getInstance().getConnection();
        DbConnection dbConnection3 = DbConnectionPoolManager.getInstance().getConnection();

        DbConnectionPoolManager.getInstance().returnConnection(dbConnection1);
    }   
}