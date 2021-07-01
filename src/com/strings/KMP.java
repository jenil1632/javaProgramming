package com.strings;

public class KMP {

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String text = "ABABABCABABABCABABACC";
        String pattern = "ABABAC";
        int[] lsp =  new int[pattern.length()];
        kmp.createPiTable(pattern, lsp);
        kmp.searchPattern(text, pattern, lsp);
    }

    private void createPiTable(String pattern, int[] lsp){
        lsp[0] = 0;
        for(int i=1; i<pattern.length(); i++){
            int maxLength = i;
            int startLength = 1;
            StringBuilder prefix = new StringBuilder();
            StringBuilder suffix = new StringBuilder();
            int index = 0;
            while(maxLength >= startLength){
                prefix.append(pattern.charAt(startLength-1));
                suffix.insert(0, pattern.charAt(i-startLength+1));
                if(prefix.toString().equals(suffix.toString())){
                    index = startLength;
                }
                startLength++;
            }
            lsp[i] = index;
        }
    }

    private void searchPattern(String text, String pattern, int[] lsp){
        boolean patternFound = false;
        for(int i=0; i<=text.length()-pattern.length();i++){
            int j = -1;
            while(true){
                if(pattern.charAt(j+1) == text.charAt(i)){
                    i++;
                    j++;
                }
                else{
                    if(j==-1)
                        break;
                    else
                        j = lsp[j] -1;
                }
                if(j == pattern.length()-1){
                    System.out.println("Pattern found at index: "+(i-j-1));
                    patternFound = true;
                    break;
                }
            }
        }
        if(!patternFound)
            System.out.println("Pattern not found");
    }
}
