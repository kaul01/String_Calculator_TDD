import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculate {

    Calculator calculator = new Calculator();

    @Test
    public void emptyStringreturnsZero(){
        assertEquals(calculator.calculate("") , 0);
    }
    @Test
    public void singleValue(){
        assertEquals(calculator.calculate("1") ,  1);
    }

}
