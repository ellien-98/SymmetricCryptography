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


public class AB_Dec_finder {
    private static File currDirectory = new File(new File("").getAbsolutePath());
    private static String keyPath = currDirectory + "\\data\\key.txt";
    private static String msg1Path = currDirectory + "\\data\\msg1.txt";
    private static String msg2Path = currDirectory + "\\data\\msg2.txt";
    private static String ciph1Path = currDirectory + "\\data\\ciph1.txt";
    private static String ciph2Path = currDirectory + "\\data\\ciph2.txt";
    private static final int max_arr_size = 1000;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        System.out.println("Crypto assignment! ");

        int[] m1Arr = new int[max_arr_size];
        int m1sum = 0;
        int[] m2Arr = new int[max_arr_size];
        int m2sum = 0;
        int[] c1Arr = new int[max_arr_size];
        int c1sum = 0;
        int[] c2Arr = new int[max_arr_size];
        int c2sum = 0;

        int[] genKeyArr = new int[500];

        //Array for numbers
        int[] no0Arr = new int[]{0,0,1,1,0,0,0,0};
        int[] no1Arr = new int[]{0,0,1,1,0,0,0,1};
        int[] no2Arr = new int[]{0,0,1,1,0,0,1,0};
        int[] no3Arr = new int[]{0,0,1,1,0,0,1,1};
        int[] no4Arr = new int[]{0,0,1,1,0,1,0,0};
        int[] no5Arr = new int[]{0,0,1,1,0,1,0,1};
        int[] no6Arr = new int[]{0,0,1,1,0,1,1,0};
        int[] no7Arr = new int[]{0,0,1,1,0,1,1,1};
        int[] no8Arr = new int[]{0,0,1,1,1,0,0,0};
        int[] no9Arr = new int[]{0,0,1,1,1,0,0,1};

        // Array for the alphabet
        int[] aArr = new int[]{0,1,1,0,0,0,0,1 };
        int[] bArr = new int[]{0,1,1,0,0,0,1,0};
        int[] cArr = new int[]{0,1,1,0,0,0,1,1};
        int[] dArr = new int[]{0,1,1,0,0,1,0,0};
        int[] eArr = new int[]{0,1,1,0,0,1,0,1};
        int[] fArr = new int[]{0,1,1,0,0,1,1,0};
        int[] gArr = new int[]{0,1,1,0,0,1,1,1};
        int[] hArr = new int[]{0,1,1,0,1,0,0,0};
        int[] iArr = new int[]{0,1,1,0,1,0,0,1};
        int[] jArr = new int[]{0,1,1,0,1,0,1,0};
        int[] kArr = new int[]{0,1,1,0,1,0,1,1};
        int[] lArr = new int[]{0,1,1,0,1,1,0,0};
        int[] mArr = new int[]{0,1,1,0,1,1,0,1};
        int[] nArr = new int[]{0,1,1,0,1,1,1,0};
        int[] oArr = new int[]{0,1,1,0,1,1,1,1};
        int[] pArr = new int[]{0,1,1,1,0,0,0,0};
        int[] qArr = new int[]{0,1,1,1,0,0,0,1};
        int[] rArr = new int[]{0,1,1,1,0,0,1,0};
        int[] sArr = new int[]{0,1,1,1,0,0,1,1};
        int[] tArr = new int[]{0,1,1,1,0,1,0,0};
        int[] uArr = new int[]{0,1,1,1,0,1,0,1};
        int[] vArr = new int[]{0,1,1,1,0,1,1,0};
        int[] wArr = new int[]{0,1,1,1,0,1,1,1};
        int[] xArr = new int[]{0,1,1,1,1,0,0,0};
        int[] yArr = new int[]{0,1,1,1,1,0,0,1};
        int[] zArr = new int[]{0,1,1,1,1,0,1,0};

        //key to help generate the messages and then we will not use it again
        int[] keyArr = new int[max_arr_size];
        int keysum = 0;
        try {       //key generator
            FileReader keyfReader = new FileReader(keyPath);
            BufferedReader keybuffReader = new BufferedReader(keyfReader);
            int keyIndex = 0;
            int c = 0;

            while((c = keybuffReader.read()) != -1)     //Read char by Char
            {
                char character = (char) c;
                int intc = c - 48;
                if (isInt(character)){
                    keysum = keysum + 1 ;
                    keyArr[keyIndex++] = intc;
                }
                else{
                    continue;
                }
            }
            keybuffReader.close();
            /*
            System.out.println("Keysum total size:  " + keysum);
            for(int i=0; i<keysum; i++){
                System.out.print(keyArr[i]);
            }
             */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //msg1 array generator from file
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
                else {    continue;    }
            }
            msg1buffReader.close();
            //System.out.println("\nMessage 1 in binary: ");
            //System.out.println(Arrays.toString(m1Arr));
            /*
            System.out.println("Message 1 total size:  " + m1sum);
            for(int i=0; i<m1sum; i++){
                System.out.print(m1Arr[i]);
            }
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // message 2 array generator from file
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
            /* System.out.println("\nMessage 2 total size:  " + m2sum);
            System.out.println("Message 2 in binary: ");
            //System.out.println(Arrays.toString(m2Arr));
            for(int i=0; i<m2sum; i++){
                System.out.print(m2Arr[i]);
            } */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       //to check message's length to be smaller than the key's

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
        System.out.println("\nCiphertext1 total size: " + c1sum);
        System.out.println("ciphertext 1");
        for(int i=0; i<c1sum; i++){
            System.out.print(c1Arr[i]);
        } System.out.println(" ");

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
        System.out.println("ciphertext 2");
        for(int i=0; i<c2sum; i++){
            System.out.print(c2Arr[i]);
        }   System.out.println(" ");

