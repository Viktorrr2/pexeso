import java.util.Scanner;

public class Pexeso {
    private static final int VELIKOST_DESKY = 4; 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vitejte ve hre Pexeso!");
        System.out.println("Vasim ukolem je najit vsechny dvojice stejnych karet zadanim souradnic (radek a sloupec).");

        boolean hratZnovu;
        do {
            Deska deska = new Deska(VELIKOST_DESKY); 
            hratHru(deska, scanner); 
            System.out.println("Chcete hrat znovu? (y/n): ");
            hratZnovu = scanner.next().equalsIgnoreCase("y");
        } while (hratZnovu); 
    }

    
    private static void hratHru(Deska deska, Scanner scanner) {
        int pokusy = 0;
        while (!deska.vsechnyParyNalezeny()) {
            deska.zobrazitDesku(false); 
            System.out.println("Zadejte souradnice prvni karty (radek a sloupec, napr. 0 1): ");
            int radek1 = scanner.nextInt();
            int sloupec1 = scanner.nextInt();

            System.out.println("Zadejte suradnice druhe karty (radek a sloupec, napr. 2 3): ");
            int radek2 = scanner.nextInt();
            int sloupec2 = scanner.nextInt();

            if (deska.jePlatnyTah(radek1, sloupec1, radek2, sloupec2)) {
                pokusy++;
                deska.odhalitKarty(radek1, sloupec1, radek2, sloupec2);
                if (!deska.kontrolovatShodu(radek1, sloupec1, radek2, sloupec2)) {
                    deska.skrýtKarty(radek1, sloupec1, radek2, sloupec2); 
                    System.out.println("Karty nejsou stejne! Zkuste to znovu.");
                }
            } else {
                System.out.println("Neplatne souradnice! Zkuste to znovu.");
            }
        }
        System.out.println("Gratulujeme! nasli jste vsechny pary po " + pokusy + " pokusech.");
    }
}
