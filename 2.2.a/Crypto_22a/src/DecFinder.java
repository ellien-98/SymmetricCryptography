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

public class DecFinder {

    private static File currDirectory = new File(new File("").getAbsolutePath());
    private static String keyPath = currDirectory + "\\data\\key.txt";
    private static String msg1Path = currDirectory + "\\data\\msg1.txt";
    private static String msg2Path = currDirectory + "\\data\\msg2.txt";
    private static String ciph1Path = currDirectory + "\\data\\ciph1.txt";
    private static String ciph2Path = currDirectory + "\\data\\ciph2.txt";
    private static final int max_arr_size = 1200;

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        System.out.println("Crypto assignment! ");

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
        int[] numArr = new int[]{110000, 110001, 110010, 110011, 110100, 110101, 110110, 110111, 111000, 111001};     //10 positions, 0-9
        int[] no0Arr = new int[]{ 0 , 0, 0, 0 };
        int[] no1Arr = new int[]{ 0 , 0, 0, 1 };
        int[] no2Arr = new int[]{ 0 , 0, 1, 0 };
        int[] no3Arr = new int[]{ 0 , 0, 1, 1 };
        int[] no4Arr = new int[]{ 0 , 1, 0, 0 };
        int[] no5Arr = new int[]{ 0 , 1, 0, 1 };
        int[] no6Arr = new int[]{0 , 1, 1, 0 };
        int[] no7Arr = new int[]{ 0 , 1, 1, 1 };
        int[] no8Arr = new int[]{1 , 0, 0, 0 };
        int[] no9Arr = new int[]{1 , 0, 0, 1 };

        int[] genKeyArr = new int[500];   //bc c2 is bigger

