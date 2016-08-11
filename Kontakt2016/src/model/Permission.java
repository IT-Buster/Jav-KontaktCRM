package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the permission database table.
 * 
 */
@Entity
@Table(name="permission")
@NamedQuery(name="Permission.findAll", query="SELECT p FROM Permission p")
public class Permission implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String name;

	//bi-directional many-to-one association to RolePerm
	@OneToMany(mappedBy="permission")
	private List<RolePerm> rolePerms;

	public Permission() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RolePerm> getRolePerms() {
		return this.rolePerms;
	}

	public void setRolePerms(List<RolePerm> rolePerms) {
		this.rolePerms = rolePerms;
	}

	public RolePerm addRolePerm(RolePerm rolePerm) {
		getRolePerms().add(rolePerm);
		rolePerm.setPermission(this);

		return rolePerm;
	}

	public RolePerm removeRolePerm(RolePerm rolePerm) {
		getRolePerms().remove(rolePerm);
		rolePerm.setPermission(null);

		return rolePerm;
	}

}