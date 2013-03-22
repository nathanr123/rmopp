package cti.rmopp.model;

import java.io.Serializable;

public class RMOPP_Coordinates  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int SCREENWIDTH;
	public int SCREENHEIGHT;
	
	public int PORTOFFSET;	
	public int PORTLABELWIDTH;
	public int PORTLABELHEIGHT;	
	public int BASEPANELWIDTH;
	public int BASEPANELHEIGHT;
	public int BASEPANELX;
	public int BASEPANELY;
	
	public int BAZIARCURVEXPOINT;
	
	public RMOPP_Coordinates() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param pORTOFFSET
	 * @param pORTLABELWIDTH
	 * @param pORTLABELHEIGHT
	 * @param bASEPANELWIDTH
	 * @param bASEPANELHEIGHT
	 * @param bASEPANELX
	 * @param bASEPANELY
	 */
	public RMOPP_Coordinates(int pORTOFFSET, int pORTLABELWIDTH,
			int pORTLABELHEIGHT, int bASEPANELWIDTH, int bASEPANELHEIGHT,
			int bASEPANELX, int bASEPANELY) {
		super();
		PORTOFFSET = pORTOFFSET;
		PORTLABELWIDTH = pORTLABELWIDTH;
		PORTLABELHEIGHT = pORTLABELHEIGHT;
		BASEPANELWIDTH = bASEPANELWIDTH;
		BASEPANELHEIGHT = bASEPANELHEIGHT;
		BASEPANELX = bASEPANELX;
		BASEPANELY = bASEPANELY;
	}

	
	
 
}
