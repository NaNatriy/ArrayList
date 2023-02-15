package menu;

import java.util.Arrays;

public class StringListImpl implements StringList {

    private String[] array;
    private int size;

    public StringListImpl(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        array = new String[initialCapacity];
    }

    private void ensureCapacity(int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = minCapacity;
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    public String add(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        ensureCapacity(size + 1);
        array[size++] = item;
        return item;
    }

    public String add(int index, String item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (item == null) {
            throw new NullPointerException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = item;
        size++;
        return item;
    }

    public String set(int index, String item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (item == null) {
            throw new NullPointerException();
        }
        String oldValue = array[index];
        array[index] = item;
        return oldValue;
    }

    public String remove(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return remove(i);
            }
        }
        throw new IllegalArgumentException("Element not found: " + item);
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        String oldValue = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        array[--size] = null;
        return oldValue;
    }

    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    public int indexOf(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        if (item == null) {
            throw new NullPointerException();
        }
        for (int i = size - 1; i >= 0; i--) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return -1;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }


    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("The other list cannot be null");
        }
        if (this == otherList) {
            return true;
        }
        if (this.size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!get(i).equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
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
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    @Override
    public String[] toArray() {
        String[] array = new String[size];
        System.arraycopy(array, 0, array, 0, size);
        return array;
    }
}
