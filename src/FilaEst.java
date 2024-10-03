public class FilaEst<T> {
    private int top = -1;
    private int base = 0;
    private T[] data;


    FilaEst(int tamanho){
        this.data = (T[]) new Object[tamanho];
    }

    public void add(T value){
        if (isFull()) {
            throw new StackOverflowError("Fila cheia");
        }
        this.data[++top] = value;
    }

    public T remove() {
        if (isEmpty()) {
            throw new StackOverflowError("Fila vazia");
        }
        T removedElement = this.data[base];


        for (int i = 0; i < top; i++) {
            this.data[i] = this.data[i + 1];
        }

        top--;
        return removedElement;
    }

    public void clear(){
        top = -1;
        base = 0;
    }

    public boolean isFull(){
        return top == this.data.length - 1;
    }

    public boolean isEmpty(){
        return top < base;
    }


}
