
import com.dxhh.services.RecursionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class RecursionTest {
    @Test
    @DisplayName("0^1")
    public void inputXEqualsZero() {
        double expected = 0.0;
        Assertions.assertEquals(expected, RecursionService.Power(0, 1));
    }
    
    @Test
    @DisplayName("02^3")
    public void input() {
        double expected = 8.0;
        Assertions.assertEquals(expected, RecursionService.Power(2, 3));
    }
    
    @Test
    @DisplayName("2^1")
    public void input2() {
        double expected = 2.0;
        Assertions.assertEquals(expected, RecursionService.Power(2, 1));
    }
    
    @Test
    @DisplayName("0^0")
    public void inputXPowerEqualsZero() {
        Assertions.assertThrows(ArithmeticException.class, () -> RecursionService.Power(0, 0));
    }
    
    
    
    @Test
    @DisplayName("0^-2")
    public void inputZeroPowerToNegativeNum() {
        Assertions.assertThrows(ArithmeticException.class, ()-> RecursionService.Power(0, -2));
    }
    
    @Test
    @DisplayName("-2^-2")
    public void inputNegToNeg() {
        double x = -2;
        int n = -2;
        Assertions.assertEquals(ArithmeticException.class, RecursionService.Power(x, n));
    } 
}
