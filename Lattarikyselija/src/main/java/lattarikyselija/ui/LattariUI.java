
package lattarikyselija.ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import lattarikyselija.data.LattariData;
import lattarikyselija.logiikka.LattariLogiikka;

public class LattariUI extends Application{
    
    private LattariLogiikka logiikka;
    private static Stage nykyinenIkkuna;
    
    public static Stage getStage() {
        
        return nykyinenIkkuna;
    }
    
    @Override
    public void init() throws Exception {
        
        logiikka = new LattariLogiikka(new LattariData());
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        
        nykyinenIkkuna = ikkuna;
        
        ikkuna.setTitle("Lajinnimet");
        Ryhmavalikko ryhmavalikko = new Ryhmavalikko(logiikka);
        
        Scene ryhmanakyma = new Scene(ryhmavalikko.getNakyma());
        
        ikkuna.setScene(ryhmanakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
