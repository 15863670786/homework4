

package example.client;

public interface CountTaxService extends javax.xml.rpc.Service {
    public java.lang.String getCalTaxAddress();

    public CountTax_PortType getCalTax() throws javax.xml.rpc.ServiceException;

    public CountTax_PortType getCalTax(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
