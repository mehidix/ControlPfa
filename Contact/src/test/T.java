package test;



import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;

import classu.Contact;
import classu.Utilisateur;
import org.apache.log4j.Logger;

import com.emsi.dao.Service;

public class T {
    final static Logger logger=Logger.getLogger(T.class);
	public static void main(String[] args) {
		// application/vnd.ms-excel
	
		Service<Contact> c=new Service<Contact>();
		c.InsertUser(new Contact("Mehdi", "066997090", "mehdi@gmail.com"));
		List<String> p;
		try {
			p = Files.readAllLines(Paths.get("C:\\Users\\User\\Desktop\\contact.csv"));
			for(String l: p) {
				l=l.replace("\"", "");
				String r[]=l.split(",");
			    System.out.println(r[0]);
			}
			logger.info("Fichier et Telecharger");
			logger.fatal("this is csv ");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("this is Erreur From Test Class");
		}
		
			
			
	}
}
			
			
			
			
			
			
			
			
			