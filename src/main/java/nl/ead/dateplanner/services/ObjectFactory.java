
package nl.ead.dateplanner.services;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the nl.ead.dateplanner.services package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: nl.ead.dateplanner.services
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DateplannerResponse }
     * 
     */
    public DateplannerResponse createDateplannerResponse() {
        return new DateplannerResponse();
    }

    /**
     * Create an instance of {@link DateDataType }
     * 
     */
    public DateDataType createDateDataType() {
        return new DateDataType();
    }

    /**
     * Create an instance of {@link DateplannerRequest }
     * 
     */
    public DateplannerRequest createDateplannerRequest() {
        return new DateplannerRequest();
    }

    /**
     * Create an instance of {@link DateOptions }
     * 
     */
    public DateOptions createDateOptions() {
        return new DateOptions();
    }

    /**
     * Create an instance of {@link WeatherDataType }
     * 
     */
    public WeatherDataType createWeatherDataType() {
        return new WeatherDataType();
    }

    /**
     * Create an instance of {@link ForecastType }
     * 
     */
    public ForecastType createForecastType() {
        return new ForecastType();
    }

    /**
     * Create an instance of {@link RestaurantDataType }
     * 
     */
    public RestaurantDataType createRestaurantDataType() {
        return new RestaurantDataType();
    }

}
