/**
 * PersonDTO.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.yodata.creditdataweb.webservice;

public class PersonDTO  implements java.io.Serializable {
    private java.lang.String[] account;

    private java.lang.String idCart;

    private java.lang.String name;

    private java.lang.String[] phone;

    public PersonDTO() {
    }

    public PersonDTO(
           java.lang.String[] account,
           java.lang.String idCart,
           java.lang.String name,
           java.lang.String[] phone) {
           this.account = account;
           this.idCart = idCart;
           this.name = name;
           this.phone = phone;
    }


    /**
     * Gets the account value for this PersonDTO.
     * 
     * @return account
     */
    public java.lang.String[] getAccount() {
        return account;
    }


    /**
     * Sets the account value for this PersonDTO.
     * 
     * @param account
     */
    public void setAccount(java.lang.String[] account) {
        this.account = account;
    }

    public java.lang.String getAccount(int i) {
        return this.account[i];
    }

    public void setAccount(int i, java.lang.String _value) {
        this.account[i] = _value;
    }


    /**
     * Gets the idCart value for this PersonDTO.
     * 
     * @return idCart
     */
    public java.lang.String getIdCart() {
        return idCart;
    }


    /**
     * Sets the idCart value for this PersonDTO.
     * 
     * @param idCart
     */
    public void setIdCart(java.lang.String idCart) {
        this.idCart = idCart;
    }


    /**
     * Gets the name value for this PersonDTO.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return name;
    }


    /**
     * Sets the name value for this PersonDTO.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the phone value for this PersonDTO.
     * 
     * @return phone
     */
    public java.lang.String[] getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this PersonDTO.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String[] phone) {
        this.phone = phone;
    }

    public java.lang.String getPhone(int i) {
        return this.phone[i];
    }

    public void setPhone(int i, java.lang.String _value) {
        this.phone[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof PersonDTO)) return false;
        PersonDTO other = (PersonDTO) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.account==null && other.getAccount()==null) || 
             (this.account!=null &&
              java.util.Arrays.equals(this.account, other.getAccount()))) &&
            ((this.idCart==null && other.getIdCart()==null) || 
             (this.idCart!=null &&
              this.idCart.equals(other.getIdCart()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              java.util.Arrays.equals(this.phone, other.getPhone())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAccount() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAccount());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getAccount(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getIdCart() != null) {
            _hashCode += getIdCart().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPhone() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getPhone());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getPhone(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(PersonDTO.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.creditdataweb.yodata.com.cn/", "personDTO"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("account");
        elemField.setXmlName(new javax.xml.namespace.QName("", "account"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idCart");
        elemField.setXmlName(new javax.xml.namespace.QName("", "idCart"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
