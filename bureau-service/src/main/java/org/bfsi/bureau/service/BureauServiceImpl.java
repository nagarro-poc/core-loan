package org.bfsi.bureau.service;

import org.bfsi.bureau.bean.BureauResponse;
import org.bfsi.bureau.entity.BureauRequest;
import org.bfsi.bureau.exception.ExceededAmountException;
import org.bfsi.bureau.repository.BureauRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BureauServiceImpl implements BureauService{
    @Autowired
    BureauRepository bureauRepository;
    @Override
    public BureauRequest saveEntity(BureauRequest bureauRequest) {
        return bureauRepository.save(bureauRequest);
    }

    @Override
    public BureauResponse checkEligibility(int score, BureauRequest bureauRequest) {
        if(Integer.valueOf(bureauRequest.getAmount())>500000){
            throw new ExceededAmountException("your amount is out of allowed range");
        }

        String eligibility = "";
        if(score>600){
            eligibility = "green";
        } else if (score<600 && score>450) {
            eligibility = "amber";
        }else {
            eligibility = "red";
        }
        BureauResponse bureauResponse = new BureauResponse();
        bureauResponse.setScore(String.valueOf(score));
        bureauResponse.setLeadId(bureauRequest.getLeadId());
        bureauResponse.setStatus(eligibility);
        bureauResponse.setMsg("Success");

        return bureauResponse;
    }
}
