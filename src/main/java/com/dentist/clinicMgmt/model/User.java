package com.dentist.clinicMgmt.model;

public class User {
	
	private long id;
	private long clinic_id;
	private String u_name;
	private String address;
	private long mob_no;
	
	public User(long id, long clinic_id, String u_name, String address, long mob_no) {
		super();
		this.id = id;
		this.clinic_id = clinic_id;
		this.u_name = u_name;
		this.address = address;
		this.mob_no = mob_no;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getClinic_id() {
		return clinic_id;
	}
	public void setClinic_id(long clinic_id) {
		this.clinic_id = clinic_id;
	}
	public String getU_name() {
		return u_name;
	}
	public void setU_name(String u_name) {
		this.u_name = u_name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMob_no() {
		return mob_no;
	}
	public void setMob_no(long mob_no) {
		this.mob_no = mob_no;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", clinic_id=" + clinic_id + ", u_name=" + u_name + ", address=" + address
				+ ", mob_no=" + mob_no + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + (int) (clinic_id ^ (clinic_id >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (int) (mob_no ^ (mob_no >>> 32));
		result = prime * result + ((u_name == null) ? 0 : u_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (clinic_id != other.clinic_id)
			return false;
		if (id != other.id)
			return false;
		if (mob_no != other.mob_no)
			return false;
		if (u_name == null) {
			if (other.u_name != null)
				return false;
		} else if (!u_name.equals(other.u_name))
			return false;
		return true;
	}
}
