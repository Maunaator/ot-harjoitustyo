
package lattarikyselija.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Luokka vastaa lajiryhmien ja lajinimien säilytyksestä ja tiedostosta hausta.
 */


public class LattariData {
    private List<Laji> lajit;
    private List<String> ryhmat;

    public LattariData() {
        
        lajit = new ArrayList<>();
        ryhmat = new ArrayList<>();
        
        this.loadRyhmat();
        this.loadLajit();
    }
    
    private void loadRyhmat() {
        
        //En osannut toteuttaa tätä niin että ohjelma lukisi ryhmat kansion tiedostonnimet myös jarissa
        //joten jouduin lisäämään tuon Ryhmat tiedoston jossa nimet ovat.
        //Ryhmä-tiedostot vielä muutaman lajin sisältäviä testaus versioita.
        
        try (
            BufferedReader lukija = new BufferedReader(new InputStreamReader(getClass()
                    .getResourceAsStream("/ryhmat/Ryhmat")))) {
            
            lukija.lines().forEach(rivi -> {
                this.ryhmat.add(rivi);
            });
            
            lukija.close();
            
        } catch (Exception virhe) {
            System.out.println("Virhe: " + virhe.getMessage());
        }
    }
    
    private void loadLajit() {
        
        this.ryhmat.stream().forEach((ryhma -> {
            
            try (
                BufferedReader lukija = new BufferedReader(new InputStreamReader(getClass()
                        .getResourceAsStream("/ryhmat/" + ryhma)))) {

                lukija.lines().forEach(rivi -> {
                    
                    String[] palat = rivi.split(";");
                    this.lajit.add(new Laji(palat[0], palat[1], ryhma));
                });
                
                lukija.close();

            } catch (Exception virhe) {
                System.out.println("Virhe: " + virhe.getMessage());
            }
        }));
    }
    
    /**
    * Metodi palauttaa lajiryhmät listana.
    * 
    * @return lajiryhmät
    */
    
    public List getRyhmat() {
        
        return this.ryhmat;
    }
    
    /**
    * Metodi palauttaa satunnaisen lajin halutusta ryhmästä.
    * 
    * @param ryhma haluttu ryhmä
    * 
    * @return satunnainen ryhmän laji
    */
    
    public Laji getRandRyhmanLaji(String ryhma) {
        
        List<Laji> ryhmanLajit = getRyhmanLajit(ryhma);
        
        return ryhmanLajit.get(new Random().nextInt(ryhmanLajit.size()));
    }
    
    private List<Laji> getRyhmanLajit(String ryhma) {
        
        List<Laji> ryhmanLajit = lajit.stream()
            .filter(l -> l.getRyhma().equals(ryhma))
            .collect(Collectors.toList());
        
        return ryhmanLajit;
    }
    
    /**
    * Metodi kertoo löytyykö kyseinen ryhmä.
    * 
    * @param ryhma kysytty ryhmä
    * 
    * @return totuusarvo ryhmän olemassaolosta
    */
    
    public boolean ryhmaOlemassa(String ryhma) {
        
        return this.ryhmat.contains(ryhma);
    }
}
