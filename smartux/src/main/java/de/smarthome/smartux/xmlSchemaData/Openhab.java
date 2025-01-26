//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.5 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.smarthome.smartux.xmlSchemaData;

import java.util.ArrayList;
import java.util.List;
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
 *         <element ref="{}ical.configuration"/>
 *         <element ref="{}ntp.configuration"/>
 *         <element ref="{}ekey.configuration"/>
 *         <element ref="{}door.configuration"/>
 *         <element name="definition">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence>
 *                   <element ref="{}area.map"/>
 *                   <element ref="{}idm.map" maxOccurs="unbounded"/>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element ref="{}alexa.configuration"/>
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
    @XmlElement(name = "ical.configuration", required = true)
    protected IcalConfiguration icalConfiguration;
    @XmlElement(name = "ntp.configuration", required = true)
    protected NtpConfiguration ntpConfiguration;
    @XmlElement(name = "ekey.configuration", required = true)
    protected EkeyConfiguration ekeyConfiguration;
    @XmlElement(name = "door.configuration", required = true)
    protected DoorConfiguration doorConfiguration;
    @XmlElement(required = true)
    protected Openhab.Definition definition;
    @XmlElement(name = "alexa.configuration", required = true)
    protected AlexaConfiguration alexaConfiguration;

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

    /**
     * Ruft den Wert der icalConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link IcalConfiguration }
     *     
     */
    public IcalConfiguration getIcalConfiguration() {
        return icalConfiguration;
    }

    /**
     * Legt den Wert der icalConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link IcalConfiguration }
     *     
     */
    public void setIcalConfiguration(IcalConfiguration value) {
        this.icalConfiguration = value;
    }

    /**
     * Ruft den Wert der ntpConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link NtpConfiguration }
     *     
     */
    public NtpConfiguration getNtpConfiguration() {
        return ntpConfiguration;
    }

    /**
     * Legt den Wert der ntpConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link NtpConfiguration }
     *     
     */
    public void setNtpConfiguration(NtpConfiguration value) {
        this.ntpConfiguration = value;
    }

    /**
     * Ruft den Wert der ekeyConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link EkeyConfiguration }
     *     
     */
    public EkeyConfiguration getEkeyConfiguration() {
        return ekeyConfiguration;
    }

    /**
     * Legt den Wert der ekeyConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link EkeyConfiguration }
     *     
     */
    public void setEkeyConfiguration(EkeyConfiguration value) {
        this.ekeyConfiguration = value;
    }

    /**
     * Ruft den Wert der doorConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DoorConfiguration }
     *     
     */
    public DoorConfiguration getDoorConfiguration() {
        return doorConfiguration;
    }

    /**
     * Legt den Wert der doorConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DoorConfiguration }
     *     
     */
    public void setDoorConfiguration(DoorConfiguration value) {
        this.doorConfiguration = value;
    }

    /**
     * Ruft den Wert der definition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Openhab.Definition }
     *     
     */
    public Openhab.Definition getDefinition() {
        return definition;
    }

    /**
     * Legt den Wert der definition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Openhab.Definition }
     *     
     */
    public void setDefinition(Openhab.Definition value) {
        this.definition = value;
    }

    /**
     * Ruft den Wert der alexaConfiguration-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AlexaConfiguration }
     *     
     */
    public AlexaConfiguration getAlexaConfiguration() {
        return alexaConfiguration;
    }

    /**
     * Legt den Wert der alexaConfiguration-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AlexaConfiguration }
     *     
     */
    public void setAlexaConfiguration(AlexaConfiguration value) {
        this.alexaConfiguration = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.</p>
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       <sequence>
     *         <element ref="{}area.map"/>
     *         <element ref="{}idm.map" maxOccurs="unbounded"/>
     *       </sequence>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "areaMap",
        "idmMap"
    })
    public static class Definition {

        @XmlElement(name = "area.map", required = true)
        protected AreaMap areaMap;
        @XmlElement(name = "idm.map", required = true)
        protected List<IdmMap> idmMap;

        /**
         * Ruft den Wert der areaMap-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link AreaMap }
         *     
         */
        public AreaMap getAreaMap() {
            return areaMap;
        }

        /**
         * Legt den Wert der areaMap-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link AreaMap }
         *     
         */
        public void setAreaMap(AreaMap value) {
            this.areaMap = value;
        }

        /**
         * Gets the value of the idmMap property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the idmMap property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getIdmMap().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link IdmMap }
         * </p>
         * 
         * 
         * @return
         *     The value of the idmMap property.
         */
        public List<IdmMap> getIdmMap() {
            if (idmMap == null) {
                idmMap = new ArrayList<>();
            }
            return this.idmMap;
        }

    }

}
