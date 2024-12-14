//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für device.specification.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * <pre>{@code
 * <simpleType name="device.specification">
 *   <restriction base="{http://www.w3.org/2001/XMLSchema}anyURI">
 *     <enumeration value="SteinelTruePräsenz"/>
 *     <enumeration value="RolladenMDTKNX"/>
 *     <enumeration value="ICALBinding"/>
 *     <enumeration value="NTPBinding"/>
 *   </restriction>
 * </simpleType>
 * }</pre>
 * 
 */
@XmlType(name = "device.specification")
@XmlEnum
public enum DeviceSpecification {

    @XmlEnumValue("SteinelTruePr\u00e4senz")
    STEINEL_TRUE_PRÄSENZ("SteinelTruePr\u00e4senz"),
    @XmlEnumValue("RolladenMDTKNX")
    ROLLADEN_MDTKNX("RolladenMDTKNX"),
    @XmlEnumValue("ICALBinding")
    ICAL_BINDING("ICALBinding"),
    @XmlEnumValue("NTPBinding")
    NTP_BINDING("NTPBinding");
    private final String value;

    DeviceSpecification(String v) {
        value = v;
    }

    /**
     * Gets the value associated to the enum constant.
     * 
     * @return
     *     The value linked to the enum.
     */
    public String value() {
        return value;
    }

    /**
     * Gets the enum associated to the value passed as parameter.
     * 
     * @param v
     *     The value to get the enum from.
     * @return
     *     The enum which corresponds to the value, if it exists.
     * @throws IllegalArgumentException
     *     If no value matches in the enum declaration.
     */
    public static DeviceSpecification fromValue(String v) {
        for (DeviceSpecification c: DeviceSpecification.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
