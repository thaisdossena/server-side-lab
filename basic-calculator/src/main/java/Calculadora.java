public class Calculadora {
    public Calculadora() {}
    
    public static double somar ( double valor1, double valor2) {
        return valor1 + valor2;
    }

    public static double subtrair ( double valor1, double valor2) {
        return valor1 - valor2;
    }

    public static double multiplicar ( double valor1, double valor2) {
        return valor1 * valor2;
    }

    public static double dividir ( double valor1, double valor2) {
        if (valor2 == 0.0) {
            throw  new ArithmeticException("Não pode dividir por zero!");
        }
        return valor1 / valor2;
    }

    public static double elevar ( double valor1, double valor2) {
        return Math.pow(valor1, valor2);
    }

    public static double[] bhaskara (double valor1, double valor2, double valor3) {
        double delta = Math.pow( valor2 , 2 ) - 4 * (valor1 * valor3);
        double denominador = 2 * valor1;

        if (delta < 0) {
            throw  new ArithmeticException("A equação não tem raízes reais!");
        }

        double raizDelta = Math.sqrt(delta);
        double raiz1 = (-valor2 + raizDelta) / denominador;
        double raiz2 = (-valor2 - raizDelta) / denominador;

        return new double[]{raiz1, raiz2};
    }
}
