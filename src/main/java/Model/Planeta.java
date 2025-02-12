package Model;

import java.util.ArrayList;

public class Planeta {

    private final String name;
    private String galaxy;
    private String weather;
    private boolean bloom;
    private boolean aquatic;
    private ArrayList<Especie> population;
    private int maxPopulation;

    public Planeta(String name) {
        this.name = name;
    }

    public Planeta(String name, String galaxy, String weather, boolean bloom, boolean aquatic, int maxPopulation) {
        this.name = name;
        this.galaxy = galaxy;
        this.weather = weather;
        this.bloom = bloom;
        this.aquatic = aquatic;
        this.maxPopulation = maxPopulation;
        this.population = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getGalaxy() {
        return galaxy;
    }

    public String getWeather() {
        return weather;
    }

    public boolean isBloom() {
        return bloom;
    }

    public boolean isAquatic() {
        return aquatic;
    }

    public int getMaxPopulation() {
        return maxPopulation;
    }

    public void setGalaxy(String galaxy) {
        this.galaxy = galaxy;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setBloom(boolean bloom) {
        this.bloom = bloom;
    }

    public void setPopulation(ArrayList<Especie> population) {
        this.population = population;
    }

    public ArrayList<Especie> getPopulation() {
        return population;
    }

    public void setAquatic(boolean aquatic) {
        this.aquatic = aquatic;
    }

    public void setMaxPopulation(int maxPopulation) {
        this.maxPopulation = maxPopulation;
    }

    /**
     * Sobreescribimos el equals para comprobar los nombres del objeto que se
     * pasa y los demas planetas que hay
     *
     * @param obj
     * @return returneamos true o false, segun si coincide con algun planeta o
     * no.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof Planeta) {
            Planeta p = (Planeta) obj;
            if (p.getName().equals(this.name)) {
                return true;
            }
        }

        return false;
    }

    /**
     * Overrideamos tambien el to string, en el cual podremos enseñar todos los
     * datos del planeta.
     *
     * @return returneamos una cadena de String, en la cual tendremos que hacer
     * print
     */
    @Override
    public String toString() {
        String bloom;
        if (isBloom() == true) {
            bloom = "Yes";
        } else {
            bloom = "No";
        }
        String aquatic;
        if (isAquatic() == true) {
            aquatic = "Yes";
        } else {
            aquatic = "No";
        }
        return "Planeta: " + name + " - galaxy: " + galaxy + " - weather: " + weather + " - bloom: " + bloom + ", aquatic=" + aquatic + " - maxPopulation: " + maxPopulation + '}';
    }

}
