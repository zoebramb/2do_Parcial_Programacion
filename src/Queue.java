public class Queue<T> {
    private Node<T> first;
    private Node<T> last; 
    
    public Queue() {
        this.first = null;
        this.last = null;
    }
    
    public void enqueue(T data) {
        Node<T> newNode = new Node<>(data);
        
        if (isEmpty()) {
            first = newNode;
            last = newNode;
        } else {
            last.setNext(newNode); 
            last = newNode;
        }
    }
    
    // Desencolar (Sacar del frente)
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        
        T data = first.getData();
        first = first.getNext(); 
        
        if (first == null) {
            last = null;
        }
        
        return data;
    }
    
    // Ver quién es el primero sin sacarlo
    public T peek() {
        if (isEmpty()) return null;
        return first.getData();
    }
    
    public boolean isEmpty() {
        return first == null;
    }
}
