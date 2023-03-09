public class Counter {

    private static int CHAR_DIAPASON = 256;

    public boolean anagramCounting (String word1, String word2) {
        if ( word1.length() !=  word2.length()) {
            return false;
        }
        int count [] = new int [CHAR_DIAPASON];
        for (int i = 0; i < word1.length(); i++ ) {
            count [word1.charAt(i)]++;
            count [word2.charAt(i)]--;
        }
        for ( int i = 0; i < CHAR_DIAPASON; i++ ){
            if (count[i] !=0 ) {
                return false;
            }
        }
        return true;
    }

}
