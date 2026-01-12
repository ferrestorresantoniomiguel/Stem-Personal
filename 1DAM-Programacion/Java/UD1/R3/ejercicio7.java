import java.util.Scanner;

public class ejercicio7 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        
        // Usamos double por si el usuario introduce decimales
        double resultado = 0; 

        System.out.print("Introduzca un número: ");
        double numero1 = teclado.nextDouble();

        System.out.print("Introduzca otro número: ");
        double numero2 = teclado.nextDouble();

        System.out.print("Introduzca el operador (+, -, *, /): ");
        String operador = teclado.next(); // Leemos el operador como String

        // En Java, para comparar Strings usamos .equals()
        if (operador.equals("+")) {
            resultado = numero1 + numero2;
        } else if (operador.equals("-")) {
            resultado = numero1 - numero2;
        } else if (operador.equals("*")) {
            resultado = numero1 * numero2;
        } else if (operador.equals("/")) {
            // Un buen programador siempre evita la división por cero
            if (numero2 != 0) {
                resultado = numero1 / numero2;
            } else {
                System.out.println("Error: No se puede dividir por cero.");
            }
        } else {
            System.out.println("Operador incorrecto");
            return; // Finaliza el programa si el operador falla
        }

        System.out.println("El resultado de " + numero1 + " " + operador + " " + numero2 + " es " + resultado);
        
        teclado.close();
    }

}
