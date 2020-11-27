package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    private TextField tuloskentta;
    private TextField syotekentta;
    private Button nollaa;
    private Button undo;
    protected Sovelluslogiikka sovellus;
    protected int arvo;
    private int edellinen = 0;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public void suorita() {
        try {
            edellinen = Integer.parseInt(tuloskentta.getText());
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
            arvo = 0;
        }
    }

    public void peru() {
        sovellus.aseta(edellinen);
        try {
            edellinen = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }
        esita();
    }

    public void esita() {
        int laskunTulos = sovellus.tulos();
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }
}
