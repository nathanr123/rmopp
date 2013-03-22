/**
 * 
 */
package cti.rmopp.controls;

import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * @author Rajaeswaran
 * 
 */
public class RMOPP_MenuControl extends JPanel implements RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RMOPP_MenuControl() {

		setLayout(new BorderLayout());		
		loadControls();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cti.rmopp.controls.RMOPP_BaseControl#loadControls()
	 */
	@Override
	public void loadControls() {
		RMOPP_ToolBar toolbar = (RMOPP_ToolBar) RMOPP_WindowBuilder
				.getControls("ToolBar");
		RMOPP_MenuBar menubar = (RMOPP_MenuBar) RMOPP_WindowBuilder
				.getControls("MenuBar");
		add(menubar, BorderLayout.NORTH);
		add(toolbar, BorderLayout.SOUTH);
	}

}
