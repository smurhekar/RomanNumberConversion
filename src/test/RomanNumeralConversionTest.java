package test;

import main.RomanNumber;
import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lenovo on 3/14/2016.
 */
public class RomanNumeralConversionTest {

    private final static Map<String, Integer> valuesForSymbol = new HashMap(){
        {
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);

        }
    };

    @Test
    public void shouldBeAbleToConvertITo1(){
        assertEquals(1, new RomanNumber("I", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleToConvertToArabicNumberWhenFirstCharacterIsEqualToSecondCharacter(){
        assertEquals(2, new RomanNumber("II", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleToConvertToArabicNumberWhenFirstCharacterIsGreaterThanSecondCharacter(){
        assertEquals(6, new RomanNumber("VI", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleConvertToArabicNumberWhenFirstCharacterIsLessThanSecondCharacter(){
        assertEquals(4, new RomanNumber("IV", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleToConvertToArabicNumberForMoreThan2SimilarCharacters(){
        assertEquals(3, new RomanNumber("III", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleToConvertToArabicNumberForMoreThan2DifferentCharacters(){
        assertEquals(8, new RomanNumber("VIII", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleToConvertToArabicNumberWhenNumberFormedBy2Characters(){
        assertEquals(14, new RomanNumber("XIV", valuesForSymbol).toArabicNumber());
    }

    @Test
    public void shouldBeAbleToConvertToArabicNumberWhenNumberFormedBy2CharactersMultipleTimes(){
        assertEquals(49, new RomanNumber("XLIX", valuesForSymbol).toArabicNumber());
    }
}
