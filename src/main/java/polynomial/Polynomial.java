package polynomial;

import ComplexNumbers.ComplexNumber;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor

public class Polynomial {
    private final double a;
    private final double b;
    private final double c;

    public Polynomial addition(Polynomial p){
        double newA = this.a + p.getA();
        double newB = this.b + p.getB();
        double newC = this.c + p.getC();
        return new Polynomial(newA, newB, newC);
    }
    public Polynomial derivative(){
        return new Polynomial(0,2*a,b);
    }
    public List<ComplexNumber> findZeros() {
        List<ComplexNumber> zeros = new ArrayList<>();
        double determinant = b * b - 4 * a * c;
        if (determinant == 0) {
            ComplexNumber x1 = new ComplexNumber(-b / (2 * a), 0);
            zeros.add(x1);
            return zeros;
        } else if (determinant < 0) {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-determinant) / (2 * a);
            double imag2 = -imag;
            ComplexNumber x1 = new ComplexNumber(real, imag);
            zeros.add(x1);
            ComplexNumber x2 = new ComplexNumber(real, imag2);
            zeros.add(x2);
        } else {
            double sol1 = (-b + Math.sqrt(determinant)) / (2 * a);
            double sol2 = (-b - Math.sqrt(determinant)) / (2 * a);
            ComplexNumber x1 = new ComplexNumber(sol1, 0);
            ComplexNumber x2 = new ComplexNumber(sol2, 0);
            zeros.add(x1);
            zeros.add(x2);
        }
        return zeros;
    }

    @Override
    public String toString() {
        String result = "";
        result += a==0 ? ' ' : a + "x^2";
        result += b==0 ? ' ' : (b>0 ? "+" + b : String.valueOf(b)) + "x";
        result += c==0 ? ' ' : (c>0 ? "+" + c : String.valueOf(c));
        if(a==0 && b == 0 && c==0)
            return "0";
        return result;
    }

}
