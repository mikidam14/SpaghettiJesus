/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author michele
 */
@Repository("categoryDao")
public class CategoryDaoImpl implements CategoryDao{
    @Autowired
    private SessionFactory sessionFactory;
    
    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public Category findById(int id) {
        return (Category) getSession().get(Category.class, id);
    }

    @Override
    public void saveCategory(Category category) {
        getSession().persist(category);
    }

    @Override
    public void deleteCategory(int id) {
        Category c = (Category) getSession().load(Category.class, id);
	if(c!=null) getSession().delete(c);
    }

    @Override
    public List<Category> findAllCategories() {
        Criteria criteria = getSession().createCriteria(Category.class);
        return (List<Category>) criteria.list();
    }
    
}
