package com.project.senior_project_01.Dto;

import lombok.*;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartDataTransferObject {

    private List<CartItem> cartItems;
    private double totalCost;
}
