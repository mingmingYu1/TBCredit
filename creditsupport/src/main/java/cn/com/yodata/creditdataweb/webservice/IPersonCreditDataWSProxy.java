package cn.com.yodata.creditdataweb.webservice;

public class IPersonCreditDataWSProxy implements cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS {
  private String _endpoint = null;
  private cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS iPersonCreditDataWS = null;
  
  public IPersonCreditDataWSProxy() {
    _initIPersonCreditDataWSProxy();
  }
  
  public IPersonCreditDataWSProxy(String endpoint) {
    _endpoint = endpoint;
    _initIPersonCreditDataWSProxy();
  }
  
  private void _initIPersonCreditDataWSProxy() {
    try {
      iPersonCreditDataWS = (new cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWSServiceLocator()).getIPersonCreditDataWSPort();
      if (iPersonCreditDataWS != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iPersonCreditDataWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iPersonCreditDataWS)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iPersonCreditDataWS != null)
      ((javax.xml.rpc.Stub)iPersonCreditDataWS)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public cn.com.yodata.creditdataweb.webservice.IPersonCreditDataWS getIPersonCreditDataWS() {
    if (iPersonCreditDataWS == null)
      _initIPersonCreditDataWSProxy();
    return iPersonCreditDataWS;
  }
  
  public java.lang.String getPersonCredit(cn.com.yodata.creditdataweb.webservice.PersonDTO arg0) throws java.rmi.RemoteException{
    if (iPersonCreditDataWS == null)
      _initIPersonCreditDataWSProxy();
    return iPersonCreditDataWS.getPersonCredit(arg0);
  }
  
  
}