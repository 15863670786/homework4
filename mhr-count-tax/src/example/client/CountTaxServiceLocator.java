
package example.client;

public class CountTaxServiceLocator extends org.apache.axis.client.Service implements CountTaxService {

    public CountTaxServiceLocator() {
    }


    public CountTaxServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CountTaxServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CalTax
    private java.lang.String CalTax_address = "http://localhost:8080//services/example/CalTax";

    public java.lang.String getCalTaxAddress() {
        return CalTax_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CalTaxWSDDServiceName = "CalTax";

    public java.lang.String getCalTaxWSDDServiceName() {
        return CalTaxWSDDServiceName;
    }

    public void setCalTaxWSDDServiceName(java.lang.String name) {
        CalTaxWSDDServiceName = name;
    }

    public CountTax_PortType getCalTax() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(CalTax_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCalTax(endpoint);
    }

    public CountTax_PortType getCalTax(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            CountTaxSoapBindingStub _stub = new CountTaxSoapBindingStub(portAddress, this);
            _stub.setPortName(getCalTaxWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCalTaxEndpointAddress(java.lang.String address) {
        CalTax_address = address;
    }


    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (CountTax_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                CountTaxSoapBindingStub _stub = new CountTaxSoapBindingStub(new java.net.URL(CalTax_address), this);
                _stub.setPortName(getCalTaxWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }


    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("CalTax".equals(inputPortName)) {
            return getCalTax();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://example", "CalTaxService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://example", "CalTax"));
        }
        return ports.iterator();
    }


    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CalTax".equals(portName)) {
            setCalTaxEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }


    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
