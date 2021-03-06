package Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuariRegistrat implements Serializable {
	
	@Column
	private String nom;
	@Column
	private String cognom;
	
	private String username;
	
	@Column
	private String pwd;
	
	UsuariRegistrat(){}
	
	UsuariRegistrat(String uname){
		username=uname;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
		
	public String getCognom() {
		return cognom;
	}
	
	public void setCognom(String cognom) {
		this.cognom = cognom;
	}
	
	@Id
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public boolean passIncorrecte(String passwd) {
		return (passwd.equals(pwd));
	}

	public boolean esJugador() {
		return false;
	}

}
