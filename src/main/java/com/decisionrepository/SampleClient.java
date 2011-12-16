package com.decisionrepository;

import java.io.IOException;
import nl.rug.search.odr.ws.connection.AuthorizedWebServiceFacade;
import nl.rug.search.odr.ws.dto.DecisionStateDTO;
import nl.rug.search.odr.ws.dto.ProjectOverviewDTO;

/**
 *
 * @author Ben Ripkens <bripkens.dev@gmail.com>
 */
public class SampleClient {
    private static final String URL = "https://www.decisionrepository.com",
            AUTH_EMAIL = "test@decisionrepository.com",
            AUTH_PASSWORD = "12345",
            FENCE = "#################################################";

    private final AuthorizedWebServiceFacade wsf;
    
    public SampleClient() {
        wsf = new AuthorizedWebServiceFacade(URL, AUTH_EMAIL, AUTH_PASSWORD);
    }
    
    public void printDecisionStates() throws IOException {
        System.out.println(FENCE);
        System.out.println("## Decision states");
        
        for(DecisionStateDTO state : wsf.getCommonDecisionStates()) {
            System.out.println(state.getName());
        }
        
        System.out.println(FENCE);
    }
    
    public void printAccessibleProjects() throws IOException {
        System.out.println(FENCE);
        System.out.println("## Accessible Projects");
        
        for(ProjectOverviewDTO project : wsf.getProjectOverview()) {
            System.out.println(project.getName());
        }
        
        System.out.println(FENCE);
    }
    
    public static void main(String[] args) throws IOException {
        
        SampleClient client = new SampleClient();
        client.printDecisionStates();
        client.printAccessibleProjects();
    }
}
