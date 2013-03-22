package cti.rmopp.utils;

import cti.rmopp.model.RMOPP_Coordinates;

public class RMOPP_CoordinatesCalculator {

	private static int scr_Width;
	private static int scr_Height;
	
	public RMOPP_CoordinatesCalculator() {
	}

	public static void setScr_Height(int scr_Height) {
		RMOPP_CoordinatesCalculator.scr_Height = scr_Height;
	}

	public void setScr_Width(int scr_Width) {
		RMOPP_CoordinatesCalculator.scr_Width = scr_Width;
	}

	public static RMOPP_Coordinates getSwitchPanelCoordinates(int scrW, int scrH) {

		scr_Width = scrW;
		scr_Height = scrH;
		return getSwitchPanelCoordinates();
	}

	public static RMOPP_Coordinates getSwitchPanelCoordinates(int scrW, int scrH,int noPorts) {

		scr_Width = scrW;
		scr_Height = scrH;
		
		return getSwitchPanelCoordinates();
	}
	public static RMOPP_Coordinates getSwitchPanelCoordinates() {

		int rectW = (int) (scr_Width * .65); // panel width
		int rectH = (int) (scr_Height * .25); // panel height

		int rectX = (int) ((scr_Width / 2) - (rectW / 2)); // panel x
		int rectY = (int) ((scr_Height / 2) - (rectH / 2)) - 20; // panel y

		int portlblW = (int) rectW / 32;
		int portlblH = (int) rectY / 15 ;
		int portOffset = portlblW * 2;

		return new RMOPP_Coordinates(portOffset, portlblW, portlblH, rectW,
				rectH, rectX, rectY);
	}
}
