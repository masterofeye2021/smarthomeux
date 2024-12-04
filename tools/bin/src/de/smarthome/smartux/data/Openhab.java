//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.data;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="devices" type="{}devices"/>
 *         <element name="groups" type="{}groups"/>
 *         <element ref="{}knx.configuration"/>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "openhab")
public class Openhab {

    @XmlElement(required = true)
    protected Devices devices;
    @XmlElement(required = true)
    protected Groups groups;
    @XmlElement(name = "knx.configuration", required = true)
    protected KnxConfiguration knxConfiguration;

    /**
     * Ruft den Wert der devices-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Devices }
     *     
     */
    public Devices getDevices() {
        return devices;
    }

    /**
     * Legt den Wert der devices-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Devices }
     *     
     */
    public void setDevices(Devices value) {
        this.devices = value;
    }

    /**
     * Ruft den Wert der groups-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Groups }
     *     
     */
    public Groups getGroups() {
        return groups;
    }

    /**
     * Legt den Wert der groups-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Groups }
     *     
     */
    public void setGroups(Groups value) {
        this.groups = value;
    }

    /**
     * Ruft den Wert der knxConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link KnxConfiguration }
     *     
     */
    public KnxConfiguration getKnxConfiguration() {
        return knxConfiguration;
    }

    /**
     * Legt den Wert der knxConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link KnxConfiguration }
     *     
     */
    public void setKnxConfiguration(KnxConfiguration value) {
        this.knxConfiguration = value;
    }

}
