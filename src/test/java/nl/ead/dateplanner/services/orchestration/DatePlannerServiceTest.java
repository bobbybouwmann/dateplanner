package nl.ead.dateplanner.services.orchestration;

import junit.framework.TestCase;
import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.business.TestDateTaskService;
import org.junit.Before;

import java.math.BigDecimal;

public class DatePlannerServiceTest extends TestCase {

    private DatePlannerService datePlannerService;

    @Before
    public void setUp() throws Exception{
        datePlannerService = new DatePlannerService(new TestDateTaskService());
    }

    public void testGetResults() throws Exception {
        String type = "restaurant";

        DateOptions dateOptions = new DateOptions();
        dateOptions.setDayPart(DayParts.fromValue("morning"));
        dateOptions.setLocation("Arnhem");
        dateOptions.setRadius(new BigDecimal(20000));
        dateOptions.setTypes(PlaceTypes.fromValue(type));

        DatePlannerRequest datePlannerRequest;
        datePlannerRequest = new DatePlannerRequest();
        datePlannerRequest.setInput(dateOptions);

        DatePlannerResponse datePlannerResponse = datePlannerService.getResults(datePlannerRequest);

        assertEquals(datePlannerResponse.getPlaces().size(), 2);

        for(int i = 0; i < datePlannerResponse.getPlaces().size(); i++) {
            assertEquals(datePlannerResponse.getPlaces().get(i).getType(), type);
        }
    }

}