
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
        
        assertFalse(logiikka.lajiMolemmatNimet().isEmpty());
    }
    
    @Test
    public void uusiLataaUudenLajin() {
        
        String vanha = logiikka.lajiMolemmatNimet();
        logiikka.uusi();
        
        assertFalse(logiikka.lajiMolemmatNimet().equals(vanha));
    }
}
