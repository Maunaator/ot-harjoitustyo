
import lattarikyselija.data.LattariData;
import lattarikyselija.logiikka.Kieli;
import lattarikyselija.logiikka.LattariLogiikka;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LattariTest {
    
    LattariLogiikka logiikka; 
    LattariData data;
        
    @Before
    public void setUp() {
        data = new LattariData();
        logiikka = new LattariLogiikka(data);
    }
    
    @Test
    public void logiikkaKostruktoriLataaAluksiLajin() {
        
        assertFalse(logiikka.nimiMolemmat().isEmpty());
    }
    
    @Test
    public void kieliOnAluksiSUOMI() {
        
        assertTrue(logiikka.getKieli() == Kieli.SUOMI);
    }
    
    @Test
    public void ryhmaOnAluksiLintu() {
        
        assertTrue(logiikka.getRyhma().equals("Lintu"));
    }
    
    @Test
    public void uusiLataaUudenLajin() {
        
        String vanha = logiikka.nimiMolemmat();
        logiikka.uusiLaji();
        
        assertFalse(logiikka.nimiMolemmat().equals(vanha));
    }
    
    @Test
    public void vaihdaKieliVaihtaaKielen() {

        Kieli vanha = logiikka.getKieli();
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        
        assertTrue(logiikka.getKieli() == Kieli.LATINA);
    }
    
    @Test
    public void ryhmanVaihtoVaihtaaNykyisenRyhman() {

        String vanha = logiikka.getRyhma();
        
        logiikka.vaihdaRyhma("Kasvi");
        
        assertTrue(logiikka.getRyhma().equals("Kasvi"));
    }
}
