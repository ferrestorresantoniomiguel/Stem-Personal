import java.util.Scanner;

public class ejercicio9 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("¿Cuántos caramelos tienes? ");
        int numeroDeCaramelos = teclado.nextInt();
        teclado.nextLine();

        System.out.print("¿Cuántos niños hay? ");
        int numeroDeNinios = teclado.nextInt();

        int carameloPorNinio = numeroDeCaramelos / numeroDeNinios;
        int restoDeCaramelos = numeroDeCaramelos % numeroDeNinios;
        System.out.println("A cada niño le tocan " + carameloPorNinio + " caramelos y han sobrado " + restoDeCaramelos);

        teclado.close();
    }
}