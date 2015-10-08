package nl.ead.dateplanner.services.business;

import junit.framework.TestCase;
import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.TestDateFinderService;;
import org.junit.Before;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.instanceOf;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;

public class DateTaskServiceTest extends TestCase {

    private DateTaskService dateTaskService;

    @Before
    public void setUp() throws Exception{
        dateTaskService = new DateTaskService(new TestDateFinderService());
    }

    public void testDateTaskServiceImplementsInterface() throws Exception {
        assertThat(dateTaskService, instanceOf(IDateTaskService.class));
    }

    public void testGetDateOption() throws Exception {
        DateOptions dateOptions = new DateOptions();
        dateOptions.setDayPart(DayParts.fromValue("evening"));
        dateOptions.setLocation("Dummy Street 234, Colorado");
        dateOptions.setRadius(new BigDecimal(20000));
        dateOptions.setTypes(PlaceTypes.fromValue("restaurant"));

        DatePlannerResponse datePlannerResponse = dateTaskService.getDateOption(dateOptions);

        assertEquals(datePlannerResponse.getPlaces().get(0).getType(), "restaurant");
        assertEquals(datePlannerResponse.getPlaces().size(), 2);
    }

}