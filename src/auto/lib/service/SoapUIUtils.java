package auto.lib.service;

import org.apache.axis.client.Call;  
import org.apache.axis.client.Service;
import java.rmi.RemoteException;
import javax.xml.rpc.ServiceException;  
  
public class SoapUIUtils {  
    public static void main(String[] args) throws ServiceException, RemoteException {  
   
            String endpoint = "http://172.16.8.229:8099/com.htfg.callcenter.portal.web/ws/IQueryDialNumberXface?wsdl";  
            // 直接引用远程的wsdl文件  
            // 以下都是套路  
            Service service = new Service();  
            Call call = (Call) service.createCall();  
            call.setTargetEndpointAddress(endpoint);  
            call.setOperationName("IQueryDialNumberXface");// WSDL里面描述的接口名称  
            call.addParameter("ipccCfgId",  
                    org.apache.axis.encoding.XMLType.XSD_DATE,  
                    javax.xml.rpc.ParameterMode.IN);// 接口的参数  
            call.setReturnType(org.apache.axis.encoding.XMLType.XSD_STRING);// 设置返回类型  
            String temp = "6767676";  
            String result = (String) call.invoke(new Object[] { temp });  
            // 给方法传递参数，并且调用方法  
            System.out.println("result is " + result);  
        
    }  
}  
