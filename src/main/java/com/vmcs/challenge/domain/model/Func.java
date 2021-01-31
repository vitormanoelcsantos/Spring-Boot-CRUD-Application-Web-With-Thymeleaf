package com.vmcs.challenge.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
/*import javax.validation.constraints.Email;*/
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Func {	
	
	@Id		
	@Column(name = "cpf")
	private String cpf;	
	
	@Size(max = 65)
	@NotBlank	
	@Column(name = "name")	
	private String name;

	@Size(max = 65)
	@NotBlank
	@Column(name = "breakfast")
	private String breakfast;

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(String breakfast) {
		this.breakfast = breakfast;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
		Func other = (Func) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}
	
	
	
	
	/*
	 * @Size(max = 255)
	 * 
	 * @NotBlank
	 * 
	 * @Email
	 * 
	 * @Column(name = "emailclient") private String emailClient;
	 * 
	 * @Size(max = 20)
	 * 
	 * @NotBlank
	 * 
	 * @Column(name = "phoneclient") private String phoneClient;
	 */
	
	
	
	
}
