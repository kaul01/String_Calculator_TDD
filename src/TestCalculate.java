import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculate {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void emptyString(){
        assertEquals(stringCalculator.add("") , 0);
    }
    @Test
    public void singleValue(){
        assertEquals(stringCalculator.add("1") ,  1);
    }
    @Test
    public void twoValues(){
        assertEquals(stringCalculator.add("1,2") , 3);
    }
    @Test
    public void unknownValues(){
        assertEquals(stringCalculator.add("1,2,3") , 6);
    }
    @Test
    public void newLine(){
        assertEquals(stringCalculator.add("1\n2,3") , 6);
    }
    @Test
    public void diffDelimiters(){
        assertEquals(stringCalculator.add("//;\n1;2;3") , 6);
        assertEquals(stringCalculator.add("//_\n2_3_5_4") , 14);
        assertEquals(stringCalculator.add("//&\n3&4&5&6&7&8") , 33);
    }
    @Test
    public void negatives(){
        assertEquals(stringCalculator.add("-1") , 0);
        assertEquals(stringCalculator.add("2,-4,-3") , 2);
    }
    @Test
    public void GetCalledCount(){
        assertEquals(stringCalculator.GetCalledCount("1,2,3") , 2);
    }
    @Test
    public void numGreaterThan1000(){
        assertEquals(stringCalculator.add("2,1001") , 2);
    }
    @Test
    public void multipleDelimiters(){
        assertEquals(stringCalculator.add("//[;;;]\n1;;;2;;;3") , 6);
    }
    @Test
    public void multipleDifferentDelimiters(){
        assertEquals(stringCalculator.add("//[;][%]\n1;2%3") ,6 );
        assertEquals(stringCalculator.add("//[;;][%%]\n6;;2%%7") ,15);
        assertEquals(stringCalculator.add("//[&&][;]\n6;2&&7") ,15);
    }
}
