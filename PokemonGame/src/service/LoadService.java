package service;

import model.*;
import model.Character;

import java.util.ArrayList;
import java.util.Scanner;

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

    public Pokemon createLowestHealthPokemon() {
        ArrayList<Pokemon> pokemonList = loadPokemons();

        if (pokemonList.isEmpty()) {
            return null;
        }

        Pokemon weakestPokemon = pokemonList.get(0);

        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getHealth() < weakestPokemon.getHealth()) {
                weakestPokemon = pokemon;
            }
        }

        return new Pokemon(weakestPokemon.getId(), weakestPokemon.getName(), weakestPokemon.getHealth(),
                weakestPokemon.getDamage(), weakestPokemon.getType(), weakestPokemon.getSpecialPower());
    }

    public Character selectChar() {
        ArrayList<Character> characterList =loadCharacters();
        Scanner input = new Scanner(System.in);

        System.out.println("--------------------------------");
        System.out.println("Karakterinizi seçiniz");
        for (Character character : characterList) {
            System.out.println(character.getId() + "\t" + character.getName());
        }

        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                return characterList.get(0);
            case 2:
                return characterList.get(1);
            case 3:
                return characterList.get(2);
            case 4:
                return characterList.get(3);
            default:
                System.out.println("Geçersiz karakter seçimi!");
                return null;
        }
    }





}
