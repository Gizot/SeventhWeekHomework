import model.*;
import service.*;
import model.Character;
import service.CharacterService;
import service.GameService;
import service.LoadService;
import service.PlayerService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DirectingService game = new DirectingService();
        game.start(scanner);
    }
}