
package lattarikyselija.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lattarikyselija.logiikka.LattariLogiikka;

public class Ryhmavalikko {
    
    private LattariLogiikka logiikka;
        
    public Ryhmavalikko(LattariLogiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    public Parent getAsettelu() {
        
        return this.ryhmaAlue();
    }
    
    private Parent ryhmaAlue() {
            
        VBox asettelu = new VBox(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        asettelu.setPrefSize(600, 200);
        
        Label otsikko = new Label("Valitse harjoiteltava ryhmä");
        asettelu.getChildren().add(otsikko);
        
        // Luodaan napit eri ryhmille
        logiikka.getRyhmat().stream().forEach(r -> {
            
            //Jos ryhmiä on paljon, tämä tapa on ongelmallinen
            Button nappi = new Button();
            nappi.setText((String) r);
            
            asettelu.getChildren().add(nappi);
            
            nappi.setOnMouseClicked((event) -> {
                
                logiikka.vaihdaRyhma((String) r);
                LattariUI.naytaKyselynakyma();
            });
        });
            
        return asettelu;
    }
}
