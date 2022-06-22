package com.project.senior_project_01.Entity;

import lombok.*;
import javax.persistence.*;
import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "ORDER_ADMIN_ENTITY_")
@Table(name = "ORDER_ADMIN_TABLE_")
public class OrderAdmin {

    @Id
    @SequenceGenerator(
            name = "ORDER_SEQUENCE_",
            sequenceName = "ORDER_SEQUENCE_",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "ORDER_SEQUENCE_"
    )
    @Column(
            name = "ORDER_ID_"
    )
    private int orderId;

    @Column(name = "NAME_", nullable = false)
    private String name;

    @Column(name = "SURNAME_",nullable = false)
    private String surname;

    @Column(name = "EMAIL_",nullable = false)
    private String email;

    @Column(name = "TOTAL_COST_",nullable = false)
    private double totalCost;

    @Column(name = "ADDRESS_",nullable = false)
    private String address;

    @Column(name = "ORDER_SUMMARY_",nullable = false)
    private String orderSummary;

}
