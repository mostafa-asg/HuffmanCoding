package com.github.huffmanCoding.example;

import com.github.huffmanCoding.HuffmanEncoder;

import java.util.Map;

/**
 * @author Mostafa Asgari
 * Email : mostafa.asg@gmail.com
 * website https://bigdatacode.wordpress.com/
 * @since 5/21/16
 */
public class Example1 {

    private static String byteArrayToString(byte[] array){

        StringBuilder sb = new StringBuilder();

        for (byte b : array)
            sb.append(b);

        return sb.toString();
    }

    public static void main(String[] args)  {

        String sampleSentence = "When drought conditions forced the donkeys into residential areas " +
                "in search of water, the herd became a problem." +
                " The animals wandered into roadways, tore up golf courses and drank from swimming pools," +
                " said Inga Gibson, Hawaii state director for the Humane Society of the United States.";


        HuffmanEncoder huffmanEncoder = new HuffmanEncoder(sampleSentence);

        Map<Character, byte[]> characterEncoding = huffmanEncoder.getCharacterEncoding();

        for( Map.Entry<Character,byte[]> entry : characterEncoding.entrySet() ){
            System.out.println( entry.getKey() + " -> " + byteArrayToString(entry.getValue()) );
        }

    }

}
