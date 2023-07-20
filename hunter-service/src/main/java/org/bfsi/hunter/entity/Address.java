package org.bfsi.hunter.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "address_details")
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;

    private String address1;
    private String address2;

    private String city;

    private String pincode;

    private String state;

    private String typeOfAddress;
}
