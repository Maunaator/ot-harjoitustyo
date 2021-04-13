
package lattarikyselija.ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import lattarikyselija.data.LattariData;
import lattarikyselija.logiikka.LattariLogiikka;

public class LattariUI extends Application{

    private LattariLogiikka logiikka;
    
    @Override
    public void init() throws Exception {
        LattariData data = new LattariData();
        logiikka = new LattariLogiikka(data);
    }
    
    @Override
    public void start(Stage ikkuna) throws Exception {
        
        //Barebones UI toteutus muistuttaa tällä hetkellä aika paljon Ohjelmoinnin jatkokurssin Sanakirja tehtävää
        
        ikkuna.setTitle("Lajinnimet");
        
        //Alkunäkymä
        
        Label ekateksti = new Label("Haluan harjoitella");
        Button suomiNappi =  new Button("Suomenkielisiä nimiä");
        Button lattariNappi =  new Button("Tieteellisiä nimiä");
        
        GridPane alkuAsettelu = new GridPane();
        
        alkuAsettelu.add(ekateksti, 0, 0);
        alkuAsettelu.add(suomiNappi, 0, 1);
        alkuAsettelu.add(lattariNappi, 1, 1);
        
        alkuAsettelu.setPrefSize(600, 180);
        alkuAsettelu.setAlignment(Pos.CENTER);
        alkuAsettelu.setPadding(new Insets(10, 10, 10, 10));
        alkuAsettelu.setVgap(10);
        alkuAsettelu.setHgap(10);
        
        Scene alkuNakyma = new Scene(alkuAsettelu);
        
        //Kyselynäkymä
        
        Button takaisinAlkuunNappi =  new Button("Takaisin");
        Button vastaaNappi = new Button("Vastaa");
        Button ohitaNappi = new Button("Ohita");
        
        Label kysymys = new Label("");
        Label palaute = new Label("");
        
        TextField vastausAlue = new TextField(); 
        
        GridPane kyselyAsettelu = new GridPane();
        
        kyselyAsettelu.add(takaisinAlkuunNappi, 0, 0);
        kyselyAsettelu.add(kysymys, 0, 1);
        kyselyAsettelu.add(vastausAlue, 0, 2);
        kyselyAsettelu.add(vastaaNappi, 0, 3);
        kyselyAsettelu.add(ohitaNappi, 1, 3);
        kyselyAsettelu.add(palaute, 0, 4);

        kyselyAsettelu.setPrefSize(600, 180);
        kyselyAsettelu.setAlignment(Pos.CENTER);
        kyselyAsettelu.setPadding(new Insets(10, 10, 10, 10));
        kyselyAsettelu.setVgap(10);
        kyselyAsettelu.setHgap(10);
        
        Scene kyselyNakyma = new Scene(kyselyAsettelu);
        
        //Näkymät voisi olla erillisinä luokkina
        
        //Toiminnallisuus
        
        kysymys.setText(logiikka.kysymys());
        
        suomiNappi.setOnAction((event) -> {
            ikkuna.setScene(kyselyNakyma);
            logiikka.vaihdaTila(0);
            palaute.setText("");
            kysymys.setText(logiikka.kysymys());
            
        });
        
        lattariNappi.setOnAction((event) -> {
            ikkuna.setScene(kyselyNakyma);
            logiikka.vaihdaTila(1);
            palaute.setText("");
            kysymys.setText(logiikka.kysymys());
        });
        
        takaisinAlkuunNappi.setOnAction((event) -> {
            ikkuna.setScene(alkuNakyma);
        });
        
        vastaaNappi.setOnMouseClicked((event) -> {
            String vastaus = vastausAlue.getText();
            
            if(logiikka.vertaa(vastaus)) {
                palaute.setText("Oikein!");
                logiikka.uusi();
                kysymys.setText(logiikka.kysymys());
            } else {
                palaute.setText("Väärin!");
            }
        });
        
        ohitaNappi.setOnMouseClicked((event) -> {
            
            palaute.setText("Ohitettu: " + logiikka.lajiMolemmatNimet());
            logiikka.uusi();
            kysymys.setText(logiikka.kysymys());
        });
        
        ikkuna.setScene(alkuNakyma);
        ikkuna.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
