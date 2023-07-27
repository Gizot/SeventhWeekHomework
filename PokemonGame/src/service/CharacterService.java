package service;

import model.Ash;
import model.Character;
import model.SpecialPower;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterService {
    Scanner scanner = new Scanner(System.in);
    public Character characterChoice(ArrayList<Character> characterList) {

        int characterChoice = 0;

        System.out.println("Karakterinizi seçmek için bir rakam girin:");
        System.out.println("1-Jessie\n2-James\n3-Ash\n4-Brooke");

        while (characterChoice < 1 || characterChoice > 4) {
            try {
                characterChoice = scanner.nextInt();
                System.out.println("Karakteriniz başarılı bir şekilde seçildi");
                if (characterChoice < 1 || characterChoice > 4) {
                    System.out.println("Geçersiz bir seçim yaptınız. Tekrar deneyin:");
                }
            } catch (Exception e) {
                System.out.println("Geçersiz bir giriş yaptınız. Rakam seçin:");
                scanner.next();
            }
        }

        return characterList.get(characterChoice - 1);
    }

}
