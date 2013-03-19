package cti.rmopp.controls;

public class RMOPP_WindowBuilder {

	public static RMOPP_BaseControl getControls(String control) {

		RMOPP_BaseControl retCtrl = null;
		if ("Navigation".equalsIgnoreCase(control)) {
			retCtrl = new RMOPP_Accordion();
		} else if ("Status".equals(control)) {
			retCtrl = new RMOPP_StatusBar();
		} else if ("ToolBar".equals(control)) {
			retCtrl = new RMOPP_ToolBar();
		} else if ("Desktop".equals(control)) {
			retCtrl = new RMOPP_DesktopPane();
		} else if ("Split".equals(control)) {
			retCtrl = new RMOPP_SplitPane();
		}
		return retCtrl;
	}
}
