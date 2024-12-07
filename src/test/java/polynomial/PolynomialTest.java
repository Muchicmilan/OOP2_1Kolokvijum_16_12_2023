package polynomial;

import ComplexNumbers.ComplexNumber;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PolynomialTest {
    @Test
    public void shouldCheckIfAdditionIsCorrect() {
        Polynomial p = new Polynomial(1.0,2.0,3.0);
        Polynomial q = new Polynomial(1.0,4.0,2.0);
        double expectedA = 1.0+1.0;
        double expectedB = 2.0 + 4.0;
        double expectedC = 3.0 + 2.0;
        Assertions.assertThat(p.addition(q).getA()).isEqualTo(expectedA);
        Assertions.assertThat(p.addition(q).getB()).isEqualTo(expectedB);
        Assertions.assertThat(p.addition(q).getC()).isEqualTo(expectedC);
    }
    @Test
    public void shouldCheckIfDerivativeIsCorrect() {
        Polynomial p = new Polynomial(1.0,2.0,3.0);
        double expectedA = 0;
        double expectedB = p.getA() * 2;
        double expectedC = p.getB();
        Assertions.assertThat(p.derivative().getA()).isEqualTo(expectedA);
        Assertions.assertThat(p.derivative().getB()).isEqualTo(expectedB);
        Assertions.assertThat(p.derivative().getC()).isEqualTo(expectedC);
    }
    @Test
    public void shouldCheckIfFoundZerosAreCorrect(){
        Polynomial p = new Polynomial(1.0,0,-1.0);
        Polynomial q = new Polynomial(1.0,0,1.0);
        Polynomial k = new Polynomial(1.0,2.0,1.0);
        List<ComplexNumber> expectedP = List.of(new ComplexNumber(1.0, 0), new ComplexNumber(-1.0, 0));
        List<ComplexNumber> expectedQ = List.of(new ComplexNumber(0, 1.0), new ComplexNumber(0, -1.0));
        List<ComplexNumber> expectedK = List.of(new ComplexNumber(-1.0, 0));
        Assertions.assertThat(p.findZeros()).containsExactlyInAnyOrderElementsOf(expectedP);
        Assertions.assertThat(q.findZeros()).containsExactlyInAnyOrderElementsOf(expectedQ);
        Assertions.assertThat(k.findZeros()).containsExactlyInAnyOrderElementsOf(expectedK);
    }
    @Test
    public void shouldCheckIfToStringIsCorrect(){
        Polynomial p = new Polynomial(1.0,2.0,3.0);
        Polynomial q = new Polynomial(1.0,4.0,0.0);
        Polynomial k = new Polynomial(0.0,0.0,0.0);
        String expectedPString = "1.0x^2+2.0x+3.0";
        String expectedQString = "1.0x^2+4.0x ";
        String expectedKString = "0";
        Assertions.assertThat(p.toString().equals(expectedPString)).isEqualTo(true);
        Assertions.assertThat(q.toString().equals(expectedQString)).isEqualTo(true);
        Assertions.assertThat(k.toString().equals(expectedKString)).isEqualTo(true);
    }

}