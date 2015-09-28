
package nl.ead.dateplanner.services;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for RestaurantDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RestaurantDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vicinity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="openingHours" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RestaurantDataType", namespace = "http://www.han.nl/schemas/dateplanner", propOrder = {
    "name",
    "location",
    "id",
    "type",
    "vicinity",
    "openingHours"
})
public class RestaurantDataType {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String location;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String id;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String type;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String vicinity;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String openingHours;

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the vicinity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVicinity() {
        return vicinity;
    }

    /**
     * Sets the value of the vicinity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVicinity(String value) {
        this.vicinity = value;
    }

    /**
     * Gets the value of the openingHours property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpeningHours() {
        return openingHours;
    }

    /**
     * Sets the value of the openingHours property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpeningHours(String value) {
        this.openingHours = value;
    }

}
