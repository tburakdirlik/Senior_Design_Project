package com.project.senior_project_01.Entity;

import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "CART_ENTITY_")
@Table(name = "CART_TABLE_")
public class Cart {

    @Id
    @SequenceGenerator(
            name = "CART_SEQUENCE_",
            sequenceName = "CART_SEQUENCE_",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "CART_SEQUENCE_"
    )
    @Column(
            name = "CART_ID_"
    )
    private int id;

    @ManyToOne
    @JoinColumn(name = "PRODUCT_ID_")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "USER_ID_")
    private User user;

    @Column(name = "QUANTITY_")
    private Integer quantity;

}
