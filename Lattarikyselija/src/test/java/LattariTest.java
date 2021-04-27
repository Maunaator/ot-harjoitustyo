
import lattarikyselija.data.Laji;
import lattarikyselija.data.LattariData;
import lattarikyselija.logiikka.Kieli;
import lattarikyselija.logiikka.LattariLogiikka;
import org.junit.Before;
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
    public void logiikkaKonstruktoriLataaAluksiRyhman() {
        
        assertFalse(logiikka.getRyhma().isEmpty());
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
        
        logiikka.vaihdaRyhma("Linnut");
        
        String vanha = logiikka.getRyhma();
        
        logiikka.vaihdaRyhma("Kasvit");
        
        assertTrue(logiikka.getRyhma().equals("Kasvit") & (vanha.equals("Linnut")));
        
        //käytännössä tupla assert testissä, en oikein keksinyt miten muuten testata
    }
    
    @Test
    public void vertaaPalauttaaTrueOikeallaVastauksella() {
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        String kysymys = logiikka.kysymys();
        
        logiikka.vaihdaKieli(Kieli.SUOMI);
        String vastaus = logiikka.kysymys();
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        
        assertTrue(logiikka.vertaa(vastaus));
    }
    
    @Test
    public void vertaaPalauttaaFalseVäärälläVastauksella() {
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        String kysymys = logiikka.kysymys();
        
        assertFalse(logiikka.vertaa("dsgsg"));
    }
    
    @Test
    public void vertaaEiVälitäKirjainkoosta() {
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        String kysymys = logiikka.kysymys();
        
        logiikka.vaihdaKieli(Kieli.SUOMI);
        String vastaus = logiikka.kysymys();
        
        vastaus = vastaus.toLowerCase();
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        
        assertTrue(logiikka.vertaa(vastaus));
    }
    
    @Test
    public void vertaaEiVälitäEdeltavistaTaiSeuraavistaValilyönneista() {
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        String kysymys = logiikka.kysymys();
        
        logiikka.vaihdaKieli(Kieli.SUOMI);
        String vastaus = logiikka.kysymys();
        
        vastaus = "  " + vastaus + "   ";
        
        logiikka.vaihdaKieli(Kieli.LATINA);
        
        assertTrue(logiikka.vertaa(vastaus));
    }
    
    @Test
    public void nykyinenRyhmaLöytyyGetRyhmatPalauttamaltaListalta() {
        
        assertTrue(logiikka.getRyhmat().contains(logiikka.getRyhma()));
        
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
}
