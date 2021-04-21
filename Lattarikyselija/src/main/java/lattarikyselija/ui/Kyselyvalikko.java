
package lattarikyselija.ui;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import lattarikyselija.logiikka.Kieli;
import lattarikyselija.logiikka.LattariLogiikka;

public class Kyselyvalikko {
    
    private LattariLogiikka logiikka;
    private Label kysymysLabel;
    
    public Kyselyvalikko(LattariLogiikka logiikka) {
        this.logiikka = logiikka;
        this.kysymysLabel = new Label();
    }
    
    public Parent getAsettelu() {
        
        VBox asettelu = new VBox(10);
        
        asettelu.setPrefSize(600, 200);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        
        kysymysLabel.setText(logiikka.kysymys());
        asettelu.getChildren().addAll(kieliAlue(), kyselyAlue());
        
        return asettelu;
    }
    
    private Parent kieliAlue() {
            
        HBox asettelu = new HBox(10);
            
        Button suomiNappi = new Button();
        Button latinaNappi = new Button();
        Button takaisinNappi = new Button();
        
        asettelu.getChildren().addAll(suomiNappi, latinaNappi, takaisinNappi);
            
        suomiNappi.setText("Kysymykset suomeksi");
        latinaNappi.setText("Kysymykset latinaksi");
        takaisinNappi.setText("Takaisin ryhmän valintaan");
            
        suomiNappi.setOnMouseClicked((event) -> {
            logiikka.vaihdaKieli(Kieli.SUOMI);
            kysymysLabel.setText(logiikka.kysymys());
        });
            
        latinaNappi.setOnMouseClicked((event) -> {
            logiikka.vaihdaKieli(Kieli.LATINA);
            kysymysLabel.setText(logiikka.kysymys());
        });
        
        takaisinNappi.setOnMouseClicked((event) -> {
            
            LattariUI.naytaRyhmanakyma();
        });
            
        return asettelu;
    }
    
    private Parent kyselyAlue() {
        
        TextField vastausAlue = new TextField();
        Label vastausLabel = new Label();
        
        Button vastaaNappi = new Button();
        Button ohitaNappi = new Button();
        
        vastaaNappi.setText("Vastaa");
        ohitaNappi.setText("Paljasta");
        
        VBox asetteluV = new VBox(10);
        HBox asetteluH = new HBox(10);
        
        asetteluH.getChildren().addAll(vastaaNappi, ohitaNappi);
        asetteluV.getChildren().addAll(kysymysLabel, vastausAlue, asetteluH, vastausLabel);
        
        kysymysLabel.setText(logiikka.kysymys());
        
        vastaaNappi.setOnMouseClicked((event) -> {
            String vastaus = vastausAlue.getText();
            
            if(logiikka.vertaa(vastaus)) {
                vastausLabel.setText("Oikein!");
                logiikka.uusiLaji();
                kysymysLabel.setText(logiikka.kysymys());
                vastausAlue.clear();
                
            } else {
                vastausLabel.setText("Väärin!");
            }
        });
        
        ohitaNappi.setOnMouseClicked((event) -> {
            vastausLabel.setText("Vastaus: " + logiikka.nimiMolemmat());
        });
        
        return asetteluV;
    }
}
