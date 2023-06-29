package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;
import org.bfsi.orchestration.repository.PersonalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LeadServiceImpl implements LeadService{

    @Autowired
  //  @Qualifier("personalDetailsRepository")
    public PersonalDetailsRepository personalDetailsRepository;
    @Override
    public LeadResponse generateLead(LeadRequest leadRequest) {
        try {
            personalDetailsRepository.save(leadRequest.getPersonalDetails());
        }catch (RuntimeException e){
            e.printStackTrace();
        }
        return null;
    }
}
