package cti.rmopp.controls;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class RMOPP_PasswordChangeWindow extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RMOPP_PasswordChangeWindow dialog = new RMOPP_PasswordChangeWindow();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RMOPP_PasswordChangeWindow() {
		setUndecorated(true);
		setBounds(100, 100, 246, 150);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[86px][145px]", "[14px][20px][20px][20px]"));
		{
			JLabel lblChangePassword = new JLabel("Change Password");
			lblChangePassword.setFont(new Font("Tahoma", Font.BOLD, 13));
			contentPanel.add(lblChangePassword, "cell 0 0,alignx center,aligny center");
		}
		{
			JLabel lblNewLabel = new JLabel("Old Password");
			contentPanel.add(lblNewLabel, "cell 0 1,alignx trailing,aligny center");
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField, "cell 1 1,growx,aligny center");
		}
		{
			JLabel lblNewLabel_1 = new JLabel("New Password");
			contentPanel.add(lblNewLabel_1, "cell 0 2,alignx trailing,aligny center");
		}
		{
			passwordField_1 = new JPasswordField();
			contentPanel.add(passwordField_1, "cell 1 2,growx,aligny center");
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Confirm Password");
			contentPanel.add(lblNewLabel_2, "cell 0 3,alignx trailing,aligny center");
		}
		{
			passwordField_2 = new JPasswordField();
			contentPanel.add(passwordField_2, "cell 1 3,growx,aligny center");
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
