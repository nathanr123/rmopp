package cti.rmopp.controls;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class RMOPP_MenuBar extends JMenuBar implements RMOPP_BaseControl {

	/**
	 * 
	 */
	private JMenu fileMenu;
	private JMenuItem exitMenuItem;
	private static final long serialVersionUID = 1L;

	public RMOPP_MenuBar() {
		loadControls();
	}

	@Override
	public void loadControls() {
		exitMenuItem = new JMenuItem("Exit");
		fileMenu = new JMenu("File");
		fileMenu.add(exitMenuItem);
		add(fileMenu);

	}

}
