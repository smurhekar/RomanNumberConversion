package main;

import java.util.Map;

/**
 * Created by Lenovo on 3/19/2016.
 */
public class RomanNumber {
    private final String number;
    private final Map<String, Integer> valuesForSymbol;

    public RomanNumber(String number, Map<String, Integer> valuesForSymbol) {
        this.number = number;
        this.valuesForSymbol = valuesForSymbol;
    }

    public int toArabicNumber() {
        if(null != valuesForSymbol.get(number)){
            return valuesForSymbol.get(number);
        }
        int convertedNum = 0;
        char[] chars = number.toCharArray();
        int index = 0;
        while(index <= chars.length - 1){
            int nextIndex = index + 1;
            if(nextIndex == chars.length){
                convertedNum = convertedNum + valuesForSymbol.get(String.valueOf(chars[index]));
                return convertedNum;
            }
            if(valuesForSymbol.get(String.valueOf(chars[index])) >= valuesForSymbol.get(String.valueOf(chars[(nextIndex)]))){
                convertedNum = convertedNum + valuesForSymbol.get(String.valueOf(chars[index])) + valuesForSymbol.get(String.valueOf(chars[(nextIndex)]));
            }else {
                convertedNum = convertedNum + valuesForSymbol.get(String.valueOf(chars[index])) - valuesForSymbol.get(String.valueOf(chars[(nextIndex)]));
            }
            index = nextIndex + 1;
        }
        return Math.abs(convertedNum);
    }
}
