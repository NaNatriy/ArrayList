package intg;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {

    private Integer[] array;
    private int size;

    public IntegerListImpl(int initialCapacity) {
        if(initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity " + initialCapacity);
        }
        array = new Integer[initialCapacity];
    }

    private void ensureCapacity (int minCapacity) {
        int oldCapacity = array.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity + (oldCapacity / 2);
            array = Arrays.copyOf(array, newCapacity);
        }
    }

    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new NullPointerException();
        }
        array[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        if(index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + "size: " + size);
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

    @Override
    public Integer set(int index, Integer item) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (item == null) {
            throw new NullPointerException();
        }
        Integer oldValue = array[index];
        array[index] = item;
        return oldValue;
    }

    @Override
    public Integer remove(Integer item) {
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

    @Override
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Integer oldValue = array[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(array, index + 1, array, index, numMoved);
        }
        return oldValue;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(Integer item) {
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

    @Override
    public int lastIndexOf(Integer item) {
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

    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
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
    public Integer[] toArray() {
        Integer[] array = new Integer[size];
        System.arraycopy(array, 0, array, 0, size);
        return array;
    }
}
