/**
 * 
 */
package cti.rmopp.controls;

import javax.swing.JInternalFrame;

/**
 * @author nathanr_kamal
 * 
 */
public class RMOPP_InternalFrame extends JInternalFrame implements
		RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public RMOPP_InternalFrame() {
		// TODO Auto-generated constructor stub
	}


	/**
	 * 
	 */
	public RMOPP_InternalFrame(String title, int x, int y, int w, int h,
			boolean iconifiable, boolean maximaizable, boolean closeable) {
		setTitle(title);
		setBounds(x, y, w, h);
		setIconifiable(iconifiable);
		setMaximizable(maximaizable);
		setClosable(closeable);
		setVisible(true);
	}

	/**
	 * 
	 */
	public RMOPP_InternalFrame(String title, int w, int h, boolean iconifiable,
			boolean maximaizable, boolean closeable) {
		setTitle(title);
		setBounds(0, 0, w, h);
		setIconifiable(iconifiable);
		setMaximizable(maximaizable);
		setClosable(closeable);
		setVisible(true);
	}

	

	/*
	 * (non-Javadoc)
	 * 
	 * @see cti.rmopp.controls.RMOPP_BaseControl#loadControls()
	 */
	@Override
	public void loadControls() {
		// TODO Auto-generated method stub

	}

}
