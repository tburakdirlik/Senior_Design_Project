package com.project.senior_project_01.Dto;

import com.project.senior_project_01.Entity.Product;
import lombok.*;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    private int quantity;
    private int id;
    private Product product;

}
