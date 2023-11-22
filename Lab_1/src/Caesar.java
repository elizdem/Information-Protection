public class Caesar {
    public void Caesar(){
        String surname = "Демко Елизавета";
        int key = 5;
        char [] array = new char[surname.length()];

        System.out.println("Caesar encryption: ");
        for (int i = 0; i < surname.length(); i++){
            if(Character.isLetter(surname.charAt(i)) && Character.isUpperCase(surname.charAt(i))){
                array[i] = (char) ((((int)(surname.charAt(i)) - 'А' + key) % 33) + 'А');
            }

            else if(Character.isLetter(surname.charAt(i)) && Character.isLowerCase(surname.charAt(i))){
                array[i] = (char) ((((int)(surname.charAt(i)) - 'а' + key) % 33) + 'а');
            }

            else{
                array[i] = surname.charAt(i);
            }
        }

        System.out.println( array);

        System.out.println("Caesar description: ");
        String newsurname = String.copyValueOf(array);
        for (int i = 0; i < newsurname.length(); i++){
            if(Character.isLetter(newsurname.charAt(i)) && Character.isUpperCase(newsurname.charAt(i))){
                array[i] = (char) ((((int)(newsurname.charAt(i))  - key - 'А') % 33) + 'А');
            }

            else if(Character.isLetter(newsurname.charAt(i)) && Character.isLowerCase(newsurname.charAt(i))){
                array[i] = (char) ((((int)(newsurname.charAt(i)) - key - 'а' ) % 33) + 'а');
            }

            else{
                array[i] = newsurname.charAt(i);
            }
        }
        System.out.println(array);

    }

}
