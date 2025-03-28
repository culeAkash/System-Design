package LLD.ProxyDesignPattern;

public class EmployeeDAOImpl implements EmployeeDAO {

    @Override
    public EmployeeDAO createEmployee(String client,EmployeeDAO employee) throws Exception {
        System.out.println("Employee created");
        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
        return employeeDAOImpl;
    }

    @Override
    public void deleteEmployee(String client,int id) throws Exception {
        System.out.println("Employee deleted");
    }

    @Override
    public EmployeeDAO getEmployee(String client,int id) throws Exception {
        System.out.println("Employee fetched");
        EmployeeDAOImpl employeeDAOImpl = new EmployeeDAOImpl();
        return employeeDAOImpl;
    }
    
}
