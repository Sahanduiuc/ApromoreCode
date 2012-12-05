package org.apromore.portal.dialogController;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Logger;

import org.apromore.model.ClusterFilterType;
import org.apromore.model.DomainsType;
import org.apromore.model.EditSessionType;
import org.apromore.model.NativeTypesType;
import org.apromore.model.PluginMessage;
import org.apromore.model.PluginMessages;
import org.apromore.model.ProcessSummariesType;
import org.apromore.model.ProcessSummaryType;
import org.apromore.model.SearchHistoriesType;
import org.apromore.model.UserType;
import org.apromore.model.UsernamesType;
import org.apromore.model.VersionSummaryType;
import org.apromore.portal.common.Constants;
import org.apromore.portal.dialogController.similarityclusters.SimilarityClustersFilterController;
import org.apromore.portal.dialogController.similarityclusters.SimilarityClustersFragmentsListboxController;
import org.apromore.portal.dialogController.similarityclusters.SimilarityClustersListboxController;
import org.apromore.portal.exception.ExceptionAllUsers;
import org.apromore.portal.exception.ExceptionDomains;
import org.apromore.portal.exception.ExceptionFormats;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.ClientInfoEvent;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Menuitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.South;
import org.zkoss.zul.Window;


/**
 * Main Controller for the whole application, most of the UI state is managed here.
 * It is automatically instantiated as index.zul is loaded!
 */
public class MainController extends BaseController {

    private static final long serialVersionUID = 5147685906484044300L;

    private Window mainW;
    private Window chooseNativeW;
    private Window OpenModelInSignavioW;
    private HeaderController header;
    private MenuController menu;
    private SimpleSearchController simplesearch;
    private UserType currentUser; // the connected user, if any
    private ShortMessageController shortmessageC;
    private Window shortmessageW;
    private String host;
    private String OryxEndPoint_xpdl;
    private String OryxEndPoint_epml;
    private Logger LOG;
    private String msgWhenClose;
    private List<SearchHistoriesType> searchHistory;

    private BaseListboxController baseListboxController;
    private BaseDetailController baseDetailController;
    private BaseFilterController baseFilterController;


    // uncomment when ready
    // private NavigationController navigation;

    /**
     * onCreate is executed after the main window has been created it is
     * responsible for instantiating all necessary controllers (one for each
     * window defined in the interface)
     * see description in index.zul
     * @throws InterruptedException
     */
    public void onCreate() throws InterruptedException {
        try {
            // if client browser is not gecko3 based (such as firefox) raise an exception
            if (!Executions.getCurrent().isGecko() && !Executions.getCurrent().isGecko3()) {
                throw new Exception("Sorry, we currently support firefox only.");
            }
            this.LOG = Logger.getLogger(MainController.class.getName());
            /**
             * to get data
             */
            this.mainW = (Window) this.getFellow("mainW");
            this.shortmessageW = (Window) this.getFellow("shortmessagescomp").getFellow("shortmessage");
            this.shortmessageC = new ShortMessageController(shortmessageW);
            this.header = new HeaderController(this);
            this.simplesearch = new SimpleSearchController(this);
            this.menu = new MenuController(this);

            // this.navigation = new NavigationController (this);
            switchToProcessSummaryView();

            this.currentUser = null;
            this.searchHistory = new ArrayList<SearchHistoriesType>();
            this.msgWhenClose = null;
            // read Oryx access point in properties
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(Constants.PROPERTY_FILE);

            Properties properties = new Properties();
            properties.load(inputStream);
            this.host = properties.getProperty("Host");
            this.OryxEndPoint_xpdl = properties.getProperty("OryxEndPoint_xpdl");
            this.OryxEndPoint_epml = properties.getProperty("OryxEndPoint_epml");

        } catch (Exception e) {
            String message = null;
            if (e.getMessage() == null) {
                message = "Please contact Apromore's administrator";
            }
            else {
                message = e.getMessage();
            }
            e.printStackTrace();
            Messagebox.show("Repository not available (" + message + ")", "Attention", Messagebox.OK, Messagebox.ERROR);
        }
    }

    /**
     * register an event listener for the clientInfo event (to prevent user to
     * close the browser window)
     */
    public void onClientInfo(final ClientInfoEvent event) {
        Clients.confirmClose(Constants.MSG_WHEN_CLOSE);
    }

