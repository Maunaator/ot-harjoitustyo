
package lattarikyselija.data;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class LattariData {
    private List<Laji> lajit;
    private List<String> ryhmat;

    public LattariData() {
        //Tarkoitus olisi toteuttaa tämä tietokantana myöhemmin
        lajit = new ArrayList<>();
        ryhmat = new ArrayList<>();
        
        this.loadRyhmat();
    }
    
    private void loadRyhmat() {
        //ryhmät kansion tiedostot
        File sijainti = new File("ryhmat");
        //käydään tiedostot läpi
        Arrays.stream(sijainti.listFiles()).forEach(tiedosto -> {
            //Ryhmän nimi tiedoston nimestä, en tiedä onko ongelma että tiedostot ovat päätteetömiä
            this.ryhmat.add(tiedosto.getName());
            
            try (Scanner lukija = new Scanner(Paths.get(tiedosto.getAbsolutePath()))) {
                
                while (lukija.hasNextLine()) {
                    
                    String rivi = lukija.nextLine();
                    String[] palat = rivi.split(";");
                    
                    this.lajit.add(new Laji(palat[0], palat[1], tiedosto.getName()));
                }
            } catch (Exception virhe) {
                System.out.println("Virhe: " + virhe.getMessage());
            }
        });
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
