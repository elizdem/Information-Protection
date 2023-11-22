import java.util.Arrays;

public class Slogan {

    //a b c d e f g h i j k l m n o p q r s t u v w x y z
    //d o n e t s k a b c f g h i j l m p q r u v w x y z
    //ethfj tgbzdotra
    public void slogan(){
        char [] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char [] slogan = "donetsk".toCharArray();
        char [] name = "demkoelizabeth".toCharArray();

        //Соединяем два массива вместе
        StringBuilder sb = new StringBuilder(64);
        sb.append(slogan);
        sb.append(alphabet);

        char finalAlphabet[] = sb.toString().toCharArray();

        //Удаляем повторяющиеся символы и получаем новый алфавит
        boolean [] seen = new boolean[256];

        StringBuilder stringBuilder = new StringBuilder(finalAlphabet.length);
        for(char c : finalAlphabet){
            if(!seen[c]){
                stringBuilder.append(c);
                seen[c] = true;
            }
        }
        char [] newAlphabet = stringBuilder.toString().toCharArray();  // готовый алфавит

        String encryptText = "";


        for (int i = 0; i < name.length; i++){
            for(int j = 0; j < alphabet.length; j++){
                if(alphabet[j] == name[i]){
                    encryptText += newAlphabet[j];
                }
            }
        }

        System.out.println("Slogan encryption:");
        System.out.println(encryptText);

        String descriptText = "";
         for(int i = 0; i < encryptText.length(); i++){
             for(int j = 0; j < newAlphabet.length; j++){
                if((newAlphabet[j] == encryptText.charAt(i))){
                    descriptText  += alphabet[j];
                 }
             }
         }

        System.out.println("Slogan description:");
        System.out.println(descriptText);
    }
}

