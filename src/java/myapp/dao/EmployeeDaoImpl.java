/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myapp.dao;
 
import java.util.List;
 
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
 
import myapp.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
 
@Repository("employeeDao")
public class EmployeeDaoImpl /*extends AbstractDao<Integer, Employee> */implements EmployeeDao {
 
    @Autowired
    private SessionFactory sessionFactory;
 
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
 
    public Employee findById(int id) {
            return (Employee) getSession().get(Employee.class, id);
    
       
    }
 
    public void saveEmployee(Employee employee) {
        getSession().persist(employee);
    }
 
    public void deleteEmployee(int id) {
        Employee e = (Employee) getSession().load(Employee.class, id);
	if(e!=null) getSession().delete(e);
    }
 
    @SuppressWarnings("unchecked")
    public List<Employee> findAllEmployees() {
       Criteria criteria = getSession().createCriteria(Employee.class);
        return (List<Employee>) criteria.list();
    }
 
}