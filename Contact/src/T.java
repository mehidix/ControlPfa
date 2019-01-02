



import java.io.IOException;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.util.List;

import org.apache.log4j.Logger;

public class T {
    final static Logger logger=Logger.getLogger(T.class);
	public static void main(String[] args) {
		// application/vnd.ms-excel
		List<String> p;
		try {
			p = Files.readAllLines(Paths.get("src\\contact (4).csv"));
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
			
			
			
			
			
			
			
			
			