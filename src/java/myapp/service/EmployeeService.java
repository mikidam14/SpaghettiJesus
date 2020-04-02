/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;
 
import java.util.List;
 
import myapp.model.Employee;
 
public interface EmployeeService {
    Employee findById(int id);
    void saveEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void deleteEmployee(int id);
    List<Employee> findAllEmployees();
    void incrementSalary(int id);
    void incrementSalary();
}