        // algorithm for generating key
        int [] tmp1Arr = new int[8];
        int [] tmp2Arr = new int[8];
        int firstbit = 0;
        // ciphertext 1 is bigger so we use these bytes
        for(int i=0; i<c2sum; i+=8){     //for each loop we check 1 byte(8 bits)

                //System.out.println("we reached first 4 bits, we continue processing the next 4");
                // first we store in a temp array the next 4 bits of each ciphertext
                tmp1Arr[0] = c1Arr[i];
                tmp1Arr[1] = c1Arr[i+1];
                tmp1Arr[2] = c1Arr[i+2];
                tmp1Arr[3] = c1Arr[i+3];
                tmp1Arr[4] = c1Arr[i+4];
                tmp1Arr[5] = c1Arr[i+5];
                tmp1Arr[6] = c1Arr[i+6];
                tmp1Arr[7] = c1Arr[i+7];

                tmp2Arr[0] = c2Arr[i];
                tmp2Arr[1] = c2Arr[i+1];
                tmp2Arr[2] = c2Arr[i+2];
                tmp2Arr[3] = c2Arr[i+3];
                tmp2Arr[4] = c2Arr[i+4];
                tmp2Arr[5] = c2Arr[i+5];
                tmp2Arr[6] = c2Arr[i+6];
                tmp2Arr[7] = c2Arr[i+7];

                //THEN we XOR these next 4 bits with the known given numbers [0-9]
                String res0 = bits8XOR(tmp1Arr, no0Arr);
                String res1 = bits8XOR(tmp1Arr, no1Arr);
                String res2 = bits8XOR(tmp1Arr, no2Arr);
                String res3 = bits8XOR(tmp1Arr, no3Arr);
                String res4 = bits8XOR(tmp1Arr, no4Arr);
                String res5 = bits8XOR(tmp1Arr, no5Arr);
                String res6 = bits8XOR(tmp1Arr, no6Arr);
                String res7 = bits8XOR(tmp1Arr, no7Arr);
                String res8 = bits8XOR(tmp1Arr, no8Arr);
                String res9 = bits8XOR(tmp1Arr, no9Arr);

                String resl0 = bits8XOR(tmp2Arr, aArr);
                String resl1 = bits8XOR(tmp2Arr, bArr);
                String resl2 = bits8XOR(tmp2Arr, cArr);
                String resl3 = bits8XOR(tmp2Arr, dArr);
                String resl4 = bits8XOR(tmp2Arr, eArr);
                String resl5 = bits8XOR(tmp2Arr, fArr);
                String resl6 = bits8XOR(tmp2Arr, gArr);
                String resl7 = bits8XOR(tmp2Arr, hArr);
                String resl8 = bits8XOR(tmp2Arr, iArr);
                String resl9 = bits8XOR(tmp2Arr, jArr);
                String resl10 = bits8XOR(tmp2Arr, kArr);
                String resl11 = bits8XOR(tmp2Arr, lArr);
                String resl12 = bits8XOR(tmp2Arr, mArr);
                String resl13 = bits8XOR(tmp2Arr, nArr);
                String resl14 = bits8XOR(tmp2Arr, oArr);
                String resl15 = bits8XOR(tmp2Arr, pArr);
                String resl16 = bits8XOR(tmp2Arr, qArr);
                String resl17 = bits8XOR(tmp2Arr, rArr);
                String resl18 = bits8XOR(tmp2Arr, sArr);
                String resl19 = bits8XOR(tmp2Arr, tArr);
                String resl20 = bits8XOR(tmp2Arr, uArr);
                String resl21 = bits8XOR(tmp2Arr, vArr);
                String resl22 = bits8XOR(tmp2Arr, wArr);
                String resl23 = bits8XOR(tmp2Arr, xArr);
                String resl24 = bits8XOR(tmp2Arr, yArr);
                String resl25 = bits8XOR(tmp2Arr, zArr);

                // then we compare each of these results with the results of the second ciphertext
                // --------check res0
                if(res0.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                       // we found the match, we put the next 4 bits to the key, now continue to the next byte
                }
                else if(res0.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));

                }
                else if(res0.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));

                }
                else if(res0.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                else if(res0.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res0.charAt(7)));
                }
                //------------check res1
                else if(res1.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                else if(res1.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res1.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res1.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res1.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res1.charAt(7)));
                }
                // --------------check res2
                else if(res2.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                else if(res2.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res2.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res2.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res2.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res2.charAt(7)));
                }
                // ----------check res3
                else if(res3.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                else if(res3.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res3.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res3.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res3.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res3.charAt(7)));
                }
                // -------------check res4
                else if(res4.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                else if(res4.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res4.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res4.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res4.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res4.charAt(7)));
                }
                //----------------check res5
                else if(res5.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                else if(res5.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res5.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res5.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res5.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res5.charAt(7)));
                }
                // ------------check res6
                else if(res6.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(resl0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(resl0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(resl0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(resl0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(resl0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(resl0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(resl0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(resl0.charAt(7)));
                }
                else if(res6.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                else if(res6.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res6.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res6.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res6.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res6.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res6.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res6.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res6.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res6.charAt(7)));
                }
                //------------check res7
                else if(res7.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res1.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                else if(res7.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res7.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res7.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res7.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res7.charAt(7)));
                }
                // -----------------check res8
                else if(res8.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                else if(res8.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res8.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res8.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res8.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res8.charAt(7)));
                }
                //--------------------check res9
                else if(res9.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl10)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl11)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl12)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl13)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl14)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl15)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl16)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl17)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(resl0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(resl0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(resl0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(resl0.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(resl0.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(resl0.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(resl0.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(resl0.charAt(7)));
                }
                else if(res9.equals(resl18)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl19)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl20)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl21)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl22)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl23)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl24)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }
                else if(res9.equals(resl25)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                    genKeyArr[i+4] = Integer.parseInt(String.valueOf(res9.charAt(4)));
                    genKeyArr[i+5] = Integer.parseInt(String.valueOf(res9.charAt(5)));
                    genKeyArr[i+6] = Integer.parseInt(String.valueOf(res9.charAt(6)));
                    genKeyArr[i+7] = Integer.parseInt(String.valueOf(res9.charAt(7)));
                }


            //}

        }
        int genksum = genKeyArr.length;
        System.out.println("\ngenerated genKeyArr.length: "+ genksum);
        System.out.println("\nkey was generated!");
        for(int o=0; o<c2sum; o++){
            System.out.print(genKeyArr[o]);
        }
        System.out.println("\n");
        /*
         HERE GIVEN CIPHERTEXT1, CIPHERTEXT2 AND THE KEY WE WILL RETRIEVE THE MESSAGES
        */
        // STEP 1: XOR CIPHERTEXT1 AND THE KEY  TO RETRIEVE MESSAGE 1
        // message 1 generator:
        System.out.println("First we will generate the fist message through ciphertext 1 and the generated key (I apply XOR function and store results in the generated array): ");
        int m1idx = 0;
        int m1Sum = 0;
        int[] msg1Arr = new int[max_arr_size];      //generatedMessage2Array
        for (int i=0; i < c1sum ; i++){
            if(c1Arr[i] != genKeyArr[i] ){
                msg1Arr[m1idx] = 1;
                m1idx++;
                m1Sum++;
            }
            else if(c1Arr[i] == genKeyArr[i] ){
                msg1Arr[m1idx] = 0;
                m1idx++;
                m1Sum++;
            }
        }
        System.out.println("  ");
        System.out.println("generated message1 size: " + m1Sum);
        System.out.println("generated message1:  ");
        //System.out.println(Arrays.toString(genKeyArr));
        for(int i=0; i<m1Sum; i++){
            System.out.print(msg1Arr[i]);
        }
        System.out.println("\n");

        // STEP 2: XOR CIPHERTEXT2 AND THE KEY  TO RETRIEVE MESSAGE 2
        // message 2 generator:
        System.out.println("Now we will decrypt ciphertext 2 through C2 and the generated key, using XOR function: ");
        int genm2idx = 0;
        int genM2Sum = 0;
        int[] genM2Arr = new int[max_arr_size];    //generatedMessage2Array
        for (int i=0; i < c2sum ; i++){
            if(c2Arr[i] != genKeyArr[i] ){
                genM2Arr[genm2idx] = 1;
                genm2idx++;
                genM2Sum++;
            }
            else if(c2Arr[i] == genKeyArr[i] ){
                genM2Arr[genm2idx] = 0;
                genm2idx++;
                genM2Sum++;
            }
        }
        System.out.println("plaintext message 2 size: " + genM2Sum);
        System.out.println("plaintext message 2:  ");
        //System.out.println(Arrays.toString(genM2Arr));
        for(int i=0; i<genM2Sum; i++){
            System.out.print(genM2Arr[i]);
        }




    }



    public static String bits8XOR(int[] arr1, int[] arr2){
        String result = "";
        for(int i = 0; i<8; i++){
            if(arr1[i] == arr2[i]){
                result = result + "0";
            }
            else{
                result = result + "1";
            }
        }
        return result;
    }
    public static String bits4XOR(int[] arr1, int[] arr2){
        String result = "";
        for(int i = 0; i<4; i++){
            if(arr1[i] == arr2[i]){
                result = result + "0";
            }
            else{
                result = result + "1";
            }
        }
        return result;
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




















