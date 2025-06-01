class Solution {
    public String intToRoman(int num) {
        String[] ones = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] hund = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] thus = {"", "M", "MM", "MMM"};
        
        int n=num,d=0;

        int thousand = num/1000;
        int hundred = (num/100)%10;
        int ten = (num/10)%10;
        int one = num%10;
        String result;

        result = thus[thousand] + hund[hundred ] + tens[ten] + ones[one];

        return result;

    }
}