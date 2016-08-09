package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the contact database table.
 * 
 */
@Entity
@Table(name="contact")
@NamedQuery(name="Contact.findAll", query="SELECT c FROM Contact c")
public class Contact implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	private String businessphone;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Lob
	private String desc;

	private String email;

	private String firstname;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_event_date")
	private Date lastEventDate;

	@Column(name="last_event_type")
	private byte lastEventType;

	private String lastname;

	private String mobilephone1;

	private String mobilephone2;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	private String office;

	//bi-directional many-to-one association to CustType
	@ManyToOne
	@JoinColumn(name="type_id")
	private CustType custType;

	//bi-directional many-to-one association to Customer
	@ManyToOne
	@JoinColumn(name="cust_id")
	private Customer customer;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="guardian")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user2;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user3;

	//bi-directional many-to-many association to User
	@ManyToMany
	@JoinTable(
		name="guard_cust"
		, joinColumns={
			@JoinColumn(name="contact_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="user_id")
			}
		)
	private List<User> users;

	public Contact() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBusinessphone() {
		return this.businessphone;
	}

	public void setBusinessphone(String businessphone) {
		this.businessphone = businessphone;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public Date getLastEventDate() {
		return this.lastEventDate;
	}

	public void setLastEventDate(Date lastEventDate) {
		this.lastEventDate = lastEventDate;
	}

	public byte getLastEventType() {
		return this.lastEventType;
	}

	public void setLastEventType(byte lastEventType) {
		this.lastEventType = lastEventType;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMobilephone1() {
		return this.mobilephone1;
	}

	public void setMobilephone1(String mobilephone1) {
		this.mobilephone1 = mobilephone1;
	}

	public String getMobilephone2() {
		return this.mobilephone2;
	}

	public void setMobilephone2(String mobilephone2) {
		this.mobilephone2 = mobilephone2;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getOffice() {
		return this.office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public CustType getCustType() {
		return this.custType;
	}

	public void setCustType(CustType custType) {
		this.custType = custType;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public User getUser3() {
		return this.user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}