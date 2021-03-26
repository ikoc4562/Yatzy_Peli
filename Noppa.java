public class Noppa {


    private int arvo;


    public Noppa() {
        this.arvo = (int) (Math.random()*6+1);
    }

    public int getArvo() {

        return arvo;
    }

    public void setArvo(int uusiArvo) {

        this.arvo = uusiArvo;
    }

    public void heitaNoppa() {
        this.arvo = (int) (Math.random()*6+1);
    }

}
