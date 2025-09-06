package test; // Замените на ваш package

import demo.parallel.Complex;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ComplexTest {

    @Test
    void testMinus() {
        // Arrange - подготовка данных
        Complex a = new Complex(5, 3);
        Complex b = new Complex(2, 1);

        // Act - выполнение операции
        Complex result = a.minus(b);

        // Assert - проверка результата
        assertEquals(3.0, result.getRe(), 0.0001, "Real part of subtraction");
        assertEquals(2.0, result.getIm(), 0.0001, "Imaginary part of subtraction");
    }

    @Test
    void testMinusWithNegativeNumbers() {
        Complex a = new Complex(-2, -4);
        Complex b = new Complex(3, 1);

        Complex result = a.minus(b);

        assertEquals(-5.0, result.getRe(), 0.0001);
        assertEquals(-5.0, result.getIm(), 0.0001);
    }

    @Test
    void testDivide() {
        Complex a = new Complex(6, 8);  // 6 + 8i
        Complex b = new Complex(2, 2);  // 2 + 2i

        Complex result = a.divide(b);

        // (6+8i)/(2+2i) = (3.5 + 0.5i)
        assertEquals(3.5, result.getRe(), 0.0001);
        assertEquals(0.5, result.getIm(), 0.0001);
    }

    @Test
    void testDivideByRealNumber() {
        Complex a = new Complex(10, 15);
        Complex b = new Complex(5, 0);  // действительное число

        Complex result = a.divide(b);

        assertEquals(2.0, result.getRe(), 0.0001);
        assertEquals(3.0, result.getIm(), 0.0001);
    }

    @Test
    void testDivideByOne() {
        Complex a = new Complex(7, 3);
        Complex one = new Complex(1, 0);

        Complex result = a.divide(one);

        assertEquals(7.0, result.getRe(), 0.0001);
        assertEquals(3.0, result.getIm(), 0.0001);
    }

    @Test
    void testComplexOperationsChain() {
        // Проверяем цепочку операций: (a * b - c) / d
        Complex a = new Complex(2, 3);
        Complex b = new Complex(1, 2);
        Complex c = new Complex(1, 1);
        Complex d = new Complex(2, 0);

        // (2+3i)*(1+2i) = (2*1 - 3*2) + (2*2 + 3*1)i = (-4 + 7i)
        // (-4 + 7i) - (1 + 1i) = (-5 + 6i)
        // (-5 + 6i) / (2 + 0i) = (-2.5 + 3i)
        Complex result = a.times(b).minus(c).divide(d);

        assertEquals(-2.5, result.getRe(), 0.0001);
        assertEquals(3.0, result.getIm(), 0.0001);
    }
}