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
            Integer currentNumber = getNumberFor(index);
            Integer previousNumber = getNumberFor(index - 1);
            if(0 < previousNumber && previousNumber < currentNumber){
                convertedNum = convertedNum - previousNumber;
                currentNumber = currentNumber - previousNumber;
            }
            if(index == chars.length - 1){
                return addTo(convertedNum, currentNumber);
            }
            Integer nextNumber = getNumberFor(index + 1);
            convertedNum = calculateNumberBy(convertedNum, currentNumber, nextNumber);
            index = index + 2;
        }
        return Math.abs(convertedNum);
    }

    private Integer getNumberFor(int index) {
        if(index < 0)
            return 0;
        char[] chars = number.toCharArray();
        return valuesForSymbol.get(String.valueOf(chars[index]));
    }

    private int calculateNumberBy(int convertedNum, Integer current, Integer next) {
        if(current >= next){
            convertedNum = addTo(convertedNum, current + next);
        }else {
            convertedNum = addTo(convertedNum, current - next);
        }
        return convertedNum;
    }

    private int addTo(int convertedNum, Integer number) {
        return convertedNum + number;
    }
}
