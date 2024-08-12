package org.algorithms.io.meta;


public class ToGoatLatin {

    public static void main(String[] args) {
        var t = new ToGoatLatin();
        System.out.println(t.toGoatLatin("I speak Goat Latin"));
    }

    private static final String KEY_APPEND = "ma";
    public String toGoatLatin(String sentence) {
        var words = sentence.split(" ");
        var response = new StringBuilder();
        String aMultiplyer = "a";
        for (var word : words) {
            if(isVowel(word.charAt(0))) {
                response.append(applyVowelRule(word))
                        .append(aMultiplyer)
                        .append(" ");
            } else {
                response.append(applyConsonantRule(word))
                        .append(aMultiplyer)
                        .append(" ");
            }

            aMultiplyer = aMultiplyer.concat("a");
        }

        return response.substring(0, response.length() - 1);
    }

    private String applyConsonantRule(String word) {
        var first = word.charAt(0);
        word = word.substring(1);
        return word.concat(String.valueOf(first)).concat(KEY_APPEND);
    }

    public String applyVowelRule(String word) {
        return word.concat(KEY_APPEND);
    }
    
    public boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U';
    }
}
