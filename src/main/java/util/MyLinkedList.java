package util;

import java.util.Comparator;

public class MyLinkedList<T> implements MyList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;


    private static class Node<T> {
        private T element;
        private Node<T> next;
        private Node<T> prev;

        Node(T element) {
            this.element = element;
        }
    }

    public void addFirst(T t) {
        Node<T> f = first;
        first = new Node<>(t);
        if (f == null) {
            last = first;
        } else {
            f.prev = first;
        }
        size++;
    }

    public void addLast(T t) {
        Node<T> l = last;
        last = new Node<>(t);
        if (l == null) {
            first = last;
        } else {
            l.next = last;
            last.prev = l;
        }
        size++;
    }


    @Override
    public void add(T t) {
        addLast(t);
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first;
        if (index == 0) {
            first = first.next;
            if (first != null) {
                first.prev = null;
            }
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current == last) {
                last = current.prev;
            }
            if (current.next != null) {
                current.next.prev = current.prev;
            }
            if (current.prev != null) {
                current.prev.next = current.next;
            }
        }
        return current.element;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = (index < size / 2) ? first : last;
        if (index < size / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            for (int i = size - 1; i > index; i--) {
                current = current.prev;
            }
        }

        return current.element;
    }

    @Override
    public T set(int index, T t) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node<T> current = first;
        if (index == 0) {
            first.element = t;
        } else {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            current.element = t;
        }

        return current.element;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        if (size > 1) {
            T[] array = (T[]) new Object[size];
            Node<T> current = first;
            for (int i = 0; i < size; i++) {
                array[i] = current.element;
                current = current.next;
            }

            quickSort(array, 0, size - 1, comparator);

            current = first;
            for (int i = 0; i < size; i++) {
                current.element = array[i];
                current = current.next;
            }
        }
    }

    private void quickSort(T[] array, int low, int high, Comparator<T> comparator) {
        if (low < high) {
            int pi = partition(array, low, high, comparator);
            quickSort(array, low, pi - 1, comparator);
            quickSort(array, pi + 1, high, comparator);
        }
    }

    private int partition(T[] array, int low, int high, Comparator<T> comparator) {
        T pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (comparator.compare(array[j], pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
}
