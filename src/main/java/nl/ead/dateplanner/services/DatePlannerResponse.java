
package nl.ead.dateplanner.services;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="places" type="{http://www.han.nl/schemas/dateplanner}PlaceType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "places"
})
@XmlRootElement(name = "DatePlannerResponse", namespace = "http://www.han.nl/schemas/dateplanner")
public class DatePlannerResponse {

    @XmlElement(namespace = "http://www.han.nl/schemas/dateplanner")
    protected List<PlaceType> places;

    /**
     * Gets the value of the places property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the places property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPlaces().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PlaceType }
     * 
     * 
     */
    public List<PlaceType> getPlaces() {
        if (places == null) {
            places = new ArrayList<PlaceType>();
        }
        return this.places;
    }

}
