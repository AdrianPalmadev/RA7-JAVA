package Model;

public class Nibiriano extends Especie {

    private static int civilization = 2;
    private boolean bloom;

    public Nibiriano(String name, boolean bloom) {
        super(name);
        this.bloom = bloom;
    }

    public boolean isBloom() {
        return bloom;
    }

    public void setBloom(boolean bloom) {
        this.bloom = bloom;
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
        String bloom;
        if (isBloom() == true) {
            bloom = "Bloom";
        } else {
            bloom = "Fish";
        }
        return "Andoriano: " + getName() + " - bloom/fish: " + bloom + " - civilization: " + getCivilization();
    }

}
