package au.edu.qut.apromore.util;

import de.hpi.bpmn2xpdl.XPDLPackage;
import de.hpi.bpmn2xpdl.XPDLPool;
import de.hpi.bpmn2xpdl.XPDLWorkflowProcess;

public class BizageInterceptor {//TODO: this class requires massive cleanup

    private static String MAIN_PROCESS = "Main Process";
    private XPDLPackage xpdlPackage;

    public BizageInterceptor(XPDLPackage newPackage) {
        this.xpdlPackage = newPackage;
    }

    public void intercept() {

        // remove the Main process empty pool
        for (XPDLWorkflowProcess workflowProcess : xpdlPackage.getWorkflowProcesses().getWorkflowProcesses()) {
            if (MAIN_PROCESS.equals(workflowProcess.getName())) {
                removeEmptyPool(workflowProcess.getId());
                xpdlPackage.getWorkflowProcesses().getWorkflowProcesses().remove(workflowProcess);
                break; // to avoid cuncurrent modification exception
            }
        }

        // remove the Main process empty pool
        for (XPDLPool pool : xpdlPackage.getPools().getPools()) {
            if (MAIN_PROCESS.equals(pool.getName())) {
                removeEmptyWorkflowProcess(pool.getProcess());
                xpdlPackage.getPools().getPools().remove(pool);
                break;
            }
        }
    }

    private void removeEmptyPool(String id) {
        for (XPDLPool pool : xpdlPackage.getPools().getPools()) {
            if (id.equals(pool.getId())) {
                xpdlPackage.getPools().getPools()
                        .remove(pool);
                break; // to avoid cuncurrent modification exception
            }
        }
    }

    private void removeEmptyWorkflowProcess(String processId) {
        for (XPDLWorkflowProcess process : xpdlPackage.getWorkflowProcesses().getWorkflowProcesses()) {
            if (processId.equals(process.getId())) {
                xpdlPackage.getWorkflowProcesses().getWorkflowProcesses().remove(process);
                break;
            }
        }
    }

}
