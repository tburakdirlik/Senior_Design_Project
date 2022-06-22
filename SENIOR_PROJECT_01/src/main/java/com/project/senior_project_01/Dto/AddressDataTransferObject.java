package com.project.senior_project_01.Dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddressDataTransferObject {

    private String city;
    private String district;
    private String street;
    private int    buildingNo;

    @Override
    public String toString() {
        return "Address{" + " city='" + city + '\'' +
                ", district='" + district + '\'' + ", street='" + street + '\'' +
                ", buildingNo=" + buildingNo +
                '}';
    }
}
