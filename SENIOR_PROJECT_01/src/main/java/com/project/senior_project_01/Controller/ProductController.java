package com.project.senior_project_01.Controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.senior_project_01.Dto.Response;
import com.project.senior_project_01.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Dto.ProductDataTransferObject;
@RestController
@RequiredArgsConstructor
public class ProductController {

    @Autowired ProductService productService;

    @PostMapping("/addProduct")
    private ResponseEntity<Response> addProduct(@RequestBody ProductDataTransferObject productDataTransferObject){
        productService.addProduct(productDataTransferObject);
        return new ResponseEntity(new Response("OK", "product created"),HttpStatus.CREATED);
    }
    @GetMapping("/getProduct/{productId}")
    public ResponseEntity<ProductDataTransferObject> getProductWithId(@PathVariable("productId") int productId){
        ProductDataTransferObject productDto = productService.getProduct(productId);
        return new ResponseEntity(productDto, HttpStatus.OK);
    }
    @PostMapping("/updateProduct/{productId}")
    public ResponseEntity<Response> updateProduct(@PathVariable("productId") int productId,
                                                  @RequestBody ProductDataTransferObject productDto) {
        productService.updateProduct(productDto, productId);
        return new ResponseEntity(new Response("OK", "product updated"),HttpStatus.CREATED);
    }
    @DeleteMapping("/deleteProduct/{productId}")
    public ResponseEntity<Response> deleteProduct(@PathVariable("productId") int productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<Response>(new Response("OK", "product deleted"), HttpStatus.OK);
    }
    @GetMapping("/getAllProducts")
    public ResponseEntity<List<ProductDataTransferObject>> getAllProducts() {
        List<ProductDataTransferObject> productDtos = productService.getAllProducts();
        return new ResponseEntity<List<ProductDataTransferObject>>(productDtos, HttpStatus.OK);
    }
}

/*
    ProductController class has these endpoints:
        /addProduct
        /getProduct/{productId}
        /updateProduct/{productId}
        /deleteProduct/{productId}
        /getAllProducts
    These endpoints return ResponseEntity object that represents the whole HTTP response.
    So we can use ResponseEntity to show response. I also created Response class to specialize HTTP response.
    As a result at the return statement we can see response result and message about response in the response body.
    /addProduct endpoint use ProductDataTransferObject class as request body to process request. This requestbody class
    include below items:
        id
        name
        description
        imageUrl
        price
    /getProduct/{productId} endpoint provide shown of product with product id.
    /updateProduct/{productId} endpoint provide product features to be updated.
    /deleteProduct/{productId} endpoint provide the product to be deleted.
    /getAllProducts endpoint show all products added by admin. Function of this endpoint is to display the products on the home page.
    */
