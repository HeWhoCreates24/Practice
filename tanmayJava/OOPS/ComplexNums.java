import java.util.*;
public class ComplexNums {
    public static void main(String[] args) {
        // Take input
        Scanner sc = new Scanner(System.in);
        int aReal, aImg, bReal, bImg;

        System.out.println("Enter real part of a:");
        aReal = sc.nextInt();
        System.out.println("Enter imaginary part of a:");
        aImg = sc.nextInt();
        System.out.println("Enter real part of b:");
        bReal = sc.nextInt();
        System.out.println("Enter imaginary part of b:");
        bImg = sc.nextInt();

        // Make two complex numbers
        ComplexNumber a = new ComplexNumber(aReal, aImg);
        ComplexNumber b = new ComplexNumber(bReal, bImg);

        // Perform operations
        ComplexNumber sum = a.add(b);
        ComplexNumber difference = a.subtract(b);
        ComplexNumber product = a.multiply(b);
        ComplexNumber quotient = a.divide(b);

        // Display results
        System.out.println("Sum: " + sum.realValue + " + " + sum.imgValue + "i");
        System.out.println("Difference: " + difference.realValue + " + " + difference.imgValue + "i");
        System.out.println("Product: " + product.realValue + " + " + product.imgValue + "i");
        System.out.println("Quotient: " + quotient.realValue + " + " + quotient.imgValue + "i");
    }

    // Make the ComplexNumber class
    static class ComplexNumber {
        int realValue;
        int imgValue;

        public ComplexNumber(int real, int img) {
            this.realValue = real;
            this.imgValue = img;
        }

        public ComplexNumber add(ComplexNumber a) {
            return new ComplexNumber(this.realValue + a.realValue, this.imgValue + a.imgValue);
        }

        public ComplexNumber subtract(ComplexNumber a) {
            return new ComplexNumber(this.realValue - a.realValue, this.imgValue - a.imgValue);
        }

        public ComplexNumber multiply(ComplexNumber a) {
            int realPart = this.realValue * a.realValue - this.imgValue * a.imgValue;
            int imgPart = this.realValue * a.imgValue + this.imgValue * a.realValue;
            return new ComplexNumber(realPart, imgPart);
        }

        public ComplexNumber divide(ComplexNumber a) {
            int denominator = a.realValue * a.realValue + a.imgValue * a.imgValue;
            int realPart = (this.realValue * a.realValue + this.imgValue * a.imgValue) / denominator;
            int imgPart = (this.imgValue * a.realValue - this.realValue * a.imgValue) / denominator;
            return new ComplexNumber(realPart, imgPart);
        }
    }
}
