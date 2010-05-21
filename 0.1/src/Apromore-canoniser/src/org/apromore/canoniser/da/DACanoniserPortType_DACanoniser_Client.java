
package org.apromore.canoniser.da;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;

/**
 * This class was generated by Apache CXF 2.2.7
 * Wed May 19 15:27:54 EST 2010
 * Generated source version: 2.2.7
 * 
 */

public final class DACanoniserPortType_DACanoniser_Client {

    private static final QName SERVICE_NAME = new QName("http://www.apromore.org/data_access/service_canoniser", "DACanoniserService");

    private DACanoniserPortType_DACanoniser_Client() {
    }

    public static void main(String args[]) throws Exception {
        URL wsdlURL = DACanoniserService.WSDL_LOCATION;
        if (args.length > 0) { 
            File wsdlFile = new File(args[0]);
            try {
                if (wsdlFile.exists()) {
                    wsdlURL = wsdlFile.toURI().toURL();
                } else {
                    wsdlURL = new URL(args[0]);
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
      
        DACanoniserService ss = new DACanoniserService(wsdlURL, SERVICE_NAME);
        DACanoniserPortType port = ss.getDACanoniser();  
        
        {
        System.out.println("Invoking storeNativeCpf...");
        org.apromore.canoniser.model_da.StoreNativeCpfInputMsgType _storeNativeCpf_payload = new org.apromore.canoniser.model_da.StoreNativeCpfInputMsgType();
        _storeNativeCpf_payload.setProcessName("ProcessName1400223486");
        _storeNativeCpf_payload.setDomain("Domain594081037");
        _storeNativeCpf_payload.setNativeType("NativeType-1936161064");
        _storeNativeCpf_payload.setUsername("Username-972276724");
        _storeNativeCpf_payload.setVersionName("VersionName-2093206696");
        javax.activation.DataHandler _storeNativeCpf_payloadNative = null;
        _storeNativeCpf_payload.setNative(_storeNativeCpf_payloadNative);
        javax.activation.DataHandler _storeNativeCpf_payloadCpf = null;
        _storeNativeCpf_payload.setCpf(_storeNativeCpf_payloadCpf);
        javax.activation.DataHandler _storeNativeCpf_payloadAnf = null;
        _storeNativeCpf_payload.setAnf(_storeNativeCpf_payloadAnf);
        org.apromore.canoniser.model_da.StoreNativeCpfOutputMsgType _storeNativeCpf__return = port.storeNativeCpf(_storeNativeCpf_payload);
        System.out.println("storeNativeCpf.result=" + _storeNativeCpf__return);


        }
        {
        System.out.println("Invoking storeNative...");
        org.apromore.canoniser.model_da.StoreNativeInputMsgType _storeNative_payload = new org.apromore.canoniser.model_da.StoreNativeInputMsgType();
        _storeNative_payload.setProcessId(-1461935888);
        _storeNative_payload.setVersion("Version12621594");
        _storeNative_payload.setNativeType("NativeType-808301022");
        javax.activation.DataHandler _storeNative_payloadNative = null;
        _storeNative_payload.setNative(_storeNative_payloadNative);
        org.apromore.canoniser.model_da.StoreNativeOutputMsgType _storeNative__return = port.storeNative(_storeNative_payload);
        System.out.println("storeNative.result=" + _storeNative__return);


        }

        System.exit(0);
    }

}
