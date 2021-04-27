
package lattarikyselija.data;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import java.util.stream.Collectors;

public class LattariData {
    private List<Laji> lajit;
    private List<String> ryhmat;

    public LattariData() {
        //Tarkoitus olisi toteuttaa tämä tietokantana myöhemmin
        lajit = new ArrayList<>();
        ryhmat = new ArrayList<>();
        
        this.loadRyhmat();
        this.loadLajit();
    }
    
    private void loadRyhmat() {
        
        //En osannut toteuttaa tätä niin että ohjelma lukisi ryhmat kansion tiedostonnimet myös jarissa
        //joten jouduin lisäämään tuon Ryhmat tiedoston jossa nimet ovat.
        
        try (
            BufferedReader lukija = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/ryhmat/Ryhmat")))) {
            
            lukija.lines().forEach(rivi -> {
                this.ryhmat.add(rivi);
            });
            
            lukija.close();
            
        } catch (Exception virhe) {
                System.out.println("Virhe: " + virhe.getMessage());
        }
    }
    
    public void loadLajit() {
        
        this.ryhmat.stream().forEach((ryhma -> {
            
            try (
                BufferedReader lukija = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/ryhmat/" + ryhma)))) {

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
    
    public List getRyhmat() {
        
        return this.ryhmat;
    }
    
    public Laji getRandRyhmanLaji(String ryhma) {
        //Varsin epätehokas mutta toimii tässä vaiheessa
        
        List<Laji> ryhmanLajit = getRyhmanLajit(ryhma);
        
        Random rand = new Random();
        
        return ryhmanLajit.get(rand.nextInt(ryhmanLajit.size()));
    }
    
    private List<Laji> getRyhmanLajit(String ryhma) {
        
        List<Laji> ryhmanLajit = lajit.stream()
            .filter(l -> l.getRyhma().equals(ryhma))
            .collect(Collectors.toList());
        
        return ryhmanLajit;
    }
    
    public boolean ryhmaOlemassa(String ryhma) {
        
        return this.ryhmat.contains(ryhma);
    }
}
