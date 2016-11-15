package com.java.arrayQuestion;

/**
 * Created by user on 11/9/16.
 */
public class ReverseAString {
    public static void main(String[] args) {
        String str = "My Name Is Chetan Raj Bharti";
        ReverseAllWords(str.toCharArray());
    }

    static char[] ReverseAllWords(char[] in_text)
    {
        int lindex = 0;
        int rindex = in_text.length - 1;
        if (rindex > 1)
        {
            //reverse complete phrase
            in_text = ReverseString(in_text, 0, rindex);

            //reverse each word in resultant reversed phrase
            for (rindex = 0; rindex <= in_text.length; rindex++)
            {
                if (rindex == in_text.length || in_text[rindex] == ' ')
                {
                    in_text = ReverseString(in_text, lindex, rindex - 1);
                    lindex = rindex + 1;
                }
            }
        }

        for (int i = 0; i < in_text.length; i++) {
            System.out.print(in_text[i]);
        }
        return in_text;
    }

    static char[] ReverseString(char[] intext, int lindex, int rindex)
    {
        char tempc;
        while (lindex < rindex)
        {
            tempc = intext[lindex];
            intext[lindex++] = intext[rindex];
            intext[rindex--] = tempc;
        }
        return intext;
    }
}
