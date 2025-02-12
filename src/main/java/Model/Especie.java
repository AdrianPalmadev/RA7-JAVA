/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Objects;

/**
 *
 * @author Adrián Palma
 */
public class Especie {

    private final String name;

    public Especie(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Sobreescribimos el equals para que compare los nombres del objeto con los
     * otros objetos creados
     *
     * @param obj
     * @return returneamos true o false, dependiendo de si ha encontrado uno
     * igual o no.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (obj instanceof Especie) {
            Especie other = (Especie) obj;
            return Objects.equals(this.name, other.getName());
        }

        return false;
    }

}
