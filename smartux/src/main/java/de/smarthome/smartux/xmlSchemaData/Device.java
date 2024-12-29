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
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für device complex type.</p>
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
 * 
 * <pre>{@code
 * <complexType name="device">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence maxOccurs="unbounded">
 *         <element name="channel">
 *           <complexType>
 *             <complexContent>
 *               <extension base="{}channel">
 *               </extension>
 *             </complexContent>
 *           </complexType>
 *         </element>
 *       </sequence>
 *       <attribute name="device.area" use="required">
 *         <simpleType>
 *           <restriction base="{}area">
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="device.function">
 *         <simpleType>
 *           <restriction base="{}function">
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="device.comm.type" type="{}comm" default="KNX" />
 *       <attribute name="device.label" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="device.name" use="required" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       <attribute name="device.specification" type="{}device.specification" />
 *       <attribute name="device.id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "device", propOrder = {
    "channel"
})
@XmlSeeAlso({
    de.smarthome.smartux.xmlSchemaData.Devices.Device.class
})
public class Device {

    @XmlElement(required = true)
    protected List<Device.Channel> channel;
    @XmlAttribute(name = "device.area", required = true)
    protected String deviceArea;
    @XmlAttribute(name = "device.function")
    protected String deviceFunction;
    @XmlAttribute(name = "device.comm.type")
    protected String deviceCommType;
    @XmlAttribute(name = "device.label", required = true)
    protected String deviceLabel;
    @XmlAttribute(name = "device.name", required = true)
    protected String deviceName;
    @XmlAttribute(name = "device.specification")
    protected DeviceSpecification deviceSpecification;
    @XmlAttribute(name = "device.id", required = true)
    protected int deviceId;

    /**
     * Gets the value of the channel property.
     * 
     * <p>This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the channel property.</p>
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * </p>
     * <pre>
     * getChannel().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Device.Channel }
     * </p>
     * 
     * 
     * @return
     *     The value of the channel property.
     */
    public List<Device.Channel> getChannel() {
        if (channel == null) {
            channel = new ArrayList<>();
        }
        return this.channel;
    }

    /**
     * Ruft den Wert der deviceArea-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceArea() {
        return deviceArea;
    }

    /**
     * Legt den Wert der deviceArea-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceArea(String value) {
        this.deviceArea = value;
    }

    /**
     * Ruft den Wert der deviceFunction-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceFunction() {
        return deviceFunction;
    }

    /**
     * Legt den Wert der deviceFunction-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceFunction(String value) {
        this.deviceFunction = value;
    }

    /**
     * Ruft den Wert der deviceCommType-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceCommType() {
        if (deviceCommType == null) {
            return "KNX";
        } else {
            return deviceCommType;
        }
    }

    /**
     * Legt den Wert der deviceCommType-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceCommType(String value) {
        this.deviceCommType = value;
    }

    /**
     * Ruft den Wert der deviceLabel-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceLabel() {
        return deviceLabel;
    }

    /**
     * Legt den Wert der deviceLabel-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceLabel(String value) {
        this.deviceLabel = value;
    }

    /**
     * Ruft den Wert der deviceName-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceName() {
        return deviceName;
    }

    /**
     * Legt den Wert der deviceName-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceName(String value) {
        this.deviceName = value;
    }

    /**
     * Ruft den Wert der deviceSpecification-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link DeviceSpecification }
     *     
     */
    public DeviceSpecification getDeviceSpecification() {
        return deviceSpecification;
    }

    /**
     * Legt den Wert der deviceSpecification-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link DeviceSpecification }
     *     
     */
    public void setDeviceSpecification(DeviceSpecification value) {
        this.deviceSpecification = value;
    }

    /**
     * Ruft den Wert der deviceId-Eigenschaft ab.
     * 
     */
    public int getDeviceId() {
        return deviceId;
    }

    /**
     * Legt den Wert der deviceId-Eigenschaft fest.
     * 
     */
    public void setDeviceId(int value) {
        this.deviceId = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.</p>
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.</p>
     * 
     * <pre>{@code
     * <complexType>
     *   <complexContent>
     *     <extension base="{}channel">
     *     </extension>
     *   </complexContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "")
    public static class Channel
        extends de.smarthome.smartux.xmlSchemaData.Channel
    {


    }

}
