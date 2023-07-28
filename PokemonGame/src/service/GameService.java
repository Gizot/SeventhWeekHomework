package service;

import model.Character;
import model.Player;
import model.Pokemon;

public class GameService {

    public void attack(Player attacker, Player defender, boolean isPokeSpecialAttack, boolean isCharSpecialAttack) {
        // Atak yapan ve savunan Pokemonları getir
        Pokemon attackingPokemon = attacker.getCharacter().getPokemonList().get(0);
        Pokemon defendingPokemon = defender.getCharacter().getPokemonList().get(0);
        // Özel saldırı durumunu belirlemek için boolean tipinde değişken belirlendi
        boolean specialAttack = false;
        // Eğer hem Pokemon hem de karakter özel saldırı yapacaksa
        if (isPokeSpecialAttack && isCharSpecialAttack) {
            // Pokemon ve karakterin kalan özel güç hakkı varsa true döndür
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0
                    && attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
            // Eğer sadece Pokemon özel saldırı yapacaksa
        } else if (isPokeSpecialAttack) {
            // Pokemon'ın kalan özel güç hakkı varsa true döndür
            specialAttack = attackingPokemon.getSpecialPower().getRemainingRights() > 0;
            // Eğer sadece karakter özel saldırı yapacaksa
        } else if (isCharSpecialAttack) {
            // Karakterin kalan özel güç hakkı varsa true döndür
            specialAttack = attacker.getCharacter().getSpecialPower().getRemainingRights() > 0;
        }
// Karakterin kalan özel güç hakkını al
        int charRemainingRights = attacker.getCharacter().getSpecialPower().getRemainingRights();
// Hasarı hesapla ve atamasını yap
        int damage = 0;
        if (specialAttack) {
            // Eğer hem Pokemon hem de karakter özel saldırı yapıyorsa
            if (isPokeSpecialAttack && isCharSpecialAttack) {
                // Pokemon'un özel saldırı hasarını ata
                damage += attackingPokemon.specialAttack();
                // Karakterin özel saldırı ekstra hasarını ata
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                // Karakterin kalan özel güç hakkını bir azalt
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
                // Eğer sadece Pokemon özel saldırı yapıyorsa
            } else if (isPokeSpecialAttack) {
                // Pokemon'un özel saldırı hasarını ata
                damage += attackingPokemon.specialAttack();
                // Eğer sadece karakter özel saldırı yapıyorsa
            } else {
                // Pokemon'un normal saldırı hasarını ata
                damage += attackingPokemon.getDamage();
                // Karakterin özel saldırı ekstra hasarını ata
                damage += attacker.getCharacter().getSpecialPower().getExtraDamage();
                // Karakterin kalan özel güç hakkını bir azalt
                attacker.getCharacter().getSpecialPower().setRemainingRights(charRemainingRights - 1);
            }
        }
        // Eğer özel saldırı yapılmıyorsa
        else {
            // Eğer sadece Pokemon veya sadece karakter özel saldırı yapmak istiyorsa hasarı 0 yap
            if (isPokeSpecialAttack || isCharSpecialAttack) {
                damage = 0;
            }
            // Normal durumda Pokemon'un normal saldırı hasarını ata
            else {
                damage += attackingPokemon.getDamage();
            }
        }
        // Savunan Pokemon'un sağlığını hasar kadar azalt
        defendingPokemon.setHealth(defendingPokemon.getHealth() - damage);
    }

    public boolean healthCheck(Player player) {
        // Oyuncunun Pokemonunun sağlığını kontrol et
        if (player.getCharacter().getPokemonList().get(0).getHealth() > 0) {
            // Eğer Pokemonun sağlığı 0'dan büyükse oyun devam ediyor
            System.out.println(player.toString());
            System.out.println("Oyun devam ediyor.");
            return true;

        } else {
            // Eğer Pokemonun sağlığı 0 veya daha küçükse oyuncu oyunu kaybetti
            System.out.println(player.toString());
            System.out.println(player.getName() + " oyunu kaybetti");
            return false;
        }
    }
}
