package Controlador;

import static Api.Api.*;
import Model.*;
import java.util.ArrayList;

public class Controlador {

    /**
     * Creamos un arraylist estatico, donde almacenaremos los planetas
     */
    private static ArrayList<Planeta> listaPlanetas = new ArrayList<>();

    /**
     *
     * lo que hace esto, es usar el metodo equals sobreescrito en especie.
     *
     * @param e e es la especie donde verificaremos el nombre
     * @return hacemos return de la especie con el mismo nombre, o si no ha
     * encontrado nada, devolvemos null.
     */
    private static Especie getSerbyName(Especie e) {
        for (Planeta n : listaPlanetas) {
            if (n.getPopulation().contains(e)) {
                return n.getPopulation().get(n.getPopulation().indexOf(e));
            }
        }
        return null;
    }

    /**
     *
     * esto lo que hace es usar el metodo equals sobreescrito en planeta, y
     * comparamos los nombres de cada planeta con el planeta que le pasamos.
     *
     * @param p le pasamos el planeta que queremos buscar por el nombre
     * @return returneamos el planeta que se ha encontrado o null si no hay
     * ninguno con el mismo nombre
     */
    private static Planeta getPlanetabyName(Planeta p) {
        if (listaPlanetas.contains(p)) {
            return listaPlanetas.get(listaPlanetas.indexOf(p));
        }
        return null;
    }

    /**
     * Creamos un planeta, le pedimos al usuario todos los datos sobre el
     * planeta importantes y finalmente lo creamos con todos los datos y lo
     * almacenamos en el arraylist.
     */
    public static void createPlanet() {
        String name;
        do {
            name = noEnter("Inserta el nombre del planeta", "No dejes el nombre vacio");
            if (getPlanetabyName(new Planeta(name)) != null) {
                System.out.println("Nombre ya asignado, vuelve a insertarlo.");
            }
        } while (getPlanetabyName(new Planeta(name)) != null);
        String galaxy = noEnter("En que galaxia se encuentra?", "No dejes la galaxia vacia");
        String weather = weather();
        boolean bloom = sn("El planeta contiene flora roja?");
        boolean aquatic = sn("El planeta contiene seres acuaticos?");
        int population = Intmayor("Cuanto es el maximo de poblacion del planeta?", 0);

        Planeta planet = new Planeta(name, galaxy, weather, bloom, aquatic, population);

        listaPlanetas.add(planet);
    }

