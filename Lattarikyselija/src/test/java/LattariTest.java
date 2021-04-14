
import lattarikyselija.data.LattariData;
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
    public void uusiLataaUudenLajin() {
        
        String vanha = logiikka.nimiMolemmat();
        logiikka.uusiLaji();
        
        assertFalse(logiikka.nimiMolemmat().equals(vanha));
    }
}
