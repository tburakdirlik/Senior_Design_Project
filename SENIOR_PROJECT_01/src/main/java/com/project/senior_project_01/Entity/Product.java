package com.project.senior_project_01.Entity;

import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRODUCT_ENTITY_")
@Table(name = "PRODUCT_TABLE_")
public class Product {

    @Id
    @SequenceGenerator(
            name = "PRODUCT_SEQUENCE_",
            sequenceName = "PRODUCT_SEQUENCE_",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "PRODUCT_SEQUENCE_"
    )
    @Column(
            name = "PRODUCT_ID_"
    )
    private int productId;

    @Column(name = "NAME_", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION_", nullable = false)
    private String description;

    @Column(name = "IMAGEURL_", nullable = false)
    private String imageUrl;

    @Column(name = "PRICE_", nullable = false)
    private double price;
}
