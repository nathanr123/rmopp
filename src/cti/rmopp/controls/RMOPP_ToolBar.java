package cti.rmopp.controls;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JToolBar;

public class RMOPP_ToolBar extends JToolBar implements RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RMOPP_ToolBar() {
		setFloatable(false);
		loadControls();
	}

	@Override
	public void loadControls() {
		JButton button = new JButton("New button");
		add(button);

		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		add(chckbxNewCheckBox);
	}

}
