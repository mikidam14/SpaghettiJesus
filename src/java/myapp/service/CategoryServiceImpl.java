/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.service;

import java.util.List;
import myapp.dao.CategoryDao;
import myapp.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author michele
 */
@Service("categoryService")
@Transactional
public class CategoryServiceImpl implements CategoryService{
    @Autowired
    private CategoryDao dao;

    @Override
    public Category findById(int id) {
        return dao.findById(id);
    }

    @Override
    public List<Category> findAllCategories() {
        return dao.findAllCategories();
    }
    
    
}
