/**
 * 
 */
package cti.rmopp.client;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

import cti.rmopp.controls.RMOPP_BaseControl;
import cti.rmopp.controls.RMOPP_SplitPane;
import cti.rmopp.controls.RMOPP_StatusBar;
import cti.rmopp.controls.RMOPP_ToolBar;
import cti.rmopp.controls.RMOPP_WindowBuilder;
import cti.rmopp.model.RMOPP_User;
import cti.rmopp.utils.RMOPP_Utilitties;

/**
 * @author nathanr_kamal
 * 
 */
public class RMOPP_ClientFrame extends JFrame implements RMOPP_BaseControl {

	private static final long serialVersionUID = 1L;

	private double cfgWidth;

	private double cfgHeight;

	private Container container;

	private RMOPP_User currentUser;
	
	final Dimension dim = RMOPP_Utilitties.getScreenResolution();

	public RMOPP_ClientFrame(RMOPP_User curUser) {
	
		currentUser = curUser;
		
		RMOPP_Utilitties.setCurrentUser(curUser);
		
		initialize();
	}

	public RMOPP_ClientFrame() {

		initialize();
	}

	private void setScreenSize() {

		cfgHeight = dim.getHeight();

		cfgWidth = dim.getWidth();

		RMOPP_Utilitties.setScreenSize(cfgWidth, cfgHeight);

	}

	private void initialize() {

		setScreenSize();

		setTitle(currentUser.getUsername());
		
		container = getContentPane();

		setSize((int) cfgWidth, (int) cfgHeight);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setAlwaysOnTop(true);

		loadControls();
		
		setVisible(true);
	}

	@Override
	public void loadControls() {
		
		container.setLayout(new BorderLayout());

		container.add(
				(RMOPP_StatusBar) RMOPP_WindowBuilder.getControls("Status"),
				BorderLayout.SOUTH);

		container.add(
				(RMOPP_ToolBar) RMOPP_WindowBuilder.getControls("ToolBar"),
				BorderLayout.NORTH);

		container.add(
				(RMOPP_SplitPane) RMOPP_WindowBuilder.getControls("Split"),
				BorderLayout.CENTER);
	}
}
