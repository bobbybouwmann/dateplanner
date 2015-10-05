
package nl.ead.dateplanner.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PlaceType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="placeId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="vicinity" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="openingHours" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PlaceType", namespace = "http://www.han.nl/schemas/dateplanner", propOrder = {
    "name",
    "id",
    "placeId",
    "type",
    "vicinity",
    "openingHours"
})
public class PlaceType {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String name;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String id;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String placeId;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String type;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner", required = true)
    protected String vicinity;
    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected List<String> openingHours;

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
     * Gets the value of the placeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaceId() {
        return placeId;
    }

    /**
     * Sets the value of the placeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaceId(String value) {
        this.placeId = value;
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
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the openingHours property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOpeningHours().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getOpeningHours() {
        if (openingHours == null) {
            openingHours = new ArrayList<String>();
        }
        return this.openingHours;
    }

}
