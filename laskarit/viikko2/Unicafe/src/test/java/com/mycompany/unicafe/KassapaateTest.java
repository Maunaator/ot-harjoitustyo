
package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class KassapaateTest {
    
    Kassapaate kassa;
    
    int edullinenHinta;
    int maukasHinta;
    
    Maksukortti rikasKortti;
    Maksukortti koyhaKortti;
    
    int alkukassa;
    int alkuRikas;
    int alkuKoyha;
    
    @Before
    public void setUp() {
        
        alkukassa = 100000;
        edullinenHinta = 240;
        maukasHinta = 400;
        
        alkuRikas = 10000;
        alkuKoyha = 1;
        
        kassa = new Kassapaate();
        rikasKortti = new Maksukortti(alkuRikas);
        koyhaKortti = new Maksukortti(alkuKoyha);
    }
    
    @Test
    public void luotuKassaOlemassa() {
        assertTrue(kassa!=null);      
    }
    
    @Test
    public void kassassaRahaaAluksiOikein() {
        assertEquals(alkukassa, kassa.kassassaRahaa());      
    }
    
    @Test
    public void edullisiaEiAluksiMyyty() {
        assertEquals(0, kassa.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void maukkaitaEiAluksiMyyty() {
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoEdullisestiKasvattaaKassaaOikein() {
        
        kassa.syoEdullisesti(alkuRikas);
        
        assertEquals(alkukassa + edullinenHinta, kassa.kassassaRahaa());      
    }
    
    @Test
    public void kateisostoEdullisestiKasvattaaMyytyjaOikein() {
        
        kassa.syoEdullisesti(alkuRikas);
        
        assertEquals(1, kassa.edullisiaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoEdullisestiVaihtorahaOikein() {
        
        assertEquals(alkuRikas - edullinenHinta, kassa.syoEdullisesti(alkuRikas));      
    }
    
    @Test
    public void kateisostoEdullisestiRahaEiRiitaKassaEiMuutu() {
        
        kassa.syoEdullisesti(alkuKoyha);
        
        assertEquals(alkukassa, kassa.kassassaRahaa());    
    }
    
    @Test
    public void kateisostoEdullisestiRahaEiRiitaVaihtorahaOikein() {
        
        assertEquals(alkuKoyha, kassa.syoEdullisesti(alkuKoyha));
    }
    
    @Test
    public void kateisostoEdullisestiRahaEiRiitaMyydytEiMuutu() {
        
        kassa.syoEdullisesti(alkuKoyha);
        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());     
    }
    
    @Test
    public void kateisostoMaukkaastiKasvattaaKassaa() {
        
        kassa.syoMaukkaasti(alkuRikas);
        
        assertEquals(alkukassa + maukasHinta, kassa.kassassaRahaa());      
    }
    
    @Test
    public void kateisostoMaukkaastiKasvattaaMyytyjaOikein() {
        
        kassa.syoMaukkaasti(alkuRikas);
        
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());      
    }
    
    @Test
    public void kateisostoMaukkaastiVaihtorahaOikein() {
        
        assertEquals(alkuRikas - maukasHinta, kassa.syoMaukkaasti(alkuRikas));      
    }
    
    @Test
    public void kateisostoMaukkaastiRahaEiRiitaKassaEiMuutu() {
        
        kassa.syoMaukkaasti(alkuKoyha);
        
        assertEquals(alkukassa, kassa.kassassaRahaa());    
    }
    
    @Test
    public void kateisostoMaukkaastiRahaEiRiitaVaihtorahaOikein() {
        
        assertEquals(alkuKoyha, kassa.syoMaukkaasti(alkuKoyha));
    }
    
    @Test
    public void kateisostoMaukkaastiRahaEiRiitaMyydytEiMuutu() {
        
        kassa.syoMaukkaasti(alkuKoyha);
        
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());     
    }
    
    @Test
    public void korttiostoEdullisestiOnnistuuPalauttaaTrue() {
        
        assertTrue(kassa.syoEdullisesti(rikasKortti));     
    }
    
    @Test
    public void korttiostoEdullisestiKortinSaldoLaskeeOikein() {
        
        kassa.syoEdullisesti(rikasKortti);
        
        assertEquals(alkuRikas - edullinenHinta, rikasKortti.saldo());     
    }
    
    @Test
    public void korttiostoEdullisestiMyydytKasvaaOikein() {
        
        kassa.syoEdullisesti(rikasKortti);
        kassa.syoEdullisesti(rikasKortti);
        
        assertEquals(2, kassa.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoEdullisestiKassaEiKasva() {
        
        kassa.syoEdullisesti(rikasKortti);
        
        assertEquals(alkukassa, kassa.kassassaRahaa()); 
    }
    
    @Test
    public void korttiostoEdullisestiEiOnnistuPalauttaaFalse() {
        
        assertFalse(kassa.syoEdullisesti(koyhaKortti));     
    }
    
    @Test
    public void korttiostoEdullisestiEpäonnisttuuKortinSaldoEiLaske() {
        
        kassa.syoEdullisesti(koyhaKortti);
        
        assertEquals(alkuKoyha, koyhaKortti.saldo());     
    }
    
    @Test
    public void korttiostoEdullisestiEpäonnisttuuMyydytEiMuutu() {
        
        kassa.syoEdullisesti(koyhaKortti);
        
        assertEquals(0, kassa.edullisiaLounaitaMyyty());     
    }
    
        @Test
    public void korttiostoMaukkaastiOnnistuuPalauttaaTrue() {
        
        assertTrue(kassa.syoMaukkaasti(rikasKortti));     
    }
    
    @Test
    public void korttiostoMaukkaastiKortinSaldoLaskeeOikein() {
        
        kassa.syoMaukkaasti(rikasKortti);
        
        assertEquals(alkuRikas - maukasHinta, rikasKortti.saldo());     
    }
    
    @Test
    public void korttiostoMaukkaastiMyydytKasvaaOikein() {
        
        kassa.syoMaukkaasti(rikasKortti);
        kassa.syoMaukkaasti(rikasKortti);
        
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiostoMaukkaastiKassaEiKasva() {
        
        kassa.syoMaukkaasti(rikasKortti);
        
        assertEquals(alkukassa, kassa.kassassaRahaa()); 
    }
    
    @Test
    public void korttiostoMaukkaastiEiOnnistuPalauttaaFalse() {
        
        assertFalse(kassa.syoMaukkaasti(koyhaKortti));     
    }
    
    @Test
    public void korttiostoMaukkaastiEpäonnisttuuKortinSaldoEiLaske() {
        
        kassa.syoMaukkaasti(koyhaKortti);
        
        assertEquals(alkuKoyha, koyhaKortti.saldo());     
    }
    
    @Test
    public void korttiostoMaukkaastiEpäonnisttuuMyydytEiMuutu() {
        
        kassa.syoMaukkaasti(koyhaKortti);
        
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());     
    }
    
    @Test
    public void korttinLatausKasvattaaKassaa() {
        
        kassa.lataaRahaaKortille(koyhaKortti, 1000);
        
        assertEquals(alkukassa + 1000, kassa.kassassaRahaa());     
    }
    
    @Test
    public void korttinLatausKasvattaaKortinSaldoa() {
        
        kassa.lataaRahaaKortille(koyhaKortti, 1000);
        
        assertEquals(alkuKoyha + 1000, koyhaKortti.saldo());     
    }
    
    @Test
    public void negatiivinenLatausEiMuutaKortinSaldoa() {
        
        kassa.lataaRahaaKortille(koyhaKortti, -1000);
        
        assertEquals(alkuKoyha, koyhaKortti.saldo());     
    }
}
