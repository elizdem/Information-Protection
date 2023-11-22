import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String name = "demkoelizabeth";


        //CAESAR CIPHER
        Caesar caesar = new Caesar();
        caesar.Caesar();
        System.out.println();
        System.out.println();


        //POLYBIAN CIPHER
        Polybian polybian = new Polybian();
        polybian.createTable();
        System.out.println("Polybian encryption:");
        String encryptionPolybian = polybian.encrypt("DEMKO");
        System.out.println(encryptionPolybian);
        System.out.println("Polybian description:");
        System.out.println(polybian.decrypt(encryptionPolybian));
        System.out.println();
        System.out.println();


        //SLOGAN CIPHER
        Slogan slogan = new Slogan();
        slogan.slogan();
        System.out.println();
        System.out.println();


        //TRISEMUS CIPHER
        Trisemus trisemus = new Trisemus();
        System.out.println("Trisemus encryption:");
        String encryptedTrisemus = trisemus.TrisemusChiperEncrypt("demko", "donetsk");
        System.out.println("Trisemus description:");
        System.out.println(trisemus.TrisemusChiperDecrypt(encryptedTrisemus, "donetsk"));
        System.out.println();
        System.out.println();


        //PLAYFAIR CIPHER
        Playfair x = new Playfair();
        Scanner sc = new Scanner(System.in);
        String keyword = "donetsk";
        x.setKey(keyword);
        x.KeyGen();
        String key_input = "demkoelizabeth";
        System.out.println("Playfair encryption: " + x.encryptMessage(key_input));
        System.out.println("Playfair decryption: " + x.decryptMessage(x.encryptMessage(key_input)));
        System.out.println();
        System.out.println();


        //VIGENER CIPHER
        Vigener vigener = new Vigener();
        String key = "DONETSK";
        String EMessage = "DEMKOELIZABETH";
        String encryptMessage = vigener.encrypt(EMessage, key);
        System.out.println("Vigener encryption: " + encryptMessage);

        String DMessage = vigener.encrypt(EMessage, key);
        String decryptMessage = vigener.decrypt(DMessage, key);
        System.out.println("Vigener description: " + decryptMessage);
        System.out.println();
        System.out.println();


        //OMOFON SYSTEM

        OmofonSystem os = new OmofonSystem();
        System.out.println("Table");
        os.printOmofons();
        System.out.println("Omofon encryption: ");
        String encryptionOmofon = os.OmofonSystemEncrypt(name);
        System.out.println(encryptionOmofon);
        System.out.println("Omofon description: ");
        System.out.println(os.OmofonSystemDecrypt(encryptionOmofon));
        System.out.println();
        System.out.println();
    }
}