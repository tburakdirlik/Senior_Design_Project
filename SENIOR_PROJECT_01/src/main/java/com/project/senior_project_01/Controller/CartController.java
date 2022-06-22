package com.project.senior_project_01.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.project.senior_project_01.Dto.Response;
import com.project.senior_project_01.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Dto.CartDataTransferObject;
import com.project.senior_project_01.Dto.CartProductDataTransferObject;

@RestController
@RequiredArgsConstructor
public class CartController {

    @Autowired
    CartService cartService;

    @PostMapping("/cart/addProduct")
    public ResponseEntity<Response> addProductToCart(@RequestBody CartProductDataTransferObject cartProductDataTransferObject){

        cartService.addProductToCart(cartProductDataTransferObject);
        return new ResponseEntity<>(new Response("SUCCESSFULL", "Product added "), HttpStatus.CREATED);
    }

    @GetMapping("/cart/getProducts")
    public ResponseEntity<CartDataTransferObject> getCartItems(){

        CartDataTransferObject cartDto = cartService.getCartItems();
        return new ResponseEntity<>(cartDto, HttpStatus.OK);
    }

    @DeleteMapping("/cart/deleteProductFromCart/{productId}")
    public ResponseEntity<Response> deleteProductFromCart(@PathVariable("productId") int productId){

        cartService.deleteProductFromCart(productId);
        return new ResponseEntity<>(new Response("SUCCESSFULL", "Item removed from cart"), HttpStatus.OK);
        /* It deletes according to the cart id
           Returns 500 error when non-existent id is sent.
        */
    }
}




 /*
    CartController class has these endpoints:
        /cart/addProduct
        /cart/getProducts
        /cart/deleteProductFromCart/{productId}
    Aim of cartController class is to ensure that products are added to the cart.
    /cart/addProduct : We can think this endpoint as the add to cart button for the product on the homepage.
    /cart/getProducts: We can think this endpoint as my cart button for that we added products to the cart.
    /cart/deleteProductFromCart/{productId}: When we go to the cart, we can think it as delete product from cart button.
    For addProductToCart method we use the CartProductDataTransferObject class as request body.
    This class include productId and quantity elements.
    getCartItems method use CartDataTransferObject class for response body. This class include List<CartItem> cartItems,
    (I showed the structure of this list at below) and totalCost element.

        [User1, User2, User3, User4, User5, User6, User7, User8]     --------------------> userRepository
                                    |
                                  User1
                                    |
                                Cart_TABLE                           ------------
                                    |                                           |
             _________________________________________________                  |
             | id |     product     |    user    |  quantity |                  |
             |____|_________________|____________|___________|                  |
             | CartItem1                                     | --> CART         |--------> cartRepository
             |_______________________________________________|                  |
             | CartItem2                                     | --> CART         |
             |_______________________________________________|                  |
                                                                                |
                                                                                |
                                                                   _____________|
    */
