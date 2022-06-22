package com.project.senior_project_01.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartProductDataTransferObject {

    private int productId;
    private int quantity;

}

