
package nl.ead.dateplanner.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DateOptions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DateOptions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="location" type="{http://www.han.nl/schemas/dateplanner}LocationType"/>
 *         &lt;element name="radius" type="{http://www.han.nl/schemas/dateplanner}RadiusType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DateOptions", namespace = "http://www.han.nl/schemas/dateplanner", propOrder = {
    "location",
    "radius"
})
public class DateOptions {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected LocationType location;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected RadiusType radius;

    /**
     * Gets the value of the location property.
     * 
     * @return
     *     possible object is
     *     {@link LocationType }
     *     
     */
    public LocationType getLocation() {
        return location;
    }

    /**
     * Sets the value of the location property.
     * 
     * @param value
     *     allowed object is
     *     {@link LocationType }
     *     
     */
    public void setLocation(LocationType value) {
        this.location = value;
    }

    /**
     * Gets the value of the radius property.
     * 
     * @return
     *     possible object is
     *     {@link RadiusType }
     *     
     */
    public RadiusType getRadius() {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     * 
     * @param value
     *     allowed object is
     *     {@link RadiusType }
     *     
     */
    public void setRadius(RadiusType value) {
        this.radius = value;
    }

}
