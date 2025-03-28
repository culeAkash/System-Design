package LLD.ProxyDesignPattern;

public interface EmployeeDAO {
    EmployeeDAO createEmployee(String client,EmployeeDAO employee) throws Exception;
    void deleteEmployee(String client,int id) throws Exception;
    EmployeeDAO getEmployee(String client,int id) throws Exception;
}
