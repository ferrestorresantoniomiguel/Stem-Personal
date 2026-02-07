//Función para leer número entero

static int leerEntero(Scanner sc) {
    int numero = 0;
    boolean numeroValido = false;

    while (!numeroValido) {
        String texto = sc.nextLine().trim();
        try {
            numero = Integer.parseInt(texto);
            numeroValido = true;
        } catch (NumberFormatException e) {
            imprimirPrompt("Debes introducir un número entero: ");
        }
    }
    return numero;
}

// Función para imprimir mensaje
static void imprimirMensaje(String mensaje) {
    System.out.println(mensaje);
}

// Función para mostrar "menú de opciones" y saber que opción ha elegido el
// usuario
static int mostrarMenuYLeerOpcion(Scanner sc, String menu) {
    imprimirMensaje(menu);
    imprimirPrompt("Opción: ");
    int opcion = leerEntero(sc);
    return opcion;
}

// Función que lee y comprueba el número entero introducido
static int leerEntero(Scanner sc) {
    int numero = 0;
    boolean numeroValido = false;

    while (!numeroValido) {
        String texto = sc.nextLine().trim();
        try {
            numero = Integer.parseInt(texto);
            numeroValido = true;
        } catch (NumberFormatException e) {
            imprimirPrompt("Debes introducir un número entero: ");
        }
    }
    return numero;
}

// Función para identificar si un número es mayor que 0
static int leerEnteroMayorQueCero(Scanner sc, String prompt) {
    int numero = 0;

    while (numero <= 0) {
        imprimirPrompt(prompt);
        numero = leerEntero(sc);
        if (numero <= 0) {
            imprimirMensaje("Debe ser mayor que 0.");
        }
    }
    return numero;
}

// Función para comprobación que índice fue introducido correcto
static int pedirIndiceValido(Scanner sc, int tam, String prompt) {
    int indice = -1;

    while (indice < 0 || indice >= tam) {
        imprimirPrompt(prompt);
        indice = leerEntero(sc);
        if (indice < 0 || indice >= tam) {
            imprimirMensaje("Índice fuera de rango.");
        }
    }
    return indice;
}

// Función para añadir elemento a array
static void anadirTractor(Scanner sc,
        ArrayList<String> marcas,
        ArrayList<Integer> potencias,
        ArrayList<String> trabajos) {

    imprimirPrompt("Marca del tractor: ");
    String marca = sc.nextLine().trim();

    int potencia = leerEnteroMayorQueCero(sc, "Potencia (CV): ");
    String trabajo = leerTrabajoValido(sc);

    marcas.add(marca);
    potencias.add(potencia);
    trabajos.add(trabajo);

    imprimirMensaje("Tractor añadido correctamente.");
}

// Función para listar array completo
static void listarTractores(ArrayList<String> marcas,
        ArrayList<Integer> potencias,
        ArrayList<String> trabajos) {

    if (marcas.isEmpty()) {
        imprimirMensaje("No hay tractores registrados.");
    } else {
        int indice = 0;
        while (indice < marcas.size()) {
            imprimirMensaje(indice + " -> " + marcas.get(indice) +
                    " | " + potencias.get(indice) +
                    " CV | trabajo: " + trabajos.get(indice));
            indice++;
        }
    }
}

// Función "comprueba tamaño del array y selecciona una posición"
static void evaluarTractor(Scanner sc,
        ArrayList<String> marcas,
        ArrayList<Integer> potencias,
        ArrayList<String> trabajos) {

    if (marcas.isEmpty()) {
        imprimirMensaje("No hay tractores para evaluar.");
    } else {
        listarTractores(marcas, potencias, trabajos);
        int indice = pedirIndiceValido(sc, marcas.size(), "Índice del tractor: ");
        String resultado = calcularResultado(trabajos.get(indice), potencias.get(indice));
        imprimirMensaje("Resultado: " + resultado);
        imprimirMensaje(mensajeResultado(resultado));
    }
}