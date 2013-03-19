/**
 * 
 */
package cti.rmopp.client;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import cti.rmopp.model.RMOPP_Group;
import cti.rmopp.model.RMOPP_User;
import cti.rmopp.utils.RMOPP_Utilitties.GroupLevel;

/**
 * @author nathanr_kamal
 * 
 */
public class RMOPP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		JFrame.setDefaultLookAndFeelDecorated(true);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				try {
					//UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
					RMOPP_User user = new RMOPP_User();
					user.setUsername("admin");
					user.setUserID("USRID01");
					user.setGroup(new RMOPP_Group("admin", "GRPID01",
							GroupLevel.ADMIN));
					new RMOPP_ClientFrame(user);

				} catch (Exception ex) {

					Logger.getLogger(RMOPP.class.getName()).log(Level.SEVERE,
							null, ex);
				}
			}
		});

	}

}
