
package com.project.senior_project_01.Service;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.project.senior_project_01.Entity.Cart;
import com.project.senior_project_01.Entity.User;
import com.project.senior_project_01.Dto.CartItem;
import com.project.senior_project_01.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Repository.UserRepository;
import com.project.senior_project_01.Repository.CartRepository;
import com.project.senior_project_01.Dto.CartDataTransferObject;
import com.project.senior_project_01.Repository.ProductRepository;
import com.project.senior_project_01.Dto.CartProductDataTransferObject;

@Service
@Getter
@Setter
public class CartService {

    @Autowired
    UserService userService;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;



    public void addProductToCart(CartProductDataTransferObject cartProductDataTransferObject) {

        User user = userRepository.findByEmail(userService.getUserSessionData().getEmail());
        Optional<Product> optionalProduct = productRepository.findById(cartProductDataTransferObject.getProductId());
        Product product = optionalProduct.get();

        Cart cartItem = Cart.builder()
                .user(user)
                .product(product)
                .quantity(cartProductDataTransferObject.getQuantity())
                .build();
        cartRepository.save(cartItem);
    }

    /*
                   User User User User User User User User
                                    |
                                  User
                                    |                               ------------
                                Cart_TABLE                                      |
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

    public CartDataTransferObject getCartItems() {

        User user = userRepository.findByEmail(userService.getUserSessionData().getEmail());
        List<Cart> cartListOfUser = cartRepository.findAllByUser(user);
        List<CartItem> cartItems = new ArrayList<>();
        double totalCost = 0;

        for (Cart cart: cartListOfUser) {
            CartItem cartItemDto = CartItem.builder()
                                                     .id(cart.getId())
                                                     .quantity(cart.getQuantity())
                                                     .product(cart.getProduct())
                                                     .build();

            totalCost += cartItemDto.getQuantity() * cart.getProduct().getPrice();
            cartItems.add(cartItemDto);
        }

        CartDataTransferObject cartDto = CartDataTransferObject.builder()
                                                     .totalCost(totalCost)
                                                     .cartItems(cartItems).build();

        return  cartDto;
    }

    public void deleteProductFromCart(Integer cartItemId) {

            Optional<Cart> optionalCartItem = cartRepository.findById(cartItemId);
            cartRepository.delete(optionalCartItem.get());

    }
}