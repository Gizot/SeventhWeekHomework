package service;

import model.*;
import model.Character;

import java.util.ArrayList;

public class LoadService {

    public ArrayList<SpecialPower> loadSpecialPowerForCharacter(){

        SpecialPower strategy1 = new Strategy(5,"Strategy I", 4, 1);
        SpecialPower strategy2 = new Strategy(6,"Strategy II", 3, 1);
        SpecialPower strategy3 = new Strategy(7,"Strategy III", 10, 1);
        SpecialPower strategy4 = new Strategy(8,"Strategy IV", 9, 1);

        ArrayList<SpecialPower> specialPowerForCharacterList = new ArrayList<>();
        specialPowerForCharacterList.add(strategy1);
        specialPowerForCharacterList.add(strategy2);
        specialPowerForCharacterList.add(strategy3);
        specialPowerForCharacterList.add(strategy4);

        return specialPowerForCharacterList;
    }

    public ArrayList<SpecialPower> loadSpecialPowerForPokemon(){

        SpecialPower electricty = new Electricty(1,"Electricty", 3, 3);
        SpecialPower water = new Water(2, "Water", 1, 3);
        SpecialPower fire = new Fire(3, "Fire", 5, 3);
        SpecialPower earth = new Earth(4,"Earth", 4, 3);

        ArrayList<SpecialPower> specialPowerForPokemonList = new ArrayList<>();
        specialPowerForPokemonList.add(electricty);
        specialPowerForPokemonList.add(water);
        specialPowerForPokemonList.add(fire);
        specialPowerForPokemonList.add(earth);

        return specialPowerForPokemonList;


    }
    public ArrayList<Character> loadCharacters(){
        SpecialPower electricty = new Electricty(1,"Electricty", 3, 3);
        SpecialPower water = new Water(2, "Water", 1, 3);
        SpecialPower fire = new Fire(3, "Fire", 5, 3);
        SpecialPower earth = new Earth(4,"Earth", 4, 3);
        SpecialPower strategy1 = new Strategy(5,"Strategy I", 4, 1);
        SpecialPower strategy2 = new Strategy(6,"Strategy II", 3, 1);
        SpecialPower strategy3 = new Strategy(7,"Strategy III", 10, 1);
        SpecialPower strategy4 = new Strategy(8,"Strategy IV", 9, 1);

        Pokemon pokemon1 = new Pikachu(1,"Pikachu", 100, 10, TypeEnum.ELECTRICITY, electricty);
        Pokemon pokemon2 = new Sqiurtle(2,"Sqiurtle", 15, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander(3,"Charmander", 90, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar(4,"Balbausar", 140, 7, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        Character james = new Character(1,"James",strategy3,pokemonList);
        Character jessie = new Character(2,"Jessie", strategy4,pokemonList);
        Character ash = new Ash(3,"Ash", strategy1,pokemonList);
        Character brooke = new Brooke(4,"Brooke", strategy2, pokemonList);

        ArrayList<Character> characterList = new ArrayList<>();
        characterList.add(ash);
        characterList.add(brooke);
        characterList.add(jessie);
        characterList.add(james);
        return characterList;
    }

    public ArrayList<Pokemon> loadPokemons(){
        SpecialPower electricty = new Electricty(1 ,"Electricty", 3, 3);
        SpecialPower water = new Water(2,"Water", 1, 3);
        SpecialPower fire = new Fire(3,"Fire", 5, 3);
        SpecialPower earth = new Earth(4,"Earth", 4, 3);

        Pokemon pokemon1 = new Pikachu(1,"Pikachu", 100, 10, TypeEnum.ELECTRICITY, electricty);
        Pokemon pokemon2 = new Sqiurtle(2,"Sqiurtle", 80, 8, TypeEnum.WATER, water);
        Pokemon pokemon3 = new Charmander(3,"Charmander", 90, 12, TypeEnum.FIRE, fire);
        Pokemon pokemon4 = new Balbausar(4,"Balbausar", 140, 7, TypeEnum.EARTH, earth);

        ArrayList<Pokemon> pokemonList = new ArrayList<>();
        pokemonList.add(pokemon1);
        pokemonList.add(pokemon2);
        pokemonList.add(pokemon3);
        pokemonList.add(pokemon4);

        return pokemonList;
    }

    public Pokemon getWeakestPokemonForPlayer(ArrayList<Pokemon> pokemonList) {
        if (pokemonList.isEmpty()) {
            //Null if list is empty
            return null;
        }
        // The first Pokemon is the weakest for now
        Pokemon weakestPokemon = pokemonList.get(0);

        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getHealth() < weakestPokemon.getHealth()) {
                // Found a weaker Pokemon, update
                weakestPokemon = pokemon;
            }
        }
        return weakestPokemon;
    }

}
