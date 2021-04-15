
package lattarikyselija.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import lattarikyselija.logiikka.Kieli;

import lattarikyselija.data.LattariData;
import lattarikyselija.logiikka.LattariLogiikka;

public class LattariUI extends Application{

    private LattariLogiikka logiikka;
    private Label kysymysLabel;
    
    @Override
    public void init() throws Exception {
        
        kysymysLabel = new Label();
        logiikka = new LattariLogiikka(new LattariData());
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
          
        ikkuna.setTitle("Lajinnimet");
        
        VBox asettelu = new VBox(10);
        
        asettelu.setPrefSize(600, 200);
        asettelu.setPadding(new Insets(10, 10, 10, 10));
        
        asettelu.getChildren().addAll(kieliValikko(), kyselyValikko());
        
        Scene nakyma = new Scene(asettelu);
        ikkuna.setScene(nakyma);
        ikkuna.show();
    }
    
    public Parent kieliValikko() {
            
        HBox asettelu = new HBox(10);
            
        Button suomiNappi = new Button();
        Button latinaNappi = new Button();
            
        asettelu.getChildren().addAll(suomiNappi, latinaNappi);
            
        suomiNappi.setText("Kysymykset suomeksi");
        latinaNappi.setText("Kysymykset latinaksi");
            
        suomiNappi.setOnMouseClicked((event) -> {
            logiikka.vaihdaKieli(Kieli.SUOMI);
            kysymysLabel.setText(logiikka.kysymys());
        });
            
        latinaNappi.setOnMouseClicked((event) -> {
            logiikka.vaihdaKieli(Kieli.LATINA);
            kysymysLabel.setText(logiikka.kysymys());
        });
            
        return asettelu;
    }
    
    public Parent kyselyValikko() {
        
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
    
    public static void main(String[] args) {
        launch(args);
    }
}
