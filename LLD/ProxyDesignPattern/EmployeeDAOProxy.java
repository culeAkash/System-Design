package LLD.ProxyDesignPattern;

public class EmployeeDAOProxy implements EmployeeDAO {

    EmployeeDAO employeeDAO;

    public EmployeeDAOProxy() {
        this.employeeDAO = new EmployeeDAOImpl();
    }

    @Override
    public EmployeeDAO createEmployee(String client, EmployeeDAO employee) throws Exception {
        if(!client.equals("ADMIN")){
            throw new Exception("Access denied");
        }
        EmployeeDAO employeeDAO = this.employeeDAO.createEmployee(client, employee);
        return employeeDAO;
    }

    @Override
    public void deleteEmployee(String client, int id) throws Exception {
        if(!client.equals("ADMIN")){
            throw new Exception("Access denied");
        }
        this.employeeDAO.deleteEmployee(client, id);
    }

    @Override
    public EmployeeDAO getEmployee(String client, int id) throws Exception {
        if(!client.equals("ADMIN")){
            throw new Exception("Access denied");
        }
        EmployeeDAO employeeDAO = this.employeeDAO.getEmployee(client, id);
        return employeeDAO;
    }

    
    
}
