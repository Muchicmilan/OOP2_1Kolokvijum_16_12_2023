package ComplexNumbers;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;

@Getter
@AllArgsConstructor

public class ComplexNumber {
    final double real;
    final double imag;

    public boolean isReal(){
        return imag==0;
    }

    @Override
    public String toString() {
        if(isReal()){
            return real +"";
        }
        if(imag < 0)
            return "" + real + imag +"i";
        else
            return real + "+" + imag +"i";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumber that = (ComplexNumber) o;
        double epsilon = 1e-9;
        return Double.compare(real, that.real) < epsilon && Double.compare(imag, that.imag) < epsilon;
    }

    @Override
    public int hashCode() {
        return Objects.hash(real, imag);
    }
}
