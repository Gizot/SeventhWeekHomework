package service;

import model.Character;
import model.Player;

public class PlayerService {
    // name: Oyuncunun ismi
// character: Oyuncunun seçtiği karakter
// Bu metot, verilen isim ve karakter bilgisiyle yeni bir oyuncu nesnesi oluşturur ve geri döndürür.
    public Player createPlayer(String name, Character character){
        return new Player(name, character);
    }
}
