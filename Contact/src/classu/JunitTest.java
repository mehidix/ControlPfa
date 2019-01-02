package classu;

import org.junit.Test;

import controleur.ControleurLogin;
import junit.framework.Assert;
import junit.framework.TestCase;

public class JunitTest extends TestCase {
	
	@Test
	public void test() {
		Calculer c=new Calculer();
		assertEquals(c.somme(1, 2),3);
		ControleurLogin cl=new ControleurLogin();
		assertEquals(cl.login(), "index.xhtml");
	
	}

}
