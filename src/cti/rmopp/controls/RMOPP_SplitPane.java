package cti.rmopp.controls;

import javax.swing.JSplitPane;

import cti.rmopp.utils.RMOPP_Utilitties;

public class RMOPP_SplitPane extends JSplitPane implements RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RMOPP_SplitPane() {
		
		super();
		
		setResizeWeight(1.0);
		
		setDividerLocation((int)Math.round(RMOPP_Utilitties.getScreenWidth()*.10));		
		
		setContinuousLayout(true);
		
		loadControls();
	}

	@Override
	public void loadControls() {
		
		setRightComponent((RMOPP_DesktopPane) RMOPP_WindowBuilder
				.getControls("Desktop"));

		setLeftComponent((RMOPP_Accordion) RMOPP_WindowBuilder
				.getControls("Navigation"));
	}

}
