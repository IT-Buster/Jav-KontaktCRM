package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cust_type database table.
 * 
 */
@Entity
@Table(name="cust_type")
@NamedQuery(name="CustType.findAll", query="SELECT c FROM CustType c")
public class CustType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte id;

	private String name;

	//bi-directional many-to-one association to Contact
	@OneToMany(mappedBy="custType")
	private List<Contact> contacts;

	//bi-directional many-to-one association to Customer
	@OneToMany(mappedBy="custType")
	private List<Customer> customers;

	public CustType() {
	}

	public byte getId() {
		return this.id;
	}

	public void setId(byte id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Contact> getContacts() {
		return this.contacts;
	}

	public void setContacts(List<Contact> contacts) {
		this.contacts = contacts;
	}

	public Contact addContact(Contact contact) {
		getContacts().add(contact);
		contact.setCustType(this);

		return contact;
	}

	public Contact removeContact(Contact contact) {
		getContacts().remove(contact);
		contact.setCustType(null);

		return contact;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setCustType(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setCustType(null);

		return customer;
	}

}