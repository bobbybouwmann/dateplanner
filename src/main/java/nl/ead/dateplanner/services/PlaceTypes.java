
package nl.ead.dateplanner.services;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PlaceTypes.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="PlaceTypes">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}NCName">
 *     &lt;enumeration value="amusement_park"/>
 *     &lt;enumeration value="aquarium"/>
 *     &lt;enumeration value="bar"/>
 *     &lt;enumeration value="bowling_alley"/>
 *     &lt;enumeration value="cafe"/>
 *     &lt;enumeration value="casino"/>
 *     &lt;enumeration value="library"/>
 *     &lt;enumeration value="movie_theater"/>
 *     &lt;enumeration value="museum"/>
 *     &lt;enumeration value="night_club"/>
 *     &lt;enumeration value="park"/>
 *     &lt;enumeration value="restaurant"/>
 *     &lt;enumeration value="spa"/>
 *     &lt;enumeration value="zoo"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "PlaceTypes", namespace = "http://www.han.nl/schemas/dateplanner")
@XmlEnum
public enum PlaceTypes {

    @XmlEnumValue("amusement_park")
    AMUSEMENT_PARK("amusement_park"),
    @XmlEnumValue("aquarium")
    AQUARIUM("aquarium"),
    @XmlEnumValue("bar")
    BAR("bar"),
    @XmlEnumValue("bowling_alley")
    BOWLING_ALLEY("bowling_alley"),
    @XmlEnumValue("cafe")
    CAFE("cafe"),
    @XmlEnumValue("casino")
    CASINO("casino"),
    @XmlEnumValue("library")
    LIBRARY("library"),
    @XmlEnumValue("movie_theater")
    MOVIE_THEATER("movie_theater"),
    @XmlEnumValue("museum")
    MUSEUM("museum"),
    @XmlEnumValue("night_club")
    NIGHT_CLUB("night_club"),
    @XmlEnumValue("park")
    PARK("park"),
    @XmlEnumValue("restaurant")
    RESTAURANT("restaurant"),
    @XmlEnumValue("spa")
    SPA("spa"),
    @XmlEnumValue("zoo")
    ZOO("zoo");
    private final String value;

    PlaceTypes(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static PlaceTypes fromValue(String v) {
        for (PlaceTypes c: PlaceTypes.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
