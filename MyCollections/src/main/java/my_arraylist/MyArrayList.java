package my_arraylist;

import java.util.*;
import java.util.function.Consumer;

/**
 * ArrayList implementation
 * Created by o-morenets on 23.06.2019
 */
public class MyArrayList<E> implements List<E> {

    /**
     * Default initial capacity
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * The maximum size of array to allocate.
     * Some VMs reserve some header words in an array.
     * Attempts to allocate larger arrays may result in
     * OutOfMemoryError: Requested array size exceeds VM limit
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * Array for data
     */
    private E[] data;

    /**
     * Size of this list
     */
    private int size;

    /**
     * Modifications counter
     */
    private int modCount;

    /**
     * Constructs this list with default initial capacity
     */
    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Constructs this list with given initial capacity
     *
     * @param capacity initial capacity
     */
    public MyArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * Trims the capacity of this list to be the list's current size
     */
    public void trimToSize() {
        modCount++;
        if (size < data.length) {
            data = (size == 0) ? (E[]) new Object[]{} : Arrays.copyOf(data, size);
        }
    }

    private void ensureCapacityInternal(int minCapacity) {
        if (data.length == 0) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;
        // overflow-conscious code
        if (minCapacity - data.length > 0) grow(minCapacity);
    }

    /**
     * @param minCapacity the desired minimum capacity
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        data = Arrays.copyOf(data, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    /**
     * Returns number of elements in this list
     *
     * @return number of elements in this list
     */
    public int size() {
        return size;
    }

    /**
     * Checks whether this list contains no elements
     *
     * @return true if this list contains no elements, false otherwise
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Checks whether this list contains given element
     *
     * @param o element to be checked
     * @return true if this list contains given element, false otherwise
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * Returns index of first occurrence of given element in this list
     *
     * @param o element to be found
     * @return index of first occurrence of given element in this list or -1 if no such element was found
     */
    public int indexOf(Object o) {
        if (o == null)
            for (int i = 0; i < size; i++) {
                if (data[i] == null)
                    return i;
            }
        else
            for (int i = 0; i < size; i++) {
                if (o.equals(data[i]))
                    return i;
            }
        return -1;
    }

