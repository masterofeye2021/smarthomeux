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
import jakarta.xml.bind.annotation.XmlAttribute;
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
 *       <sequence>
 *         <element name="bridge">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="discoverSmartHome" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="pollingIntervalSmartHomeAlexa" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="pollingIntervalSmartSkills" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="thing" maxOccurs="unbounded">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <attribute name="serial" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *                 <attribute name="deviceid" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
 *                 <attribute name="type" use="required" type="{}alexa.device.type" />
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
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
    "bridge",
    "thing"
})
@XmlRootElement(name = "alexa.configuration")
public class AlexaConfiguration {

    @XmlElement(required = true)
    protected AlexaConfiguration.Bridge bridge;
    @XmlElement(required = true)
    protected List<AlexaConfiguration.Thing> thing;

    /**
     * Ruft den Wert der bridge-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link AlexaConfiguration.Bridge }
     *     
     */
    public AlexaConfiguration.Bridge getBridge() {
        return bridge;
    }

    /**
     * Legt den Wert der bridge-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link AlexaConfiguration.Bridge }
     *     
     */
    public void setBridge(AlexaConfiguration.Bridge value) {
        this.bridge = value;
    }

    /**
     * Gets the value of the thing property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the thing property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getThing().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link AlexaConfiguration.Thing }
     * </p>
     * 
     * 
     * @return
     *     The value of the thing property.
     */
    public List<AlexaConfiguration.Thing> getThing() {
        if (thing == null) {
            thing = new ArrayList<>();
        }
        return this.thing;
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
     *       <attribute name="discoverSmartHome" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="pollingIntervalSmartHomeAlexa" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="pollingIntervalSmartSkills" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Bridge {

        @XmlAttribute(name = "discoverSmartHome", required = true)
        protected short discoverSmartHome;
        @XmlAttribute(name = "pollingIntervalSmartHomeAlexa", required = true)
        protected short pollingIntervalSmartHomeAlexa;
        @XmlAttribute(name = "pollingIntervalSmartSkills", required = true)
        protected short pollingIntervalSmartSkills;

        /**
         * Ruft den Wert der discoverSmartHome-Eigenschaft ab.
         * 
         */
        public short getDiscoverSmartHome() {
            return discoverSmartHome;
        }

        /**
         * Legt den Wert der discoverSmartHome-Eigenschaft fest.
         * 
         */
        public void setDiscoverSmartHome(short value) {
            this.discoverSmartHome = value;
        }

        /**
         * Ruft den Wert der pollingIntervalSmartHomeAlexa-Eigenschaft ab.
         * 
         */
        public short getPollingIntervalSmartHomeAlexa() {
            return pollingIntervalSmartHomeAlexa;
        }

        /**
         * Legt den Wert der pollingIntervalSmartHomeAlexa-Eigenschaft fest.
         * 
         */
        public void setPollingIntervalSmartHomeAlexa(short value) {
            this.pollingIntervalSmartHomeAlexa = value;
        }

        /**
         * Ruft den Wert der pollingIntervalSmartSkills-Eigenschaft ab.
         * 
         */
        public short getPollingIntervalSmartSkills() {
            return pollingIntervalSmartSkills;
        }

        /**
         * Legt den Wert der pollingIntervalSmartSkills-Eigenschaft fest.
         * 
         */
        public void setPollingIntervalSmartSkills(short value) {
            this.pollingIntervalSmartSkills = value;
        }

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
     *       <attribute name="serial" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
     *       <attribute name="deviceid" use="required" type="{http://www.w3.org/2001/XMLSchema}short" />
     *       <attribute name="type" use="required" type="{}alexa.device.type" />
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Thing {

        @XmlAttribute(name = "serial", required = true)
        protected String serial;
        @XmlAttribute(name = "deviceid", required = true)
        protected short deviceid;
        @XmlAttribute(name = "type", required = true)
        protected String type;

        /**
         * Ruft den Wert der serial-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getSerial() {
            return serial;
        }

        /**
         * Legt den Wert der serial-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setSerial(String value) {
            this.serial = value;
        }

        /**
         * Ruft den Wert der deviceid-Eigenschaft ab.
         * 
         */
        public short getDeviceid() {
            return deviceid;
        }

        /**
         * Legt den Wert der deviceid-Eigenschaft fest.
         * 
         */
        public void setDeviceid(short value) {
            this.deviceid = value;
        }

        /**
         * Ruft den Wert der type-Eigenschaft ab.
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
         * Legt den Wert der type-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }

}
