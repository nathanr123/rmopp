package cti.rmopp.controls;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import cti.rmopp.utils.RMOPP_Utilitties;

public class RMOPP_PortLabel extends JLabel implements RMOPP_BaseControl,
		MouseListener {

	public enum PortType {
		INPUT, OUTPUT
	};

	private PortType portType;
	private static final long serialVersionUID = 1L;
	private int portRow;
	private RMOPP_SwitchPanel superPanel;

	public RMOPP_PortLabel(String text) {
		setText("<html>" + text + "<sub><font color='yellow'>" + text
				+ "</font></sub></html>");
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setBorder(new LineBorder(Color.white));
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
	}

	public RMOPP_PortLabel(RMOPP_SwitchPanel superPane, String text, int x,
			int y, int w, int h, int row, PortType type) {
		this.superPanel = superPane;
		portType = type;
		if (type == PortType.INPUT) {
			setText("<html>" + text + "<sub><font color='yellow'>" + text
					+ "</font></sub></html>");
		} else if (type == PortType.OUTPUT) {
			setText("<html><sup><font color='yellow'>" + text + "</font></sup>"
					+ text + "</html>");
		}
		portRow = row;
		setBounds(x, y, w, h);
		setHorizontalAlignment(JLabel.CENTER);
		setForeground(Color.red);
		setBorder(new LineBorder(Color.white));
		setOpaque(true);
		setBackground(Color.DARK_GRAY);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		addMouseListener(this);
	}

	public PortType getType() {
		return this.portType;
	}

	@Override
	public void loadControls() {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		setSize(getWidth() + 5, getHeight() + 5);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		setSize(getWidth() - 5, getHeight() - 5);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	/**
	 * @return the portRow
	 */
	public int getPortRow() {
		return portRow;
	}

	/**
	 * @param portRow the portRow to set
	 */
	public void setPortRow(int portRow) {
		this.portRow = portRow;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (portType == PortType.INPUT) {
			RMOPP_Utilitties.setInputPortSelected(true);
			RMOPP_Utilitties.setStartXY(new Point((getX() + (getWidth() / 2)),
					getY() + getHeight()));
		}

		if (portType == PortType.OUTPUT) {
			RMOPP_Utilitties.setInputPortSelected(false);
			RMOPP_Utilitties.setEndXY(new Point(getX() + (getWidth() / 2),
					getY()));
			RMOPP_Utilitties.setDrawFlag(true);
			superPanel.drawLine();
		}
	}

}
