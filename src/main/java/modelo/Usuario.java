package modelo;


import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Usuario {
	
	
    
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
  //Considerar o ID quando quando convertido em JSON(SEREALIZAÇÃO) || Desconsiderar o ID quando convertido em Objeto(DESEREALIZAÇÃO)    
   @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)    
   //@JsonProperty(access = JsonProperty.Access.READ_ONLY)
   private Long id;
    
    
	public Usuario(Long id, String email, String first_name, String last_name, String avatar) {
		super();
		this.id = id;
		this.email = email;
		this.first_name = first_name;
		this.last_name = last_name;
		this.avatar = avatar;
	}		
	
	public Usuario() {
		
	}

    //Getters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getFirst_name() { return first_name; }
    public String getLast_name() { return last_name; }
    public String getAvatar() { return avatar; }
        
        
	public void setEmail(String email) { this.email = email;}
	public void setFirst_name(String first_name) {this.first_name = first_name;}
	public void setLast_name(String last_name) {this.last_name = last_name;}
	public void setAvatar(String avatar) {this.avatar = avatar;}
	public void setId(Long id) {this.id = id;}
	
	
	
	//CRIAR METOSOS BIELD	
	public Usuario email(String email) {
		
		 this.email = email;
		return this;
	}
	
	
	public Usuario first_name(String first_name) {
		
		this.first_name = first_name;
		return this;
	}
	
	public Usuario last_name(String last_name) {
		
		this.last_name = last_name;
		return this;
	}
	
	public Usuario avatar(String avatar) {
		
		this.avatar = avatar;
		return this;
	}
	
	
	

	@Override
	public int hashCode() {
		return Objects.hash(avatar, email, first_name, id, last_name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(avatar, other.avatar) && Objects.equals(email, other.email)
				&& Objects.equals(first_name, other.first_name) && Objects.equals(id, other.id)
				&& Objects.equals(last_name, other.last_name);
	}

	@Override
	public String toString() {
		return "Usuario "
		+ "{id=" + id + ", "
		+ "email=" + email + ", "
		+ "first_name=" + first_name + ", "
		+ "last_name=" + last_name + ", "
		+ "avatar="	+ avatar + "]";			
		

	}
    
    
}