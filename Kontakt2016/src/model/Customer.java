package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@NamedQuery(name="Customer.findAll", query="SELECT c FROM Customer c")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	private String desc;

	private String domain;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="modify_date")
	private Date modifyDate;

	private String name;

	private String nip;

	private String regon;

	@Column(name="web_page")
	private String webPage;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="customer")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="trade_id")
	private Category category;

	//bi-directional many-to-one association to CustType
	@ManyToOne
	@JoinColumn(name="type_id")
	private CustType custType;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="created_by")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="modified_by")
	private User user2;

	public Customer() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Date getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNip() {
		return this.nip;
	}

	public void setNip(String nip) {
		this.nip = nip;
	}

	public String getRegon() {
		return this.regon;
	}

	public void setRegon(String regon) {
		this.regon = regon;
	}

	public String getWebPage() {
		return this.webPage;
	}

	public void setWebPage(String webPage) {
		this.webPage = webPage;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setCustomer(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setCustomer(null);

		return contact;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public CustType getCustType() {
		return this.custType;
	}

	public void setCustType(CustType custType) {
		this.custType = custType;
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

}