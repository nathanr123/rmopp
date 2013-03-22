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

	public RMOPP_SwitchPanel(int w, int h) {
		this.width = w;
		this.height = h;
		setOpaque(true);
		setBackground(Color.gray);
		setLayout(null);

		rectW = (int) (width * .65);
		rectH = (int) (height * .25);

		rectX = (int) ((width / 2) - (rectW / 2));
		rectY = (int) ((height / 2) - (rectH / 2)) - 20;

		loadControls();
	}

	@Override
	public void loadControls() {
		int tempX = rectX + 25;
		for (int i = 0; i < 16; i++) {
			System.out.println(tempX);
			RMOPP_PortLabel lbl = new RMOPP_PortLabel("" + (i + 1));
			lbl.setBounds(tempX, rectY - 12, 25, 25);
			tempX += 50;
			add(lbl);
		}
		tempX = rectX+25 ;
		int tempY = rectY + rectH;
		for (int i = 16; i < 32; i++) {
			System.out.println(tempX);
			RMOPP_PortLabel lbl = new RMOPP_PortLabel("" + (i + 1));
			lbl.setBounds(tempX, tempY-12, 25, 25);
			tempX += 50;
			add(lbl);
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
