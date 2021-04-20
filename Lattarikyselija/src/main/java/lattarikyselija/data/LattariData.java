
package lattarikyselija.data;


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
        
        //Vielä ei ole toteutettu tiedostosta lukua
        this.lataaEsimerkkiLinnut();
        this.lataaEsimerkkiKasvit();
    }
    
    public void addLaji(String snimi, String lnimi, String ryhma) {
        
        if (!this.ryhmat.contains(ryhma)) {
            this.ryhmat.add(ryhma);
        }
        
        lajit.add(new Laji(snimi, lnimi, ryhma));
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
    
    private void lataaEsimerkkiLinnut() {
        
        String l = "Lintu";
        
        this.addLaji("Varis", "Corvus corone", l);
        this.addLaji("Harakka", "Pica Pica", l);
        this.addLaji("Korppi", "Corvus corax", l);
        
        this.addLaji("Talitiainen", "Parus major", l);
        this.addLaji("Hömötiainen", "Poecile montanus", l);
        this.addLaji("Kuusitiainen", "Periparus ater", l);
        this.addLaji("Sinitiainen", "Cyanistes caeruleus", l);
        
        this.addLaji("Varpunen", "Passer domesticus", l);
        this.addLaji("Pikkuvarpunen", "Passer montanus", l);
    }
    
    private void lataaEsimerkkiKasvit() {
        
        String k = "Kasvi";
        
        this.addLaji("Litulaukka", "Alliaria petiolata", k);
        this.addLaji("Siperianpihta", "Abies sibirica", k);
        this.addLaji("Metsävaahtera", "Acer platanoides", k);
        
        this.addLaji("Kultakärsämö", "Achillea filipendulina", k);
        this.addLaji("Rohtokalmojuuri", "Acorus calamus", k);
        this.addLaji("Maarianverijuuri", "Agrimonia eupatoria", k);
        this.addLaji("Isoaurankukka", "Agrostemma githago", k);
        
        this.addLaji("Kartioakankaali", "Ajuga pyramidalis", k);
        this.addLaji("Rönsyakankaali", "Ajuga reptans", k);
    }
}
