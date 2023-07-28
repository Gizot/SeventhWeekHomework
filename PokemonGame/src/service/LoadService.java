package service;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.Scanner;

public class LoadService {

    public ArrayList<SpecialPower> loadSpecialPowerForCharacter(){

        SpecialPower strategy1 = new Strategy("Strategy I", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);
        SpecialPower strategy3 = new Strategy("Strategy III", 10, 1);
        SpecialPower strategy4 = new Strategy("Strategy IV", 9, 1);

        ArrayList<SpecialPower> specialPowerForCharacterList = new ArrayList<>();
        specialPowerForCharacterList.add(strategy1);
        specialPowerForCharacterList.add(strategy2);
        specialPowerForCharacterList.add(strategy3);
        specialPowerForCharacterList.add(strategy4);

        return specialPowerForCharacterList;
    }

    public ArrayList<SpecialPower> loadSpecialPowerForPokemon(){

        SpecialPower electricty = new Electricty("Electricty", 3, 3);
        SpecialPower water = new Water( "Water", 2, 3);
        SpecialPower fire = new Fire( "Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        ArrayList<SpecialPower> specialPowerForPokemonList = new ArrayList<>();
        specialPowerForPokemonList.add(electricty);
        specialPowerForPokemonList.add(water);
        specialPowerForPokemonList.add(fire);
        specialPowerForPokemonList.add(earth);

        return specialPowerForPokemonList;


    }
    public ArrayList<Character> loadCharacters(){

        SpecialPower strategy1 = new Strategy("StrategyI", 4, 1);
        SpecialPower strategy2 = new Strategy("Strategy II", 3, 1);
        SpecialPower strategy3 = new Strategy("Strategy III",5, 1);
        SpecialPower strategy4 = new Strategy("Strategy IV", 2, 1);

        Character james = new Character("James",strategy3);
        Character jessie = new Character("Jessie", strategy4);
        Character ash = new Ash("Ash", strategy1);
        Character brooke = new Brooke("Brooke", strategy2);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        characterList.add(jessie);
        characterList.add(james);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricty = new Electricty("Electricty", 3, 3);
        SpecialPower water = new Water("Water", 1, 3);
        SpecialPower fire = new Fire("Fire", 5, 3);
        SpecialPower earth = new Earth("Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu("Pikachu", 90, 7, TypeEnum.ELECTRICITY, electricty);
        Pokemon pokemon2 = new Sqiurtle("Sqiurtle", 100, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander("Charmander", 130, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar("Balbausar", 140, 10, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }

    public Pokemon getWeakestPokemonForPlayer(ArrayList<Pokemon> pokemonList) {
        if (pokemonList.isEmpty()) {
            return null;
        }

        Pokemon weakestPokemon = pokemonList.get(0);

        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getHealth() < weakestPokemon.getHealth()) {
                weakestPokemon = pokemon;
            }
        }
        return weakestPokemon;
    }

}
