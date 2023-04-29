import java.util.HashMap;

public class Latin {
    public static void main(String[] args)  {
        String romanExample = "MMMCMXCIX";
        Latin nonPositionSystem = new Latin();
        try {
            System.out.println(nonPositionSystem.complianceWithTheSchwartzmannRule(romanExample));
            if(true){
                System.out.println(nonPositionSystem.romanToInt(romanExample));
            }
            } catch (IncorrectMaxSizeException | IncorrectDataException  e) {
            System.out.println(e.getMessage());
        }
        }

    private boolean complianceWithTheSchwartzmannRule (String characters) throws IncorrectDataException {
        char [] checker = characters.toCharArray();
        int temp, count;
        for (int i = 0; i < checker.length;)
        {
            temp = checker [i];
            count = 1;
            while(++i < checker.length && checker [i] == temp)
                ++count;
            if (count > 3) {
                throw new IncorrectDataException("According to the Schwartzmann rule in the Roman numeral system," +
                        " the repetition of the same characters cannot be more than 3 times in a row");
            }
        }
       return true;
    }
    private int romanToInt(String characters) throws IncorrectMaxSizeException, IncorrectDataException{
        try{
        HashMap<Character, Integer> system = new HashMap<>();
        system.put('I', 1);
        system.put('V', 5);
        system.put('X', 10);
        system.put('L', 50);
        system.put('C', 100);
        system.put('D', 500);
        system.put('M', 1000);

        int last = characters.length()-1;
        char [] separatedSymbols = characters.toCharArray();
        int arabian;
        int result = system.get(separatedSymbols[last]);
        for (int i = last-1; i >=0 ; i--) {
                arabian = system.get(separatedSymbols[i]);
            if (arabian < system.get(separatedSymbols[i+1])){
                result -= arabian;
            }else {
                result += arabian;
            }
            if (result > 3999){
             throw new IncorrectMaxSizeException("Roman numerals can not represent numbers more than 3999");
            }
        }
        return result;
        }catch (NullPointerException e) {
            throw new IncorrectDataException("You insert must contain I, V, X, L, C, D, M character.");
        }
    }
}