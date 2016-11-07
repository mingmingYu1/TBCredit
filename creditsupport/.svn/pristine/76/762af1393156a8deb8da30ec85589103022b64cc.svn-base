/**
 * ICreditDataWSLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cn.com.yodata.creditdataweb.webservice;

import java.rmi.RemoteException;

public class ICreditDataWSLocator extends org.apache.axis.client.Service implements cn.com.yodata.creditdataweb.webservice.ICreditDataWS {

    public ICreditDataWSLocator() {
    }


    public ICreditDataWSLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ICreditDataWSLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ICreditDataWSPort
    private java.lang.String ICreditDataWSPort_address = "http://10.48.1.32:60530/creditdata-web/services/credit";

    public java.lang.String getICreditDataWSPortAddress() {
        return ICreditDataWSPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ICreditDataWSPortWSDDServiceName = "ICreditDataWSPort";

    public java.lang.String getICreditDataWSPortWSDDServiceName() {
        return ICreditDataWSPortWSDDServiceName;
    }

    public void setICreditDataWSPortWSDDServiceName(java.lang.String name) {
        ICreditDataWSPortWSDDServiceName = name;
    }

    public cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType getICreditDataWSPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ICreditDataWSPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getICreditDataWSPort(endpoint);
    }

    public cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType getICreditDataWSPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            cn.com.yodata.creditdataweb.webservice.ICreditDataWSSoapBindingStub _stub = new cn.com.yodata.creditdataweb.webservice.ICreditDataWSSoapBindingStub(portAddress, this);
            _stub.setPortName(getICreditDataWSPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setICreditDataWSPortEndpointAddress(java.lang.String address) {
        ICreditDataWSPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                cn.com.yodata.creditdataweb.webservice.ICreditDataWSSoapBindingStub _stub = new cn.com.yodata.creditdataweb.webservice.ICreditDataWSSoapBindingStub(new java.net.URL(ICreditDataWSPort_address), this);
                _stub.setPortName(getICreditDataWSPortWSDDServiceName());
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
        if ("ICreditDataWSPort".equals(inputPortName)) {
            return getICreditDataWSPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice.creditdataweb.yodata.com.cn/", "ICreditDataWS");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice.creditdataweb.yodata.com.cn/", "ICreditDataWSPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ICreditDataWSPort".equals(portName)) {
            setICreditDataWSPortEndpointAddress(address);
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


    @Override
    public String ping() throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String getCredit(String arg0) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }


    @Override
    public String updateCredit(String arg0) throws RemoteException {
        // TODO Auto-generated method stub
        return null;
    }

}
