
package lattarikyselija.logiikka;

import java.util.List;
import lattarikyselija.data.Laji;
import lattarikyselija.data.LattariData;

/**
 * Sovelluslogiikasta vastaava luokka.
 */

public class LattariLogiikka {
    
    private LattariData data;
    private Laji nykyinenLaji;
    private Kieli nykyinenKieli;
    private String nykyinenRyhma;

    public LattariLogiikka(LattariData data) {
        this.data = data;
        
        // Asettaa aluksi ensimmäisen kielen, ryhman ja lajin.
        this.nykyinenKieli = Kieli.SUOMI;
        this.alkuRyhma();
        this.uusiLaji();
    }
    
    private void alkuRyhma() {
        
        this.nykyinenRyhma = (String) data.getRyhmat().get(0);
    }
    
    /**
     * Metodi vaihtaa nykyisen kyseltävän lajin satunnaiseen uuteen nykyisen ryhmän lajiin.
     */
    
    public void uusiLaji() {
        Laji vanha = nykyinenLaji;
        
        //ei ehkä paras tapa saada aina uusi laji mutta toimii aluksi
        while (true) {
            nykyinenLaji = data.getRandRyhmanLaji(this.nykyinenRyhma);
            
            if (!(nykyinenLaji.equals(vanha))) {
                break;
            }
        }
    }
    
    /**
     * Metodi vaihtaa nykyisen lajikyselyjen kielen.
     * 
     * @param vaihtoKieli kieli johon halutaan vaihtaa
     */
    
    public void vaihdaKieli(Kieli vaihtoKieli) {
        if (vaihtoKieli == Kieli.SUOMI) {
            nykyinenKieli = Kieli.SUOMI;
        }
        if (vaihtoKieli == Kieli.LATINA) {
            nykyinenKieli = Kieli.LATINA;
        }
    }
    
    /**
     * Metodi vaihtaa kyseltävän ryhmän.
     * 
     * @param ryhma ryhmä johon halutaan vaihtaa
     */
    
    public void vaihdaRyhma(String ryhma) {
        
        if (data.ryhmaOlemassa(ryhma)) {
            
            this.nykyinenRyhma = ryhma;
            this.uusiLaji();
        }
    }
    
    /**
     * Metodi palauttaa nykyistä lajia vastaavan kysymyksen.
     * 
     * @return lajikysymys
     */
    
    public String kysymys() {
        
        if (nykyinenKieli == Kieli.SUOMI) {
            return this.nykyinenLaji.getSnimi();
            
        } else {
            return this.nykyinenLaji.getLnimi();
        }
    }
    
    /**
     * Metodi palauttaa nykyisen lajin suomenkielisen ja latinakielisen nimen.
     * 
     * @return lajin nimipari
     */
    
    public String nimiMolemmat() {
        return nykyinenLaji.toString();
    }
    
     /**
     * Metodi kertoo onko annettu vastaus oikein.
     * 
     * @param vastaus
     * 
     * @return totuuarvo onko vastaus oikein
     */
    
    public boolean vertaa(String vastaus) {
        
        if (nykyinenKieli == Kieli.SUOMI) {
            return this.trimLower(this.nykyinenLaji.getLnimi())
                    .equals(this.trimLower(vastaus));
            
        } else {
            return this.trimLower(this.nykyinenLaji.getSnimi())
                    .equals(this.trimLower(vastaus));
        }
    }
    
    /**
     * Metodi palauttaa listan sovelluksen tuntemista ryhmistä.
     * 
     * @return lista ryhmistä
     */
    
    public List getRyhmat() {
        
        return data.getRyhmat();
    }
    
    /**
     * Metodi palauttaa nykyisen kyselykielen.
     * 
     * @return nykyinen kyselyjen kieli
     */
    
    public Kieli getKieli() {
        
        return this.nykyinenKieli;
    }
    
    /**
     * Metodi palauttaa nykyisen kyseltävän ryhmän.
     * 
     * @return nykyinen ryhmä
     */
    
    public String getRyhma() {
        
        return this.nykyinenRyhma;
    }
    
    private String trimLower(String sana) {
        
        return sana.trim().toLowerCase();
    }
            
}
