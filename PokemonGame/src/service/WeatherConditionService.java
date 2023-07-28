package service;

import model.Player;
import model.Pokemon;
import model.WeatherConditionsEnum;

public class WeatherConditionService {

    public WeatherConditionsEnum getWeather() {
        int random = (int) (Math.random() * 4);
        return switch (random) {
            case 1 -> WeatherConditionsEnum.HOT;
            case 2 -> WeatherConditionsEnum.WINDY;
            case 3 -> WeatherConditionsEnum.THUNDER;
            default -> WeatherConditionsEnum.RAINY;
        };
    }
    public void effectOfWeatherOnPower(Pokemon pokemon, WeatherConditionsEnum weatherEnum) {
        switch (pokemon.getType()) {
            case ELECTRICITY:
                if (weatherEnum == WeatherConditionsEnum.THUNDER) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " yıldırımlı havada güç kazandı.");
                } else if (weatherEnum == WeatherConditionsEnum.RAINY) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " yağmurlu havada güç kaybetti.");
                }
                break;
            case WATER:
                if (weatherEnum == WeatherConditionsEnum.RAINY) {
                    //Water-type Pokemon strength increases in rainy weather
                    pokemon.setDamage(pokemon.getDamage() * 3);
                    System.out.println(pokemon.getName() + " yağmurlu havada güç kazandı.");
                } else if (weatherEnum == WeatherConditionsEnum.HOT) {
                    //Water-type Pokemon strength decreases in sunny weather
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " sıcak havada güç kaybetti.");
                }
                break;
            case FIRE:
                if (weatherEnum == WeatherConditionsEnum.HOT) {
                    //Fire-type Pokemon strength increases in hot weather
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " sıcak havada güç kazandı.");
                } else if (weatherEnum == WeatherConditionsEnum.RAINY) {
                    //Fire-type Pokemon strength decreases in rainy weather
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " yağmurlu havada güç kaybetti.");
                }
                break;
            case EARTH:
                if (weatherEnum == WeatherConditionsEnum.WINDY) {
                    //Ground type Pokemon strength increases in windy weather
                    pokemon.setDamage(pokemon.getDamage() * 3);
                    System.out.println(pokemon.getName() + " rüzgarlı havada güç kazandı.");
                } else if (weatherEnum == WeatherConditionsEnum.HOT) {
                    //Earth type Pokemon strength decreases in hot weather
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " sıcak havada güç kaybetti.");
                }
                break;
            default:
                break;
        }
    }
    public void applyWeatherEffects(Player player1, Player player2) {
        WeatherConditionsEnum weatherEnum = getWeather();
        System.out.println("Weather is " + weatherEnum + "!\n");

        for (Pokemon pokemon : player1.getCharacter().getPokemonList()) {
            effectOfWeatherOnPower(pokemon, weatherEnum);
        }
        for (Pokemon pokemon : player2.getCharacter().getPokemonList()) {
            effectOfWeatherOnPower(pokemon, weatherEnum);
        }
    }
}
