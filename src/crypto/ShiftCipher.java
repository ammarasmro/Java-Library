package crypto;

import java.util.HashMap;
import java.util.Map;

public class ShiftCipher {

    private String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l","m","n","o","p","q","r",
            "s","t","u","v","w","x","y","z"};

    private Map<String, Integer> alphabetMap;

    int key;

    public ShiftCipher(int key){
        alphabetMap = new HashMap<>();
        for(int i = 0; i < 26; i++){
            alphabetMap.put(alphabet[i], i);
        }
        this.key = key;
    }

    public String encrypt(String text){
        StringBuilder sb = new StringBuilder();
        text = text.toLowerCase();
        for(String letter: text.split("")){
            sb.append(alphabet[(alphabetMap.get(letter) + key) % 26]);
        }
        return sb.toString();
    }

    public String decrypt(String text){
        StringBuilder sb = new StringBuilder();
        text = text.toLowerCase();
        for(String letter: text.split("")){
            sb.append(alphabet[(alphabetMap.get(letter) - key) % 26]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ShiftCipher cipherEngine = new ShiftCipher(3);
        String testString = "Ammar";
        System.out.println("Test string is:\t\t" + testString);
        String encrypted = cipherEngine.encrypt(testString);
        System.out.println("Encrypted text:\t\t" + encrypted);
        System.out.println("Decrypted text:\t\t" + cipherEngine.decrypt(encrypted));

    }



}
