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
        assertEquals(stringCalculator.add("//;\n1;2;-3;-4") , 3);
        assertEquals(stringCalculator.add("//_\n2_3") , 5);
    }
    @Test
    public void GetCalledCount(){
        assertEquals(stringCalculator.GetCalledCount("1,2,3") , 2);
    }
    @Test
    public void numGreaterThan1000(){
        assertEquals(stringCalculator.add("2,1001") , 2);
    }
}