    /**
     * Creamos un ser con todos los parametros importantes, y vemos de que
     * especie es y le pedimos los otros datos unicos del ser y lo creamos. Este
     * se almacena en el planeta que nos ha indicado en el caso de que tenga
     * espacio y/o las caracteristicas que el ser tiene unicas
     */
    public static void createSer() {
        if (listaPlanetas.isEmpty()) {
            System.out.println("Crea un planeta para almacenar el Ser primero.");
            return;
        }
        String name;
        String specie;
        String planet;
        boolean check = true;
        do {
            name = noEnter("Inserta el nombre del Ser", "No dejes el nombre vacio");
            if (!(getSerbyName(new Especie(name)) == null)) {
                System.out.println("Nombre ya asignado, insertalo otro.");
            }
        } while (!(getSerbyName(new Especie(name)) == null));
        do {
            specie = noEnter("Inserta el nombre de la especie", "No dejes la especie vacia");
        } while (especievalid(specie));
        System.out.println("Planetas disponibles:");
        for (int i = 0; i < listaPlanetas.size(); i++) {
            System.out.println(listaPlanetas.get(i).toString());
        }
        do {
            planet = noEnter("Inserta el nombre del planeta", "No dejes el planeta vacio");
            if (!(getPlanetabyName(new Planeta(planet)) == null)) {
                if (!(getPlanetabyName(new Planeta(planet)).getPopulation().size() < getPlanetabyName(new Planeta(planet)).getMaxPopulation())) {
                    System.out.println("Este planeta no tiene espacio, inserta otro.");
                    check = true;
                } else {
                    if (specie.equalsIgnoreCase("klingon") && getPlanetabyName(new Planeta(planet)).getWeather().equalsIgnoreCase("calido")) {
                        System.out.println("Un klingon no puede vivir en un planeta calido.");
                        return;
                    } else if (specie.equalsIgnoreCase("ferengi") && getPlanetabyName(new Planeta(planet)).getWeather().equalsIgnoreCase("frio")) {
                        System.out.println("Un ferengi no puede vivir en un planeta frio.");
                        return;
                    } else if (specie.equalsIgnoreCase("nibiriano") && getPlanetabyName(new Planeta(planet)).isAquatic() == false && getPlanetabyName(new Planeta(planet)).isBloom() == false) {
                        System.out.println("Un nibiriano no puede vivir sin seres acuaticos ni flora roja.");
                        return;
                    } else if (specie.equalsIgnoreCase("vulcaniano")) {
                        Planeta p = getPlanetabyName(new Planeta(planet));

                        for (Especie s : p.getPopulation()) {
                            if (s instanceof Andoriano) {
                                System.out.println("Un vulcaniano no puede convivir con un andoriano en el mismo planeta.");
                                return;
                            }
                        }
                    } else if (specie.equalsIgnoreCase("vulcaniano")) {
                        Planeta p = getPlanetabyName(new Planeta(planet));

                        for (Especie s : p.getPopulation()) {
                            if (s instanceof Andoriano) {
                                System.out.println("Un vulcaniano no puede convivir con un andoriano en el mismo planeta.");
                                return;
                            }
                        }
                    } else {
                        check = false;
                    }
                }

            }
        } while (check);

        if (specie.equalsIgnoreCase("humano")) {
            int age = askForIntBetween(0, 130, "Inserta la edad del humano entre 0 y 130");
            boolean male = sn("El humano es de genero masculino");

            Humano h = new Humano(name, age, male);
            getPlanetabyName(new Planeta(planet)).getPopulation().add(h);

        } else if (specie.equalsIgnoreCase("andoriano")) {
            String rango = andoriano();
            boolean aenar = sn("Habitan bajo el hielo?");

            Andoriano a = new Andoriano(name, rango, aenar);
            getPlanetabyName(new Planeta(planet)).getPopulation().add(a);

        } else if (specie.equalsIgnoreCase("ferengi")) {
            int latinum = Intmayor("Cuanto latium tiene este Ferengi?", 0);

            Ferengi f = new Ferengi(name, latinum);
            getPlanetabyName(new Planeta(planet)).getPopulation().add(f);

        } else if (specie.equalsIgnoreCase("klingon")) {
            int fuerza = askForIntBetween(50, 350, "Inserta la fuerza que tiene el Klingon");

            Klingon k = new Klingon(name, fuerza);
            getPlanetabyName(new Planeta(planet)).getPopulation().add(k);

        } else if (specie.equalsIgnoreCase("nibiriano")) {
            boolean bloom = sn("Se alimentan de flora roja? En caso contrario, se alimentan de seres acuaticos.");

            if (bloom == true && getPlanetabyName(new Planeta(planet)).isBloom() == false) {
                System.out.println("El planeta que has mencionado no tiene flora roja.");
                return;
            } else if (bloom == false && getPlanetabyName(new Planeta(planet)).isAquatic() == false) {
                System.out.println("El planeta que has mencionado no tiene seres acuaticos");
                return;
            }
            Nibiriano n = new Nibiriano(name, bloom);
            getPlanetabyName(new Planeta(planet)).getPopulation().add(n);

        } else if (specie.equalsIgnoreCase("vulcaniano")) {
            int meditacion = askForIntBetween(0, 10, "Inserta el nivel de meditacion del Vulcaniano");

            Vulcaniano v = new Vulcaniano(name, meditacion);
            getPlanetabyName(new Planeta(planet)).getPopulation().add(v);

        }
    }