    /**
     * Display version processes in processSummaries: if isQueryResult, the
     * query is given by version of process
     * @param processSummaries
     * @param isQueryResult
     * @param process
     * @param version
     * @throws Exception
     */
    public void displayProcessSummaries(final ProcessSummariesType processSummaries, final Boolean isQueryResult,
            final ProcessSummaryType process, final VersionSummaryType version) {
        if (isQueryResult) {
            clearProcessVersions();
        }

        // TODO switch to process query result view
        switchToProcessSummaryView();
        ((ProcessListboxController) this.baseListboxController)
                .displayProcessSummaries(processSummaries, isQueryResult,
                        process, version);
    }

    // disable/enable features depending on user status
    public void updateActions() {

        Boolean connected = this.currentUser != null;

        // disable/enable menu items in menu bar
        Iterator<Component> itC = this.menu.getMenuB().getFellows().iterator();
        while (itC.hasNext()) {
            Component C = itC.next();
            if (C.getClass().getName().compareTo("org.zkoss.zul.Menuitem") == 0) {
                if (C.getId().compareTo("processMerge") != 0) {
                    ((Menuitem) C).setDisabled(!connected);
                }
            }
        }
    }

    public void reloadProcessSummaries() {
        ProcessSummariesType processSummaries = getService()
                .readProcessSummaries("");
        String message = null;
        if (processSummaries.getProcessSummary().size() > 1) {
            message = " processes.";
        }
        else {
            message = " process.";
        }
        this.displayMessage(processSummaries.getProcessSummary().size()
                + message);
        this.simplesearch.clearSearches();
        this.displayProcessSummaries(processSummaries, false, null, null);
    }

    /**
     * reset displayed informations: - short message - process summaries -
     * simple search
     * @throws Exception
     */
    public void resetUserInformation() throws Exception {
        eraseMessage();
        this.currentUser = null;
        this.simplesearch.clearSearches();
    }

    /**
     * Forward to the controller ProcessTableController the request to add the
     * process to the table
     * @param returnedProcess
     */
    public void displayNewProcess(final ProcessSummaryType returnedProcess) {
        switchToProcessSummaryView();
        ((ProcessListboxController) this.baseListboxController)
                .displayNewProcess(returnedProcess);
        this.displayMessage(this.baseListboxController.getListModel().getSize()
                + " processes.");
    }

    /**
     * Send request to Manager: deleted process versions given as parameter
     * @param processVersions
     * @throws InterruptedException
     */
    public void deleteProcessVersions(final Map<ProcessSummaryType, List<VersionSummaryType>> processVersions) throws InterruptedException {
        try {
            getService().deleteProcessVersions(processVersions);
            switchToProcessSummaryView();
            ((ProcessListboxController) this.baseListboxController).unDisplay(processVersions);
            String message;
            int nb = 0;

            // to count how many process version(s) deleted
            Collection<List<VersionSummaryType>> sumTypes = processVersions.values();
            for (List<VersionSummaryType> sumType : sumTypes) {
                nb += sumType.size();
            }
            if (nb > 1) {
                message = nb + " process versions deleted.";
            } else {
                message = " One process version deleted.";
            }
            displayMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            Messagebox.show("Deletion failed (" + e.getMessage() + ")", "Attention", Messagebox.OK, Messagebox.ERROR);
        }
    }

