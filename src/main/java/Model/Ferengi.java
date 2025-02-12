package Model;

public class Ferengi extends Especie {

    private static int civilization = 1;
    private int gold;

    public Ferengi(String name, int gold) {
        super(name);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public static int getCivilization() {
        return civilization;
    }

    /**
     * Sobreescribimos el tostring para que nos muestre los valores que queramos
     *
     * @return
     */
    @Override
    public String toString() {
        return "Ferengi: " + getName() + " - gold: " + getGold() + " - civilization: " + getCivilization();
    }

}
