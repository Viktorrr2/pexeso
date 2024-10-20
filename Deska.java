import java.util.ArrayList;
import java.util.Collections;

public class Deska {
    private Karta[][] mrizka;
    private int velikost;

    public Deska(int velikost) {
        this.velikost = velikost;
        mrizka = new Karta[velikost][velikost];
        inicializovatKarty();
    }

    
    private void inicializovatKarty() {
        ArrayList<Character> symboly = new ArrayList<>();
        for (char znak = 'A'; znak < 'A' + (velikost * velikost) / 2; znak++) {
            symboly.add(znak);
            symboly.add(znak); 
        }
        Collections.shuffle(symboly); 

        int index = 0;
        for (int radek = 0; radek < velikost; radek++) {
            for (int sloupec = 0; sloupec < velikost; sloupec++) {
                mrizka[radek][sloupec] = new Karta(symboly.get(index));
                index++;
            }
        }
    }

   
    public void zobrazitDesku(boolean zobrazitVse) {
        for (int radek = 0; radek < velikost; radek++) {
            for (int sloupec = 0; sloupec < velikost; sloupec++) {
                if (zobrazitVse || mrizka[radek][sloupec].jeOdhalena()) {
                    System.out.print(mrizka[radek][sloupec].getSymbol() + " ");
                } else {
                    System.out.print("X "); 
                }
            }
            System.out.println();
        }
    }

   
    public boolean jePlatnyTah(int radek1, int sloupec1, int radek2, int sloupec2) {
        return radek1 >= 0 && radek1 < velikost && sloupec1 >= 0 && sloupec1 < velikost &&
               radek2 >= 0 && radek2 < velikost && sloupec2 >= 0 && sloupec2 < velikost &&
               !(radek1 == radek2 && sloupec1 == sloupec2) && 
               !mrizka[radek1][sloupec1].jeOdhalena() && !mrizka[radek2][sloupec2].jeOdhalena();
    }

    
    public void odhalitKarty(int radek1, int sloupec1, int radek2, int sloupec2) {
        mrizka[radek1][sloupec1].odhalit();
        mrizka[radek2][sloupec2].odhalit();
    }

    
    public void skrýtKarty(int radek1, int sloupec1, int radek2, int sloupec2) {
        mrizka[radek1][sloupec1].skryt();
        mrizka[radek2][sloupec2].skryt();
    }

    
    public boolean kontrolovatShodu(int radek1, int sloupec1, int radek2, int sloupec2) {
        return mrizka[radek1][sloupec1].getSymbol() == mrizka[radek2][sloupec2].getSymbol();
    }

   
    public boolean vsechnyParyNalezeny() {
        for (int radek = 0; radek < velikost; radek++) {
            for (int sloupec = 0; sloupec < velikost; sloupec++) {
                if (!mrizka[radek][sloupec].jeOdhalena()) {
                    return false;
                }
            }
        }
        return true;
    }
}
