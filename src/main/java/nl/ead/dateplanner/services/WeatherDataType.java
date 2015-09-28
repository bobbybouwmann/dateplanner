
package nl.ead.dateplanner.services;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WeatherDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WeatherDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="astronomy" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="forecast" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WeatherDataType", namespace = "http://www.han.nl/schemas/dateplanner", propOrder = {
    "location",
    "astronomy",
    "forecast"
})
public class WeatherDataType {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String location;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String astronomy;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected BigDecimal forecast;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLocation(String value) {
        this.location = value;
    }

    /**
     * Gets the value of the astronomy property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAstronomy() {
        return astronomy;
    }

    /**
     * Sets the value of the astronomy property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAstronomy(String value) {
        this.astronomy = value;
    }

    /**
     * Gets the value of the forecast property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getForecast() {
        return forecast;
    }

    /**
     * Sets the value of the forecast property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setForecast(BigDecimal value) {
        this.forecast = value;
    }

}
