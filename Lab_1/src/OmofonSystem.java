import java.util.*;

//abcdefghijklmnopqrstuvwxyz
//ABCDEFGHIJKLMNOPQRSTUVWXYZ
public class OmofonSystem {
    OmofonSystem(){
        fillOmofonDictionary();
    }
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private final int[][] nums = {{714, 282}, {436, 259}, {958, 171}, {198, 246}, {373, 654}, {621, 355},
            {911, 140}, {547, 515}, {468, 671}, {170, 552}, {775, 335}, {243, 379},
            {922, 939}, {235, 276}, {618, 179}, {218, 953}, {356, 822}, {512, 266},
            {797, 249}, {383, 846}, {934, 362}, {525, 295}, {432, 293}, {136, 457},
            {798, 759}, {695, 967}
    };
    private HashMap<Character, Integer[]> omofonDictionary = new HashMap<Character, Integer[]>();

    private  <K, V> K getKeyInArray(Map<K, Integer[]> map, V value)
    {
        for (Map.Entry<K, Integer[]> entry: map.entrySet())
        {
            Integer[] nums = entry.getValue();
            for(int i = 0; i < nums.length; i++){
                if (value.equals(nums[i])) {
                    return entry.getKey();
                }
            }

        }
        return null;
    }
    private void fillOmofonDictionary(){
        char[] aplhabetCharArr = alphabet.toCharArray();
        for(int i = 0; i < aplhabetCharArr.length; i++){
            int count = 0;
            Integer[] charNums = {nums[i][count++], nums[i][count]};
            omofonDictionary.put(aplhabetCharArr[i], charNums);
        }
    }
    private int SetNumberToLetter(char c, String text){
        int num;
        Random random = new Random();
        Integer[] charDigits = omofonDictionary.get(c);
        for(Integer charDigit : charDigits){
            if(CheckOnExist(charDigit, text) == true){
                continue;
            }
            else {
                if(CheckOnExist(charDigit, text) == false){
                    return charDigit;
                }
                else {
                    return charDigits[random.nextInt(2)];
                }
            }
        }
        return charDigits[random.nextInt(2)];
    }
    private boolean CheckOnExist(int num, String text){
        boolean exist = false;
        String numInText = String.valueOf(num);
        if(text.contains(numInText)){
            exist = true;
        }
        return exist;
    }

    public String OmofonSystemEncrypt(String text){

        String newText = "";
        char[] textInCharArr = text.toCharArray();
        for(int i = 0 ; i < textInCharArr.length; i++){
            newText += " " + String.valueOf(SetNumberToLetter(textInCharArr[i], newText));
        }
        return newText;
    }
    public String OmofonSystemDecrypt(String text){

        String newText = "";
        String[] nums = text.split(" ");

        for(int i = 0 ; i < nums.length; i++){
            if(!nums[i].isEmpty()){
                newText += getKeyInArray(omofonDictionary, Integer.parseInt(nums[i]));
            }
        }
        return newText;
    }

    public void printOmofons(){
        char[] alphabetChars = alphabet.toCharArray();
        for(int i = 0; i < alphabetChars.length; i++){
            System.out.print(alphabetChars[i] + ": ");
            for(int num : omofonDictionary.get(alphabetChars[i])){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
