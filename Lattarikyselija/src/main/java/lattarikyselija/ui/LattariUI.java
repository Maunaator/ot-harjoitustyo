
package lattarikyselija.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import lattarikyselija.data.LattariData;
import lattarikyselija.logiikka.LattariLogiikka;

public class LattariUI extends Application{
    
    private static LattariLogiikka logiikka;
    private static Stage ikkuna;
    
    @Override
    public void init() throws Exception {
        
        this.logiikka = new LattariLogiikka(new LattariData());
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        
        this.ikkuna = ikkuna;
        
        ikkuna.setTitle("Lajinnimet");
        
        naytaRyhmanakyma();
        
        ikkuna.show();
    }
    
    public static void naytaKyselynakyma() {
        
        ikkuna.setScene(new Scene(new Kyselyvalikko(logiikka).getAsettelu()));
    }
    
    public static void naytaRyhmanakyma() {
        
        ikkuna.setScene(new Scene(new Ryhmavalikko(logiikka).getAsettelu()));
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
