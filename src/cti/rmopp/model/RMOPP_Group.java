package cti.rmopp.model;

import java.io.Serializable;

import cti.rmopp.utils.RMOPP_Utilitties.GroupLevel;

public class RMOPP_Group implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String groupName;
	private String groupID;
	private GroupLevel groupLevel;

	public RMOPP_Group() {

	}

	/**
	 * @param groupName
	 * @param groupLevel
	 */
	public RMOPP_Group(String groupName, GroupLevel groupLevel) {
		super();
		this.groupName = groupName;
		this.groupLevel = groupLevel;
	}

	/**
	 * @param groupName
	 * @param groupID
	 * @param groupLevel
	 */
	public RMOPP_Group(String groupName, String groupID, GroupLevel groupLevel) {
		super();
		this.groupName = groupName;
		this.groupID = groupID;
		this.groupLevel = groupLevel;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the groupID
	 */
	public String getGroupID() {
		return groupID;
	}

	/**
	 * @param groupID
	 *            the groupID to set
	 */
	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}

	/**
	 * @return the groupLevel
	 */
	public GroupLevel getGroupLevel() {
		return groupLevel;
	}

	/**
	 * @param groupLevel
	 *            the groupLevel to set
	 */
	public void setGroupLevel(GroupLevel groupLevel) {
		this.groupLevel = groupLevel;
	}

}
