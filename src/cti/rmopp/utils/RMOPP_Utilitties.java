package cti.rmopp.utils;

import java.awt.Dimension;
import java.awt.Toolkit;

import cti.rmopp.model.RMOPP_User;

public class RMOPP_Utilitties {

	private static double scrWidth;

	private static double scrHeight;
	
	private static RMOPP_User currentUser;

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
	 * @param currentUser the currentUser to set
	 */
	public static void setCurrentUser(RMOPP_User currentUser) {
		RMOPP_Utilitties.currentUser = currentUser;
	}
	
	
	
}
