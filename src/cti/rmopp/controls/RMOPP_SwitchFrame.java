/**
 * 
 */
package cti.rmopp.controls;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author nathanr_kamal
 * 
 */
public class RMOPP_SwitchFrame extends RMOPP_InternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	private int width;
	private int height;

	
	/**
	 * @param title
	 * @param w
	 * @param h
	 * @param iconifiable
	 * @param maximaizable
	 * @param closeable
	 */
	public RMOPP_SwitchFrame(String title, int w, int h, boolean iconifiable,
			boolean maximaizable, boolean closeable) {
		super(title, w, h+10, iconifiable, maximaizable, closeable);		
		this.width = w;
		this.height = h;
		loadControls();
	}

	@Override
	public void loadControls() {

		RMOPP_ToolBar toolbar = (RMOPP_ToolBar) RMOPP_WindowBuilder
				.getControls("ToolBar");

		
		RMOPP_SwitchPanel switchPanel = new RMOPP_SwitchPanel(width, height);

		getContentPane().add(toolbar, BorderLayout.NORTH);
		getContentPane().add(switchPanel, BorderLayout.CENTER);

	}

	private void loadPropertiesBox() {

	}

	private void loadControlBox() {
	}

	private void loadSwitchPanel() {
	}
}
