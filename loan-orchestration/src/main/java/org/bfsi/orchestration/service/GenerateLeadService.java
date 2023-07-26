package org.bfsi.orchestration.service;

import org.bfsi.orchestration.bean.bureau.BureauRequest;
import org.bfsi.orchestration.entity.LeadRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenerateLeadService {
    @Autowired
    BREConnectorService breConnectorService;

    @Autowired
    BureauConnectorService bureauConnectorService;

    @Autowired
    HunterConnectorService hunterConnectorService;

    public void generateLeadAction(LeadRequest leadRequest){
        BureauRequest bureauRequest  = createObject(leadRequest);



    }

    private static BureauRequest createObject(LeadRequest leadRequest) {
        return BureauRequest.builder()
                .leadId(leadRequest.getLeadId())
                .firstName(leadRequest.getPersonalDetails().getFirstName())
                .lastName(leadRequest.getPersonalDetails().getLastName())
                .pan(leadRequest.getPersonalDetails().getPan())
                .mobileNumber(leadRequest.getContactDetails().getMobileNumber())
                .email(leadRequest.getContactDetails().getEmail())
                .amount(leadRequest.getPersonalDetails().getAmount())
                .city(leadRequest.getPersonalDetails().getCity())
                .address1(leadRequest.getOfficeAddress().getAddress1())
                .address2(leadRequest.getOfficeAddress().getAddress2())
                .pincode(leadRequest.getOfficeAddress().getPincode())
                .build();
    }

}
