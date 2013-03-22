package cti.rmopp.controls;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import cti.rmopp.model.RMOPP_Coordinates;
import cti.rmopp.utils.RMOPP_CoordinatesCalculator;

public class RMOPP_SwitchPanel extends JPanel implements RMOPP_BaseControl {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int width;
	private int height;
	private int rectW;
	private int rectH;
	private int rectX;
	private int rectY;
	private RMOPP_Coordinates cord;

	public RMOPP_SwitchPanel(int w, int h) {
		this.width = w;
		this.height = h;
		setOpaque(true);
		setBackground(Color.gray);
		setLayout(null);
		setAlignmentY(TOP_ALIGNMENT);
		cord = RMOPP_CoordinatesCalculator.getSwitchPanelCoordinates(width,
				height, 192);

		rectW = cord.BASEPANELWIDTH; // (int) (width * .65);
		rectH = cord.BASEPANELHEIGHT;// (int) (height * .25);
		rectX = cord.BASEPANELX;// (int) ((width / 2) - (rectW / 2));
		rectY = cord.BASEPANELY;// (int) ((height / 2) - (rectH / 2)) - 20;

		loadControls();
	}

	@Override
	public void loadControls() {

		loadInputPorts();
		loadOutputPorts();

	}

	private void loadInputPorts() {
		int tempX, tempY;
		tempX = rectX + (cord.PORTOFFSET / 3);
		tempY = rectY;
		int index = 1;
		for (int k = 0; k < 12; k++) {
			tempX = rectX + (cord.PORTOFFSET / 3);

			tempY = (rectY - (((k + 1) * cord.PORTLABELHEIGHT)))
					- ((k + 1) * 6);

			for (int i = 0; i < 16; i++) {
				RMOPP_PortLabel lbl = new RMOPP_PortLabel("" + index, tempX,
						tempY + 13, cord.PORTLABELWIDTH, cord.PORTLABELHEIGHT,
						RMOPP_PortLabel.PortType.INPUT);
				tempX += cord.PORTOFFSET;
				add(lbl);
				index++;
			}
		}

	}

	private void loadOutputPorts() {
		int tempX, tempY, recY;
		tempX = rectX + (cord.PORTOFFSET / 3);
		recY = cord.BASEPANELY + cord.BASEPANELHEIGHT;
		tempY = recY;
		int index = 193;
		for (int k = 0; k < 12; k++) {
			tempX = rectX + (cord.PORTOFFSET / 3);
			tempY = (recY + (((k + 1) * cord.PORTLABELHEIGHT))) + ((k + 1) * 6);

			for (int i = 16; i < 32; i++) {
				RMOPP_PortLabel lbl = new RMOPP_PortLabel("" + index, tempX,
						tempY-(cord.PORTLABELHEIGHT *2), cord.PORTLABELWIDTH, cord.PORTLABELHEIGHT,
						RMOPP_PortLabel.PortType.OUTPUT);
				tempX += cord.PORTOFFSET;
				add(lbl);
				index++;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		BufferedImage outter = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = outter.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.dispose();
		BufferedImage inner = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		g2d = inner.createGraphics();
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLACK);

		g2d.fillRoundRect(rectX, rectY, rectW, rectH, 20, 20);
		g2d.dispose();

		BufferedImage masked = applyMask(outter, inner, AlphaComposite.DST_OUT);
		g.drawImage(masked, 0, 0, this);

	}

	public BufferedImage applyMask(BufferedImage sourceImage,
			BufferedImage maskImage, int method) {
		BufferedImage maskedImage = null;
		if (sourceImage != null) {

			int width = maskImage.getWidth();
			int height = maskImage.getHeight();

			maskedImage = new BufferedImage(width, height,
					BufferedImage.TYPE_INT_ARGB);
			Graphics2D mg = maskedImage.createGraphics();

			int x = (width - sourceImage.getWidth()) / 2;
			int y = (height - sourceImage.getHeight()) / 2;

			mg.drawImage(sourceImage, x, y, null);
			mg.setComposite(AlphaComposite.getInstance(method));
			mg.drawImage(maskImage, 0, 0, null);
			mg.dispose();
		}

		return maskedImage;
	}

	public BufferedImage applyMask(BufferedImage sourceImage,
			BufferedImage maskImage) {
		return (BufferedImage) applyMask(sourceImage, maskImage,
				AlphaComposite.DST_IN);
	}

}
