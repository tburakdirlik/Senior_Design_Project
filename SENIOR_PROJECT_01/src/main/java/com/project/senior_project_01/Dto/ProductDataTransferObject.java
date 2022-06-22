package com.project.senior_project_01.Dto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDataTransferObject {

    private int id;
    private String name;
    private String description;
    private String imageUrl;
    private double price;

}
 /*
    When we trigger add product endpoint, no need to add productId to path or request body. Product id is created automatically when product added at the product class.
    Also, if we send product id in the request body. Program do not give any error. Because product class does not matter this id. But in order for the program not to crash,
    we need to use the @AllArgsConstructor annotation and program will not be crashed.
    */
