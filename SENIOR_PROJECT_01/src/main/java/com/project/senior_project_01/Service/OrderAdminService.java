package com.project.senior_project_01.Service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import com.project.senior_project_01.Entity.OrderAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import com.project.senior_project_01.Repository.UserRepository;
import com.project.senior_project_01.Dto.CartDataTransferObject;
import com.project.senior_project_01.Dto.AddressDataTransferObject;
import com.project.senior_project_01.Repository.OrderAdminRepository;

@Service
@Getter
@Setter
public class OrderAdminService {

    @Autowired
    OrderAdminRepository orderAdminRepository;
    @Autowired
    UserSession userSession;

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;

    public String saveOrder(CartDataTransferObject cartDto, AddressDataTransferObject addressDto){

        userSession = userService.getUserSessionData();

        String orderSummary="";
        String address = addressDto.toString();
        String totalcost= "Total cost : " +  String.valueOf(cartDto.getTotalCost()) + "\n\n";

        String userInfos=   "Name : " + userSession.getName()  + "\n" +
                "Surname : " +   userSession.getSurname() + "\n" +
                "Email : " + userSession.getEmail() + "\n\n";

        for (int i=0; i<cartDto.getCartItems().size(); i++){
            orderSummary +=         "Product name  :" + cartDto.getCartItems().get(i).getProduct().getName() + "\n" +
                    "Description   :" + cartDto.getCartItems().get(i).getProduct().getDescription() + "\n" +
                    "Quantity      :" + cartDto.getCartItems().get(i).getQuantity() + "\n" +
                    "Product price :" + cartDto.getCartItems().get(i).getProduct().getPrice() + "\n\n" ;
        }

        OrderAdmin orderAdmin = OrderAdmin.builder()
                .name(userSession.getName())
                .surname(userSession.getSurname())
                .email(userSession.getEmail())
                .totalCost(cartDto.getTotalCost())
                .address(addressDto.toString())
                .orderSummary(orderSummary)
                .build();

        orderAdminRepository.save(orderAdmin);

        return userInfos +  orderSummary  + totalcost + addressDto.toString();

    }
}