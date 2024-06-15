public class MyDeque<E> implements DequeInterface<E> {
    
    Object[] data;
    int size;
    int rear;
    int front;

    public MyDeque(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException();
        }

        this.data = new Object[initialCapacity];
        this.size = 0;
        this.rear = 0;
        this.front = 0;
    }

    public int size() {
        return this.size;
    }

    public void expandCapacity() {
        int newCapacity;
        if (data.length == 0) {
            newCapacity = 10;
        } else {
            newCapacity = data.length * 2;
        }

        Object[] newData = new Object[newCapacity];

        for (int i = 0; i < this.size; i++) {
            newData[i] = this.data[(this.front + i) % this.data.length];
        }

        this.data = newData;
        this.front = 0;
        if (this.size == 0) {
            this.rear = 0;
        } else {
            this.rear = this.size - 1;
        }
    }

    public void addFirst(E element) {
        if (element == null) {
            throw new NullPointerException();
        }

        if (this.size == this.data.length) {
            expandCapacity();
        }

        if (this.size == 0) {
            this.data[0] = element;
            this.size++;
            this.front = 0;
            this.rear = this.front;
        } else {
            this.front = (this.front - 1 + this.data.length) % this.data.length;
            this.data[front] = element;
            this.size++;
        }


    }

    public void addLast(E element) {

        if (element == null) {
            throw new NullPointerException();
        }

        if (this.size == this.data.length) {
            expandCapacity();
        }

        if (this.size == 0) {
            this.data[0] = element;
            this.size++;
            this.rear = 0;
            this.front = this.rear;
        } else {
            this.rear = (this.rear + 1) % this.data.length;
            this.data[rear] = element;
            this.size++;
        }

    }

    public E removeFirst() {
        if (this.size == 0) {
            return null;
        }

        E element = (E) this.data[front];
        this.data[front] = null;
        this.front = (this.front + 1) % this.data.length;
        this.size--;
        return element;
    }

    public E removeLast() {
        if (this.size == 0) {
            return null;
        }

        E element = (E) this.data[rear];
        this.data[rear] = null;
        this.rear = (this.rear - 1 + this.data.length) % this.data.length;
        this.size--;
        return element;
    }

    public E peekFirst() {
        if (this.size == 0) {
            return null;
        }

        E element = (E) this.data[front];
        return element;

    }

    public E peekLast() {
        if (this.size == 0) {
            return null;
        }

        E element = (E) this.data[rear];
        return element;
    }

}
