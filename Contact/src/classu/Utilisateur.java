package classu;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Date;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.servlet.http.HttpServletResponse;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;



@Entity
@Table(name="Utilisateur")
@ManagedBean
@RequestScoped
@SessionScoped
public class Utilisateur {

    public Utilisateur(int id) {
		super();
		this.id = id;
	}

	

    @Override
	public String toString() {
		return "Utilisateur [id=" + id + ", login=" + login + ", mdp=" + mdp + "]";
	}



	public Utilisateur() {
    }


    @Id @GeneratedValue
    private int id;
    

    private String login;
    private String mdp;
   
	public Utilisateur(String login, String mdp) {
		super();

		this.login = login;
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


  
  

			
}