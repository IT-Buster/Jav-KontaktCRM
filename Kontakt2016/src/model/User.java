package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@Table(name="user")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="create_date")
	private Date createDate;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_login")
	private Date lastLogin;

	private String login;

	private String name;

	private String password;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user1")
	private List<Contact> contacts1;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user2")
	private List<Contact> contacts2;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="user3")
	private List<Contact> contacts3;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user1")
	private List<Customer> customers1;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="user2")
	private List<Customer> customers2;

	//bi-directional many-to-one association to Event
	@OneToMany(mappedBy="user")
	private List<Event> events;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getLastLogin() {
		return this.lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Contact> getContacts1() {
		return this.contacts1;
	}

	public void setContacts1(List<Contact> contacts1) {
		this.contacts1 = contacts1;
	}

	public Contact addContacts1(Contact contacts1) {
		getContacts1().add(contacts1);
		contacts1.setUser1(this);

		return contacts1;
	}

	public Contact removeContacts1(Contact contacts1) {
		getContacts1().remove(contacts1);
		contacts1.setUser1(null);

		return contacts1;
	}

	public List<Contact> getContacts2() {
		return this.contacts2;
	}

	public void setContacts2(List<Contact> contacts2) {
		this.contacts2 = contacts2;
	}

	public Contact addContacts2(Contact contacts2) {
		getContacts2().add(contacts2);
		contacts2.setUser2(this);

		return contacts2;
	}

	public Contact removeContacts2(Contact contacts2) {
		getContacts2().remove(contacts2);
		contacts2.setUser2(null);

		return contacts2;
	}

	public List<Contact> getContacts3() {
		return this.contacts3;
	}

	public void setContacts3(List<Contact> contacts3) {
		this.contacts3 = contacts3;
	}

	public Contact addContacts3(Contact contacts3) {
		getContacts3().add(contacts3);
		contacts3.setUser3(this);

		return contacts3;
	}

	public Contact removeContacts3(Contact contacts3) {
		getContacts3().remove(contacts3);
		contacts3.setUser3(null);

		return contacts3;
	}

	public List<Customer> getCustomers1() {
		return this.customers1;
	}

	public void setCustomers1(List<Customer> customers1) {
		this.customers1 = customers1;
	}

	public Customer addCustomers1(Customer customers1) {
		getCustomers1().add(customers1);
		customers1.setUser1(this);

		return customers1;
	}

	public Customer removeCustomers1(Customer customers1) {
		getCustomers1().remove(customers1);
		customers1.setUser1(null);

		return customers1;
	}

	public List<Customer> getCustomers2() {
		return this.customers2;
	}

	public void setCustomers2(List<Customer> customers2) {
		this.customers2 = customers2;
	}

	public Customer addCustomers2(Customer customers2) {
		getCustomers2().add(customers2);
		customers2.setUser2(this);

		return customers2;
	}

	public Customer removeCustomers2(Customer customers2) {
		getCustomers2().remove(customers2);
		customers2.setUser2(null);

		return customers2;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public Event addEvent(Event event) {
		getEvents().add(event);
		event.setUser(this);

		return event;
	}

	public Event removeEvent(Event event) {
		getEvents().remove(event);
		event.setUser(null);

		return event;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setUser(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setUser(null);

		return userRole;
	}

}