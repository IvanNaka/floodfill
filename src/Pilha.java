public class Pilha<T> {
    public int top = -1;
    public T[] data;

    private int tamanho;

    public Pilha(int tamanhoPilha) {
        tamanho = tamanhoPilha;
        this.data = (T[]) new Object[tamanhoPilha];
    }

    public void push(T data) {
        if (isFull()) {
            throw new StackOverflowError("Pilha cheia");
        }
        System.out.println("aumentou");
        this.data[++top] = data;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Pilha vazia");
        }
        T valorRem = this.data[top];
        T[] dataNovo = (T[]) new Object[tamanho];
        for (int i = 0, j = 0; i <= top; i++) {
            if (i != top) {
                dataNovo[j++] = data[i];
            }
        }
        data = dataNovo;
        top--;
        return valorRem;
    }

    public void clear() {
        data =  (T[]) new Object[tamanho];
        top = 0;
    }

    public boolean isFull() {
        return top == this.data.length - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}
