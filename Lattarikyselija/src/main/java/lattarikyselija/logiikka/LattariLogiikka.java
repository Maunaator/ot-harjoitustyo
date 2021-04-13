
package lattarikyselija.logiikka;

import lattarikyselija.data.Laji;
import lattarikyselija.data.LattariData;

public class LattariLogiikka {
    
    private LattariData data;
    private Laji nykyinenLaji;
    
    //Tila: 0 = suomi, 1 = latina, ei ehkä järkevin toteutus, mutta aluksi näin
    private int tila;

    public LattariLogiikka(LattariData data) {
        this.data = data;
        this.tila = 0;
        
        //Lataa aluksi lajin
        this.uusi();
    }
    
    public void uusi() {
        Laji vanha = nykyinenLaji;
        
        //ei ehkä paras tapa saada aina uusi laji mutta toimii aluksi
        while (true) {
            nykyinenLaji = data.getRandRyhmanLaji("lintu");
            
            if(!(nykyinenLaji.equals(vanha))) {
                break;
            }
        }
    }
    
    public void vaihdaTila(int tila) {
        if (tila == 1) {
            this.tila = 1;
        } else {
            this.tila = 0;
        }
    }
    
    public int getTila() {
        return this.tila;
    }
    
    public String kysymys() {
        
        if (tila == 0) {
            return nykyinenLaji.getLnimi();
            
        } else {
            
            return nykyinenLaji.getSnimi();
        }
    }
    
    public String lajiMolemmatNimet() {
        return nykyinenLaji.toString();
    }
    
    public boolean vertaa(String vastaus) {
        
        String oikea;
        
        if (tila == 0) {
            oikea = nykyinenLaji.getSnimi();
            
        } else {
            
            oikea = nykyinenLaji.getLnimi();
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