    /**
     * Le preguntamos donde esta el planeta primero en el cual quiere eliminar
     * el ser, tambien miramos si el planeta tiene seres registrados en este
     * planeta, despues de que todo sea correcto, procedemos a eliminar el ser,
     * simplemente lo desvinculamos del arraylist del planeta.
     */
    public static void deleteSer() {
        Planeta d;
        String planeta;
        for (int i = 0; i < listaPlanetas.size(); i++) {
            Planeta p = listaPlanetas.get(i);
            p.getName();
        }
        do {
            planeta = noEnter("Inserta el nombre del planeta del ser que quieres eliminar", "No lo dejes vacío");
            d = getPlanetabyName(new Planeta(planeta));

            if (d == null) {
                System.out.println("El planeta no existe. Inténtalo de nuevo.");
            }
        } while (d == null);

        if (getPlanetabyName(new Planeta(planeta)).getPopulation().isEmpty()) {
            System.out.println("Este planeta no tiene seres registrados.");
            return;
        }

        System.out.println("Seres en " + getPlanetabyName(new Planeta(planeta)).getName() + ":");
        for (int i = 0; i < getPlanetabyName(new Planeta(planeta)).getPopulation().size(); i++) {
            System.out.println(getPlanetabyName(new Planeta(planeta)).getPopulation().get(i).toString());
        }

        Especie serEliminar = null;
        String ser;
        do {
            ser = noEnter("Inserta el nombre del ser que deseas borrar", "No lo dejes en blanco");
            for (Especie e : d.getPopulation()) {
                if (e.getName().equalsIgnoreCase(ser)) {
                    serEliminar = e;
                    break;
                }
            }
            if (serEliminar == null) {
                System.out.println("No se ha encontrado ningun ser con ese nombre, vuelve a añadirlo");
            }
        } while (serEliminar == null);

        d.getPopulation().remove(serEliminar);
        System.out.println("Se ha eliminado el ser correctamente.");

    }

    /**
     * Mostramos los seres y los planetas que hay dentro de estos.
     */
    public static void verseresporplaneta() {

        for (int i = 0; i < listaPlanetas.size(); i++) {
            Planeta p = listaPlanetas.get(i);
            System.out.println(p.getName());
            for (Especie s : p.getPopulation()) {
                System.out.println(s.toString());
            }
        }
    }

    /**
     * Modificamos el valor del ser, segun la especie, modificamos una cosa u
     * otra.
     */
    public static void modser() {
        Especie serModificar = null;
        String ser;
        do {
            ser = noEnter("Inserta el nombre del ser que deseas modificar", "No lo dejes en blanco");
            for (Planeta d : listaPlanetas) {
                for (Especie e : d.getPopulation()) {
                    if (e.getName().equalsIgnoreCase(ser)) {
                        serModificar = e;
                        break;
                    }
                }
            }
            if (serModificar == null) {
                System.out.println("No se ha encontrado ningun ser con ese nombre, vuelve a añadirlo");
            }
        } while (serModificar == null);

        if (serModificar instanceof Humano) {
            int newage = askForIntBetween(0, 130, "Inserta la nueva edad del humano");

            ((Humano) serModificar).setAge(newage);
            System.out.println("Se ha modificado correctamente.");

        } else if (serModificar instanceof Ferengi) {
            int newlatium = Intmayor("Cuanto latium tiene el Ferengi?", 0);

            ((Ferengi) serModificar).setGold(newlatium);
            System.out.println("Se ha modificado correctamente.");

        } else if (serModificar instanceof Klingon) {
            int newstrength = askForIntBetween(50, 350, "Inserta la nueva fuerza del Klingon");

            ((Klingon) serModificar).setStrength(newstrength);
            System.out.println("Se ha modificado correctamente.");

        } else if (serModificar instanceof Vulcaniano) {
            int newmeditation = askForIntBetween(0, 10, "Inserta el nuevo nivel de meditacion");

            ((Vulcaniano) serModificar).setMeditation(newmeditation);
            System.out.println("Se ha modificado correctamente.");
        }
    }

