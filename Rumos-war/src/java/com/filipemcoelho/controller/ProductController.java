package com.filipemcoelho.controller;

import com.filipemcoelho.entities.Category;
import com.filipemcoelho.entities.Product;
import com.filipemcoelho.entities.Users;
import com.filipemcoelho.filters.utils.SessionUtils;
import com.filipemcoelho.model.CategoryFacade;
import com.filipemcoelho.model.PersonFacade;
import com.filipemcoelho.model.ProductFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;

@Named(value = "productController")
@SessionScoped
public class ProductController implements Serializable {

    @EJB
    private CategoryFacade categoryFacade;

    @EJB
    private PersonFacade personFacade;

    @EJB
    private ProductFacade productFacade;

    private Product product = new Product();

    private Product selectedProduct = new Product();

    private List<Product> filteredProducts;

    private String categoryId;

    public ProductController() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        System.out.println("Product" + product);
        this.product = product;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        System.out.println("Selected" + selectedProduct);
        this.selectedProduct = selectedProduct;
    }

    public List<Product> getFilteredProducts() {
        return filteredProducts;
    }

    public void setFilteredProducts(List<Product> filteredProducts) {
        this.filteredProducts = filteredProducts;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public void addProduct() {

        product.setCategoryId(categoryFacade.find(Integer.valueOf(categoryId)));
        product.setAdministratorId(personFacade.find(1));

        product.setCreatedBy("FC");
        product.setLastUpdatedBy("FMBRC");
        product.setCreatedDate(new Date());
        product.setLastUpdatedDate(new Date());
        productFacade.create(this.product);

        System.out.println(product);

        product = new Product();

    }

    public void editProduct() {
        productFacade.edit(selectedProduct);
        selectedProduct = new Product();
    }

    public void deleteProduct() {
        productFacade.remove(product);
        product = new Product();
    }

    public List<Product> findAllProducts() {
        return productFacade.findAll();
    }

    public List<Category> findAllCategories() {
        return categoryFacade.findAll();
    }

    public boolean allowEditing(int administratorId) {
        Users user = (Users) SessionUtils.getParam("loggedInUser");

        return user.getUserId().getUserId() == administratorId;
    }

}
