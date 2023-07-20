package org.bfsi.orchestration.service;

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


    }

}
