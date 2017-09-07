package Format;

import java.io.*;
import java.util.*;

public class Format {
    final int MAX_LETTER_NUMBER;
    final int A_SMALL_CODE;
    final int A_BIG_CODE;
    final int MAX_LETTER_NUMBER_IN_LINE;
    final int MAX_WORD_NUMBER;
    final char DOT, COMMA, EXCLAMATION, QUESTION, DASH, COLON, QUOTES, SEMICOLON;

    String[] Text;
    int wordNum;

    public Format() {
        MAX_LETTER_NUMBER = 26;
        A_SMALL_CODE = 97;
        A_BIG_CODE = 65;
        MAX_LETTER_NUMBER_IN_LINE = 20;
        MAX_WORD_NUMBER = 200;
        DOT = '.';
        COMMA = ',';
        QUESTION = '?';
        DASH = '-';
        COLON = ':';
        QUOTES = '"';
        EXCLAMATION = '!';
        SEMICOLON = ';';
        Text = new String[MAX_WORD_NUMBER];
        wordNum = 0;
    }

    public boolean compareToPunct(char c) {
        if (c == DOT || c == COMMA || c == QUESTION || c == DASH || c == COLON || c == QUOTES || c == EXCLAMATION || c == SEMICOLON) {
            return true;
        }
        return false;
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
}
