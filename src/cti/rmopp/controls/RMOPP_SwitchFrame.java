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

	public RMOPP_SwitchFrame() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);

		JDesktopPane desktopPane = new JDesktopPane();
		getContentPane().add(desktopPane, BorderLayout.CENTER);

		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setResizable(true);
		internalFrame.setClosable(true);
		internalFrame.setBounds(23, 44, 190, 295);
		desktopPane.add(internalFrame);

		JInternalFrame internalFrame_1 = new JInternalFrame(
				"New JInternalFrame");
		internalFrame_1.setResizable(true);
		internalFrame_1.setClosable(true);
		internalFrame_1.setBounds(595, 44, 190, 348);
		desktopPane.add(internalFrame_1);

		JInternalFrame internalFrame_2 = new JInternalFrame(
				"New JInternalFrame");
		internalFrame_2.setResizable(true);
		internalFrame_2.setClosable(true);
		internalFrame_2.setBounds(292, 44, 255, 392);
		desktopPane.add(internalFrame_2);
		internalFrame_2.setVisible(true);
		internalFrame_1.setVisible(true);
		internalFrame.setVisible(true);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param title
	 * @param x
	 * @param y
	 * @param w
	 * @param h
	 * @param iconifiable
	 * @param maximaizable
	 * @param closeable
	 */
	public RMOPP_SwitchFrame(String title, int x, int y, int w, int h,
			boolean iconifiable, boolean maximaizable, boolean closeable) {
		super(title, x, y, w, h, iconifiable, maximaizable, closeable);

	}

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
		super(title, w, h, iconifiable, maximaizable, closeable);
		this.width = w;
		this.height = h;
		loadControls();
	}

	@Override
	public void loadControls() {

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmClose = new JMenuItem("Close");
		mnFile.add(mntmClose);

		RMOPP_SwitchPanel switchPanel = new RMOPP_SwitchPanel(width, height);

		getContentPane().add(switchPanel, BorderLayout.CENTER);

	}

	private void loadPropertiesBox() {

	}

	private void loadControlBox() {
	}

	private void loadSwitchPanel() {
	}
}
