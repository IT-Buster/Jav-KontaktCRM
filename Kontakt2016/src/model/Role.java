package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
@Table(name="role")
@NamedQuery(name="Role.findAll", query="SELECT r FROM Role r")
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private byte id;

	private String name;

	//bi-directional many-to-one association to RolePerm
	@OneToMany(mappedBy="role")
	private List<RolePerm> rolePerms;

	//bi-directional many-to-one association to UserRole
	@OneToMany(mappedBy="role")
	private List<UserRole> userRoles;

	public Role() {
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

	public List<RolePerm> getRolePerms() {
		return this.rolePerms;
	}

	public void setRolePerms(List<RolePerm> rolePerms) {
		this.rolePerms = rolePerms;
	}

	public RolePerm addRolePerm(RolePerm rolePerm) {
		getRolePerms().add(rolePerm);
		rolePerm.setRole(this);

		return rolePerm;
	}

	public RolePerm removeRolePerm(RolePerm rolePerm) {
		getRolePerms().remove(rolePerm);
		rolePerm.setRole(null);

		return rolePerm;
	}

	public List<UserRole> getUserRoles() {
		return this.userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRole addUserRole(UserRole userRole) {
		getUserRoles().add(userRole);
		userRole.setRole(this);

		return userRole;
	}

	public UserRole removeUserRole(UserRole userRole) {
		getUserRoles().remove(userRole);
		userRole.setRole(null);

		return userRole;
	}

}