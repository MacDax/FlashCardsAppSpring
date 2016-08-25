package com.sonal.flashcardapp.domain;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

public class FcUsers {
	@NotEmpty
	private String fname;
	private String lname;
	//@NotNull
	@NotEmpty
	private String email;
	private int userid;
	private List<FcDeck> dlist;
	
	public FcUsers() { }
	public FcUsers(String fname, String lname) {
		this.fname = fname;
		this.lname = lname;
		//dlist = new FcDeck();
	}
	
	public void setFname(String fn) { fname = fn; }
	public void setLname(String ln) { lname = ln; }
	public void setEmail(String uemail) { email = uemail; }
	
	public String getFname() { return fname; }
	public String getLname() { return lname; }
	public String getEmail() { return email; }
	public void setUserid(int userid) { this.userid = userid; }
	public int getUserid() { return userid; }
	public void setDlist(List<FcDeck> deck) { this.dlist = deck; }
	public List<FcDeck> getDlist() { return dlist; }
	
	public String toString() {
		return lname + ", " + fname;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fname == null) ? 0 : fname.hashCode());
		result = prime * result + ((lname == null) ? 0 : lname.hashCode());
		result = prime * result + userid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof FcUsers)) {
			return false;
		}
		FcUsers other = (FcUsers) obj;
		/*if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (fname == null) {
			if (other.fname != null) {
				return false;
			}
		} else if (!fname.equals(other.fname)) {
			return false;
		}
		if (lname == null) {
			if (other.lname != null) {
				return false;
			}
		} else if (!lname.equals(other.lname)) {
			return false;
		}*/
		if (userid != other.userid) {
			return false;
		}
		return true;
	}


	
	
}
