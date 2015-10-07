
package nl.ead.dateplanner.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ForecastType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ForecastType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="temperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="minTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="maxTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="rain" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="snow" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="clouds" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ForecastType", namespace = "http://www.han.nl/schemas/dateplanner", propOrder = {
    "temperature",
    "minTemperature",
    "maxTemperature",
    "rain",
    "snow",
    "clouds"
})
public class ForecastType {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float temperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float minTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float maxTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected boolean rain;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected boolean snow;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float clouds;

    /**
     * Gets the value of the temperature property.
     * 
     */
    public float getTemperature() {
        return temperature;
    }

    /**
     * Sets the value of the temperature property.
     * 
     */
    public void setTemperature(float value) {
        this.temperature = value;
    }

    /**
     * Gets the value of the minTemperature property.
     * 
     */
    public float getMinTemperature() {
        return minTemperature;
    }

    /**
     * Sets the value of the minTemperature property.
     * 
     */
    public void setMinTemperature(float value) {
        this.minTemperature = value;
    }

    /**
     * Gets the value of the maxTemperature property.
     * 
     */
    public float getMaxTemperature() {
        return maxTemperature;
    }

    /**
     * Sets the value of the maxTemperature property.
     * 
     */
    public void setMaxTemperature(float value) {
        this.maxTemperature = value;
    }

    /**
     * Gets the value of the rain property.
     * 
     */
    public boolean isRain() {
        return rain;
    }

    /**
     * Sets the value of the rain property.
     * 
     */
    public void setRain(boolean value) {
        this.rain = value;
    }

    /**
     * Gets the value of the snow property.
     * 
     */
    public boolean isSnow() {
        return snow;
    }

    /**
     * Sets the value of the snow property.
     * 
     */
    public void setSnow(boolean value) {
        this.snow = value;
    }

    /**
     * Gets the value of the clouds property.
     * 
     */
    public float getClouds() {
        return clouds;
    }

    /**
     * Sets the value of the clouds property.
     * 
     */
    public void setClouds(float value) {
        this.clouds = value;
    }

}
