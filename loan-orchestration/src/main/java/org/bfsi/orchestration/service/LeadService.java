package org.bfsi.orchestration.service;

import org.bfsi.orchestration.entity.LeadRequest;
import org.bfsi.orchestration.entity.LeadResponse;
import org.springframework.stereotype.Service;

public interface LeadService {

    public LeadResponse generateLead(LeadRequest leadRequest);

}
