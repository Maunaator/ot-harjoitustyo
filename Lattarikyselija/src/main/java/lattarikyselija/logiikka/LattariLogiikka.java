
package lattarikyselija.logiikka;

import java.util.List;
import lattarikyselija.data.Laji;
import lattarikyselija.data.LattariData;

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
    
    public void vaihdaKieli(Kieli vaihtoKieli) {
        if (vaihtoKieli == Kieli.SUOMI) {
            nykyinenKieli = Kieli.SUOMI;
        }
        if (vaihtoKieli == Kieli.LATINA) {
            nykyinenKieli = Kieli.LATINA;
        }
    }
    
    public void vaihdaRyhma(String ryhma) {
        
        if (data.ryhmaOlemassa(ryhma)) {
            
            this.nykyinenRyhma = ryhma;
            this.uusiLaji();
        }
    }
    
    public String kysymys() {
        
        if (nykyinenKieli == Kieli.SUOMI) {
            return this.nykyinenLaji.getSnimi();
            
        } else {
            return this.nykyinenLaji.getLnimi();
        }
    }
    
    public String nimiMolemmat() {
        return nykyinenLaji.toString();
    }
    
    public boolean vertaa(String vastaus) {
        
        if (nykyinenKieli == Kieli.SUOMI) {
            return this.trimLower(this.nykyinenLaji.getLnimi())
                    .equals(this.trimLower(vastaus));
            
        } else {
            return this.trimLower(this.nykyinenLaji.getSnimi())
                    .equals(this.trimLower(vastaus));
        }
    }
    
    public List getRyhmat() {
        
        return data.getRyhmat();
    }
    
    public Kieli getKieli() {
        
        return this.nykyinenKieli;
    }
    
    public String getRyhma() {
        
        return this.nykyinenRyhma;
    }
    
    private String trimLower(String sana) {
        
        return sana.trim().toLowerCase();
    }
            
}
