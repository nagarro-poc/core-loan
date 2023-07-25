package org.bfsi.orchestration.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "personal_details")
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId;
    private String leadId;
    private String firstName;
    private String lastName;
    private String fatherName;
    private String pan;
    private String city;
    private String pincode;
}
