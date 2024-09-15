import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PTfinder {

    private static File currDirectory = new File(new File("").getAbsolutePath());
    private static String keyPath = currDirectory + "\\data\\key.txt";
    private static String msg1Path = currDirectory + "\\data\\msg1.txt";
    private static String msg2Path = currDirectory + "\\data\\msg2.txt";
    private static String ciph1Path = currDirectory + "\\data\\ciph1.txt";
    // private static String brokersPath = currDirectory + "\\data\\Brokers.txt";
    private static final int max_arr_size = 1900;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        System.out.print("Crypto assignment! ");

        // TODO: first i will create the first ciphertext with the given key, then I will "produce" the key
        // with the plaintext and the cipher text and finally I will use the produced key to find the

        // key generator:
        int[] keyArr = new int[max_arr_size];
        int keysum = 0;
        int[] m1Arr = new int[max_arr_size];
        int m1sum = 0;
        int[] m2Arr = new int[max_arr_size];
        int m2sum = 0;
        int[] c1Arr = new int[max_arr_size];
        int c1sum = 0;
        int[] c2Arr = new int[max_arr_size];
        int c2sum = 0;

        System.out.println("Here we have some information about the sizes: " );
        try {       //key generator
            FileReader keyfReader = new FileReader(keyPath);
            BufferedReader keybuffReader = new BufferedReader(keyfReader);

            int keyIndex = 0;
            // first we put all key characters in an array,
            // then we create a new array for the binary unencrypted file
            // then we compare each array and xor the same array cells and store it in new array
            //int[] intKeyArr = new int[];
            // ignore spaces when dealing with key
            int c = 0;

            //System.out.println("test if zeros are correct");
            //System.out.print(c + "  ");
            // System.out.println(keysum + "  ");
            while((c = keybuffReader.read()) != -1)     //Read char by Char
            {
                char character = (char) c;      //converting integer to char
                int intc = c - 48;
                if (isInt(character)){
                    //System.out.print(intc + "  ");
                    keysum = keysum + 1 ;
                    keyArr[keyIndex++] = intc;
                    //System.out.print(sum);
                    //System.out.print("\n");
                }
                else{
                    //System.out.println(" -it's a space- ");
                    continue;
                }
                //System.out.println("");
            }
            keybuffReader.close();
            //System.out.println("Key in binary: ");
            //System.out.println(Arrays.toString(keyArr));
           // System.out.println("Keysum (total size:  " + keysum);

            //System.out.println(sum);
            /*
            String line = buffReader.readLine();
            while (line != null) {
                txtLines.add(line.strip());
                line = buffReader.readLine();
            }
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // TODO: exw gemisei ton pinaka twn akeraiwn gia to kleidi, menei na kanw
        // kai ton  pinaka toy 2ou arxeiou

        // convert m1 binary txt to int array to process it
        try {

            FileReader msg1fReader = new FileReader(msg1Path);
            BufferedReader msg1buffReader = new BufferedReader(msg1fReader);

            int m1arrIndex = 0;
            int c = 0;
            while ((c = msg1buffReader.read()) != -1)
            {
                char character = (char) c;
                int intc = c - 48;
                if (isInt(character)){
                    m1sum = m1sum + 1 ;
                    m1Arr[m1arrIndex++] = intc;
                }
                else {
                    continue;
                }
            }
            msg1buffReader.close();
            //System.out.println("Message 1 in binary: ");
            //System.out.println(Arrays.toString(m1Arr));
            System.out.println("Message 1 total size:  " + m1sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       //to check message's length to be smaller than the key's
        //System.out.println("Message 1 total size:  " + m1sum + "key (total size:  " + keysum);

        // cipher message 1  generator through key and message 1
        ///System.out.println("ciphertext 1");
        int c1idx = 0;
        for (int i=0; i < m1sum ; i++){     // apply XOR
            if(m1Arr[i] != keyArr[i] ){     // if m1Arr[i] = 0 and keyArr[j] = 1 or the opposite
                c1Arr[c1idx] = 1;
                c1idx++;
                c1sum++;
                continue;
            }
            else if(m1Arr[i] == keyArr[i] ){     // if m1Arr[i] = 0 and keyArr[j] = 1 or the opposite
                c1Arr[c1idx] = 0;
                c1idx++;
                c1sum++;
                continue;
            }
        }
        //System.out.println("ciphertext1 length: " + c1Arr.length);
        System.out.println("Ciphertext1 total size: " + c1sum);
        //System.out.println(Arrays.toString(c1Arr));

        //convert message 2 binary text to int array to process it
        try {

            FileReader msg2fReader = new FileReader(msg2Path);
            BufferedReader msg2buffReader = new BufferedReader(msg2fReader);

            int m2arrIndex = 0;
            int c = 0;
            while ((c = msg2buffReader.read()) != -1)
            {
                char character = (char) c;
                int intc = c - 48;
                if (isInt(character)){
                    m2sum = m2sum + 1 ;
                    m2Arr[m2arrIndex++] = intc;
                }
                else {
                    continue;
                }
            }
            msg2buffReader.close();
            //System.out.println("Message 2 in binary: ");
            //System.out.println(Arrays.toString(m2Arr));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       //to check message's length to be smaller than the key's
        //System.out.println("Message 2 total size:  " + m2sum);

        // cipher message 2  generator through key and message 2
        //System.out.println("ciphertext 2");
        int c2idx = 0;
        for (int i=0; i < m2sum ; i++){
            if(m2Arr[i] != keyArr[i] ){
                c2Arr[c2idx] = 1;
                c2idx++;
                c2sum++;
                continue;
            }
            else if(m2Arr[i] == keyArr[i] ){
                c2Arr[c2idx] = 0;
                c2idx++;
                c2sum++;
                continue;
            }
        }
        System.out.println("Ciphertext2 total size: " + c2sum);
        for(int i=0; i<c2sum; i++){
            System.out.print(c2Arr[i]);
        }
        //System.out.println("ciphertext2 length: " + c2Arr.length);
        //System.out.println("cipher text 2 int array:  ");
        //System.out.println(Arrays.toString(c2Arr));

        /*
         HERE MY ALGORITHM BEGINS, GIVEN ONLY CIPHERTEXT1, CIPHERTEXT2 AND
         PLAINTEXT MESSAGE 1
        */

        // STEP 1: XOR CIPHERTEXT1 AND PLAINTEXT1  TO RETRIEVE THE KEY
        // key generator:
        System.out.println("  ");
        System.out.println("First we will generate the key through M1 and C1 (apply XOR function and store results in the generated key array): ");
        int kidx = 0;
        int genKeySum = 0;
        int[] genKeyArr = new int[max_arr_size];    //generatedKeyArray
        for (int i=0; i < c1sum ; i++){
            if(c1Arr[i] != m1Arr[i] ){
                genKeyArr[kidx] = 1;
                kidx++;
                genKeySum++;
                continue;
            }
            else if(c1Arr[i] == m1Arr[i] ){
                genKeyArr[kidx] = 0;
                kidx++;
                genKeySum++;
                continue;
            }
        }
        System.out.println("  ");
        System.out.println("generatedKeyArray size: " + genKeySum);
        System.out.println("generatedKeyArray:  ");
        //System.out.println(Arrays.toString(genKeyArr));
        for(int i=0; i<genKeySum; i++){
            System.out.print(genKeyArr[i]);
        }

        // NOW WE HAVE THE KEY SO WE WILL DECRYPT CIPHERTEXT 2 AND GET MESSAGE 1
        //  (We XOR ciphertext 2 and the generated key)
        System.out.println("");
        System.out.println("");
        System.out.println("Now we will decrypt ciphertext 2 through C2 and the key, using XOR function: ");
        int genm2idx = 0;
        int genM2Sum = 0;
        int[] genM2Arr = new int[max_arr_size];    //generatedMessage2Array
        for (int i=0; i < c2sum ; i++){
            if(c2Arr[i] != genKeyArr[i] ){
                genM2Arr[genm2idx] = 1;
                genm2idx++;
                genM2Sum++;
                continue;
            }
            else if(c2Arr[i] == genKeyArr[i] ){
                genM2Arr[genm2idx] = 0;
                genm2idx++;
                genM2Sum++;
                continue;
            }
        }
        System.out.println("plaintext message 2 size: " + genKeySum);
        System.out.println("plaintext message 2:  ");
        //System.out.println(Arrays.toString(genM2Arr));
        for(int i=0; i<genM2Sum; i++){
            System.out.print(genM2Arr[i]);
        }


        /*
        // key  generator through cipher message 1 and plaintext1
        int[] cryptoKeyArr = new int[max_arr_size];
        int c1idx = 0;
        int c1sum = 0;
        for (int i=0; i < m1sum ; i++){     // apply XOR
            if(m1Arr[i] != keyArr[i] ){     // if m1Arr[i] = 0 and keyArr[j] = 1 or the opposite
                c1Arr[c1idx] = 1;
                c1idx++;
                c1sum++;
                continue;
            }
            else if(m1Arr[i] == keyArr[i] ){     // if m1Arr[i] = 0 and keyArr[j] = 1 or the opposite
                c1Arr[c1idx] = 0;
                c1idx++;
                c1sum++;
                continue;
            }
        }
        System.out.println("ciphertext 1");
        System.out.println("c1Arr.length: " + c1Arr.length);
        System.out.println(Arrays.toString(c1Arr));
         */

       /* //method to write to file, not necessary
        try {
            FileWriter fWriter = new FileWriter(ciph1Path, true);
            for (int i=0; i < c1Arr.length; i++){
                fWriter.write(c1Arr[i]);
                // fWriter.write("\n" + c1Arr[i]);

            }
            fWriter.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        */

    }

    static boolean isInt(char c)
    {
        String s = "" + c;
        try{
            int i = Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException er)
        { return false; }
    }

}
