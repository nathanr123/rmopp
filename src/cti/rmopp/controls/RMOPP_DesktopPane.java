package cti.rmopp.controls;

import javax.swing.JDesktopPane;

import cti.rmopp.utils.RMOPP_Utilitties;

public class RMOPP_DesktopPane extends JDesktopPane implements
		RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RMOPP_DesktopPane() {

		loadControls();
	}

	@Override
	public void loadControls() {

/*		RMOPP_InternalFrame internalFrame = new RMOPP_InternalFrame(
				"Dash Board", (int) (RMOPP_Utilitties.getScreenWidth() * .88),
				(int) (RMOPP_Utilitties.getScreenHeight() * .86), true, false,
				false);*/

		RMOPP_SwitchFrame switchFrame = new RMOPP_SwitchFrame("Switch 1",
				(int) (RMOPP_Utilitties.getScreenWidth() * .88),
				(int) (RMOPP_Utilitties.getScreenHeight() * .86), true, false,
				true);

//		add(internalFrame);
		add(switchFrame);

//		internalFrame.setVisible(true);
	}

}