    /**
     * Returns index of last occurrence of given element in this list
     *
     * @param o element to be found
     * @return index of last occurrence of given element in this list or -1 if no such element was found
     */
    public int lastIndexOf(Object o) {
        if (o == null)
            for (int i = size - 1; i >= 0; i--) {
                if (data[i] == null)
                    return i;
            }
        else
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(data[i]))
                    return i;
            }
        return -1;
    }

    /**
     * Returns new array containing all elements of this list
     *
     * @return new array containing all elements of this list
     */
    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    /**
     * Copies all elements of this list to given array
     * If this list's size is greater than array's size, new array is created to fit all list elements
     *
     * @param a   given array
     * @param <T> given type of elements
     * @return array containing all elements of this list
     */
    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(data, size, a.getClass());
        System.arraycopy(data, 0, a, 0, size);
        return a;
    }

    /**
     * Returns element at given index
     *
     * @param index index of element
     * @return element at given index
     */
    public E get(int index) {
        checkRanges(index);

        return data[index];
    }

    /**
     * Replaces the element at the specified position in this list with the specified element
     *
     * @param index   inde of element
     * @param element element
     * @return the element previously at the specified position
     */
    public E set(int index, E element) {
        checkRanges(index);
        E oldElement = data[index];
        data[index] = element;

        return oldElement;
    }

    /**
     * Appends given element to the end of this list
     *
     * @param t element to be appended
     * @return true if element appended successfully, false otherwise
     */
    public boolean add(E t) {
        ensureCapacityInternal(size + 1);
        data[size++] = t;
        return true;
    }

    /**
     * Inserts element at given index in this list
     *
     * @param index   position of new element
     * @param element element to be added ti list
     * @throws IndexOutOfBoundsException if index out of range
     */
    public void add(int index, E element) {
        checkRangesForAdd(index);
        ensureCapacityInternal(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    /**
     * <Remove is not allowed>
     *
     * @param o element to remove
     * @return <Remove is not allowed>
     */
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("Remove is not allowed!");
    }

    /**
     * <Remove is not allowed>
     *
     * @param index index of element
     * @return <Remove is not allowed>
     */
    public E remove(int index) {
        throw new UnsupportedOperationException("Remove is not allowed!");
    }

    /**
     * Appends all elements of given collection to this list
     *
     * @param c given collection
     * @return true if all elements appended, false if collection is empty
     */
    public boolean addAll(Collection<? extends E> c) {
        if (c.size() == 0) return false;

        E[] cArr = (E[]) c.toArray();
        int cArrLen = cArr.length;
        ensureCapacityInternal(size + cArrLen);
        System.arraycopy(cArr, 0, data, size, cArrLen);
        size += cArrLen;
        return true;
    }

    /**
     * Appends all elements of given collection to this list
     *
     * @param c     given collection
     * @param index starting index of inserted collection
     * @return true if all elements appended, false if collection is empty
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        checkRangesForAdd(index);
        if (c.size() == 0) return false;

        E[] cArr = (E[]) c.toArray();
        int cArrLen = cArr.length;
        ensureCapacityInternal(size + cArrLen);

        int numToShift = size - index;
        if (numToShift > 0)
            System.arraycopy(data, index, data, index + cArrLen, numToShift);

        System.arraycopy(cArr, 0, data, index, cArrLen);
        size += cArrLen;
        return true;
    }

    /**
     * Helper method - Checks whether index is out of bounds
     *
     * @param index index to be checked
     */
    private void checkRanges(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index = " + index + ", size = " + size);
    }

    /**
     * Helper method for add() and addAll() - Checks whether index is out of bounds
     *
     * @param index index to be checked
     */
    private void checkRangesForAdd(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index = " + index + ", size = " + size);
    }

    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException("Remove is not allowed!");
    }

    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException("Remove is not allowed!");
    }

    /**
     * Checks whether this list contains all elements of given collection
     *
     * @param c given collection
     * @return true if this list contains all elements of given collection
     */
    public boolean containsAll(Collection<?> c) {
        Objects.requireNonNull(c);

        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    /**
     * <Remove is not allowed>
     */
    public void clear() {
        throw new UnsupportedOperationException("Remove is not allowed!");
    }

    /**
     * Creates an iterator over this list
     *
     * @return iterator over this list
     */
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    /**
     * Creates new list iterator over this list
     *
     * @return list iterator over this list
     */
    public ListIterator<E> listIterator() {
        return new MyListIterator(0);
    }

    /**
     * Creates new list iterator over this list starting from given index
     *
     * @param index start index
     * @return new list iterator over this list starting from given index
     */
    public ListIterator<E> listIterator(int index) {
        checkRanges(index);
        return new MyListIterator(index);
    }

    public List<E> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof List)) return false;

        List<?> that = (List<?>) o;
        if (size != that.size()) return false;

        for (int i = 0; i < size; i++) {
            if (!(data[i] == null ? that.get(i) == null : data[i].equals(that.get(i))))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hashCode = 1;
        for (E e : this)
            hashCode = 31 * hashCode + (e == null ? 0 : e.hashCode());
        return hashCode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(get(i));
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        return sb.toString() + "]";
    }

    /**
     * Iterator class
     */
    private class MyIterator implements Iterator<E> {
        int cursor;         // index of next element to return
        int lastRet = -1;   // index of last element returned; -1 if no such
        int expectedModCount = modCount; // modifications counter must be equal to modCount of this list

        @Override
        public boolean hasNext() {
            return cursor != size;
        }

        @Override
        public E next() {
            checkForComodification();

            int i = cursor;
            if (i >= size) throw new NoSuchElementException();

            E[] elementData = MyArrayList.this.data;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();

            cursor = i + 1;
            return elementData[lastRet = i];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not allowed!");
        }

        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }
    }

    /**
     * MyListIterator class
     */
    private class MyListIterator extends MyIterator implements ListIterator<E> {

        public MyListIterator(int index) {
            super();
            cursor = index;
        }

        @Override
        public boolean hasPrevious() {
            return cursor != 0;
        }

        @Override
        public E previous() {
            checkForComodification();
            int i = cursor - 1;
            if (i < 0) throw new NoSuchElementException();
            E[] elementData = MyArrayList.this.data;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i;
            return elementData[lastRet = i];
        }

        @Override
        public int nextIndex() {
            return cursor;
        }

        @Override
        public int previousIndex() {
            return cursor - 1;
        }

        public void set(E o) {
            if (lastRet < 0) throw new IllegalStateException();
            checkForComodification();

            try {
                MyArrayList.this.set(lastRet, o);
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        public void add(E o) {
            checkForComodification();
            try {
                int i = cursor;
                MyArrayList.this.add(i, o);
                cursor = i + 1;
                lastRet = -1;
                expectedModCount = modCount;
            } catch (IndexOutOfBoundsException ex) {
                throw new ConcurrentModificationException();
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove is not allowed!");
        }
    }
}
