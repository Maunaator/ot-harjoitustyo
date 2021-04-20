
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
        
        this.nykyinenKieli = Kieli.SUOMI;
        this.nykyinenRyhma = "Lintu";
        
        //Lataa aluksi lajin
        this.uusiLaji();
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
        
        String oikea = "";
        
        if (nykyinenKieli == Kieli.SUOMI) {
            oikea = this.nykyinenLaji.getLnimi();
            
        } else {
            oikea = this.nykyinenLaji.getSnimi();
        }
        
        oikea = this.trimLower(oikea);
        vastaus = this.trimLower(vastaus);
        
        return oikea.equals(vastaus);
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
        
        sana = sana.toLowerCase();
        sana = sana.trim();
        
        return sana;
    }
            
}
