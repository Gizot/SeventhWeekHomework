package service;

import model.Player;
import model.Pokemon;

public class StageService {
    public StageEnum getStage() {
        int random = (int) (Math.random() * 5);
        return switch (random) {
            case 1 -> StageEnum.VOLCANO;
            case 2 -> StageEnum.OCEAN;
            case 3 -> StageEnum.CANYON;
            case 4 -> StageEnum.HURRICANE;
            default -> StageEnum.FOREST;
        };
    }
    public void effectOfStagesOnPower(Pokemon pokemon, StageEnum stageEnum) {
        switch (pokemon.getType()) {
            case ELECTRICITY:
                if (stageEnum == StageEnum.HURRICANE) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " fırtınada güç kazandı.");
                } else if (stageEnum == stageEnum.OCEAN) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " okyanus ortamında güç kaybetti.");
                }
                break;
            case WATER:
                if (stageEnum == StageEnum.OCEAN) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " okyanus ortamında güç kazandı.");
                } else if (stageEnum == stageEnum.VOLCANO) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " yanardağ bölgesinde güç kaybetti.");
                }
                break;
            case FIRE:
                if (stageEnum == StageEnum.FOREST) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " ormanda güç kazandı.");
                } else if (stageEnum == StageEnum.CANYON) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " çorak kanyon arazisinde güç kaybetti.");
                }
                break;
            case EARTH:
                if (stageEnum == StageEnum.VOLCANO) {
                    pokemon.setDamage(pokemon.getDamage() * 2);
                    System.out.println(pokemon.getName() + " yanardağ bölgesinde güç kazandı.");
                } else if (stageEnum == StageEnum.OCEAN) {
                    pokemon.setDamage(pokemon.getDamage() / 2);
                    System.out.println(pokemon.getName() + " okyanus ortamında güç kaybetti.");
                }
                break;
            default:
                break;
        }
    }
    public void applyWeatherEffects(Player player1, Player player2) {
        StageEnum stageEnum = getStage();
        System.out.println("Stage is " + stageEnum + "!\n");

        for (Pokemon pokemon : player1.getCharacter().getPokemonList()) {
            effectOfStagesOnPower(pokemon, stageEnum);
        }

        for (Pokemon pokemon : player2.getCharacter().getPokemonList()) {
            effectOfStagesOnPower(pokemon, stageEnum);
        }
    }
}
