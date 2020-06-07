package hw6_MyList;

import java.util.List;

public class DefaultMyList<E> implements MyList<E> {

    private Node<E> first;
    private Node<E> last;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("DefaultMyList{");

        if (first == null) {
            sb.append("List is empty");
        } else {
            sb.append("{");
            for (Node<E> x = first; x != null; x = x.next) {
                sb.append("[").append(x.item).append("]");
            }
            sb.append("}");
        }

        return sb.toString();
    }

    @Override
    public int size() {
        int size = 0;
        Node<E> f = first;
        Node<E> l = last;

        if (first == null)
            size = 0;
        else if (f == l)
            size = 1;
        else {
            while (f != null){
                size++;
                f = f.next;
            }
        }
        return size;
    }

    @Override
    public void add(E e) {
        link(e);
    }

    @Override
    public E get(int index) {
        int size = size();
        if (!(index >= 0 && index < size)){
            throw new IndexOutOfBoundsException();
        }

        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }

        return x.item;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null) {
                    unlink(x);
                    return true;
                }
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item)) {
                    unlink(x);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (Node<E> x = first; x != null; ) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x.prev = null;
            x = next;
        }
        first = last = null;
    }

    @Override
    public Object[] toArray() {
        int i = 0;
        int size = size();
        Object[] array = new Object[size];
        for (Node<E> x = first; x != null; ) {
            array[i] = x.item;
            i++;
            x = x.next;
        }
        return array;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return true;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(MyList<?> c) {
        for (Object o : c.toArray()) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    private class Node<E>{
        Node<E> prev;
        E item;
        Node<E> next;

        public Node(Node<E> prev, E item, Node<E> next) {
            this.prev = prev;
            this.item = item;
            this.next = next;
        }
    }

    void link(E e){
        Node<E> l = last;
        Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    boolean unlink(Node<E> x){
        Node<E> next = x.next;
        Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        return true;
    }
}