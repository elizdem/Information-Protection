//D  O  N  E  T  S  K
//3  14 13 4  19 18 10

//D   E   M   K   O
//3   4   12  10  14 - исходные значения
//3   14  13  4   19 - значения ключа
//6   18  25  14  7  - значения шифрации
//G   S   Z   O   H  - зашифрованное слово


public class Vigener {

    //  ASCII: "H" is 72 && "S" is 83
	//	((72-65) + (83-65)) % 26 + 65 >> Encrypted "Z"
    public String encrypt(String Message, String Key) {
        String EMessage = "";
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            EMessage += (char)(((letter - 65) + (Key.charAt(j)-65)) % 26 + 65);
            j = ++j % Key.length();
        }
        return EMessage;
    }


    //	ASCII: "Z" is 90 && "S" is 83
    //	(90-83+26) % 26 + 65 >> Encrypted "Z"
    public String decrypt(String Message, String Key) {
        String DMessage = "";
        Message = Message.toUpperCase();
        for (int i = 0, j = 0; i < Message.length(); i++) {
            char letter = Message.charAt(i);
            DMessage += (char)((letter - Key.charAt(j) + 26) % 26 + 65);
            j = ++j % Key.length();
        }
        return DMessage;
    }
}
