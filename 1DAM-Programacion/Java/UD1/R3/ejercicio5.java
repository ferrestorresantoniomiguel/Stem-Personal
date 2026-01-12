import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // 1. Pedir el número
        System.out.print("Introduzca el numero: ");
        int numero = teclado.nextInt();

        // 2. Lógica booleana
        // En Java, el tipo de dato para verdadero/falso se escribe 'boolean' completo
        boolean estaEntre10y20 = (numero >= 10 && numero <= 20);

        // 3. Estructura condicional
        if (estaEntre10y20) {
            System.out.println("El número está entre 10 y 20");
        } else {
            System.out.println("El número NO está entre 10 y 20");
        }

        teclado.close();
    }

}
