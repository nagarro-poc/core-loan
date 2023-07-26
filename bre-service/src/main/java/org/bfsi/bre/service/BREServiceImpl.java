package org.bfsi.bre.service;

import org.bfsi.bre.bean.BRERequest;
import org.bfsi.bre.bean.BREResponse;
import org.bfsi.bre.repository.BRERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BREServiceImpl implements BREService{

    @Autowired
    BRERepository breRepository;
    @Override
    public BRERequest saveEntity(BRERequest breRequest) {
        return breRepository.save(breRequest);
    }

    @Override
    public BREResponse checkEligibility(BRERequest breRequest) {
        return BREResponse.builder().status("Approved")
                .leadId(breRequest.getLeadId())
                .msg("your loan is processed")
                .build();
    }
}
