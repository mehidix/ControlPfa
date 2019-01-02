package controleur;

import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.jasper.tagplugins.jstl.Util;
import org.primefaces.model.UploadedFile;

import com.emsi.dao.Service;

import classu.Contact;
import classu.Utilisateur;

@ManagedBean(name="controleurLogin")
@RequestScoped
@SessionScoped
public class ControleurLogin implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Contact> contact  =new ArrayList<Contact>();
	public ArrayList<Contact> contact1  =new ArrayList<Contact>();
	public UploadedFile file;
	private String login;
	private String mdpass;




	public String getMdpass() {
		return mdpass;
	}

	public void setMdpass(String mdpass) {
		this.mdpass = mdpass;
	}

	public String login() {
		Service<Utilisateur> service =new Service<Utilisateur>();
		Utilisateur us =service.Find(login,mdpass, "Utilisateur", "login", "mdp");
		System.out.println(login+mdpass);
		System.out.println(us);
		if(us!=null) 
		{
			System.out.println(us);
			 FacesMessage message = new FacesMessage("Succesful"," Connected");
	            FacesContext.getCurrentInstance().addMessage(null, message);
	            System.out.println("jhjhdg");
			return "login";
		}
		 FacesMessage message = new FacesMessage("Unsuccesful"," Not Connected");
         FacesContext.getCurrentInstance().addMessage(null, message);
		
		return "index.xhtml";
	}

	public void upload() {
        if(file != null) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
        List<String> p=classu.Util.bytesToStringList(file.getContents());
        Service<Contact> ser=new Service<Contact>();
        for(String l: p) {
			l=l.replace("\"", "");
			String r[]=l.split(",");
		    String nom=r[0];
		    String tel=r[1];
		    String mail=r[2];
		    Contact co=new Contact(nom, tel, mail);
		    ser.InsertUser(co);
		    contact1.add(co);
		    init();
		}
    }
	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	@PostConstruct
	public void init() {
		this.listC();
		
	}
	
	public void listC() {
		
		Service<Contact> ser=new Service<Contact>();
		contact=ser.FindALL("Contact");
		 
	}
	
	
	
	
	
	
	
	
	
	
	public ArrayList<Contact> getContact() {
		return contact;
	}
	public void setContact(ArrayList<Contact> contact) {
		this.contact = contact;
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
	public String mdp;
	
}
