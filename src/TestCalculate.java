import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalculate {
    @Test
    public void emptyStringreturnsZero(){
        Calculator calculator = new Calculator();
        assertEquals(calculator.calculate("") , 0);
    }

}
