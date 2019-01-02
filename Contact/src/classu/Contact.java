package classu;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact")
@ManagedBean
@RequestScoped
@SessionScoped
public class Contact implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Contact() {
		super();
	}

	@Id
	@GeneratedValue
	private int id;
	private String nomPrenom;
	private String telephone;
	private String mail;

	public Contact(String nomPrenom, String telephone, String mail) {
		super();
		this.nomPrenom = nomPrenom;
		this.telephone = telephone;
		this.mail = mail;
	}

	public Contact(int id, String nomPrenom, String telephone, String mail) {
		super();
		this.id = id;
		this.nomPrenom = nomPrenom;
		this.telephone = telephone;
		this.mail = mail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomPrenom() {
		return nomPrenom;
	}

	public void setNomPrenom(String nomPrenom) {
		this.nomPrenom = nomPrenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", nomPrenom=" + nomPrenom + ", telephone=" + telephone + ", mail=" + mail + "]";
	}

}
