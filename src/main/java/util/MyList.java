package util;

import java.util.Comparator;

public interface MyList<T> {
    void add(T t);

    T remove(int index);

    T get(int index);

    T set(int index, T t);

    int size();

    boolean isEmpty();

    void sort(Comparator<T> comparator);
}
