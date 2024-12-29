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
import jakarta.xml.bind.annotation.XmlIDREF;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für channel complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType name="channel">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="link" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         <element name="connection">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <choice>
 *                   <element name="knx" type="{}knx"/>
 *                   <element name="ping" type="{}ping"/>
 *                   <element name="modbus" type="{}modbus"/>
 *                   <element ref="{}ical"/>
 *                   <element name="ntp">
 *                     <complexType>
 *                       <complexContent>
 *                         <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                         </restriction>
 *                       </complexContent>
 *                     </complexType>
 *                   </element>
 *                   <element name="ekey" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
 *                 </choice>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="groups">
 *           <complexType>
 *             <complexContent>
 *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 <sequence maxOccurs="unbounded">
 *                   <element name="group.ref">
 *                     <complexType>
 *                       <complexContent>
 *                         <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           <attribute name="refid" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
 *                         </restriction>
 *                       </complexContent>
 *                     </complexType>
 *                   </element>
 *                 </sequence>
 *               </restriction>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *         <element name="alexa" type="{}alexa" minOccurs="0"/>
 *       </all>
 *       <attribute name="format" use="required" type="{}format" />
 *       <attribute name="unit" use="required" type="{}unit" />
 *       <attribute name="access" use="required" type="{}access" />
 *       <attribute name="icon" use="required">
 *         <simpleType>
 *           <restriction base="{}icon">
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="enable" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       <attribute name="persistence" use="required" type="{http://www.w3.org/2001/XMLSchema}boolean" />
 *       <attribute name="label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute ref="{}type use="required""/>
 *       <attribute name="name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="extention" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="channel.id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "channel", propOrder = {

})
@XmlSeeAlso({
    de.smarthome.smartux.xmlSchemaData.Device.Channel.class
})
public class Channel {

