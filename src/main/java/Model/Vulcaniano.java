package Model;

public class Vulcaniano extends Especie {

    private static int civilization = 3;
    private int meditation;

    public Vulcaniano(String name, int meditation) {
        super(name);
        this.meditation = meditation;
    }

    public int getMeditation() {
        return meditation;
    }

    public void setMeditation(int meditation) {
        this.meditation = meditation;
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
        return "Ferengi: " + getName() + " - meditation: " + getMeditation() + " - civilization: " + getCivilization();
    }

}
