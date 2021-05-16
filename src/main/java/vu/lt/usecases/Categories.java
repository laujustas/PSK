package vu.lt.usecases;

import lombok.Getter;
import lombok.Setter;
import vu.lt.entities.Category;
import vu.lt.persistence.CategoryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Categories {

    @Inject
    private CategoryDAO categoryDAO;

    @Getter @Setter
    private Category categoryToCreate = new Category();

    @Getter
    private List<Category> allCategories;

    @PostConstruct
    public void init(){
        loadAllCategories();
    }

    @Transactional
    public String createCategory(){
        this.categoryDAO.persist(categoryToCreate);
        return "index?faces-redirect=true";
    }

    @Transactional
    public String deleteCategory(Category categoryToDelete){
        this.categoryDAO.delete(categoryToDelete);
        return "index?faces-redirect=true";
    }

    private void loadAllCategories(){
        this.allCategories = categoryDAO.loadAll();
    }
}