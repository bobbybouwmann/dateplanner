package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.DateOptions;
import nl.ead.dateplanner.services.DatePlannerResponse;

import javax.xml.datatype.DatatypeConfigurationException;
import java.io.IOException;

public interface IDateTaskService {

    /**
     * Get the date options. A date option holds a place with a forecast.
     *
     * @param options The options from the request.
     *
     * @return Return a list of date options.
     *
     * @throws IOException
     * @throws DatatypeConfigurationException
     */
    DatePlannerResponse getDateOption(DateOptions options) throws IOException, DatatypeConfigurationException;

}
