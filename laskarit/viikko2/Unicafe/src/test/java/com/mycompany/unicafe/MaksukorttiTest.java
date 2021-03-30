package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;
    
    @Before
    public void setUp() {
        kortti = new Maksukortti(1000);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void toStringToimiiOikein() {
        assertEquals("saldo: 10.0", kortti.toString());      
    }
    
    @Test
    public void saldoAlussaOikein() {
        assertEquals(1000, kortti.saldo());      
    }
    
    @Test
    public void lataaminenKasvattaaSaldoaOikein() {
        
        kortti.lataaRahaa(500);
        
        assertEquals(1500, kortti.saldo());      
    }
    
    @Test
    public void saldoVaheneeOikein() {
        
        kortti.otaRahaa(500);
        
        assertEquals(500, kortti.saldo());      
    }
    
    @Test
    public void saldoEiMuutuJosRahaaEiTarpeeksi() {
        
        kortti.otaRahaa(1500);
        
        assertEquals(1000, kortti.saldo());      
    }
    
    @Test
    public void otaRahaaPalauttaaTrueJosRahaaTarpeeksi() {
        
        assertTrue(kortti.otaRahaa(500));
    }
    
    @Test
    public void otaRahaaPalauttaaFalseJosRahaaEiTarpeeksi() {
        
        assertFalse(kortti.otaRahaa(1500));
    }
}
