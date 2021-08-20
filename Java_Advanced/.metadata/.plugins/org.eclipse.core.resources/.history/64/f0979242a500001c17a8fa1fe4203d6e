package com.vti.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the group database table.
 * 
 */
@Entity
@Table(name="group")
@NamedQuery(name="Group.findAll", query="SELECT g FROM Group g")
public class Group implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private byte groupID;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;

	@Column(nullable=false)
	private byte creatorID;

	@Column(nullable=false, length=50)
	private String groupName;

	//bi-directional many-to-one association to Groupaccount
	@OneToMany(mappedBy="group")
	private List<Groupaccount> groupaccounts;

	public Group() {
	}

	public byte getGroupID() {
		return this.groupID;
	}

	public void setGroupID(byte groupID) {
		this.groupID = groupID;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public byte getCreatorID() {
		return this.creatorID;
	}

	public void setCreatorID(byte creatorID) {
		this.creatorID = creatorID;
	}

	public String getGroupName() {
		return this.groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<Groupaccount> getGroupaccounts() {
		return this.groupaccounts;
	}

	public void setGroupaccounts(List<Groupaccount> groupaccounts) {
		this.groupaccounts = groupaccounts;
	}

	public Groupaccount addGroupaccount(Groupaccount groupaccount) {
		getGroupaccounts().add(groupaccount);
		groupaccount.setGroup(this);

		return groupaccount;
	}

	public Groupaccount removeGroupaccount(Groupaccount groupaccount) {
		getGroupaccounts().remove(groupaccount);
		groupaccount.setGroup(null);

		return groupaccount;
	}

}