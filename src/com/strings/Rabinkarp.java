package com.strings;

public class Rabinkarp {

    public static void main(String[] args) {
        Rabinkarp rabinkarp = new Rabinkarp();
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        rabinkarp.searchPattern(text, pattern);
    }

    private long hashFunction(String s){
        int l = s.length();
        long hashCode = 0l;
        for(int i=0; i<l; i++){
            char c = s.charAt(i);
            hashCode += Math.pow(26, (l-1-i))* (int)c;
        }
        return hashCode;
    }

    private void searchPattern(String text, String pattern){
        long patternHash = hashFunction(pattern);
        long rollHash = hashFunction(text.substring(0, pattern.length()));
        for(int i=0; i<=text.length()-pattern.length();i++){
            if(rollHash == patternHash && !isSpuriousMatch(pattern, text.substring(i, pattern.length()+i)))
                System.out.println("Pattern match at index "+i);
            if(pattern.length()+i == text.length())
                break;
            char prev = text.charAt(i);
            char nxt = text.charAt(pattern.length()+i);
            long prevValue = (long)((int)prev*Math.pow(26, pattern.length()-1));
            rollHash = (rollHash - prevValue)*26 + (int)nxt;
        }
    }

    private boolean isSpuriousMatch(String a, String b){
        return !(a.equals(b));
    }
}
