package service;

import model.Ash;
import model.Character;
import model.SpecialPower;

import java.util.ArrayList;
import java.util.Scanner;

public class CharacterService {
    LoadService loadService = new LoadService();
    Scanner input = new Scanner(System.in);
    public void selectChar(){
        ArrayList<Character> characterList = new ArrayList<>();
        System.out.println("--------------------------------");
        System.out.println("Karakterinizi seçiniz");
        for(Character character : characterList) {

            System.out.println(characterList.get(0).getId() + "\t" + characterList.get(0).getName() +
                    characterList.get(1).getId() + "\t" + characterList.get(1).getName() +
                    characterList.get(2).getId() + "\t" + characterList.get(2).getName() +
                    characterList.get(3).getId() + "\t" + characterList.get(3).getName() );
        }
        int selectChar = input.nextInt();
        switch (selectChar) {
            case 1:
                loadService.loadCharacters().get(0);
                break;
            case 2:
                loadService.loadCharacters().get(1);
                break;
            case 3:
                loadService.loadCharacters().get(2);
            case 4:
                loadService.loadCharacters().get(3);

        }


        for (Character character : characterList) {
            System.out.println("Karakter: " + character.getName()
            + "\t\t Özel güç: " + character.getSpecialPower().getName());
        }
    }
    public Character characterChoice(ArrayList<Character> characterList) {

        int characterChoice = 0;

        System.out.println("Karakterinizi seçmek için bir rakam girin:");
        System.out.println("1-Jessie\n2-James\n3-Ash\n4-Brooke");

        while (characterChoice < 1 || characterChoice > 4) {
            try {
                characterChoice = input.nextInt();
                System.out.println("Karakteriniz başarılı bir şekilde seçildi");
                if (characterChoice < 1 || characterChoice > 4) {
                    System.out.println("Geçersiz bir seçim yaptınız. Tekrar deneyin:");
                }
            } catch (Exception e) {
                System.out.println("Geçersiz bir giriş yaptınız. Rakam seçin:");
                input.next();
            }
        }

        return characterList.get(characterChoice - 1);
    }

}
