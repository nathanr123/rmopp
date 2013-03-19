package cti.rmopp.controls;

import java.awt.FlowLayout;

import javax.swing.*;

public class RMOPP_StatusBar extends JPanel implements RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel statusLabel;

	public RMOPP_StatusBar() {
		setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		loadControls();
	}

	public String getStatus() {
		return statusLabel.getText().trim();
	}

	public void setStatus(String status) {
		statusLabel.setText(status);
	}

	@Override
	public void loadControls() {
		statusLabel = new JLabel("status");
		add(statusLabel);

	}
}
