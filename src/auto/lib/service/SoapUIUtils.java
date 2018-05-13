package auto.lib.service;

import org.apache.axis.client.Call;  
import org.apache.axis.client.Service;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;  
  
public class SoapUIUtils {  
    public static void main(String[] args) throws ServiceException, RemoteException {  
   
            String endpoint = "http://172.16.8.229:8099/com.htfg.callcenter.portal.web/ws/IQueryDialNumberXface?wsdl";  
            // ֱ������Զ�̵�wsdl�ļ�  
            // ���¶�����·  
            Service service = new Service();  
            Call call = (Call) service.createCall();  
            call.setTargetEndpointAddress(endpoint);  
            call.setOperationName("IQueryDialNumberXface");// WSDL���������Ľӿ�����  
            call.addParameter("ipccCfgId",  
                    org.apache.axis.encoding.XMLType.XSD_DATE,  
                    javax.xml.rpc.ParameterMode.IN);// �ӿڵĲ���  
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// ���÷�������  
            String temp = "6767676";  
            String result = (String) call.invoke(new Object[] { temp });  
            // ���������ݲ��������ҵ��÷���  
            System.out.println("result is " + result);  
        
    }  
}  