    /**
     * Pedimos la especie, y mostramos segun la opcion que escoja. En esta
     * mostramos todos seres de la especie que nos ha pasado por el menu.
     */
    public static void verserporespecie() {
        menu("Que especie deseas ver?",
                "1. Humano",
                "2. Ferengi",
                "3. Klingon",
                "4. Nibiriano",
                "5. Vulcaniano",
                "6. Andoriano");

        int opt = askForIntBetween(1, 6, "Selecciona un valor del menu");

        switch (opt) {
            case 1 -> {
                for (int i = 0; i < listaPlanetas.size(); i++) {
                    Planeta p = listaPlanetas.get(i);
                    for (Especie s : p.getPopulation()) {
                        if (s instanceof Humano) {
                            System.out.println(s.toString());
                        }
                    }
                }
            }
            case 2 -> {
                for (int i = 0; i < listaPlanetas.size(); i++) {
                    Planeta p = listaPlanetas.get(i);
                    for (Especie s : p.getPopulation()) {
                        if (s instanceof Ferengi) {
                            System.out.println(s.toString());
                        }
                    }
                }
            }
            case 3 -> {
                for (int i = 0; i < listaPlanetas.size(); i++) {
                    Planeta p = listaPlanetas.get(i);
                    for (Especie s : p.getPopulation()) {
                        if (s instanceof Klingon) {
                            System.out.println(s.toString());
                        }
                    }
                }
            }
            case 4 -> {
                for (int i = 0; i < listaPlanetas.size(); i++) {
                    Planeta p = listaPlanetas.get(i);
                    for (Especie s : p.getPopulation()) {
                        if (s instanceof Nibiriano) {
                            System.out.println(s.toString());
                        }
                    }
                }
            }
            case 5 -> {
                for (int i = 0; i < listaPlanetas.size(); i++) {
                    Planeta p = listaPlanetas.get(i);
                    for (Especie s : p.getPopulation()) {
                        if (s instanceof Vulcaniano) {
                            System.out.println(s.toString());
                        }
                    }
                }
            }
            case 6 -> {
                for (int i = 0; i < listaPlanetas.size(); i++) {
                    Planeta p = listaPlanetas.get(i);
                    for (Especie s : p.getPopulation()) {
                        if (s instanceof Andoriano) {
                            System.out.println(s.toString());
                        }
                    }
                }
            }
        }
    }

    /**
     * Comprobamos que el weather es correcto, pues solo puede ser frio, calido
     * o templado.
     *
     * @return returneamos el valor.
     */
    private static String weather() {
        String name;
        do {
            name = noEnter("Inserta el clima del planeta (frio, calido o templado)", "No dejes el clima vacio").toLowerCase();
        } while (!(name.equals("frio") || name.equals("calido") || name.equals("templado")));

        return name;
    }

    /**
     * Comprobamos que el rol del andoriano es correcto, solo puede ser
     * entrenador, defensor, luchador o caballero.
     *
     * @return returneamos el valor.
     */
    private static String andoriano() {
        String name;
        do {
            name = noEnter("Inserta el rango de la especie (entrenador, defensor, luchador o caballero)", "Inserta un rango, no lo dejes vacio").toLowerCase();
        } while (!(name.equals("entrenador") || name.equals("defensor") || name.equals("luchador") || name.equals("caballero")));

        return name;
    }

    /**
     * comprbobamos si la especie es valida.
     *
     * @param n por n, le pasamos el valor que nos ha enviado por teclado.
     * @return returneamos true o false, en el caso de que sea correcto o no
     */
    private static boolean especievalid(String n) {
        n = n.toLowerCase();
        return !(n.equals("humano") || n.equals("andoriano") || n.equals("nibiriano") || n.equals("klingon") || n.equals("ferengi") || n.equals("vulcaniano"));
    }

}