    /**
     * Call editor to edit process version whose id is processId, name is
     * processName and version name is version. nativeType identifies language
     * to be used to edit the process version. If annotation is instantiated, it
     * identifies the annotation file to be used. If readOnly=1, annotations
     * only are editable.
     * @param version
     * @param nativeType
     * @param annotation
     * @param readOnly
     * @throws InterruptedException
     * @throws Exception
     */
    public void editProcess(final ProcessSummaryType process,
                            final VersionSummaryType version, final String nativeType, final String annotation,
                            final String readOnly) throws InterruptedException {

        String instruction = "", url = getHost();
        int offsetH = 100, offsetV = 200;
        int editSessionCode;
        EditSessionType editSession = new EditSessionType();
        editSession.setDomain(process.getDomain());
        editSession.setNativeType(nativeType);
        editSession.setProcessId(process.getId());
        editSession.setProcessName(process.getName());
        editSession.setUsername(this.getCurrentUser().getUsername());
        editSession.setVersionName(version.getName());
        editSession.setCreationDate(version.getCreationDate());
        editSession.setLastUpdate(version.getLastUpdate());
        if (annotation == null) {
            editSession.setWithAnnotation(false);
        } else {
            editSession.setWithAnnotation(true);
            editSession.setAnnotation(annotation);
        }
        try {
            // create and store an edit session
            editSessionCode = getService().writeEditSession(editSession);
            SignavioController.editSession = editSession;
            SignavioController.mainC = this;
            url = "macros/OpenModelInSignavio.zul";
            instruction += "window.open('" + url + "','','top=" + offsetH + ",left=" + offsetV
                    + ",height=600,width=800,scrollbars=1,resizable=1'); ";

            // Send http post to Oryx
            Clients.evalJavaScript(instruction);
        } catch (Exception e) {
            Messagebox
                    .show("Cannot edit " + process.getName() + " ("
                            + e.getMessage() + ")", "Attention", Messagebox.OK,
                            Messagebox.ERROR);
        }
    }

    public void displayMessage(final String mes) {
        this.shortmessageC.displayMessage(mes);
    }

    public void eraseMessage() {
        this.shortmessageC.eraseMessage();
    }

    public HeaderController getHeader() {
        return header;
    }

    public void setHeader(final HeaderController header) {
        this.header = header;
    }

    public MenuController getMenu() {
        return menu;
    }

    public void setMenu(final MenuController menu) {
        this.menu = menu;
    }

    public BaseListboxController getBaseListboxController() {
        return baseListboxController;
    }

    public BaseDetailController getDetailListbox() {
        return baseDetailController;
    }

    public SimpleSearchController getSimplesearch() {
        return simplesearch;
    }

    public void setSimplesearch(final SimpleSearchController simplesearch) {
        this.simplesearch = simplesearch;
    }

    public UserType getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(final UserType currentUser) {
        this.currentUser = currentUser;
        if (currentUser == null) {
            this.msgWhenClose = null;
        }
        else {
            this.msgWhenClose = Constants.MSG_WHEN_CLOSE;
            this.searchHistory = this.currentUser.getSearchHistories();
        }
    }

    public ShortMessageController getShortmessageC() {
        return shortmessageC;
    }

    public void setShortmessageC(final ShortMessageController shortmessageC) {
        this.shortmessageC = shortmessageC;
    }

    public Window getShortmessageW() {
        return shortmessageW;
    }

    public void setShortmessageW(final Window shortmessageW) {
        this.shortmessageW = shortmessageW;
    }

    public String getOryxEndPoint_xpdl() {
        return OryxEndPoint_xpdl;
    }

    public String getOryxEndPoint_epml() {
        return OryxEndPoint_epml;
    }

    public Logger getLOG() {
        return LOG;
    }

    public String getHost() {
        return host;
    }

    public List<SearchHistoriesType> getSearchHistory() {
        return searchHistory;
    }

    /**
     * get list of domains
     */
    public List<String> getDomains() throws ExceptionDomains {
        DomainsType domainsType;
        domainsType = getService().readDomains();
        return domainsType.getDomain();
    }

    /**
     * get list of users' names
     * @return
     * @throws org.apromore.portal.exception.ExceptionAllUsers
     */
    public List<String> getUsers() throws ExceptionAllUsers {
        UsernamesType usernames = getService().readAllUsers();
        return usernames.getUsername();
    }

    /**
     * get list of formats: <k, v> belongs to getNativeTypes() <=> the file
     * extension k is associated with the native type v (<xpdl,XPDL 1.2>)
     * @throws org.apromore.portal.exception.ExceptionFormats
     */
    public HashMap<String, String> getNativeTypes() throws ExceptionFormats {
        HashMap<String, String> formats = new HashMap<String, String>();
        NativeTypesType nativeTypesDB = getService().readNativeTypes();
        for (int i = 0; i < nativeTypesDB.getNativeType().size(); i++) {
            formats.put(nativeTypesDB.getNativeType().get(i).getExtension(),
                    nativeTypesDB.getNativeType().get(i).getFormat());
        }
        return formats;
    }

    public void displayProcessVersions(final ProcessSummaryType data) {
        switchToProcessSummaryView();
        ((ProcessVersionDetailController) this.baseDetailController)
                .displayProcessVersions(data);
    }

