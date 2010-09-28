
/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

package org.apromore.manager.da;

import java.util.logging.Logger;

/**
 * This class was generated by Apache CXF 2.2.9
 * Sat Sep 18 13:11:30 CEST 2010
 * Generated source version: 2.2.9
 * 
 */

@javax.jws.WebService(
                      serviceName = "DAManagerService",
                      portName = "DAManager",
                      targetNamespace = "http://www.apromore.org/data_access/service_manager",
                      wsdlLocation = "http://localhost:8080/Apromore-dataAccess/services/DAManager?wsdl",
                      endpointInterface = "org.apromore.manager.da.DAManagerPortType")
                      
public class DAManagerPortTypeImpl implements DAManagerPortType {

    private static final Logger LOG = Logger.getLogger(DAManagerPortTypeImpl.class.getName());

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#deleteProcessVersions(org.apromore.manager.model_da.DeleteProcessVersionsInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.DeleteProcessVersionsOutputMsgType deleteProcessVersions(org.apromore.manager.model_da.DeleteProcessVersionsInputMsgType payload) { 
        LOG.info("Executing operation deleteProcessVersions");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.DeleteProcessVersionsOutputMsgType _return = new org.apromore.manager.model_da.DeleteProcessVersionsOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message1933893067");
            _returnResult.setCode(Integer.valueOf(781392184));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#writeUser(org.apromore.manager.model_da.WriteUserInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.WriteUserOutputMsgType writeUser(org.apromore.manager.model_da.WriteUserInputMsgType payload) { 
        LOG.info("Executing operation writeUser");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.WriteUserOutputMsgType _return = new org.apromore.manager.model_da.WriteUserOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message82018924");
            _returnResult.setCode(Integer.valueOf(-253183130));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readNativeTypes(org.apromore.manager.model_da.ReadNativeTypesInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadNativeTypesOutputMsgType readNativeTypes(org.apromore.manager.model_da.ReadNativeTypesInputMsgType payload) { 
        LOG.info("Executing operation readNativeTypes");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadNativeTypesOutputMsgType _return = new org.apromore.manager.model_da.ReadNativeTypesOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message-239932575");
            _returnResult.setCode(Integer.valueOf(-1474803266));
            _return.setResult(_returnResult);
            org.apromore.manager.model_da.NativeTypesType _returnNativeTypes = new org.apromore.manager.model_da.NativeTypesType();
            java.util.List<org.apromore.manager.model_da.FormatType> _returnNativeTypesNativeType = new java.util.ArrayList<org.apromore.manager.model_da.FormatType>();
            org.apromore.manager.model_da.FormatType _returnNativeTypesNativeTypeVal1 = new org.apromore.manager.model_da.FormatType();
            _returnNativeTypesNativeTypeVal1.setFormat("Format832919287");
            _returnNativeTypesNativeTypeVal1.setExtension("Extension-1309283776");
            _returnNativeTypesNativeType.add(_returnNativeTypesNativeTypeVal1);
            _returnNativeTypes.getNativeType().addAll(_returnNativeTypesNativeType);
            _return.setNativeTypes(_returnNativeTypes);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#deleteEditSession(org.apromore.manager.model_da.DeleteEditSessionInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.DeleteEditSessionOutputMsgType deleteEditSession(org.apromore.manager.model_da.DeleteEditSessionInputMsgType payload) { 
        LOG.info("Executing operation deleteEditSession");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.DeleteEditSessionOutputMsgType _return = new org.apromore.manager.model_da.DeleteEditSessionOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message-1514407872");
            _returnResult.setCode(Integer.valueOf(-1519768042));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readEditSession(org.apromore.manager.model_da.ReadEditSessionInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadEditSessionOutputMsgType readEditSession(org.apromore.manager.model_da.ReadEditSessionInputMsgType payload) { 
        LOG.info("Executing operation readEditSession");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadEditSessionOutputMsgType _return = new org.apromore.manager.model_da.ReadEditSessionOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message1421981995");
            _returnResult.setCode(Integer.valueOf(2062462768));
            _return.setResult(_returnResult);
            javax.activation.DataHandler _returnNative = null;
            _return.setNative(_returnNative);
            org.apromore.manager.model_da.EditSessionType _returnEditSession = new org.apromore.manager.model_da.EditSessionType();
            _returnEditSession.setUsername("Username-1140493225");
            _returnEditSession.setNativeType("NativeType-177283541");
            _returnEditSession.setProcessId(Integer.valueOf(1600803853));
            _returnEditSession.setProcessName("ProcessName-847022041");
            _returnEditSession.setVersionName("VersionName1562392782");
            _returnEditSession.setDomain("Domain-1932769158");
            _returnEditSession.setWithAnnotation(Boolean.valueOf(false));
            _returnEditSession.setAnnotation("Annotation-636649376");
            _return.setEditSession(_returnEditSession);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readDomains(org.apromore.manager.model_da.ReadDomainsInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadDomainsOutputMsgType readDomains(org.apromore.manager.model_da.ReadDomainsInputMsgType payload) { 
        LOG.info("Executing operation readDomains");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadDomainsOutputMsgType _return = new org.apromore.manager.model_da.ReadDomainsOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message395564706");
            _returnResult.setCode(Integer.valueOf(-1648255207));
            _return.setResult(_returnResult);
            org.apromore.manager.model_da.DomainsType _returnDomains = new org.apromore.manager.model_da.DomainsType();
            java.util.List<java.lang.String> _returnDomainsDomain = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnDomainsDomainVal1 = "_returnDomainsDomainVal-1417106493";
            _returnDomainsDomain.add(_returnDomainsDomainVal1);
            _returnDomains.getDomain().addAll(_returnDomainsDomain);
            _return.setDomains(_returnDomains);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#writeEditSession(org.apromore.manager.model_da.WriteEditSessionInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.WriteEditSessionOutputMsgType writeEditSession(org.apromore.manager.model_da.WriteEditSessionInputMsgType payload) { 
        LOG.info("Executing operation writeEditSession");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.WriteEditSessionOutputMsgType _return = new org.apromore.manager.model_da.WriteEditSessionOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message2004791053");
            _returnResult.setCode(Integer.valueOf(1782037107));
            _return.setResult(_returnResult);
            _return.setEditSessionCode(Integer.valueOf(1975259386));
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readAllUsers(org.apromore.manager.model_da.ReadAllUsersInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadAllUsersOutputMsgType readAllUsers(org.apromore.manager.model_da.ReadAllUsersInputMsgType payload) { 
        LOG.info("Executing operation readAllUsers");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadAllUsersOutputMsgType _return = new org.apromore.manager.model_da.ReadAllUsersOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message849578445");
            _returnResult.setCode(Integer.valueOf(505297971));
            _return.setResult(_returnResult);
            org.apromore.manager.model_da.UsernamesType _returnUsernames = new org.apromore.manager.model_da.UsernamesType();
            java.util.List<java.lang.String> _returnUsernamesUsername = new java.util.ArrayList<java.lang.String>();
            java.lang.String _returnUsernamesUsernameVal1 = "_returnUsernamesUsernameVal-1126549092";
            _returnUsernamesUsername.add(_returnUsernamesUsernameVal1);
            _returnUsernames.getUsername().addAll(_returnUsernamesUsername);
            _return.setUsernames(_returnUsernames);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readCanonicalAnf(org.apromore.manager.model_da.ReadCanonicalAnfInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadCanonicalAnfOutputMsgType readCanonicalAnf(org.apromore.manager.model_da.ReadCanonicalAnfInputMsgType payload) { 
        LOG.info("Executing operation readCanonicalAnf");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadCanonicalAnfOutputMsgType _return = new org.apromore.manager.model_da.ReadCanonicalAnfOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message-660122768");
            _returnResult.setCode(Integer.valueOf(1620181530));
            _return.setResult(_returnResult);
            javax.activation.DataHandler _returnCpf = null;
            _return.setCpf(_returnCpf);
            javax.activation.DataHandler _returnAnf = null;
            _return.setAnf(_returnAnf);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readUser(org.apromore.manager.model_da.ReadUserInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadUserOutputMsgType readUser(org.apromore.manager.model_da.ReadUserInputMsgType payload) { 
        LOG.info("Executing operation readUser");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadUserOutputMsgType _return = new org.apromore.manager.model_da.ReadUserOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message-495960110");
            _returnResult.setCode(Integer.valueOf(1822612612));
            _return.setResult(_returnResult);
            org.apromore.manager.model_da.UserType _returnUser = new org.apromore.manager.model_da.UserType();
            java.util.List<org.apromore.manager.model_da.SearchHistoriesType> _returnUserSearchHistories = new java.util.ArrayList<org.apromore.manager.model_da.SearchHistoriesType>();
            org.apromore.manager.model_da.SearchHistoriesType _returnUserSearchHistoriesVal1 = new org.apromore.manager.model_da.SearchHistoriesType();
            _returnUserSearchHistoriesVal1.setSearch("Search-218185741");
            _returnUserSearchHistoriesVal1.setNum(Integer.valueOf(1135513685));
            _returnUserSearchHistories.add(_returnUserSearchHistoriesVal1);
            _returnUser.getSearchHistories().addAll(_returnUserSearchHistories);
            _returnUser.setFirstname("Firstname1659146056");
            _returnUser.setLastname("Lastname-358712781");
            _returnUser.setEmail("Email11274783");
            _returnUser.setUsername("Username-437568310");
            _returnUser.setPasswd("Passwd-36991754");
            _return.setUser(_returnUser);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readFormat(org.apromore.manager.model_da.ReadFormatInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadFormatOutputMsgType readFormat(org.apromore.manager.model_da.ReadFormatInputMsgType payload) { 
        LOG.info("Executing operation readFormat");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadFormatOutputMsgType _return = new org.apromore.manager.model_da.ReadFormatOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message1253636392");
            _returnResult.setCode(Integer.valueOf(739037698));
            _return.setResult(_returnResult);
            javax.activation.DataHandler _returnNative = null;
            _return.setNative(_returnNative);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#editProcessData(org.apromore.manager.model_da.EditProcessDataInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.EditProcessDataOutputMsgType editProcessData(org.apromore.manager.model_da.EditProcessDataInputMsgType payload) { 
        LOG.info("Executing operation editProcessData");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.EditProcessDataOutputMsgType _return = new org.apromore.manager.model_da.EditProcessDataOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message306838365");
            _returnResult.setCode(Integer.valueOf(735432227));
            _return.setResult(_returnResult);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

    /* (non-Javadoc)
     * @see org.apromore.manager.da.DAManagerPortType#readProcessSummaries(org.apromore.manager.model_da.ReadProcessSummariesInputMsgType  payload )*
     */
    public org.apromore.manager.model_da.ReadProcessSummariesOutputMsgType readProcessSummaries(org.apromore.manager.model_da.ReadProcessSummariesInputMsgType payload) { 
        LOG.info("Executing operation readProcessSummaries");
        System.out.println(payload);
        try {
            org.apromore.manager.model_da.ReadProcessSummariesOutputMsgType _return = new org.apromore.manager.model_da.ReadProcessSummariesOutputMsgType();
            org.apromore.manager.model_da.ResultType _returnResult = new org.apromore.manager.model_da.ResultType();
            _returnResult.setMessage("Message559008104");
            _returnResult.setCode(Integer.valueOf(776509078));
            _return.setResult(_returnResult);
            org.apromore.manager.model_da.ProcessSummariesType _returnProcessSummaries = new org.apromore.manager.model_da.ProcessSummariesType();
            java.util.List<org.apromore.manager.model_da.ProcessSummaryType> _returnProcessSummariesProcessSummary = new java.util.ArrayList<org.apromore.manager.model_da.ProcessSummaryType>();
            org.apromore.manager.model_da.ProcessSummaryType _returnProcessSummariesProcessSummaryVal1 = new org.apromore.manager.model_da.ProcessSummaryType();
            java.util.List<org.apromore.manager.model_da.VersionSummaryType> _returnProcessSummariesProcessSummaryVal1VersionSummaries = new java.util.ArrayList<org.apromore.manager.model_da.VersionSummaryType>();
            _returnProcessSummariesProcessSummaryVal1.getVersionSummaries().addAll(_returnProcessSummariesProcessSummaryVal1VersionSummaries);
            _returnProcessSummariesProcessSummaryVal1.setOriginalNativeType("OriginalNativeType-620264004");
            _returnProcessSummariesProcessSummaryVal1.setName("Name1615706912");
            _returnProcessSummariesProcessSummaryVal1.setId(Integer.valueOf(-1697289254));
            _returnProcessSummariesProcessSummaryVal1.setDomain("Domain-457913204");
            _returnProcessSummariesProcessSummaryVal1.setRanking("Ranking375203032");
            _returnProcessSummariesProcessSummaryVal1.setLastVersion("LastVersion-1853321811");
            _returnProcessSummariesProcessSummaryVal1.setOwner("Owner1419221714");
            _returnProcessSummariesProcessSummary.add(_returnProcessSummariesProcessSummaryVal1);
            _returnProcessSummaries.getProcessSummary().addAll(_returnProcessSummariesProcessSummary);
            _return.setProcessSummaries(_returnProcessSummaries);
            return _return;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }

}
