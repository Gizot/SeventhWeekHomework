package service;

import model.Player;
import model.Pokemon;
import model.WeatherConditionsEnum;

public class WeatherConditionService {

    public WeatherConditionsEnum getWeatherConditions() {
        // Rastgele bir sayı üretmek için Math.random() kullanılır
        int random = (int) (Math.random() * 4);

        // Random değere göre hava durumu enumunu döndür
        return switch (random) {
            case 1 -> WeatherConditionsEnum.HOT;
            case 2 -> WeatherConditionsEnum.WINDY;
            case 3 -> WeatherConditionsEnum.THUNDER;
            default -> WeatherConditionsEnum.RAINY;
        };
    }

    public void effectOfWeatherOnPower(Pokemon pokemon, WeatherConditionsEnum weatherEnum) {
        // Pokemon'un tipine göre hava durumu etkisini belirle
        switch (pokemon.getType()) {
            case ELECTRICITY:
                // Eğer hava durumu yıldırımlı ise hasarı 2 kat artır ve mesaj yazdır
                if (weatherEnum == WeatherConditionsEnum.THUNDER) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " yıldırımlı havada güç kazandı.");
                }
                // Eğer hava durumu yağmurlu ise hasarı yarıya indir ve mesaj yazdır
                else if (weatherEnum == WeatherConditionsEnum.RAINY) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " yağmurlu havada güç kaybetti.");
                }
                break;
            case WATER:
                // Eğer hava durumu yağmurlu ise su tipi Pokemonların hasarını 3 kat artır ve mesaj yazdır
                if (weatherEnum == WeatherConditionsEnum.RAINY) {
                    pokemon.setDamage(pokemon.getDamage() * 3);
                    System.out.println(pokemon.getName() + " yağmurlu havada güç kazandı.");
                }
                // Eğer hava durumu sıcak ise su tipi Pokemonların hasarını yarıya indir ve mesaj yazdır
                else if (weatherEnum == WeatherConditionsEnum.HOT) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " sıcak havada güç kaybetti.");
                }
                break;
            case FIRE:
                // Eğer hava durumu sıcak ise ateş tipi Pokemonların hasarını 2 kat artır ve mesaj yazdır
                if (weatherEnum == WeatherConditionsEnum.HOT) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " sıcak havada güç kazandı.");
                }
                // Eğer hava durumu yağmurlu ise ateş tipi Pokemonların hasarını yarıya indir ve mesaj yazdır
                else if (weatherEnum == WeatherConditionsEnum.RAINY) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " yağmurlu havada güç kaybetti.");
                }
                break;
            case EARTH:
                // Eğer hava durumu rüzgarlı ise toprak tipi Pokemonların hasarını 3 kat artır ve mesaj yazdır
                if (weatherEnum == WeatherConditionsEnum.WINDY) {
                    pokemon.setDamage(pokemon.getDamage() * 3);
                    System.out.println(pokemon.getName() + " rüzgarlı havada güç kazandı.");
                }
                // Eğer hava durumu sıcak ise toprak tipi Pokemonların hasarını yarıya indir ve mesaj yazdır
                else if (weatherEnum == WeatherConditionsEnum.HOT) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " sıcak havada güç kaybetti.");
                }
                break;
            default:
                break;
        }
    }

    public void applyWeatherEffects(Player player1, Player player2) {
        // Rastgele bir hava durumu belirle
        WeatherConditionsEnum weatherEnum = getWeatherConditions();
        System.out.println("Weather is " + weatherEnum + "!\n");

        // Her bir oyuncunun Pokemonları için hava durumu etkisini uygula
        for (Pokemon pokemon : player1.getCharacter().getPokemonList()) {
            effectOfWeatherOnPower(pokemon, weatherEnum);
        }
        for (Pokemon pokemon : player2.getCharacter().getPokemonList()) {
            effectOfWeatherOnPower(pokemon, weatherEnum);
        }
    }
}