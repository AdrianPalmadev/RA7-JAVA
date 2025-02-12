package Model;

public class Klingon extends Especie {

    private static int civilization = 2;
    private int strength;

    public Klingon(String name, int strength) {
        super(name);
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public static int getCivilization() {
        return civilization;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Sobreescribimos el tostring para que nos muestre los valores que queramos
     *
     * @return
     */
    @Override
    public String toString() {
        return "Klingon: " + getName() + " - strength: " + getStrength() + " - civilization: " + getCivilization();
    }

}