    @XmlElement(required = true)
    protected String link;
    @XmlElement(required = true)
    protected Channel.Connection connection;
    @XmlElement(required = true)
    protected Channel.Groups groups;
    protected Alexa alexa;
    @XmlAttribute(name = "format", required = true)
    protected String format;
    @XmlAttribute(name = "unit", required = true)
    protected String unit;
    @XmlAttribute(name = "access", required = true)
    protected String access;
    @XmlAttribute(name = "icon", required = true)
    protected String icon;
    @XmlAttribute(name = "enable", required = true)
    protected boolean enable;
    @XmlAttribute(name = "persistence", required = true)
    protected boolean persistence;
    @XmlAttribute(name = "label", required = true)
    protected String label;
    @XmlAttribute(name = "type", required = true)
    protected String type;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "extention")
    protected String extention;
    @XmlAttribute(name = "channel.id", required = true)
    protected int channelId;

    /**
     * Ruft den Wert der link-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLink() {
        return link;
    }

    /**
     * Legt den Wert der link-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLink(String value) {
        this.link = value;
    }

    /**
     * Ruft den Wert der connection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Channel.Connection }
     *     
     */
    public Channel.Connection getConnection() {
        return connection;
    }

    /**
     * Legt den Wert der connection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Channel.Connection }
     *     
     */
    public void setConnection(Channel.Connection value) {
        this.connection = value;
    }

    /**
     * Ruft den Wert der groups-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Channel.Groups }
     *     
     */
    public Channel.Groups getGroups() {
        return groups;
    }

    /**
     * Legt den Wert der groups-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Channel.Groups }
     *     
     */
    public void setGroups(Channel.Groups value) {
        this.groups = value;
    }

    /**
     * Ruft den Wert der alexa-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Alexa }
     *     
     */
    public Alexa getAlexa() {
        return alexa;
    }

    /**
     * Legt den Wert der alexa-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Alexa }
     *     
     */
    public void setAlexa(Alexa value) {
        this.alexa = value;
    }

    /**
     * Ruft den Wert der format-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFormat() {
        return format;
    }

    /**
     * Legt den Wert der format-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFormat(String value) {
        this.format = value;
    }

    /**
     * Ruft den Wert der unit-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUnit() {
        return unit;
    }

    /**
     * Legt den Wert der unit-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUnit(String value) {
        this.unit = value;
    }

    /**
     * Ruft den Wert der access-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccess() {
        return access;
    }

    /**
     * Legt den Wert der access-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccess(String value) {
        this.access = value;
    }

    /**
     * Ruft den Wert der icon-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIcon() {
        return icon;
    }

    /**
     * Legt den Wert der icon-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIcon(String value) {
        this.icon = value;
    }

    /**
     * Ruft den Wert der enable-Eigenschaft ab.
     * 
     */
    public boolean isEnable() {
        return enable;
    }

    /**
     * Legt den Wert der enable-Eigenschaft fest.
     * 
     */
    public void setEnable(boolean value) {
        this.enable = value;
    }

    /**
     * Ruft den Wert der persistence-Eigenschaft ab.
     * 
     */
    public boolean isPersistence() {
        return persistence;
    }

    /**
     * Legt den Wert der persistence-Eigenschaft fest.
     * 
     */
    public void setPersistence(boolean value) {
        this.persistence = value;
    }

    /**
     * Ruft den Wert der label-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Legt den Wert der label-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
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

    /**
     * Ruft den Wert der name-Eigenschaft ab.
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
     * Legt den Wert der name-Eigenschaft fest.
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
     * Ruft den Wert der extention-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtention() {
        return extention;
    }

    /**
     * Legt den Wert der extention-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtention(String value) {
        this.extention = value;
    }

    /**
     * Ruft den Wert der channelId-Eigenschaft ab.
     * 
     */
    public int getChannelId() {
        return channelId;
    }

    /**
     * Legt den Wert der channelId-Eigenschaft fest.
     * 
     */
    public void setChannelId(int value) {
        this.channelId = value;
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
     *       <choice>
     *         <element name="knx" type="{}knx"/>
     *         <element name="ping" type="{}ping"/>
     *         <element name="modbus" type="{}modbus"/>
     *         <element ref="{}ical"/>
     *         <element name="ntp">
     *           <complexType>
     *             <complexContent>
     *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *               </restriction>
     *             </complexContent>
     *           </complexType>
     *         </element>
     *         <element name="ekey" type="{http://www.w3.org/2001/XMLSchema}anyType"/>
     *       </choice>
     *     </restriction>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "knx",
        "ping",
        "modbus",
        "ical",
        "ntp",
        "ekey"
    })
    public static class Connection {

        protected Knx knx;
        protected Ping ping;
        protected Modbus modbus;
        protected Ical ical;
        protected Channel.Connection.Ntp ntp;
        protected Object ekey;

        /**
         * Ruft den Wert der knx-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Knx }
         *     
         */
        public Knx getKnx() {
            return knx;
        }

        /**
         * Legt den Wert der knx-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Knx }
         *     
         */
        public void setKnx(Knx value) {
            this.knx = value;
        }

        /**
         * Ruft den Wert der ping-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Ping }
         *     
         */
        public Ping getPing() {
            return ping;
        }

        /**
         * Legt den Wert der ping-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Ping }
         *     
         */
        public void setPing(Ping value) {
            this.ping = value;
        }

        /**
         * Ruft den Wert der modbus-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Modbus }
         *     
         */
        public Modbus getModbus() {
            return modbus;
        }

        /**
         * Legt den Wert der modbus-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Modbus }
         *     
         */
        public void setModbus(Modbus value) {
            this.modbus = value;
        }

        /**
         * Ruft den Wert der ical-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Ical }
         *     
         */
        public Ical getIcal() {
            return ical;
        }

        /**
         * Legt den Wert der ical-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Ical }
         *     
         */
        public void setIcal(Ical value) {
            this.ical = value;
        }

        /**
         * Ruft den Wert der ntp-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Channel.Connection.Ntp }
         *     
         */
        public Channel.Connection.Ntp getNtp() {
            return ntp;
        }

        /**
         * Legt den Wert der ntp-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Channel.Connection.Ntp }
         *     
         */
        public void setNtp(Channel.Connection.Ntp value) {
            this.ntp = value;
        }

        /**
         * Ruft den Wert der ekey-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link Object }
         *     
         */
        public Object getEkey() {
            return ekey;
        }

        /**
         * Legt den Wert der ekey-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link Object }
         *     
         */
        public void setEkey(Object value) {
            this.ekey = value;
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
         *     </restriction>
         *   </complexContent>
         * </complexType>
         * }</pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class Ntp {


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
     *       <sequence maxOccurs="unbounded">
     *         <element name="group.ref">
     *           <complexType>
     *             <complexContent>
     *               <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 <attribute name="refid" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
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
        "groupRef"
    })
    public static class Groups {

        @XmlElement(name = "group.ref", required = true)
        protected List<Channel.Groups.GroupRef> groupRef;

        /**
         * Gets the value of the groupRef property.
         * 
         * <p>This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the groupRef property.</p>
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * </p>
         * <pre>
         * getGroupRef().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Channel.Groups.GroupRef }
         * </p>
         * 
         * 
         * @return
         *     The value of the groupRef property.
         */
        public List<Channel.Groups.GroupRef> getGroupRef() {
            if (groupRef == null) {
                groupRef = new ArrayList<>();
            }
            return this.groupRef;
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
         *       <attribute name="refid" type="{http://www.w3.org/2001/XMLSchema}IDREF" />
         *     </restriction>
         *   </complexContent>
         * </complexType>
         * }</pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "")
        public static class GroupRef {

            @XmlAttribute(name = "refid")
            @XmlIDREF
            @XmlSchemaType(name = "IDREF")
            protected Object refid;

            /**
             * Ruft den Wert der refid-Eigenschaft ab.
             * 
             * @return
             *     possible object is
             *     {@link Object }
             *     
             */
            public Object getRefid() {
                return refid;
            }

            /**
             * Legt den Wert der refid-Eigenschaft fest.
             * 
             * @param value
             *     allowed object is
             *     {@link Object }
             *     
             */
            public void setRefid(Object value) {
                this.refid = value;
            }

        }

    }

}
