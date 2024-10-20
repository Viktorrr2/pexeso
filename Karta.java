public class Karta {
    private char symbol;
    private boolean odhalena;

    public Karta(char symbol) {
        this.symbol = symbol;
        this.odhalena = false;
    }

    public char getSymbol() {
        return symbol;
    }

    public boolean jeOdhalena() {
        return odhalena;
    }

    public void odhalit() {
        odhalena = true;
    }

    public void skryt() {
        odhalena = false;
    }
}
