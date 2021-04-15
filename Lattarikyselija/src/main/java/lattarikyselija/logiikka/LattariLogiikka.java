
package lattarikyselija.logiikka;

import lattarikyselija.data.Laji;
import lattarikyselija.data.LattariData;

public class LattariLogiikka {
    
    private LattariData data;
    private Laji nykyinenLaji;
    private Kieli kieli;

    public LattariLogiikka(LattariData data) {
        this.data = data;
        this.kieli = Kieli.SUOMI;
        
        //Lataa aluksi lajin
        this.uusiLaji();
    }
    
    public void uusiLaji() {
        Laji vanha = nykyinenLaji;
        
        //ei ehkä paras tapa saada aina uusi laji mutta toimii aluksi
        while (true) {
            nykyinenLaji = data.getRandRyhmanLaji("lintu");
            
            if(!(nykyinenLaji.equals(vanha))) {
                break;
            }
        }
    }
    
    public void vaihdaKieli(Kieli vaihtoKieli) {
        if (vaihtoKieli == Kieli.SUOMI) {
            kieli = Kieli.SUOMI;
        } else {
            kieli = Kieli.LATINA;
        }
    }
    
    public String kysymys() {
        
        if(kieli == Kieli.SUOMI) {
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
        
        if(kieli == Kieli.SUOMI){
            oikea = this.nykyinenLaji.getLnimi();
            
        } else {
            oikea = this.nykyinenLaji.getSnimi();
        }
        
        oikea = this.trimLower(oikea);
        vastaus = this.trimLower(vastaus);
        
        return oikea.equals(vastaus);
    }
    
    private String trimLower(String sana) {
        
        sana = sana.toLowerCase();
        sana = sana.trim();
        
        return sana;
    }
            
}
