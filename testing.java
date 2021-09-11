package oop;

class Cipher {
    private static final int[] ALPHABET = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            '+', '/'
    };
    private static final int[] DECODETABLE = {
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1,
            -1,  0,  1,  2,  3,  4,  5,  6,  7,  8,  9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1,
            -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
            -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1
    };
    private static final int BLOCK_SIZE = 8;
    private static final int PADDING = '=';

    public static String encode(String plainText) {
        StringBuilder result = new StringBuilder();
        byte[] bytes = plainText.getBytes();
        int i = 0;
        int len = bytes.length;
        while (i < len) {
            int ch1 = bytes[i++] & 0xff;
            int ch2 = i < len ? bytes[i++] & 0xff : 0;
            int ch3 = i < len ? bytes[i++] & 0xff : 0;
            result.append((char)ALPHABET[(ch1 >> 2) & 0x3f]);
            result.append((char)ALPHABET[((ch1 << 4) | (ch2 >> 4)) & 0x3f]);
            result.append((char)ALPHABET[((ch2 << 2) | (ch3 >> 6)) & 0x3f]);
            result.append((char)ALPHABET[ch3 & 0x3f]);
        }
        int padding = BLOCK_SIZE - (len % BLOCK_SIZE);
        if (padding == 0) {
            padding = BLOCK_SIZE;
        }
        for (int j = 0; j < padding; j++) {
            result.append(PADDING);
        }
        return result.toString();
    }
    public static String decode(String encodedText) {
        StringBuilder result = new StringBuilder();
        byte[] bytes = encodedText.getBytes();
        int i = 0;
        int len = bytes.length;
        while (i < len) {
            int ch1 = DECODETABLE[bytes[i++] & 0xff];
            int ch2 = i < len ? DECODETABLE[bytes[i++] & 0xff] : 0;
            int ch3 = i < len ? DECODETABLE[bytes[i++] & 0xff] : 0;
            if (ch1 == -1 || ch2 == -1 || ch3 == -1) {
                return null;
            }
            result.append((char)((ch1 << 2) | (ch2 >> 4)));
            if (ch3 != PADDING) {
                result.append((char)((ch2 << 4) | (ch3 >> 2)));
            }
        }
        return result.toString();
    }
}

public class testing {
    public static void main(String[] args) {
        String plainText = "Hello World";
        String encodedText = Cipher.encode(plainText);
        encodedText.replaceAll("61", "");
        System.out.println(encodedText);
        String decodedText = Cipher.decode(encodedText);
        System.out.println(decodedText);
    }
}
