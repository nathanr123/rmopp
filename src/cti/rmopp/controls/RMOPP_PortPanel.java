package cti.rmopp.controls;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Font;

public class RMOPP_PortPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public RMOPP_PortPanel(String text,int w,int h) {
		setBackground(Color.GRAY);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel(text);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setForeground(Color.PINK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		int lW = (int) (w *.10);
		lblNewLabel.setBounds(w/2, h/2, lW, lW);
		add(lblNewLabel);
		
		/*JLabel label = new JLabel("17");
		label.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		label.setForeground(Color.YELLOW);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(87, 90, 37, 29);
		add(label);*/

	}
}
