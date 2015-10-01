
package nl.ead.dateplanner.services;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
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
 *         &lt;element name="location" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="radius" type="{http://www.w3.org/2001/XMLSchema}decimal"/>
 *         &lt;element name="dayPart" type="{http://www.han.nl/schemas/dateplanner}DayParts"/>
 *         &lt;element name="types" type="{http://www.han.nl/schemas/dateplanner}PlaceTypes" maxOccurs="unbounded"/>
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
    "radius",
    "dayPart",
    "types"
})
public class DateOptions {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String location;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected BigDecimal radius;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    @XmlSchemaType(name = "NCName")
    protected DayParts dayPart;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    @XmlSchemaType(name = "NCName")
    protected List<PlaceTypes> types;

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
     * Gets the value of the radius property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getRadius() {
        return radius;
    }

    /**
     * Sets the value of the radius property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setRadius(BigDecimal value) {
        this.radius = value;
    }

    /**
     * Gets the value of the dayPart property.
     * 
     * @return
     *     possible object is
     *     {@link DayParts }
     *     
     */
    public DayParts getDayPart() {
        return dayPart;
    }

    /**
     * Sets the value of the dayPart property.
     * 
     * @param value
     *     allowed object is
     *     {@link DayParts }
     *     
     */
    public void setDayPart(DayParts value) {
        this.dayPart = value;
    }

    /**
     * Gets the value of the types property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the types property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlaceTypes }
     * 
     * 
     */
    public List<PlaceTypes> getTypes() {
        if (types == null) {
            types = new ArrayList<PlaceTypes>();
        }
        return this.types;
    }

}
