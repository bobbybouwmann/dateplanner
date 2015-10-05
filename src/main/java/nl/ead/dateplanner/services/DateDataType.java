
package nl.ead.dateplanner.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for DateDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="weatherData" type="{http://www.han.nl/schemas/dateplanner}WeatherDataType"/>
 *         &lt;element name="placesData" type="{http://www.han.nl/schemas/dateplanner}PlaceDataType"/>
 *         &lt;element name="date" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateDataType", namespace = "http://www.han.nl/schemas/dateplanner", propOrder = {
    "weatherData",
    "placesData",
    "date"
})
public class DateDataType {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected WeatherDataType weatherData;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected PlaceDataType placesData;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar date;

    /**
     * Gets the value of the weatherData property.
     * 
     * @return
     *     possible object is
     *     {@link WeatherDataType }
     *     
     */
    public WeatherDataType getWeatherData() {
        return weatherData;
    }

    /**
     * Sets the value of the weatherData property.
     * 
     * @param value
     *     allowed object is
     *     {@link WeatherDataType }
     *     
     */
    public void setWeatherData(WeatherDataType value) {
        this.weatherData = value;
    }

    /**
     * Gets the value of the placesData property.
     * 
     * @return
     *     possible object is
     *     {@link PlaceDataType }
     *     
     */
    public PlaceDataType getPlacesData() {
        return placesData;
    }

    /**
     * Sets the value of the placesData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PlaceDataType }
     *     
     */
    public void setPlacesData(PlaceDataType value) {
        this.placesData = value;
    }

    /**
     * Gets the value of the date property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDate() {
        return date;
    }

    /**
     * Sets the value of the date property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDate(XMLGregorianCalendar value) {
        this.date = value;
    }

}
