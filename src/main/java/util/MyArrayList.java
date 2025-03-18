package util;

import java.util.Comparator;

public class MyArrayList<T> implements MyList<T> {
    private final int INIT_SIZE = 10;
    private Object[] elements;
    private int size;

    public MyArrayList() {
        this.elements = new Object[INIT_SIZE];
        this.size = 0;
    }

    @Override
    public void add(T t) {
        if (size == elements.length - 1) {
            resize(elements.length * 2);
        }
        elements[size++] = t;
    }

    private void resize(int newSize) {
        Object[] newArray = new Object[newSize];
        System.arraycopy(elements, 0, newArray, 0, elements.length);
        elements = newArray;
    }

    @Override
    public T remove(int index) {
        Object o = elements[index];

        for (int i = index; i < size; i++) {
            elements[i] = elements[i + 1];
        }

        elements[size] = null;
        size--;

        return (T) o;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Object o = elements[index];
        return (T) o;
    }

    @Override
    public T set(int index, T t) {
        T old = get(index);
        elements[index] = t;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void sort(Comparator<T> comparator) {
        if (size > 1) {
            mergeSort(elements, 0, size - 1, comparator);
        }
    }

    private void mergeSort(Object[] arr, int left, int right, Comparator<T> comparator) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid, comparator);
        mergeSort(arr, mid + 1, right, comparator);
        merge(arr, left, mid, right, comparator);
    }

    private void merge(Object[] arr, int left, int mid, int right, Comparator<T> comparator) {
        int size1 = mid - left + 1;
        int size2 = right - mid;

        Object[] leftArr = new Object[size1];
        Object[] rightArr = new Object[size2];

        System.arraycopy(arr, left, leftArr, 0, size1);
        System.arraycopy(arr, mid + 1, rightArr, 0, size2);

        int i = 0, j = 0, k = left;

        while (i < size1 && j < size2) {
            if (comparator.compare((T) leftArr[i], (T) rightArr[j]) <= 0) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }
        }

        while (i < size1) {
            arr[k++] = leftArr[i++];
        }
        while (j < size2) {
            arr[k++] = rightArr[j++];
        }
    }
}
