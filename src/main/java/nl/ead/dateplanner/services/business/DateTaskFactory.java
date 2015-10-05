package nl.ead.dateplanner.services.business;

import nl.ead.dateplanner.services.application.DateFinderFactory;

/**
 * Created by thoma on 5-10-2015.
 */
public class DateTaskFactory {

    public IDateTaskService create() {
        DateFinderFactory factory = new DateFinderFactory();
        return new DateTaskService(factory.create());
    }

}
