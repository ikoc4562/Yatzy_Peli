import java.util.ArrayList;

public class Peli {
    public ArrayList<Pelaaja> pelaajat;
    private Voitot valittuLaskea;
    public Noppa[] nopat;
    private int kierros;

    public Peli() {
        valittuLaskea = new Voitot();
        pelaajat = new ArrayList<>();
        this.kierros = 1;
        nopat = new Noppa[5];
        this.luoEnsiNopat();

    }

    public void luoEnsiNopat() {
        for (int i = 0; i < nopat.length; i++) {
            nopat[i] = new Noppa();
        }
    }

    public void luoPelaajat(int lkm) {
        for (int i = 0; i < lkm; i++) {
            pelaajat.add(new Pelaaja("Pelaaja " + (i + 1)));
        }
    }

    public void heittaNoppa() {
        if ( kierros > 15) {
            return;
        }
        for (Noppa noppa : nopat) {
            noppa.heitaNoppa();
        }

    }

    public void setKierros(int luku){

        this.kierros = luku;
    }


    public boolean loppukoPeli() {
        if (this.kierros == 15) {
            return true;
        }
        return false;
    }

    public String kukaVoitti() {
        String voittaja = "";
        int suurinPisteet = 0;

        for (Pelaaja pelaaja : this.pelaajat) {
            if (pelaaja.getPisteet(17) > suurinPisteet) {
                voittaja = pelaaja.getNimi();
                suurinPisteet = pelaaja.getPisteet(17);
            } else if (pelaaja.getPisteet(17) == suurinPisteet) {
                voittaja += " ja " + pelaaja.getNimi()+" sama pistetta";
            }
        }
        return voittaja;
    }

    public int laskePisteita(int monesko) {
        int pisteet = 0;
        if (monesko == 0 || monesko == 1 || monesko == 2 || monesko == 3 || monesko == 4 || monesko == 5) {
            pisteet = (monesko + 1) * valittuLaskea.samaaNumeroa(nopat, monesko + 1);
        } else if (monesko == 8) {
            pisteet = valittuLaskea.yksiPari(nopat);
        } else if (monesko == 9) {
            pisteet = valittuLaskea.kaksiParia(nopat);
        } else if (monesko == 10) {
            pisteet = valittuLaskea.kolmeSamanlaista(nopat);
        } else if (monesko == 11) {
            pisteet = valittuLaskea.neljaSamanlaista(nopat);
        } else if (monesko == 12) {
            pisteet = valittuLaskea.pieniSuora(nopat);
        } else if (monesko == 13) {
            pisteet = valittuLaskea.suuriSuora(nopat);
        } else if (monesko == 14) {
            pisteet = valittuLaskea.taysikasi(nopat);
        } else if (monesko == 15) {
            pisteet = valittuLaskea.yatzy(nopat);
        } else if (monesko == 16) {
            pisteet = valittuLaskea.sattuma(nopat);
        }
        return pisteet;
    }

    public void listaaPelaja() {

        for (Pelaaja pel:pelaajat){
            System.out.println(pel.getNimi()+"-------->"+pel.summaPisteet());
        }
    }
}
