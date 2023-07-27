package model;

import java.util.ArrayList;

public class James extends Character{
    public James(int id, String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        super(id, name, specialPower, pokemonList);
    }

    public James(int id, String name, SpecialPower specialPower) {
        super(id, name, specialPower);
    }
}