        // read key to find the ciphertexts
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
                    //System.out.print(intc + "  ");
                    keysum = keysum + 1 ;
                    keyArr[keyIndex++] = intc;
                }
                else{
                    continue;
                }
            }
            keybuffReader.close();
             //System.out.println("Keysum total size:  " + keysum);

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
                else {
                    continue;
                }
            }
            msg1buffReader.close();
            //System.out.println("Message 1 in binary: ");
            //System.out.println(Arrays.toString(m1Arr));
            // System.out.println("Message 1 total size:  " + m1sum);
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
            //System.out.println("Message 2 in binary: ");
            //System.out.println(Arrays.toString(m2Arr));
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
        System.out.println("Ciphertext1 total size: " + c1sum);
        System.out.println("ciphertext 1");
        for(int i=0; i<c1sum; i++){
            System.out.print(c1Arr[i]);
        } System.out.println(" ");
        //System.out.println(Arrays.toString(c1Arr));

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
        //System.out.println("ciphertext2 length: " + c2Arr.length);
        //System.out.println("cipher text 2 int array:  ");
        //System.out.println(Arrays.toString(c2Arr));

        // key generator
        System.out.println("Now the algorithm begins. We know that both decrypted messages are decimal numbers, so we use this " +
                "information to create the key. We check in each loop 8 bits (1 byte). For numbers 0-9, in their binary representation," +
                " the first 4 bits are '0011'.  So for the first 4 bits we check the corresponding ciphertext's first 4 bits, and " +
                "based on the XOR function you decide which bit you must place at this cell of the newly generated key (for example" +
                "if the first bit of the ciphertext's byte is '1', we want as result the number zero -0011 is the sequence we need" +
                "to have in the end-, so we place number 0 at this cell of the key bc 0 XOR 0 -> 1 ). Now, for the next 4 bits of" +
                "this byte, we follow a different procedure. First, we got the decimal representation of all the numbers (0-9) (4 bits in" +
                " length). Next, we take ciphertext's 1 next 4 bits. We XOR them with all the numbers and we store all the results" +
                ". Then we take ciphertext's 2 next 4 bits (of the same byte ofcourse) and XOR them with all the numbers as well. " +
                "Then we compare the results of the results of ciphertext1 and ciphertext2. There will be one match, and this match " +
                "will give us the last 4 bits of this byte, and the iteration ends. This is because the same key has encrypted both" +
                "original messages, so the output must correspond both ciphertexts. This one unique sequence of 4 bits that is the " +
                "same for both ciphertext (when we XOR them with the binary value of the numbers), is the one that belongs to the key" +
                "as well, because the same key encrypted both plaintexts. Now we will implement this logic, extract the key and finally" +
                " find the plaintexts");
        int [] tmp1Arr = new int[4];
        int [] tmp2Arr = new int[4];
        int first4bits = 0;
        for(int i=0; i<c1sum; i+=8){     //for each loop we check 1 byte(8 bits)
            // first 4 bits of each byte must be 0011
            for(int k=0; k<4; k++){     // check first 4 bits of current byte
                if(first4bits < 2){ //first 2 bits must have result 0
                    if(c2Arr[i] == 0 ){     // bc  result == 0, key must have value 0 in this cell
                        genKeyArr[i] = 0;
                        first4bits++;   i++;
                        continue;
                    }
                    else if(c2Arr[i] == 1 ){    //// bc result=1 key must have value 1 in this cell
                        genKeyArr[i] = 1;
                        first4bits++;   i++;
                        continue;
                    }
                }
                else if(first4bits == 2 || first4bits == 3){
                    if(c2Arr[i] == 0 ){     // if result==1 key must have value 0 in this cell
                        genKeyArr[i] = 1;
                        first4bits++;   i++;
                        continue;
                    }
                    else if(c2Arr[i] == 1 ){
                        genKeyArr[i] = 0;
                        first4bits++;   i++;
                        continue;
                    }
                }
            }   //teleiwsame me ta prwta 4 bits tou byte pou prepei na vgazoyn result 0011
            if(first4bits == 4){    // if we checked first 4 bits of this byte  //i is has also the value 4
                //first4bits = 0; //continue to the next 4 bits
                //ousiastika sygkrinoume ta 4 bits tou kathe ciphertext, ta kanoume xor
                //me tous gnwstous arithmous kai opoio string tessarwn bits einai idio kai
                //gia ta 2 ciphertexts, to kratame ws thn swsth epilogh kai to vazoyme sto
                //kleidi mas!!!

                first4bits = 0; // put the value zero (0) in this variable again, bc we will finish calculating
                                // the last 4 bits at this segment of the code
                //System.out.println("we reached first 4 bits, we continue processing the next 4");
                // first we store in a temp array the next 4 bits of each ciphertext
                tmp1Arr[0] = c1Arr[i];  //this is the fourth (4th) bit of the byte
                tmp1Arr[1] = c1Arr[i+1];    //6th
                tmp1Arr[2] = c1Arr[i+2];    //7th
                tmp1Arr[3] = c1Arr[i+3];    //8th

                tmp2Arr[0] = c2Arr[i];
                tmp2Arr[1] = c2Arr[i+1];
                tmp2Arr[2] = c2Arr[i+2];
                tmp2Arr[3] = c2Arr[i+3];

                //THEN we XOR these next 4 bits with the known given numbers [0-9]
                String res0 = bits4XOR(tmp1Arr, no0Arr);
                String res1 = bits4XOR(tmp1Arr, no1Arr);
                String res2 = bits4XOR(tmp1Arr, no2Arr);
                String res3 = bits4XOR(tmp1Arr, no3Arr);
                String res4 = bits4XOR(tmp1Arr, no4Arr);
                String res5 = bits4XOR(tmp1Arr, no5Arr);
                String res6 = bits4XOR(tmp1Arr, no6Arr);
                String res7 = bits4XOR(tmp1Arr, no7Arr);
                String res8 = bits4XOR(tmp1Arr, no8Arr);
                String res9 = bits4XOR(tmp1Arr, no9Arr);

                String resl0 = bits4XOR(tmp2Arr, no0Arr);
                String resl1 = bits4XOR(tmp2Arr, no1Arr);
                String resl2 = bits4XOR(tmp2Arr, no2Arr);
                String resl3 = bits4XOR(tmp2Arr, no3Arr);
                String resl4 = bits4XOR(tmp2Arr, no4Arr);
                String resl5 = bits4XOR(tmp2Arr, no5Arr);
                String resl6 = bits4XOR(tmp2Arr, no6Arr);
                String resl7 = bits4XOR(tmp2Arr, no7Arr);
                String resl8 = bits4XOR(tmp2Arr, no8Arr);
                String resl9 = bits4XOR(tmp2Arr, no9Arr);

                // then we compare each of these results with the results of the second ciphertext
                // --------check res0
                if(res0.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;   // we found the match, we put the next 4 bits to the key, now continue to the next byte
                }
                else if(res0.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                else if(res0.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res0.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res0.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res0.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res0.charAt(3)));
                    continue;
                }
                //------------check res1
                else if(res1.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));

                }
                else if(res1.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                else if(res1.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res1.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res1.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res1.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res1.charAt(3)));
                }
                // --------------check res2
                else if(res2.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));

                }
                else if(res2.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                else if(res2.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res2.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res2.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res2.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res2.charAt(3)));
                }
                // ----------check res3
                else if(res3.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));

                }
                else if(res3.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                else if(res3.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res3.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res3.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res3.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res3.charAt(3)));
                }
                // -------------check res4
                else if(res4.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));

                }
                else if(res4.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                else if(res4.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res4.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res4.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res4.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res4.charAt(3)));
                }
                //----------------check res5
                else if(res5.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res5.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                // ------------check res6
                else if(res6.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                else if(res6.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res5.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res5.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res5.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res5.charAt(3)));
                }
                //------------check res7
                else if(res7.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                else if(res7.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res7.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res7.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res7.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res7.charAt(3)));
                }
                // -----------------check res8
                else if(res8.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                else if(res8.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res8.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res8.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res8.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res8.charAt(3)));
                }
                //--------------------check res9
                else if(res9.equals(resl0)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl1)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl2)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl3)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl4)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl5)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl6)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl7)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl8)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }
                else if(res9.equals(resl9)){
                    genKeyArr[i] = Integer.parseInt(String.valueOf(res9.charAt(0)));
                    genKeyArr[i+1] = Integer.parseInt(String.valueOf(res9.charAt(1)));
                    genKeyArr[i+2] = Integer.parseInt(String.valueOf(res9.charAt(2)));
                    genKeyArr[i+3] = Integer.parseInt(String.valueOf(res9.charAt(3)));
                }

            }

        }

        int genksum = genKeyArr.length;
        System.out.println("generated genKeyArr.length: "+ genksum);

        System.out.println("generated key array presented ");
        for(int o=0; o<c1sum; o++){
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
        System.out.println("generated message 2 size: " + genM2Sum);
        System.out.println("generated message 2:  ");
        //System.out.println(Arrays.toString(genM2Arr));
        for(int i=0; i<genM2Sum; i++){
            System.out.print(genM2Arr[i]);
        }


    }

    public static int bitXOR(int bit1, int bit2){
        int result = 3;
        if(bit1 == bit2){
           return result = 0;
        }
        else
            return result = 1;
    }
    //takes as input two (2) int arrays, returns a string with XOR applied on them
    // "static" keyword not necessary
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

    //probably not necessary
    public static void decimalToBinary(int num)
    {
        // Creating and assigning binary array size
        int[] binary = new int[35];
        int id = 0;
        // Number should be positive
        while (num > 0) {
            binary[id++] = num % 2;
            num = num / 2;
        }

        // Print Binary
        printBinary(binary, id);
    }
    static void printBinary(int[] binary, int id)
    {
        // Iteration over array
        for (int i = id - 1; i >= 0; i--)
            System.out.print(binary[i] + " ");
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