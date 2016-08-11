package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_perm database table.
 * 
 */
@Entity
@Table(name="role_perm")
@NamedQuery(name="RolePerm.findAll", query="SELECT r FROM RolePerm r")
public class RolePerm implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private int access;

	//bi-directional many-to-one association to Permission
	@ManyToOne
	@JoinColumn(name="perm_id")
	private Permission permission;

	//bi-directional many-to-one association to Role
	@ManyToOne
	private Role role;

	public RolePerm() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccess() {
		return this.access;
	}

	public void setAccess(int access) {
		this.access = access;
	}

	public Permission getPermission() {
		return this.permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}