package cti.rmopp.utils;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;

import cti.rmopp.model.RMOPP_User;

public class RMOPP_Utilitties {

	private static double scrWidth;

	private static double scrHeight;

	private static RMOPP_User currentUser;

	private static boolean isInputPortSelected = false;

	private static Point startXY, endXY;

	private static boolean drawFlag = false;

	public enum Nagigation {

		HOME, USER, SWITCHES, SETTINGS, LOGOUT
	}

	public enum GroupLevel {

		ADMIN, SUPERUSER, OPERATOR, PROVISSIONAL, GUEST
	}

	public static void setScreenSize(double w, double h) {

		scrWidth = w;

		scrHeight = h;
	}

	public static void setScreenSize(Dimension d) {

		scrWidth = d.getWidth();

		scrHeight = d.getHeight();
	}

	public static Dimension getScreenSize() {

		return new Dimension((int) scrWidth, (int) scrHeight);
	}

	public static Dimension getScreenResolution() {

		return Toolkit.getDefaultToolkit().getScreenSize();
	}

	public static double getScreenWidth() {

		return scrWidth;
	}

	public static double getScreenHeight() {

		return scrHeight;
	}

	/**
	 * @return the currentUser
	 */
	public static RMOPP_User getCurrentUser() {
		return currentUser;
	}

	/**
	 * @param currentUser
	 *            the currentUser to set
	 */
	public static void setCurrentUser(RMOPP_User currentUser) {
		RMOPP_Utilitties.currentUser = currentUser;
	}

	/**
	 * @return the isInputPortSelected
	 */
	public static boolean isInputPortSelected() {
		return isInputPortSelected;
	}

	/**
	 * @param isInputPortSelected
	 *            the isInputPortSelected to set
	 */
	public static void setInputPortSelected(boolean isInputPortSelected) {
		RMOPP_Utilitties.isInputPortSelected = isInputPortSelected;
	}

	/**
	 * @return the startXY
	 */
	public static Point getStartXY() {
		return startXY;
	}

	/**
	 * @param startXY
	 *            the startXY to set
	 */
	public static void setStartXY(Point startXY) {
		RMOPP_Utilitties.startXY = startXY;
	}

	/**
	 * @return the endXY
	 */
	public static Point getEndXY() {
		return endXY;
	}

	/**
	 * @param endXY
	 *            the endXY to set
	 */
	public static void setEndXY(Point endXY) {
		RMOPP_Utilitties.endXY = endXY;
	}

	/**
	 * @return the drawFlag
	 */
	public static boolean isDrawFlag() {
		return drawFlag;
	}

	/**
	 * @param drawFlag
	 *            the drawFlag to set
	 */
	public static void setDrawFlag(boolean drawFlag) {
		RMOPP_Utilitties.drawFlag = drawFlag;
	}

}
