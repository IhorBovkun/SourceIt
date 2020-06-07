package hw6_MyList;

public interface MyList<E> {
    int size();
    void add(E e);
    E get(int index);
    boolean remove(Object o);
    void clear();
    Object[] toArray();
    boolean contains(Object o);
    boolean containsAll(MyList<?> c);
}
