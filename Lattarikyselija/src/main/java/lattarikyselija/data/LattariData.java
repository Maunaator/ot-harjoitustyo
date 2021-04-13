
package lattarikyselija.data;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class LattariData {
    private List<Laji> lajit;

    public LattariData() {
        //Tarkoitus olisi toteuttaa tämä tietokantana myöhemmin
        lajit = new ArrayList<>();
        
        //Vielä ei ole toteutettu tiedostosta lukua
        this.lataaEsimerkkiLinnut();
    }
    
    public void addLaji(String snimi, String lnimi, String ryhma) {
                
        lajit.add(new Laji(snimi, lnimi, ryhma));
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
    
    private void lataaEsimerkkiLinnut() {
        
        String l = "lintu";
        
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
}
