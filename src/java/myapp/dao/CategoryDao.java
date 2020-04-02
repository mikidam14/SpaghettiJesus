/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myapp.dao;

import java.util.List;
import myapp.model.Category;

/**
 *
 * @author michele
 */
public interface CategoryDao {
    Category findById(int id);
    void saveCategory(Category category);
    void deleteCategory(int id);
    List<Category> findAllCategories();
}
