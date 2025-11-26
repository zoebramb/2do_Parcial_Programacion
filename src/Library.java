import java.util.LinkedList;

/**
 * Esta clase representa una un tren de bibliotecas que maneja una colección de libros libres.
 */
public class Library {
    private String name;
    private LinkedList<Book> books;
    
    /**
     * Constructor para crear una biblioteca
     * @param name El nombre de la biblioteca
     */
    public Library(String name) {
        this.name = name;
       this.books = new LinkedList<>();
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public LinkedList<Book> getBooks() {
        return books;
    }
    
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * Agrega un libro a la biblioteca
     * @param book El libro a agregar
     * @return true si se agregó exitosamente
     */
    public boolean addBook(Book book) {
        books.add(book);
        return true;
    }
    
    
    /**
     * Elimina un libro de la biblioteca
     * @param book El libro a eliminar
     * @return true si se eliminó exitosamente
     */
    public boolean removeBook(Book book) 
    {
        return books.remove(book);
    }
    
    /**
     * Busca un libro por ISBN
     * @param isbn El ISBN a buscar
     * @return El libro encontrado o null si no existe
     */
    public Book findBookByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) 
        {
            Book book = books.get(i);
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }
    
    /**
     * Busca libros por título (Búsqueda parcial, ignorando mayúsculas)
     */
    public LinkedList<Book> findBooksByTitle(String title) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        String searchTitle = title.toLowerCase();
        
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getTitle().toLowerCase().contains(searchTitle)) {
                foundBooks.add(b);
            }
        }
        return foundBooks;
    }
    
   public LinkedList<Book> findBooksByAuthor(String authorName) {
        LinkedList<Book> foundBooks = new LinkedList<>();
        String searchAuthor = authorName.toLowerCase();
        
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getAuthor().toLowerCase().contains(searchAuthor)) {
                foundBooks.add(b);
            }
        }
        return foundBooks;
    }
    
    /**
     * Obtiene todos los libros disponibles para préstamo
     * @return Lista enlazada con los libros disponibles
     */
    public LinkedList<Book> getAvailableBooks() 
    {
        LinkedList<Book> availableBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.isAvailable()) {
                availableBooks.add(b);
            }
        }
        return availableBooks;
    }
    
    /**
     * Obtiene todos los libros prestados
     * @return Lista enlazada con los libros prestados
     */
    public LinkedList<Book> getLoanedBooks() 
    {
        LinkedList<Book> loanedBooks = new LinkedList<>();
        for (int i = 0; i < books.size(); i++) 
            {
            Book b = books.get(i);
            if (!b.isAvailable()) loanedBooks.add(b);
        }
        return loanedBooks;
    }
    
    /**
     * Obtiene estadísticas de la biblioteca
     * @return String con las estadísticas
     */
    public String getStatistics() {
        int totalBooks = books.size();
        int availableCount = 0;
        int loanedCount = 0;
        
        for (int i = 0; i < totalBooks; i++) {
            if (books.get(i).isAvailable()) {
                availableCount++;
            } else {
                loanedCount++;
            }
        }
        
        return String.format(
            "Estadísticas de la Biblioteca:\n" +
            "- Total de Libros: %d\n" +
            "- Libros Disponibles: %d\n" +
            "- Libros Prestados: %d\n",
            totalBooks, availableCount, loanedCount
        );
    }
    
    /**
     * Representación legible de la biblioteca
     * @return String con la información de la biblioteca
     */
    @Override
    public String toString() 
    {
        return "Biblioteca: " + name + " | Total de Libros: " + books.size();
    }
}
