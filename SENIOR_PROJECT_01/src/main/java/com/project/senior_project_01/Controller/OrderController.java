package com.project.senior_project_01.Controller;

import lombok.RequiredArgsConstructor;
import com.project.senior_project_01.Service.CartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.project.senior_project_01.Service.OrderAdminService;
import com.project.senior_project_01.Dto.CartDataTransferObject;
import com.project.senior_project_01.Dto.AddressDataTransferObject;

@RestController
@RequiredArgsConstructor
public class OrderController {

    /*
    OrderController class save order to database for admin when the shopping is done.
    */
    @Autowired
    CartService cartService;

    @Autowired
    OrderAdminService orderAdminService;

    @PostMapping("/cart/paymentAndSaveOrder")
    public String goPayment(@RequestBody AddressDataTransferObject addressDto){

        CartDataTransferObject cartDto = cartService.getCartItems();
        return orderAdminService.saveOrder(cartDto, addressDto );
    }
}