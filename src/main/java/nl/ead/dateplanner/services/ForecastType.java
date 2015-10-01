
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
 *         &lt;element name="dayTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="eveningTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="maximumTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="minimumTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="morningTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="nightTemperature" type="{http://www.w3.org/2001/XMLSchema}float"/>
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
    "dayTemperature",
    "eveningTemperature",
    "maximumTemperature",
    "minimumTemperature",
    "morningTemperature",
    "nightTemperature"
})
public class ForecastType {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float dayTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float eveningTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float maximumTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float minimumTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float morningTemperature;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected float nightTemperature;

    /**
     * Gets the value of the dayTemperature property.
     * 
     */
    public float getDayTemperature() {
        return dayTemperature;
    }

    /**
     * Sets the value of the dayTemperature property.
     * 
     */
    public void setDayTemperature(float value) {
        this.dayTemperature = value;
    }

    /**
     * Gets the value of the eveningTemperature property.
     * 
     */
    public float getEveningTemperature() {
        return eveningTemperature;
    }

    /**
     * Sets the value of the eveningTemperature property.
     * 
     */
    public void setEveningTemperature(float value) {
        this.eveningTemperature = value;
    }

    /**
     * Gets the value of the maximumTemperature property.
     * 
     */
    public float getMaximumTemperature() {
        return maximumTemperature;
    }

    /**
     * Sets the value of the maximumTemperature property.
     * 
     */
    public void setMaximumTemperature(float value) {
        this.maximumTemperature = value;
    }

    /**
     * Gets the value of the minimumTemperature property.
     * 
     */
    public float getMinimumTemperature() {
        return minimumTemperature;
    }

    /**
     * Sets the value of the minimumTemperature property.
     * 
     */
    public void setMinimumTemperature(float value) {
        this.minimumTemperature = value;
    }

    /**
     * Gets the value of the morningTemperature property.
     * 
     */
    public float getMorningTemperature() {
        return morningTemperature;
    }

    /**
     * Sets the value of the morningTemperature property.
     * 
     */
    public void setMorningTemperature(float value) {
        this.morningTemperature = value;
    }

    /**
     * Gets the value of the nightTemperature property.
     * 
     */
    public float getNightTemperature() {
        return nightTemperature;
    }

    /**
     * Sets the value of the nightTemperature property.
     * 
     */
    public void setNightTemperature(float value) {
        this.nightTemperature = value;
    }

}
