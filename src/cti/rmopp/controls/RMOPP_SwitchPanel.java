package cti.rmopp.controls;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import cti.rmopp.model.RMOPP_Coordinates;
import cti.rmopp.utils.RMOPP_CoordinatesCalculator;
import cti.rmopp.utils.RMOPP_Utilitties;

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
	private RMOPP_PortLabel lbl[];
	private int index = 0;

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
		lbl = new RMOPP_PortLabel[384];
		loadInputPorts();
		loadOutputPorts();

	}

	private void loadInputPorts() {
		int tempX, tempY;
		tempX = rectX + (cord.PORTOFFSET / 3);
		tempY = rectY;

		for (int k = 0; k < 12; k++) {
			tempX = rectX + (cord.PORTOFFSET / 3);

			tempY = (rectY - (((k + 1) * cord.PORTLABELHEIGHT)))
					- ((k + 1) * 6);

			for (int i = 0; i < 16; i++) {
				lbl[index] = new RMOPP_PortLabel(this, "" + (index + 1), tempX,
						tempY + 13, cord.PORTLABELWIDTH, cord.PORTLABELHEIGHT,
						(k + 1), RMOPP_PortLabel.PortType.INPUT);
				tempX += cord.PORTOFFSET;
				add(lbl[index]);
				index++;
			}
		}

	}

	private void loadOutputPorts() {
		int tempX, tempY, recY;
		tempX = rectX + (cord.PORTOFFSET / 3);
		recY = cord.BASEPANELY + cord.BASEPANELHEIGHT;
		tempY = recY;
		for (int k = 0; k < 12; k++) {
			tempX = rectX + (cord.PORTOFFSET / 3);
			tempY = (recY + (((k + 1) * cord.PORTLABELHEIGHT))) + ((k + 1) * 6);

			for (int i = 0; i < 16; i++) {
				lbl[index] = new RMOPP_PortLabel(this, "" + (index + 1), tempX,
						tempY - (cord.PORTLABELHEIGHT * 2),
						cord.PORTLABELWIDTH, cord.PORTLABELHEIGHT, (k + 1),
						RMOPP_PortLabel.PortType.OUTPUT);
				tempX += cord.PORTOFFSET;
				add(lbl[index]);
				index++;
			}
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D gd1 = (Graphics2D) g;
		drawPort(gd1);
		if (RMOPP_Utilitties.isDrawFlag()) {
			Graphics2D gd = (Graphics2D) g;
			gd.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);
			gd.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL,
					RenderingHints.VALUE_STROKE_PURE);

			gd.setColor(new Color(0, 255, 0));
			int stx = RMOPP_Utilitties.getStartXY().x;
			int sty = RMOPP_Utilitties.getStartXY().y;
			int edx = RMOPP_Utilitties.getEndXY().x;
			int edy = RMOPP_Utilitties.getEndXY().y;

			GeneralPath path = new GeneralPath();
			path.moveTo(stx, sty);
			int diff = (edx - stx) / 2;
			path.curveTo((stx + diff), (sty), (edx - diff), (edy), edx, edy);
			gd.draw(path);

			gd.setColor(Color.ORANGE);
			gd.fillOval(stx - 7, sty - 8, 19, 19);

			gd.setColor(Color.RED);
			gd.fillOval(stx - 6, sty - 6, 15, 15);

			gd.setColor(Color.RED);
			gd.fillOval(edx - 7, edy - 8, 19, 19);

			gd.setColor(Color.ORANGE);
			gd.fillOval(edx - 6, edy - 6, 15, 15);

		}
		/*
		BufferedImage outter = new BufferedImage(getWidth(), getHeight(),
				BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2d = outter.createGraphics();
		drawPort(g2d);
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

		BufferedImage masked = applyMask(outter, inner, AlphaComposite.DST_OUT);
		g.drawImage(masked, 0, 0, this);

		g2d.dispose();*/

	}

	private void drawPort(Graphics2D g2d) {
		int portX = 0, portY = 0, portW = 0, portH = 0;
		for (int i = 0; i < lbl.length; i++) {

			if (lbl[i].getType() == RMOPP_PortLabel.PortType.INPUT) {
				if (lbl[i].getPortRow() == 1) {
					portX = lbl[i].getX() + ((lbl[i].getWidth() / 2) - 5);
					portY = lbl[i].getY() + lbl[i].getHeight();
					portW = 10;
					portH = 5;
				} else {
					portX = lbl[i].getX() + lbl[i].getWidth();
					portY = lbl[i].getY() + ((lbl[i].getHeight() / 2) - 5);
					portW = 5;
					portH = 10;
				}
			}

			if (lbl[i].getType() == RMOPP_PortLabel.PortType.OUTPUT) {
				if (lbl[i].getPortRow() == 1) {
					portX = lbl[i].getX() + ((lbl[i].getWidth() / 2) - 5);
					portY = lbl[i].getY() - 5;
					portW = 10;
					portH = 5;
				} else {
					portX = lbl[i].getX() + lbl[i].getWidth();
					portY = lbl[i].getY() + ((lbl[i].getHeight() / 2) - 5);
					portW = 5;
					portH = 10;
				}
			}
			g2d.setPaint(Color.RED);
			g2d.fillRect(portX, portY, portW, portH);
		}
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

	public void drawLine() {
		repaint();
	}
}
