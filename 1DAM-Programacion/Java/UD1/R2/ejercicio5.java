import java.util.Scanner;

public class ejercicio5 {
    public static void main(String[] args) {
    Scanner scanner1 = new Scanner(System.in);
    
    System.out.print("Introduzca su peso: ");
    double pesoEnLaTierra = scanner1.nextDouble();

    double pesoEnLaLuna = pesoEnLaTierra * 0.165;

    System.out.println("En la Luna pesarías: " + pesoEnLaLuna + "kg");
    
    scanner1.close();


    }
}
