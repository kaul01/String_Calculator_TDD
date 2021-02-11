import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculate {

    Calculator calculator = new Calculator();

    @Test
    public void emptyStringreturnsZero(){
        assertEquals(calculator.add("") , 0);
    }
    @Test
    public void singleValue(){
        assertEquals(calculator.add("1") ,  1);
    }
    @Test
    public void twoValues(){
        assertEquals(calculator.add("1,2") , 3);
    }
    @Test
    public void unknownValues(){
        assertEquals(calculator.add("1,2,3") , 6);
    }
    @Test
    public void newLine(){
        assertEquals(calculator.add("1\n2,3") , 6);
    }
    @Test
    public void diffDelimiters(){
        assertEquals(calculator.add("//;\n1;2") , 3);
        assertEquals(calculator.add("//_\n2_3") , 5);
    }

}
