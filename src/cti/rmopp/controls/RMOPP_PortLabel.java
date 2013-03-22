package cti.rmopp.controls;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class RMOPP_PortLabel extends JLabel implements RMOPP_BaseControl {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RMOPP_PortLabel(String text) {
		setText(text);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setBorder(new LineBorder(Color.white));
		setOpaque(true);
		setBackground(Color.DARK_GRAY);		
	}
	@Override
	public void loadControls() {
		// TODO Auto-generated method stub

	}

}
