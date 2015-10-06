package nl.ead.dateplanner.services.business;

import junit.framework.TestCase;
import nl.ead.dateplanner.services.*;
import nl.ead.dateplanner.services.application.TestDateFinderService;;
import org.junit.Before;

import java.math.BigDecimal;

import static org.hamcrest.Matchers.instanceOf;
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
        String type = "bar";

        DateOptions dateOption = new DateOptions();
        dateOption.setDayPart(DayParts.fromValue("morning"));
        dateOption.setLocation("Arnhem");
        dateOption.setRadius(new BigDecimal(20000));
        dateOption.setTypes(PlaceTypes.fromValue(type));

        for (PlaceType placeType : dateTaskService.getDateOption(dateOption).getResult().getPlacesData().getPlaces()) {
            assertEquals(type, placeType.getType());
        }
    }

}