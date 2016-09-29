package com.khomenko.controllers;

import com.khomenko.domain.Product;
import com.khomenko.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductRestController {

    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    @RequestMapping(value = "rest/products", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Product> list(){
        return  productService.listAllProducts();
    }

    @RequestMapping(value = "rest/product/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Product showProduct(@PathVariable Integer id){
        return productService.getProductById(id);
    }

    @RequestMapping(value = "rest/product/edit/{id}", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Product edit(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @RequestMapping(value = "rest/product", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveProduct(Product product){
        productService.saveProduct(product);
    }

    @RequestMapping(value = "rest/product/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer id){
        productService.deleteProduct(id);
    }

}
