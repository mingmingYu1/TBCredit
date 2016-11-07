package cn.com.yodata.creditdataweb.webservice;

public class ICreditDataWSPortTypeProxy implements cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType {
  private String _endpoint = null;
  private cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType iCreditDataWSPortType = null;
  
  public ICreditDataWSPortTypeProxy() {
    _initICreditDataWSPortTypeProxy();
  }
  
  public ICreditDataWSPortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initICreditDataWSPortTypeProxy();
  }
  
  private void _initICreditDataWSPortTypeProxy() {
    try {
      iCreditDataWSPortType = (new cn.com.yodata.creditdataweb.webservice.ICreditDataWSLocator()).getICreditDataWSPort();
      if (iCreditDataWSPortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iCreditDataWSPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iCreditDataWSPortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iCreditDataWSPortType != null)
      ((javax.xml.rpc.Stub)iCreditDataWSPortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.com.yodata.creditdataweb.webservice.ICreditDataWSPortType getICreditDataWSPortType() {
    if (iCreditDataWSPortType == null)
      _initICreditDataWSPortTypeProxy();
    return iCreditDataWSPortType;
  }
  
  public java.lang.String ping() throws java.rmi.RemoteException{
    if (iCreditDataWSPortType == null)
      _initICreditDataWSPortTypeProxy();
    return iCreditDataWSPortType.ping();
  }
  
  public java.lang.String getCredit(java.lang.String arg0) throws java.rmi.RemoteException{
    if (iCreditDataWSPortType == null)
      _initICreditDataWSPortTypeProxy();
    return iCreditDataWSPortType.getCredit(arg0);
  }
  
  public java.lang.String updateCredit(java.lang.String arg0) throws java.rmi.RemoteException{
    if (iCreditDataWSPortType == null)
      _initICreditDataWSPortTypeProxy();
    return iCreditDataWSPortType.updateCredit(arg0);
  }
  
  
}