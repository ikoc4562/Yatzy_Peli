
import java.util.Arrays;

public class Pelaaja {


    private String nimi;
    private int[] pisteet;
    private boolean[] onkoPelannut;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        this.pisteet = new int[18];
        this.onkoPelannut= new boolean[18];
        int i=0;
        for (int op:pisteet){
            onkoPelannut[i]=false;
            i++;
        }
    }

    public String getNimi() {

        return this.nimi;
    }

    public int getPisteet(int mitkaPisteet) {

        return pisteet[mitkaPisteet];
    }

    public void setPisteet(int i, int pistemaara){

        pisteet[i] = pistemaara;
        onkoPelannut[i]=true;
    }

    public boolean[] getOnkoPelannut() {
        return onkoPelannut;
    }

    public int summaPisteet(){
        return pisteet[17];
    }

    @Override
    public String toString() {
        return "Pelaaja{" +
                "nimi='" + nimi + '\'' +
                ", pisteet=" + Arrays.toString(pisteet) +
                '}'+ '\'';
    }
}
