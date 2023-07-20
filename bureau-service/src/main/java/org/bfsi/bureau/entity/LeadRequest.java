package org.bfsi.bureau.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LeadRequest {

    PersonalDetails personalDetails;

    BankDetails bankDetails;

    Address homeAddress;

    Address officeAddress;

    ContactDetails contactDetails;

}
