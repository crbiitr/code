package com.java.dynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by chetan on 16/1/18.
 */
public class MinimumJump {
    public static void main(String[] args) {
        int[] array = {1,4,3,7,1,2,6,7,6,10};
//        int[] array = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumps(array));
/* System.out.println(substringCalculator("kincenvizh"));
        System.out.println(substringCalculator("ghaqjdrmnegmrlrlfpjmnnngpwalzknsencuzwsnhfltwohdgbmvfuwtquosrnyerucntxxkfqehjqygcarxogvcfkljzbzutxphpyykapncjfclnhndzxghelyvzpylazhuutmcquusexzbhsfsmbnlvnlemzvfqbfzwquairhpylnbvyhiyamztlhfchhbwrqddmuzsprfdwuqqchcpeakkexackwwzihkfenwzwckynymgqydvjtovaoezkjjurylqcuonsujycziobnfnmuwnoxcdtahpituykvgpyyshvukrstcbmnsqtjseflwywnslmvnqrtnzkyaddkjamrezprqgoenzsdryygbkeahfiduozpwkrgmatszaxmwodsqiocvagbvxyqotpaujnqvqgjmfxnxhfbwqjpgodlxdrxpjpmzeabpgqrzpxomniknjkdiwtfgyvwvekrnoupwkcbtmpcfamzrghgrznuedkybmfwctdghcfawajlxfkzhdamuygjbcwnyglkjlfmpxfdtovkqbshhrfrnyjrgxgiozsuuncnwofkqzsypwgeikpfbhryhpszegdfajzvqlwwqlnvdtdiuckcvvosrdweohnmawqonjbxyjjhlccuteeshfrxxdhzgakwjqbymnaeudcmibsytyajsgdpfvrutcpglzxdevenevmkgalcrpknuvcrnkuboennhyzirfwvtozzijujsckbxqpocakzrbwgpqgjjmsrtwmvhwyraukbuxfvebeylfpipzwjdzlmgslbtwzataxgqpasrssnfwndldwkdutdqcmcpyanrbdsxrvcvpsywjambtbzlcrvzesuhvyvwwuwwdznigxjxknfajpknqutfvvqynkpvkzgypasevrpxofbymdzcitoqolwqegocuyqsexhumzmckzuuwkamolbltlifongpvkcnrnnuplftqbxpdnegdqlymftqyrxcnzmu"));
*/
    }

    public static int minJumps(int[] arr) {
        if(arr.length<=1) return 0;
        int jump =1;

        int ladder = arr[0];
        int stair = arr[0];
        for (int level = 1; level <arr.length ; level++) {
            if(level==arr.length-1) return jump;
            if(ladder<arr[level]+level) ladder=arr[level] + level;
            stair--;
            if (stair==0) {
                jump++;
                stair = ladder-level;
            }
        }
        return jump;
    }
/*    private static final int MAX_CHAR = 26;

    static class Node {
        Node[] child = new Node[MAX_CHAR];

        Node() {
            for (int i = 0; i < MAX_CHAR; i++)
                child[i] = null;
        }

        void addIntoSuffixTrie(String input) {
            if (input.length() > 0) {
                char index = (char) (input.charAt(0) - 'a');
                if (child[index] == null)
                    child[index] = new Node();
                child[index].addIntoSuffixTrie(input.substring(1));
            }
        }
    }

    static class SuffixTrie {
        Node root;

        SuffixTrie(String input) {
            root = new Node();
            for (int i = 0; i < input.length(); i++)
                root.addIntoSuffixTrie(input.substring(i));
        }

        int countSubString(Node node) {
            if (node == null)
                return 0;
            int count = 0;
            for (int i = 0; i < MAX_CHAR; i++) {
                if (node.child[i] != null)
                    count += countSubString(node.child[i]);
            }

            return (1 + count);
        }

        // method to count total nodes in suffix trie
        long countSubString() {
            return countSubString(root);
        }

    }

    private static long substringCalculator(String input) {
        SuffixTrie sTrie = new SuffixTrie(input);
        return sTrie.countSubString() - 1;
    }*/

}
