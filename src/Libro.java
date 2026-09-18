// ==========================================
// ARCHIVO 1: Biblioteca.java (Jhon Mario)
// ==========================================

// 1. Clase Modelo: Libro
class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private boolean disponible;

    public Libro(String isbn, String titulo, String autor) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.disponible = true;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public void imprimirFicha() {
        String estadoStr = disponible ? "DISPONIBLE" : "PRESTADO";
        System.out.printf("[%s] %s - %s | Estado: %s%n", isbn, titulo, autor, estadoStr);
    }
}

// 2. Clase de Gestión: Biblioteca
public class Libro {
    private Libro[] catalogo;
    private int totalLibros;

    public Libro(int limite) {
        this.catalogo = new Libro[limite];
        this.totalLibros = 0;
    }

    public boolean agregarLibro(String isbn, String titulo, String autor) {
        if (totalLibros >= catalogo.length) {
            return false;
        }
        catalogo[totalLibros] = new Libro(isbn, titulo, autor);
        totalLibros++;
        return true;
    }

    public void mostrarCatalogo() {
        if (totalLibros == 0) {
            System.out.println("El catálogo está actualmente vacío.");
            return;
        }
        System.out.println("\n=== CATÁLOGO DE LA BIBLIOTECA ===");
        for (int i = 0; i < totalLibros; i++) {
            catalogo[i].imprimirFicha();
        }
    }

    public Libro obtenerPorIsbn(String isbn) {
        for (int i = 0; i < totalLibros; i++) {
            if (catalogo[i].getIsbn().equalsIgnoreCase(isbn)) {
                return catalogo[i];
            }
        }
        return null;
    }

    public boolean prestarLibro(String isbn) {
        Libro libro = obtenerPorIsbn(isbn);
        if (libro != null && libro.isDisponible()) {
            libro.setDisponible(false);
            return true;
        }
        return false;
    }

    public boolean devolverLibro(String isbn) {
        Libro libro = obtenerPorIsbn(isbn);
        if (libro != null && !libro.isDisponible()) {
            libro.setDisponible(true);
            return true;
        }
        return false;
    }
}