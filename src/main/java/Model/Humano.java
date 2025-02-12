package Model;

public class Humano extends Especie {

    private static int civilization = 1;
    private int age;
    private boolean male;

    public Humano(String name, int age, boolean male) {
        super(name);
        this.age = age;
        this.male = male;
    }

    public static int getCivilization() {
        return civilization;
    }

    public int getAge() {
        return age;
    }

    public boolean isMale() {
        return male;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    /**
     * Sobreescribimos el tostring para que nos muestre los valores que queramos
     *
     * @return
     */
    @Override
    public String toString() {
        String male;
        if (isMale() == true) {
            male = "Si";
        } else {
            male = "No";
        }
        return "Humano: " + getName() + " - age: " + getAge() + " - male: " + male + " - civilization: " + getCivilization();
    }

}
