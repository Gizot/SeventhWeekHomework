package model;

import java.util.ArrayList;

public class Jassie extends  Character{

    public Jassie(String name, SpecialPower specialPower, ArrayList<Pokemon> pokemonList) {
        super(name, specialPower, pokemonList);
    }

    public Jassie(int id, String name, SpecialPower specialPower) {
        super(id, name, specialPower);
    }
}
