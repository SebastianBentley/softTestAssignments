package com.example.testassignment2;

public class BootlegStringUtils {


    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
   }


    public static String capitalizeString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i)>='a' && str.charAt(i)<='z')
            {
                sb.append((char) ((int)str.charAt(i) - 32));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static String lowercaseString(String str) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < str.length(); i++) {
            if(str.charAt(i)>='A' && str.charAt(i)<='Z')
            {
                sb.append((char) ((int)str.charAt(i) + 32));
            } else {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseString("hej"));
        System.out.println(capitalizeString("HejsA"));
        System.out.println(lowercaseString("HejsA"));

    }

}
