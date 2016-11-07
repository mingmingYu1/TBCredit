/**
 * IPersonCreditDataWSServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.yodata.creditdataweb.webservice;

public class IPersonCreditDataWSServiceLocator extends org.apache.axis.client.Service implements cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSService {

    public IPersonCreditDataWSServiceLocator() {
    }


    public IPersonCreditDataWSServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IPersonCreditDataWSServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IPersonCreditDataWSPort
    private java.lang.String IPersonCreditDataWSPort_address = "http://10.48.1.32:60530/creditdata-web/services/personcredit";

    public java.lang.String getIPersonCreditDataWSPortAddress() {
        return IPersonCreditDataWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IPersonCreditDataWSPortWSDDServiceName = "IPersonCreditDataWSPort";

    public java.lang.String getIPersonCreditDataWSPortWSDDServiceName() {
        return IPersonCreditDataWSPortWSDDServiceName;
    }

    public void setIPersonCreditDataWSPortWSDDServiceName(java.lang.String name) {
        IPersonCreditDataWSPortWSDDServiceName = name;
    }

    public cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS getIPersonCreditDataWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IPersonCreditDataWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIPersonCreditDataWSPort(endpoint);
    }

    public cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS getIPersonCreditDataWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSServiceSoapBindingStub _stub = new cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getIPersonCreditDataWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIPersonCreditDataWSPortEndpointAddress(java.lang.String address) {
        IPersonCreditDataWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSServiceSoapBindingStub _stub = new cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSServiceSoapBindingStub(new java.net.URL(IPersonCreditDataWSPort_address), this);
                _stub.setPortName(getIPersonCreditDataWSPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IPersonCreditDataWSPort".equals(inputPortName)) {
            return getIPersonCreditDataWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.creditdataweb.yodata.com.cn/", "IPersonCreditDataWSService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.creditdataweb.yodata.com.cn/", "IPersonCreditDataWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IPersonCreditDataWSPort".equals(portName)) {
            setIPersonCreditDataWSPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
