package nl.ead.dateplanner.services.orchestration;

import java.io.IOException;

import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.business.IDateTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class DatePlannerService {

    private final IDateTaskService dateTaskService;

    @Autowired
    public DatePlannerService(IDateTaskService dateTaskService) {
        this.dateTaskService = dateTaskService;
    }

    @PayloadRoot(localPart = "DateplannerRequest", namespace = "http://www.han.nl/schemas/dateplanner")
    @ResponsePayload
    public DatePlannerResponse getResults(@RequestPayload DatePlannerRequest req) throws IOException {
        return dateTaskService.getDateOption(req.getInput());
    }
}