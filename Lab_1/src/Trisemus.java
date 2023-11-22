import java.util.*;
import java.io.*;

public class Trisemus  {

//    d o n e t s
//    k a b c d g
//    h i j l m p
//    q r u v w x
//    y z - - - -

    //kcwha cvaojcdk

private String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private char[][] alphabetTable;
    private char[][] newAlphabetTable;

    private char[]  deleteDuplicationsInSlogan(String slogan){
        char[] sloganCharArray = slogan.toCharArray();
        List<Character> finallySlogan = new ArrayList<Character>();

        for(int i = 0; i < sloganCharArray.length; i++){
            if(finallySlogan.contains(sloganCharArray[i])){
                continue;
            }
            else {
                finallySlogan.add(sloganCharArray[i]);
            }
        }

        String finallySloganString = "";
        for(int i = 0; i < finallySlogan.size(); i++){
            finallySloganString += finallySlogan.get(i);
        }
        return finallySloganString.toCharArray();
    }
    private char[] makeNewAlphabet(String finnalySlogan){
        List<Character> newAlphabet = new ArrayList<Character>();

        for(int i = 0; i < finnalySlogan.toCharArray().length; i++){
            newAlphabet.add(finnalySlogan.toCharArray()[i]);
        }
        int count = newAlphabet.size();
        for(int i = 0; i < alphabet.length(); i++){
            if(newAlphabet.contains(alphabet.toCharArray()[i])){
                continue;
            }
            else {
                newAlphabet.add(alphabet.toCharArray()[i]);
            }
        }
        String newAlphabetString = "";
        for(int i = 0; i < newAlphabet.size(); i++){
            newAlphabetString += newAlphabet.get(i);
        }
        return newAlphabetString.toCharArray();
    }

    private char[][] fillNewAlphabetTable(String slogan){
        char[][] table = new char[6][6];
        char[] newAlphabet = makeNewAlphabet(String.valueOf(deleteDuplicationsInSlogan(slogan)));
        int count = 0;
        for(int i = 0; i < table[0].length; i++){
            for(int j = 0; j < table[1].length; j++){
                if (count > alphabet.length() - 1) {
                    break;
                }
                table[i][j] = newAlphabet[count++];
            }
        }
        return table;
    }
    public void printTrisemusAlphabetTable(String slogan) {
        char[][] TrisemusAlphabetTable = fillNewAlphabetTable(slogan);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.println();
                }
                System.out.print(TrisemusAlphabetTable[i][j]);
            }
        }
        System.out.println();
    }
    public void printAlphabetTable() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.println();
                }
                System.out.print(alphabetTable[i][j]);
            }
        }
        System.out.println();
    }

    private String findSymbolIndexInTrisemusTable(char c) {
        String pos = "";
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                if (newAlphabetTable[i][j] == Character.toLowerCase(c)) {
                    pos = String.format("%d%d", i + 1, j + 1);
                }

            }
        }
        return pos;
    }

    private int[] makeTrisemusSymbulIndex(String oldIndex){
        char[] indexesInCharArr = oldIndex.toCharArray();
        int[] pos = new int[2];
        pos[1] = Integer.parseInt(String.valueOf(indexesInCharArr[1]))-1;
        // err mb
        if(Integer.parseInt(String.valueOf(indexesInCharArr[0])) >= newAlphabetTable[0].length){
            pos[0] = 0;
        }
        else {
            pos[0] = Integer.parseInt(String.valueOf(indexesInCharArr[0]));
        }

        return pos;
    }
    private int[] makeAlphabetSymbulIndex(String oldIndex){
        char[] indexesInCharArr = oldIndex.toCharArray();
        int[] pos = new int[2];
        pos[1] = Integer.parseInt(String.valueOf(indexesInCharArr[1]))-1;
        // err mb
        if(Integer.parseInt(String.valueOf(indexesInCharArr[0])) == 0){
            pos[0] = newAlphabetTable.length;
        }
        else {
            pos[0] = Integer.parseInt(String.valueOf(indexesInCharArr[0]))-2;
        }

        return pos;
    }

    public String TrisemusChiperEncrypt(String word, String slogan){
        String finalyString = "";

        char[] wordInCharArr = word.toCharArray();
        newAlphabetTable = fillNewAlphabetTable(slogan);
        for(char c : wordInCharArr){
            String wordCharIndex = findSymbolIndexInTrisemusTable(c);
            int[] indexes = makeTrisemusSymbulIndex(wordCharIndex);
            finalyString += newAlphabetTable[indexes[0]][indexes[1]];
        }
        System.out.println(finalyString);
        return finalyString;

    }

    public String TrisemusChiperDecrypt(String word, String slogan){
        String finalyString = "";
        char[] wordInCharArr = word.toCharArray();
        newAlphabetTable = fillNewAlphabetTable(slogan);
        for(char c : wordInCharArr){
            String wordCharIndex = findSymbolIndexInTrisemusTable(c);
            int[] indexes = makeAlphabetSymbulIndex(wordCharIndex);
            finalyString += newAlphabetTable[indexes[0]][indexes[1]];

        }
        return finalyString;
    }

}
