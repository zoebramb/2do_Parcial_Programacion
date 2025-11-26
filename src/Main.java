import java.util.LinkedList;

public class Main {
    public static void main(String[] args)
    {
        System.out.println("=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===");

        Library library = new Library("Biblioteca de la UNViMe");
          
        // Crear algunos libros
        Book book1 = new Book("El Quijote", "978-84-376-0494-7", "Miguel de Cervantes", 1605);
        Book book2 = new Book("Cien años de soledad", "978-84-376-0495-4", "Gabriel García Márquez", 1967);
        Book book3 = new Book("1984", "978-84-376-0496-1", "George Orwell", 1949);
        Book book4 = new Book("El amor en los tiempos del cólera", "978-84-376-0497-8", "Gabriel García Márquez", 1985);
        
        // Agregar libros a la biblioteca
        System.out.println(" AGREGANDO LIBROS A LA BIBLIOTECA:");
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        System.out.println("Libros agregados exitosamente");
        
        // Mostramos cómo quedó la biblioteca
        System.out.println(library.toString());
        System.out.println(library.getStatistics());

        // Buscar libros por título
        System.out.println("\n BÚSQUEDA POR TÍTULO ('amor'):");
        LinkedList<Book> searchResults = library.findBooksByTitle("amor");
        System.out.println("\n BÚSQUEDA POR TÍTULO ('amor'):");
        for (int i = 0; i < searchResults.size(); i++) {
            System.out.println("  - " + searchResults.get(i));
        }
        
        // Buscar libros por autor
        System.out.println("\n BÚSQUEDA POR AUTOR ('García Márquez'):");
        LinkedList<Book> authorBooks = library.findBooksByAuthor("García Márquez");
        for (int i = 0; i < authorBooks.size(); i++) {
            System.out.println("  - " + authorBooks.get(i));
        }    

        //Por ISBN
        System.out.println(">>> Buscando ISBN-003:");
        Book encontrado = library.findBookByIsbn("ISBN-003");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.toString());
        } else {
            System.out.println("No encontrado.");
        }

        //Simulación de Préstamos
        System.out.println("\n--- SIMULACIÓN DE PRÉSTAMOS ---");
        
        // Prestamos el libro b1 (Quijote)
        if (book1.lend()) {
            System.out.println("Se prestó: " + book1.getTitle());
        }
        
        // Prestamos el libro b3 (1984)
        if (book3.lend()) {
            System.out.println("Se prestó: " + book3.getTitle());
        }

        // Intentamos prestar uno ya prestado (b1)
        if (!book1.lend()) {
            System.out.println("Error: " + book1.getTitle() + " ya estaba prestado.");
        }

        //Verificar Estadísticas post-préstamo
        System.out.println("\n--- ESTADÍSTICAS ACTUALIZADAS ---");
        System.out.println(library.getStatistics());

        //Prueba cola de espera
        System.out.println("\n--- PRUEBA DE COLA DE ESPERA ---");
        book3.agregarASolicitudes("Usuario_A"); //ya esta prestado
        book3.agregarASolicitudes("Usuario_B");
        book3.agregarASolicitudes("Usuario_C");

        System.out.println("Siguiente en espera:"+ book3.atenderSiguienteSolicitud());

        //se devuelve el libro 3
        book3.returnBook();
        System.out.println("Siguiente en espera: "+ book3.atenderSiguienteSolicitud());//deberia atender a Usuario_C
    }
}