package LLD.ProxyDesignPattern;

public class Main {
    public static void main(String[] args) {
        try {
            EmployeeDAO employeeDAO = new EmployeeDAOProxy();
            employeeDAO.createEmployee("ADMIN", new EmployeeDAOImpl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
    }
}