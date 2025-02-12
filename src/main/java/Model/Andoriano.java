package Model;

public class Andoriano extends Especie {

    private static int civilization = 2;
    private String role;
    private boolean aenar;

    public Andoriano(String name, String role, boolean aenar) {
        super(name);
        this.role = role;
        this.aenar = aenar;
    }

    public String getRole() {
        return role;
    }

    public boolean isAenar() {
        return aenar;
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
        String aenar;
        if (isAenar() == true) {
            aenar = "Si";
        } else {
            aenar = "No";
        }
        return "Andoriano: " + getName() + " - rol: " + getRole() + " - aenar: " + aenar + " - civilization: " + getCivilization();
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setAenar(boolean aenar) {
        this.aenar = aenar;
    }

}
