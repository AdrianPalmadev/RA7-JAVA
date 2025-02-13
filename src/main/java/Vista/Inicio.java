package Vista;

import static Api.Api.*;
import static Controlador.Controlador.*;

public class Inicio {

    /**
     *
     * @param args En el main, simplemente insertamos un menu, que se encuentra
     * en la api y llamamos a los metodos
     */
    public static void main(String[] args) {

        boolean exit = false;
        int nummenu;
        do {
            menu("===========================================",
                    "==         MENU                          ==",
                    "== 1. Create planet                      ==",
                    "== 2. Create ser                         ==",
                    "== 3. Delete ser                         ==",
                    "== 4. Ver seres por planeta              ==",
                    "== 5. Modificar ser                      ==",
                    "== 6. Ver seres por especie              ==",
                    "== 0. Exit                               ==",
                    "===========================================",
                    "");
            nummenu = askForIntBetween(0, 6, "Selecciona una opcion...");
            switch (nummenu) {
                case 0 -> {
                    exit = salir(exit);
                }
                case 1 -> {
                    createPlanet();
                }
                case 2 -> {
                    createSer();
                }
                case 3 -> {
                    deleteSer();
                }
                case 4 -> {
                    verSeresPorPlaneta();
                }
                case 5 -> {
                    modser();
                }
                case 6 -> {
                    verserporespecie();
                }
            }
        } while (!exit);
    }

}
