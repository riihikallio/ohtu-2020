package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int OLETUSKAPASITEETTI = 5; // aloitustalukon koko
    public final static int OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] alkiot;      // Joukon luvut säilytetään taulukon alkupäässä. 
    private int indeksi;    // Tyhjässä joukossa alkioiden_määrä on nolla. 

    public IntJoukko() {
        this(OLETUSKAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasiteetti negatiivinen");
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("Kasvatuskoko negatiivinen");
        }
        alkiot = new int[kapasiteetti];
        indeksi = 0;
        this.kasvatuskoko = kasvatuskoko;

    }

    public boolean lisaa(int luku) {
        if (!sisaltyy(luku)) {
            alkiot[indeksi] = luku;
            indeksi++;
            if (indeksi == alkiot.length) {
                kasvata();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean sisaltyy(int luku) {
        for (int i = 0; i < indeksi; i++) {
            if (luku == alkiot[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int poistettava) {
        int siirto = 0;
        for (int i = 0; i < indeksi; i++) {
            if (alkiot[i] == poistettava) {
                siirto = 1;
            }
            alkiot[i] = alkiot[i + siirto];
        }
        if (siirto == 1) {
            alkiot[indeksi] = 0;    // Tietoturvan varalta
            indeksi--;
            return true;
        } else {
            return false;
        }
    }

    private void kasvata() {
        int[] vanha = alkiot;
        alkiot = new int[indeksi + kasvatuskoko];
        for (int i = 0; i < vanha.length; i++) {
            alkiot[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return indeksi;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{");
        for (int i = 0; i < indeksi; i++) {
            str.append(alkiot[i]);
            if (i < indeksi - 1) {
                str.append(", ");
            }
        }
        str.append("}");
        return str.toString();
    }

    public int[] toIntArray() {
        int[] kopio = new int[indeksi];
        for (int i = 0; i < kopio.length; i++) {
            kopio[i] = alkiot[i];
        }
        return kopio;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko(a.indeksi + b.indeksi);
        for (int i = 0; i < a.indeksi; i++) {
            tulos.lisaa(a.alkiot[i]);
        }
        for (int i = 0; i < b.indeksi; i++) {
            tulos.lisaa(b.alkiot[i]);
        }
        return tulos;
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        for (int i = 0; i < a.indeksi; i++) {
            if (b.sisaltyy(a.alkiot[i])) {
                tulos.lisaa(a.alkiot[i]);
            }
        }
        return tulos;

    }

    public static IntJoukko erotus(IntJoukko a, IntJoukko b) {
        IntJoukko tulos = new IntJoukko();
        for (int i = 0; i < a.indeksi; i++) {
            if (!b.sisaltyy(a.alkiot[i])) {
                tulos.lisaa(a.alkiot[i]);
            }
        }
        return tulos;
    }

}
