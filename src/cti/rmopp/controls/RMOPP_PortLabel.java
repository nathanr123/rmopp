package cti.rmopp.controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class RMOPP_PortLabel extends JLabel implements RMOPP_BaseControl,MouseListener
{

	public enum PortType {
		INPUT, OUTPUT
	};

	private static final long serialVersionUID = 1L;

	public RMOPP_PortLabel(String text) {
		setText("<html>" + text + "<sub><font color='yellow'>" + text
				+ "</font></sub></html>");
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setBorder(new LineBorder(Color.white));
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
	}

	public RMOPP_PortLabel(String text, int x, int y, int w, int h,
			PortType type) {
		if (type == PortType.INPUT) {
			setText("<html>" + text + "<sub><font color='yellow'>" + text
					+ "</font></sub></html>");
		} else if (type == PortType.OUTPUT) {
			setText("<html><sup><font color='yellow'>" + text + "</font></sup>"
					+ text + "</html>");
		}
		setBounds(x, y, w, h);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setBorder(new LineBorder(Color.white));		
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);		
	}

	@Override
	public void loadControls() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setSize(getWidth()+5,getHeight()+5);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setSize(getWidth()-5,getHeight()-5);
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
