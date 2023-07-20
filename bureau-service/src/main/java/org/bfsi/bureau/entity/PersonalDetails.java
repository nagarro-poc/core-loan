package org.bfsi.bureau.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "personal_details")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    private String fatherName;
    @NotNull
    private String pan;
    private String city;
    private String pincode;
}
