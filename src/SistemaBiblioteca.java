// ==========================================
// ARCHIVO 2: SistemaBiblioteca.java (Maya)
// ==========================================

import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        SistemaBiblioteca miBiblioteca = new SistemaBiblioteca(30);
        int opcion = 0;

        do {
            System.out.println("\n-------------------------------------");
            System.out.println("   MÓDULO DE GESTIÓN DE BIBLIOTECA   ");
            System.out.println("-------------------------------------");
            System.out.println("1. Registrar nuevo libro");
            System.out.println("2. Consultar catálogo completo");
            System.out.println("3. Buscar libro por ISBN");
            System.out.println("4. Prestar un libro");
            System.out.println("5. Devolver un libro");
            System.out.println("6. Salir del sistema");
            System.out.print("Seleccione una opción: ");

            if (entrada.hasNextInt()) {
                opcion = entrada.nextInt();
                entrada.nextLine();
            } else {
                System.out.println("Error: Debe ingresar un número entero.");
                entrada.nextLine();
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el ISBN: ");
                    String isbn = entrada.nextLine();
                    System.out.print("Ingrese el Título: ");
                    String titulo = entrada.nextLine();
                    System.out.print("Ingrese el Autor: ");
                    String autor = entrada.nextLine();

                    if (miBiblioteca.agregarLibro(isbn, titulo, autor)) {
                        System.out.println(">> ¡Libro registrado correctamente!");
                    } else {
                        System.out.println(">> Error: Capacidad máxima del sistema alcanzada.");
                    }
                    break;

                case 2:
                    miBiblioteca.mostrarCatalogo();
                    break;

                case 3:
                    System.out.print("Ingrese el ISBN del libro a buscar: ");
                    String isbnBusqueda = entrada.nextLine();
                    Libro hallado = miBiblioteca.obtenerPorIsbn(isbnBusqueda);
                    if (hallado != null) {
                        System.out.println("\nInformación del libro:");
                        hallado.imprimirFicha();
                    } else {
                        System.out.println(">> No se encontró ningún libro con ese ISBN.");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese el ISBN del libro a prestar: ");
                    String isbnPrestamo = entrada.nextLine();
                    if (miBiblioteca.prestarLibro(isbnPrestamo)) {
                        System.out.println(">> Préstamo realizado con éxito.");
                    } else {
                        System.out.println(">> No se pudo realizar el préstamo (Libro no encontrado o ya prestado).");
                    }
                    break;

                case 5:
                    System.out.print("Ingrese el ISBN del libro a devolver: ");
                    String isbnDevolucion = entrada.nextLine();
                    if (miBiblioteca.devolverLibro(isbnDevolucion)) {
                        System.out.println(">> Devolución registrada con éxito.");
                    } else {
                        System.out.println(">> No se pudo procesar la devolución (Libro no encontrado o no estaba prestado).");
                    }
                    break;

                case 6:
                    System.out.println("Cerrando sesión en el sistema...");
                    break;

                default:
                    System.out.println("Opción inválida, intente de nuevo.");
            }
        } while (opcion != 6);

        entrada.close();
    }
}