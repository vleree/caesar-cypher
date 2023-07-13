import java.util.Scanner;

public class CeasarCipher{
    private Integer key;
    private char[] alphabet;

    public CeasarCipher(Integer key){
        this.key=key;
        this.alphabet=new char[26];
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = (char)('a' + i);
        }
    }   
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to your personalised encrypt/decrypt app <3<3");
        System.out.println("************************************************************");
        System.out.println("Stating that number 1 is for encryption and number 2 is for decryptio"+
        " please enter what you want to do: ");
        int select = scan.nextInt();
        System.out.println("Please enter the key: ");
        int key = scan.nextInt();
        CeasarCipher ceasarCipher = new CeasarCipher(key);

        switch(select){
            case 1: 
            System.out.println("Please type what you want to encrypt all lowercase: ");
            String stringToEncrypt = scan.next();
            System.out.println("Your line encrypted: ");
            System.out.println(ceasarCipher.encrypt(stringToEncrypt));
            break;
            case 2:
            System.out.println("Please type what you want to decrypt all lowercase: ");
            String stringToDecrypt = scan.next();
            System.out.println("Your line decrypted: ");
            System.out.println(ceasarCipher.decrypt(stringToDecrypt));
            break;            
        }
        //System.out.println(ceasarCipher.decrypt(ceasarCipher.encrypt("abcdefghijklmnopqrstuvwxyz")));
        //System.out.println(ceasarCipher.encrypt("we aleykum selam motrushe"));
        //System.out.println(ceasarCipher.decrypt("nxv nxv"));

        scan.close();
    }

   
    public String encrypt(String txt) {
        String qaravesht="";
        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            int index = indexOf(alphabet,c);
            if(index==-1){
                qaravesht+=c;
            }else{
                int newIndex= index + key>25 ? (index+key)%26:index+key;
                qaravesht+=alphabet[newIndex];
            }

        }
        return qaravesht;
    }

    
    public String decrypt(String str) {
        String aqaravesht="";
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int index = indexOf(alphabet,c);
            if(index==-1){
                aqaravesht += c;
            }else{
                int newIndex= index - key<0 ? index-key+26:index-key;
                aqaravesht+=alphabet[newIndex];
            }
        }
        return aqaravesht;
    }

    int indexOf(char[] arr,char c){
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==c){
                return i;
            }
        }
        return -1;
    }
    
}