    public void clearProcessVersions() {
        switchToProcessSummaryView();
        ((ProcessVersionDetailController) this.baseDetailController)
                .clearProcesVersions();
    }

    public void displaySimilarityClusters(final ClusterFilterType filter) {
        switchToSimilarityClusterView();
        ((SimilarityClustersListboxController) this.baseListboxController)
                .displaySimilarityClusters(filter);
    }

    @SuppressWarnings("unchecked")
    public Set<ProcessSummaryType> getSelectedProcesses() {
        if (this.baseListboxController instanceof ProcessListboxController) {
            ProcessListboxController processController = (ProcessListboxController) getBaseListboxController();
            //ZK returns untyped Set, but we can assume it is of type ProcessSummaryType here!
            return processController.getListModel().getSelection();
        }
        else {
            return new HashSet<ProcessSummaryType>();
        }
    }


    /**
     * Removes the currently displayed listbox, detail and filter view
     */
    private void deattachDynamicUI() {
        getFellow("baseListbox").getFellow("tablecomp").getChildren().clear();
        getFellow("baseDetail").getFellow("detailcomp").getChildren().clear();
        getFellow("baseFilter").getFellow("filtercomp").getChildren().clear();
    }


    /**
     * Attaches the the listbox, detail and filter view
     */
    private void reattachDynamicUI() {
        getFellow("baseFilter").getFellow("filtercomp").appendChild(
                this.baseFilterController);
        getFellow("baseListbox").getFellow("tablecomp").appendChild(
                this.baseListboxController);
        getFellow("baseDetail").getFellow("detailcomp").appendChild(
                this.baseDetailController);
    }

    /**
     * Switches all dynamic UI elements to the ProcessSummaryView. Affects the
     * listbox, detail and filter view
     */
    private void switchToProcessSummaryView() {

        // TODO should replace this with TabBox!! and without all these
        // instanceof checks!

        if (this.baseListboxController != null) {
            if ((this.baseListboxController instanceof ProcessListboxController)) {
                // Everything is correctly setup
                return;
            }
            else {
                // Another view is currently displayed
                deattachDynamicUI();
            }
        }

        // Otherwise create new Listbox
        this.baseListboxController = new ProcessListboxController(this);
        this.baseDetailController = new ProcessVersionDetailController(this);
        this.baseFilterController = new BaseFilterController(this);

        reattachDynamicUI();

        // TODO this should be done in ZUL or elsewhere
        ((South) getFellow("leftSouthPanel")).setTitle("Process Details");
        ((South) getFellow("leftInnerSouthPanel")).setOpen(false);

        reloadProcessSummaries();
    }

    /**
     * Switches all dynamic UI elements to the SimilarityClusterView. Affects
     * the listbox, detail and filter view
     */
    private void switchToSimilarityClusterView() {

        // TODO should replace this with TabBox!! and without all these
        // instanceof checks!

        if (this.baseListboxController != null) {
            if ((this.baseListboxController instanceof SimilarityClustersListboxController)) {
                // Everything is correctly setup
                return;
            }
            else {
                // Another view is currently displayed
                deattachDynamicUI();
            }
        }

        // Otherwise create new Listbox
        this.baseFilterController = new SimilarityClustersFilterController(this);
        this.baseDetailController = new SimilarityClustersFragmentsListboxController(
                this);
        this.baseListboxController = new SimilarityClustersListboxController(
                this,
                (SimilarityClustersFilterController) this.baseFilterController,
                (SimilarityClustersFragmentsListboxController) this.baseDetailController);

        reattachDynamicUI();

        // TODO this should be done in ZUL or elsewhere
        ((South) getFellow("leftSouthPanel")).setTitle("Cluster Details");
        ((South) getFellow("leftInnerSouthPanel")).setOpen(true);
    }

    public void showPluginMessages(final PluginMessages messages) throws InterruptedException {
        if (messages != null) {
            StringBuilder sb = new StringBuilder();
            Iterator<PluginMessage> iter = messages.getMessage().iterator();
            while (iter.hasNext()) {
                sb.append(iter.next().getValue());
                if (iter.hasNext()) {
                    sb.append("\n\n");
                }
            }
            if (sb.length() > 0) {
                Messagebox.show(sb.toString(), "Plugin Warnings", Messagebox.OK, Messagebox.EXCLAMATION);
            }
        }
    }

}