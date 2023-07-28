package service;

import model.Player;
import model.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;

public class DirectingService {
    private final LoadService loadService = new LoadService();
    private final StageService stageService = new StageService();
    private final CharacterService characterService = new CharacterService();
    private final GameService gameService = new GameService();



    public void start(Scanner input) {
        PlayerService playerService = new PlayerService();
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        // Karakter ve Pokemonları oluşturma
        Player player1 = playerService.createPlayer(input);
        Player player2 = playerService.createPlayer(input);

        // Oyuncuların sırasını random olarak belirleme
        Player firstPlayer = (Math.random() < 0.5) ? player1 : player2;
        Player secondPlayer = (firstPlayer == player1) ? player2 : player1;

        // Oyun başlamadan önce oyuncuların seçtiği karakter ve pokémonları gösterme
        showPlayerInfo(player1);
        showPlayerInfo(player2);

        int round = 1;

        while (!player1.isWinner() && !player2.isWinner()) {
            System.out.println("\nRound " + round + " başlıyor!");
            stageService.applyWeatherEffects(player1, player2);

            // Sıranın kime ait olduğunu belirleme
            Player currentPlayer = (round % 2 == 1) ? firstPlayer : secondPlayer;
            Player opponentPlayer = (currentPlayer == player1) ? player2 : player1;

            // Sıra oyuncusunun hamle yapması
            performMove(input, currentPlayer, opponentPlayer);

            // Her raund sonunda kazanan oyuncunun pokemonunu son health değerinde tutma
            if (!currentPlayer.getCharacter().getPokemonList().isEmpty()) {
                currentPlayer.getCharacter().getPokemonList().get(0).setHealth(100);
            }

            // Her raund sonunda kaybedenin pokemonunu en düşük health değerine sahip pokemon ile değiştirme
            if (!opponentPlayer.getCharacter().getPokemonList().isEmpty()) {
                Pokemon lowestHealthPokemon = loadService.getWeakestPokemonForPlayer(opponentPlayer.getCharacter().getPokemonList());
                opponentPlayer.getCharacter().getPokemonList().remove(lowestHealthPokemon);
                opponentPlayer.getCharacter().getPokemonList().add(loadService.createLowestHealthPokemon());
            }

            // Her raund sonunda health check yapma
            if (currentPlayer.getCharacter().getPokemonList().isEmpty() || opponentPlayer.getCharacter().getPokemonList().isEmpty()) {
                // Oyunculardan biri kaybetti, oyunu bitirelim.
                break;
            }

            round++;
        }

        // Oyun sonucu
        if (player1.isWinner()) {
            System.out.println("\n" + player1.getName() + " kazandı!");
        } else {
            System.out.println("\n" + player2.getName() + " kazandı!");
        }
    }

    private void showPlayerInfo(Player player) {
        System.out.println("\n" + player.getName() + " karakteri seçti ve aşağıdaki Pokemonlara sahip:");
        for (Pokemon pokemon : player.getCharacter().getPokemonList()) {
            System.out.println("Pokemon: " + pokemon.getName() + "\tTip: " +
                    pokemon.getType() + "\tSağlık: " + pokemon.getHealth());
        }
    }

    private void performMove(Scanner scanner, Player currentPlayer, Player opponentPlayer) {
        boolean pokeSpecialAttack = Math.random() < 0.5;
        boolean charSpecialAttack = Math.random() < 0.5;

        System.out.println("\nSıra " + currentPlayer.getName() +
                "'de! Hamle yapmak için 1'e, oyundan çıkmak için 2'ye basın.");
        int moveChoice = scanner.nextInt();

        if (moveChoice == 2) {
            System.out.println("Oyuncu " + currentPlayer.getName() + " oyundan çıktı.");
            currentPlayer.getCharacter().getPokemonList().clear();
            return;
        }

        gameService.attack(currentPlayer, opponentPlayer, pokeSpecialAttack, charSpecialAttack);

        // Health check ve sonuçları gösterme
        if (!gameService.healthCheck(currentPlayer)) {
            opponentPlayer.setWinner(true);
        }

        if (!gameService.healthCheck(opponentPlayer)) {
            currentPlayer.setWinner(true);
        }
    }



}