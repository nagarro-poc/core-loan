package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;
import org.bfsi.orchestration.repository.AddressRepository;
import org.bfsi.orchestration.repository.BankDetailsRepository;
import org.bfsi.orchestration.repository.ContactDetailsRepository;
import org.bfsi.orchestration.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService{

    @Autowired
    public PersonalDetailsRepository personalDetailsRepository;

    @Autowired
    BankDetailsRepository bankDetailsRepository;

    @Autowired
    ContactDetailsRepository contactDetailsRepository;

    @Autowired
    AddressRepository addressRepository;

    @Override
    public LeadResponse persistLeadData(LeadRequest leadRequest) {
        try {

            personalDetailsRepository.save(leadRequest.getPersonalDetails());
            addressRepository.save(leadRequest.getHomeAddress());
            addressRepository.save(leadRequest.getOfficeAddress());
            contactDetailsRepository.save(leadRequest.getContactDetails());
            bankDetailsRepository.save(leadRequest.getBankDetails());
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }
}
