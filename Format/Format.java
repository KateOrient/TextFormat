package Format;

import java.io.*;
import java.util.*;

public class Format {
    final int MAX_LETTER_NUMBER;
    final int A_SMALL_CODE;
    final int A_BIG_CODE;
    final int MAX_LETTER_NUMBER_IN_LINE;
    final int MAX_WORD_NUMBER;
    final int NUM_WORDS_IN_LINE;

    String[] Text;
    int wordNum;

    public Format() {
        MAX_LETTER_NUMBER = 26;
        A_SMALL_CODE = 97;
        A_BIG_CODE = 65;
        MAX_LETTER_NUMBER_IN_LINE = 20;
        MAX_WORD_NUMBER = 200;
        NUM_WORDS_IN_LINE = 3;
        Text = new String[MAX_WORD_NUMBER];
        wordNum = 0;
    }

    public void loadText(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String s;
        s = reader.readLine();
        StringTokenizer st = new StringTokenizer(s);
        wordNum = 0;
        while (st.hasMoreTokens()) {
            Text[wordNum] = st.nextToken();
            wordNum++;
        }
    }

    public void print() {
        for (int i = 0; i < wordNum; i++)
            System.out.println(Text[i]);
    }

    boolean isALetter(char c) {
        if ((c >= A_SMALL_CODE && c <= A_SMALL_CODE + MAX_LETTER_NUMBER - 1)
                || ((c >= A_BIG_CODE && c <= A_BIG_CODE + MAX_LETTER_NUMBER - 1))) {
            return true;
        }
        return false;
    }

    boolean isUppercase(char c) {
        if (isALetter(c) && c < A_SMALL_CODE) {
            return true;
        }
        return false;
    }

    int getNumInAlph(char c) {
        if (isALetter(c)) {
            if (isUppercase(c)) {
                return (c - A_BIG_CODE + 1);
            } else {
                return (c - A_SMALL_CODE + 1);
            }
        }
        return 0;
    }

    boolean isOneSignedNumberInAlph(char c) {
        if (isUppercase(c)) {
            if (getNumInAlph(c) / 10 < 1)
                return true;
            else
                return false;
        } else {
            if (getNumInAlph(c) / 10 < 1)
                return true;
            else
                return false;
        }
    }

    public void format(String fileName) throws IOException {
        FileWriter writer = new FileWriter(fileName, false);
        int firstWordInLine = 0;
        while (firstWordInLine < wordNum) {
            for (int i = firstWordInLine; i < firstWordInLine + NUM_WORDS_IN_LINE && i < wordNum; i++) {
                char[] L = new char[Text[i].length()];
                Text[i].getChars(0, Text[i].length(), L, 0);
                for (int j = 0; j < L.length; j++) {
                    if (isALetter((L[j]))) {
                        writer.write("  ");
                    }
                    writer.write(L[j]);
                }
                writer.write("  ");
            }
            writer.write("\r\n");
            for (int i = firstWordInLine; i < firstWordInLine + NUM_WORDS_IN_LINE && i < wordNum; i++) {
                char[] L = new char[Text[i].length()];
                Text[i].getChars(0, Text[i].length(), L, 0);
                for (int j = 0; j < L.length; j++) {
                    if (isALetter((L[j]))) {
                        if (isOneSignedNumberInAlph(L[j])) {
                            writer.write("  ");
                        } else {
                            writer.write(" ");
                        }
                        writer.write("" + getNumInAlph(L[j]));
                    } else
                        writer.write(" ");
                }
                writer.write("  ");
            }
            writer.write("\r\n");
            firstWordInLine += NUM_WORDS_IN_LINE;
        }
        writer.close();
    }
}
