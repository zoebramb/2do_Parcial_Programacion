/**
 * Implementación simple de una Lista Doblemente Enlazada
 */
public class LinkedList <T>{
    Node<T> head;
    int size;
    
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    public void add(T data) 
    {
        Node<T> newNode = new Node<T>(data);
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }
    
    public T get(int index) 
    {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getData();
 
    }
    
    
    public void remove(T data) 
    {
        if (head == null) return; 
        
        // Si el nodo a eliminar es el head
        if (head.getData().equals(data)) {
            head = head.getNext();
            size--;
            return;
        }
        
        Node<T> current = head;
        Node<T> previous = null;
        
        while (current != null && !current.getData().equals(data)) {
            previous = current;
            current = current.getNext();
        }
        
        // Si el nodo no fue encontrado
        if (current == null) {
            return;
        }
        
        // Eliminar el nodo
        previous.setNext(current.getNext());
        size--;
        
    }
    
    public boolean contains(T data) 
    {
        Node<T> current = head;
        while (current != null) {
            if (current.getData().toString().contains(data.toString())) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
    
    public boolean isEmpty() 
    {
        return head == null;
    }
    
    
    public void clear() 
    {
        head = null;
        size = 0;
    }
    
}
