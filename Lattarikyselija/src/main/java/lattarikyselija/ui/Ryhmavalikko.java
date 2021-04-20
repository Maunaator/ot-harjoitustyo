
package lattarikyselija.ui;

import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import lattarikyselija.logiikka.LattariLogiikka;

public class Ryhmavalikko {
    
    private LattariLogiikka logiikka;
        
    public Ryhmavalikko(LattariLogiikka logiikka) {
        this.logiikka = logiikka;
    }
    
    public Parent getNakyma() {
        
        return this.ryhmaAlue();
    }
    
    private Parent ryhmaAlue() {
            
        VBox asettelu = new VBox(10);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        asettelu.setPrefSize(600, 200);
        
        Label otsikko = new Label("Valitse harjoiteltava ryhmä");
        asettelu.getChildren().add(otsikko);
        
        logiikka.getRyhmat().stream().forEach(r -> {
            
            //Jos ryhmiä on paljon, tämä tapa on ongelmallinen
            Button nappi = new Button();
            nappi.setText((String) r);
            
            asettelu.getChildren().add(nappi);
            
            nappi.setOnMouseClicked((event) -> {
                
                logiikka.vaihdaRyhma((String) r);
                
                LattariUI.getStage().setScene(new Scene(new Kyselyvalikko(logiikka).getNakyma()));
                // Tämä ei oikein tunnu selkeimmältä tavalta siirtyä näkymien välillä, pitää miettiä parempaa
                
            });
        });
            
        return asettelu;
    }
}
