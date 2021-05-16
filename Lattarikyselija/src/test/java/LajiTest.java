
import lattarikyselija.data.Laji;
import org.junit.Test;
import static org.junit.Assert.*;

public class LajiTest {
    
    public LajiTest() {
    }
    
    @Test
    public void EqualsPalauttaaTrueSamallaLajilla() {
        
        Laji ekaLaji = new Laji("Talitiainen", "Parus major", "Linnut");
        Laji tokaLaji = new Laji("Talitiainen", "Parus major", "Linnut");
        
        assertTrue(ekaLaji.equals(tokaLaji));
    }
    
    @Test
    public void lajinEqualsTestaaSuomalaistaNimea() {
        
        Laji ekaLaji = new Laji("Talitiainen", "Parus major", "Linnut");
        Laji tokaLaji = new Laji("Ihratiainen", "Parus major", "Linnut");
        
        assertFalse(ekaLaji.equals(tokaLaji));
    }
    
    @Test
    public void lajinEqualsTestaaLatinalaistaNimea() {
        //Sinäänsä synonyymit voisi lisätä toiminnallisuudeksi
        
        Laji ekaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Linnut");
        Laji tokaLaji = new Laji("Sinitiainen", "Cyanistes caeruleus", "Linnut");
        
        assertFalse(ekaLaji.equals(tokaLaji));
    }
    
    @Test
    public void lajinEqualsTestaaRyhmää() {
        Laji ekaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Linnut");
        Laji tokaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Varpuslinnut");
        
        assertFalse(ekaLaji.equals(tokaLaji));
    }
    
    @Test
    public void samallaLajillaSamaHash() {
        Laji ekaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Linnut");
        Laji tokaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Linnut");
        
        assertTrue(ekaLaji.hashCode() == tokaLaji.hashCode());
    }
    
    @Test
    public void eriLajellaEriHash() {
        Laji ekaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Linnut");
        Laji tokaLaji = new Laji("Kuusitiainen", "Periparus ater", "Linnut");
        
        assertFalse(ekaLaji.hashCode() == tokaLaji.hashCode());
    }
    
    @Test
    public void eriRyhmanLajeillaEriHash() {
        Laji ekaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Linnut");
        Laji tokaLaji = new Laji("Sinitiainen", "Parus caeruleus", "Varpuslinnut");
        
        assertFalse(ekaLaji.hashCode() == tokaLaji.hashCode());
    }
}
