package cti.rmopp.model;

import java.io.Serializable;

public class RMOPP_User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String userID;
	private RMOPP_Group group;

	public RMOPP_User() {
	}

	/**
	 * @param username
	 * @param group
	 */
	public RMOPP_User(String username, RMOPP_Group group) {
		super();
		this.username = username;
		this.group = group;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID
	 *            the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the group
	 */
	public RMOPP_Group getGroup() {
		return group;
	}

	/**
	 * @param group
	 *            the group to set
	 */
	public void setGroup(RMOPP_Group group) {
		this.group = group;
	}

}
