package utils;

import java.util.Random;

public class RandomUtils {
    static Random random = new Random();

    public static String generateString(int length){
        String chars = "abcdefghijklmnopqrstuvwxyz0123456789";
        char [] randomString = new char[length];
        int index = 0;
        int charLength = chars.length();
        for (int i = 0; i < length; i++) {
            index = random.nextInt(charLength);
            randomString[i] = chars.charAt(i);
        }
        return new String(randomString);
    }
}
