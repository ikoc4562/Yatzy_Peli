import java.util.Scanner;

class main {
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        System.out.println("*****************************");
        System.out.println("TERVETULOA PELAAMAAN YATZYA!");
        System.out.println("*****************************");
        System.out.println("Syötä pelaajien lukumäärä.");
        int lkm = Integer.valueOf(lukija.nextLine());
        Peli peli = new Peli();
        Noppa noppa = new Noppa();
        peli.luoPelaajat(lkm);

        int kierros = 1;

        while (!peli.loppukoPeli()) {
            for (Pelaaja plj : peli.pelaajat) {
                System.out.println("*****************************");
                System.out.println("PELIVUOROSSA: "+ plj.getNimi());
                System.out.println("*****************************");
                peli.heittaNoppa();
                int i = 1;
                for (Noppa pel : peli.nopat) {
                    System.out.println("NOPPA " + i + " : " + pel.getArvo());
                    i++;
                }
                for (int r = 0; r < 2; r++) {
                    System.out.println("*****************************");
                    System.out.println("Kuinka monta nopista haluat heittää uusiksi? Syötä luku (0-5)");
                    int monta = Integer.valueOf(lukija.nextLine());
                    if (monta >= 0 && monta <= 5) {
                        for (int j = 0; j < monta; j++) {
                            System.out.println("*****************************");
                            System.out.println("Mitkä nopat? Syötä uusittavan nopan numero. HUOM! Yksi kerrallaan!");
                            int syota = Integer.valueOf(lukija.nextLine());
                            noppa.heitaNoppa();
                            peli.nopat[syota - 1].setArvo(noppa.getArvo());
                        }
                        int k = 1;
                        System.out.println("*****************************");
                        for (Noppa pel : peli.nopat) {
                            System.out.println("Noppa " + k + " : " + pel.getArvo());
                            k++;
                        }
                    }
                }
                nayttaValikko();
                System.out.println("VALITSE KUINKA HALUAT PISTEYTTÄÄ KIERROKSESI. Syötä luku.(0-16)");
                int valittu = Integer.valueOf(lukija.nextLine());
                if (plj.getOnkoPelannut()[valittu]==false){
                    plj.setPisteet(valittu,peli.laskePisteita(valittu));
                } else{
                    System.out.println("Olet pisteyttänyt jo kyseisen kohdan, etkä voi valita sitä uudelleen.");
                    System.out.println("Valitse uusi kohta johon pisteytät kierroksen. Syötä luku (0-16)");
                    int valittu2 = Integer.valueOf(lukija.nextLine());
                    plj.setPisteet(valittu,peli.laskePisteita(valittu2));
                }
                /*
                if (plj.getPisteet(valittu)!=0){
                    System.out.println("Aiemmin tama on laskenut");
                    System.out.println("Valita yhden luku ylasta taas");
                    int valittu2 = Integer.valueOf(lukija.nextLine());
                    plj.setPisteet(valittu,peli.laskePisteita(valittu2));
                } else{
                    plj.setPisteet(valittu,peli.laskePisteita(valittu));

                }
                */

                //plj.setPisteet(valittu,peli.laskePisteita(valittu));


                int summa=0;
                for (int s=0;s<17;s++){
                    summa+=plj.getPisteet(s);
                }
                int bonus=0;
                for (int b=0;b<6;b++){
                    bonus+=plj.getPisteet(b);
                }
                if (bonus>=63){
                    plj.setPisteet(17,summa+50);
                } else{
                    plj.setPisteet(17,summa);
                }
                //System.out.println("Toplam puan:"+summa);

            }

            peli.setKierros(kierros);
            kierros++;



        }

        peli.listaaPelaja();
        System.out.println( peli.kukaVoitti());

        //System.out.println(peli.pelaajat.toString());
    }

    private static void nayttaValikko() {
        System.out.println("*****************************");
        System.out.println("PISTEYTETÄÄN KIERROS:");
        System.out.println("");

        //Pöytäkirjan yläosan yhdistelmät:
        System.out.println("0 - Ykköset");
        System.out.println("1 - Kakkoset");
        System.out.println("2 - Kolmoset");
        System.out.println("3 - Neloset");
        System.out.println("4 - Viitoset");
        System.out.println("5 - Kuutoset");
        //Pöytäkirjan alaosan yhdistelmät (skandinaavisessa versiossa):
        System.out.println("8 - Yksi pari");
        System.out.println("9 - Kaksi paria");
        System.out.println("10 - Kolmoisluku");
        System.out.println("11 - Neloisluku");
        System.out.println("12 - Pieni suora");
        System.out.println("13 - Suuri suora");
        System.out.println("14 - Täyskäsi");
        System.out.println("15 - Yahtzee");
        System.out.println("16 - Sattuma");
        System.out.println("*****************************");

    }
}


