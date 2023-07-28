package service;

import model.Character;
import model.Player;
import model.Pokemon;
import model.WeatherConditionsEnum;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DirectingService {
    public static void beginningStage(Scanner input){
        //Oyun başlangıç aşamasında kullanıcıya gösterilecek intro ve yönlendirmeler.
        System.out.println("\n" +
                "jessie: belaya hazır olun!\n" +
                "james: hem de çifte belaya!\n" +
                "jessie: dünyayı yok olmaktan kurtarmak için!\n" +
                "james: tüm insanlığı ulusumuzla birleştirmek için!\n" +
                "jessie: gerçeğin ve sevginin kötülüklerini açığa vurmak için!\n" +
                "james: amacımız yıldızlara ulaşıncaya kadar!\n" +
                "jessie: jessie!\n" +
                "james: james!\n" +
                "jessie: roket takımı her zaman ışık hızıyla hareket eder!\n" +
                "james: ya teslim olun, ya da savaşmaya hazır olun!\n" +
                "meowth: miyavVV! işte bu çok doğru!  ");
        System.out.println("*****************************************************************");
        System.out.println("1- Oyuna başlayalım.");
        System.out.println("2- Çıkış yapmak istiyorum.");

        int choice = input.nextInt();
        if (choice == 1) {
            directingGame(input);
        } else if (choice == 2) {
            System.out.println("Çıkışşş Yapılıyorr :|");
            System.exit(0);
        } else {
            System.out.println("Geçersiz seçim yaptınız. Lütfen 1 veya 2 tuşuna basınız.");
        }
    }
    public static void directingGame(Scanner input) {
        //Kod yazarken ulaşmamız gereken servisler burada
        LoadService loadService = new LoadService();
        PlayerService playerService = new PlayerService();
        GameService gameService = new GameService();
        WeatherConditionService weatherConditionService = new WeatherConditionService();

        ArrayList<Character> characterList = loadService.loadCharacters();
        System.out.println("------Characters------");
        //Karakterleri listeledik.
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println((i + 1) + "- " + characterList.get(i).toString());
        }
        // karakter seçimi yapılıyor.
        System.out.print("\nPlayer 1 : , Karakter seçiminizi yapınız (1-" + characterList.size() + "): ");
        int player1CharacterIndex = input.nextInt() - 1;
        Character player1Character = characterList.get(player1CharacterIndex);

        System.out.print("Player 1, için bir isim  giriniz: ");
        String player1Name = input.next();
        Player player1 = playerService.createPlayer(player1Name, player1Character);

        characterList.remove(player1CharacterIndex);

        System.out.println("------Characters------");
        for (int i = 0; i < characterList.size(); i++) {
            System.out.println((i + 1) + " - " + characterList.get(i).toString());
        }

        System.out.print("\nPlayer 2 : , Karakter seçiminizi yapınız (1-" + characterList.size() + "): ");
        int player2CharacterIndex = input.nextInt() - 1;
        Character player2Character = characterList.get(player2CharacterIndex);

        System.out.print("Player 2, için bir isim  giriniz: ");
        String player2Name = input.next();
        Player player2 = playerService.createPlayer(player2Name, player2Character);

        //Pokemonları listeledik
        ArrayList<Pokemon> pokemonList = loadService.loadPokemons();
        System.out.println("\n------Pokemon--------");
        for (int i = 0; i < pokemonList.size(); i++) {
            System.out.println((i + 1) + " - " + pokemonList.get(i).toString());
        }

        //Kullanıcı için pokemon seçimi yaptırıldı burada indexin
        // 0 dan başlamasına çözüm olarak kullanıcı girişini bir azalttık.
        System.out.println( player1Name + "\nPlayer 1 : , bir Pokemon seçin (1-" + pokemonList.size() + "): ");
        int player1PokemonIndex = input.nextInt() - 1;
        player1.getCharacter().getPokemonList().add(pokemonList.get(player1PokemonIndex));

        pokemonList.remove(player1PokemonIndex);

        System.out.println("\n------Pokemon--------");
        for (int i = 0; i < pokemonList.size(); i++) {
            System.out.println((i + 1) + "- " + pokemonList.get(i).toString());
        }

        System.out.println("Oyuncu 2, bir Pokemon seçin (1-" + pokemonList.size() + "): ");
        int player2PokemonIndex = input.nextInt() - 1;
        player2.getCharacter().getPokemonList().add(pokemonList.get(player2PokemonIndex));

        Random random = new Random();
        boolean isPlayer1Turn = random.nextBoolean();

        int roundCount = 1;
        final int maxRounds = 2;
        WeatherConditionsEnum weatherConditionsEnum = weatherConditionService.getWeatherConditions();
        weatherConditionService.applyWeatherEffects(player1, player2);

        while (true) {
            if (gameService.healthCheck(player1) && gameService.healthCheck(player2)) {
                if (isPlayer1Turn) {
                    System.out.println("\n" + player1.getName() + "'in sırası: ");
                    selectDisplayOptions(input, gameService, player1, player2);
                } else {
                    System.out.println("\n" + player2.getName() + "'in sırası: ");
                    selectDisplayOptions(input, gameService, player2, player1);
                }
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                System.out.println("Round " + (roundCount));
                roundCount++;

                //When the round ends, the losing player's Pokemon passes to the winning player
                if (player1.getCharacter().getPokemonList().get(0).getHealth() <= 0 && player2.getCharacter().
                        getPokemonList().get(0).getHealth() > 0) {
                    //Player1 lost
                    System.out.println(player1.getName() + " oyunu kaybetti.");
                    int initialWinnerHealth = player2.getCharacter().getPokemonList().get(0).getHealth();

                    player2.getCharacter().getPokemonList().set(0, player1.getCharacter().getPokemonList().get(0));
                    player2.getCharacter().getPokemonList().get(0).setHealth(initialWinnerHealth);

                    Pokemon weakestPokemonForPlayer1 = loadService.getWeakestPokemonForPlayer(pokemonList);
                    player1.getCharacter().getPokemonList().set(0, weakestPokemonForPlayer1);
                    player1.getCharacter().getPokemonList().get(0).setHealth(weakestPokemonForPlayer1.getMaxHealth());

                    System.out.println(player1);
                    System.out.println(player2);
                } else if (player2.getCharacter().getPokemonList().get(0).getHealth() <= 0 && player1.getCharacter().
                        getPokemonList().get(0).getHealth() > 0) {
                    //Player2 lost
                    System.out.println(player2.getName() + " oyunu kaybetti.");
                    int initialWinnerHealth = player1.getCharacter().getPokemonList().get(0).getHealth();

                    player1.getCharacter().getPokemonList().set(0, player2.getCharacter().getPokemonList().get(0));
                    player1.getCharacter().getPokemonList().get(0).setHealth(initialWinnerHealth);

                    Pokemon weakestPokemonForPlayer1 = loadService.getWeakestPokemonForPlayer(pokemonList);
                    player2.getCharacter().getPokemonList().set(0, weakestPokemonForPlayer1);
                    player2.getCharacter().getPokemonList().get(0).setHealth(weakestPokemonForPlayer1.getMaxHealth());

                    System.out.println(player1);
                    System.out.println(player2);
                }

                //Exit the loop when the 2nd hand of the game is completed
                if (roundCount == maxRounds + 1) {
                    System.out.println("Oyun tamamlandı.");
                    break;
                }
            }
        }
    }

    public static void selectDisplayOptions(Scanner input, GameService gameService, Player attacker, Player defender) {
        System.out.println("Saldırı Seçenekleri:");
        System.out.println("1- Normal Saldırı");
        System.out.println("2- Pokemon Özel Güç Saldırısı");
        System.out.println("3- Karakter Özel Güç Saldırısı");
        System.out.print("Seçiminizi yapın (1-3): ");

        int option = input.nextInt();

        if (option == 1) {
            gameService.attack(attacker, defender, false, false);
        } else if (option == 2) {
            gameService.attack(attacker, defender, true, false);
        } else if (option == 3) {
            gameService.attack(attacker, defender, false, true);
        }
    }



}