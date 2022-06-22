package com.project.senior_project_01.Service;
import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.project.senior_project_01.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Repository.ProductRepository;
import com.project.senior_project_01.Dto.ProductDataTransferObject;
@Service @Getter @Setter
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    // for pages
    public List<Product> getAllProductFromPage(){
        return productRepository.findAll();
    }
    public void addProductFromPage(Product product){
        productRepository.save(product);
    }
    public void removeProductByIdFromPage(int id){
        productRepository.deleteById(id);
    }
    public Optional<Product> getProductByIdFromPage(int id){
        return productRepository.findById(id);
    }
    public Optional<Product> getProductById(int id){
        return  productRepository.findById(id);
    }

    public void addProduct(ProductDataTransferObject productDataTransferObject){

        Product product = Product.builder()
                                            .name(productDataTransferObject.getName())
                                            .imageUrl(productDataTransferObject.getImageUrl())
                                            .price(productDataTransferObject.getPrice())
                                            .description(productDataTransferObject.getDescription())
                                            .build();
        productRepository.save(product);
    }
    public ProductDataTransferObject getProduct(int productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (!optionalProduct.isPresent()) { throw new IllegalStateException(); }
        Product product = optionalProduct.get();
        return   ProductDataTransferObject.builder()
                .id(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .build();
    }
    public void updateProduct(ProductDataTransferObject productDto, int productId) {

        Optional<Product> optProduct = productRepository.findById(productId);
        if( optProduct.isPresent()){
            Product product = optProduct.get();
            product.setName(productDto.getName());
            product.setDescription(productDto.getDescription());
            product.setImageUrl(productDto.getImageUrl());
            product.setDescription(productDto.getDescription());
            product.setPrice(productDto.getPrice());
            productRepository.save(product);
        }
    }
    public void deleteProduct(int productId) {

        Optional<Product> optionalProduct = productRepository.findById(productId);
        if (optionalProduct.isPresent()){ productRepository.deleteById(productId); }
        else { throw  new RuntimeException(); }
    }

    public List<ProductDataTransferObject> getAllProducts() {

        List<Product> allProducts = productRepository.findAll(); // we brought the whole product list
        List<ProductDataTransferObject> allProductDtos = new ArrayList<>();  //we created producDto list which will store all products

        for (int i =0; i< allProducts.size(); i++){
            allProductDtos.add(convertProductToProductDto(allProducts.get(i)));
            // product -> productDto converting
        }
        return  allProductDtos;
    }
    public ProductDataTransferObject convertProductToProductDto(Product product) {
        ProductDataTransferObject productDto = ProductDataTransferObject.builder()
                .name(product.getName())
                .description(product.getDescription())
                .imageUrl(product.getImageUrl())
                .price(product.getPrice())
                .id(product.getProductId())
                .build();

        return productDto;
    }
}
