package telran;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OurArrayDeque <E> implements OurDeque<E>{
    private  static  final int INITIAL_CAPACITY = 16;
    E[] source;
    int size;
    // the field points out
    int firstIndex;
    OurArrayDeque (){
        source = (E[]) new Object[INITIAL_CAPACITY];
    }

    @Override
    public void addLast(E elt) {
        if(size == source.length)
            increaseSource();
        int newLastIndex = (firstIndex+ size) % source.length;
        source[newLastIndex] = elt;
        size++;
    }

    private void increaseSource() {
        E[] newSource = (E[]) new Object[INITIAL_CAPACITY*2];
        int i =0;
//        for(E elt : this){
//            newSource[i++] = elt;
//        }
//        firstIndex = 0;
//        this.source = newSource;
        System.arraycopy(source,firstIndex, newSource, 0, source.length-firstIndex);
        System.arraycopy(source,0,newSource,source.length-firstIndex,firstIndex);
        firstIndex = 0;
        this.source = newSource;
    }

    @Override
    public void addFirst(E elt) {
        int newFirstIndex;
        if(size == source.length)
            increaseSource();
            newFirstIndex = (firstIndex + source.length - 1) % source.length;


        source[newFirstIndex] = elt;
        firstIndex = newFirstIndex;
        size++;

    }

    @Override
    public E removeFirst() {
        if( size == 0)
        throw  new NoSuchElementException();
        E res = source[firstIndex];
        size --;
        //firstIndex = (firstIndex+1) % source.length;
        if(firstIndex == source.length -1)
            firstIndex = 0;
        else
            firstIndex++;
        return res;
    }

    @Override
    public E removeLast() {
        if (size == 0)
            throw new NoSuchElementException();

        int lastIndex = (firstIndex+ size - 1) % source.length;
        E toRemove = (E) source[lastIndex];
        source[lastIndex] = null;
        size--;
        return toRemove;
    }

    @Override
    public E getFirst() {
        if(size == 0)
            throw  new NoSuchElementException();
        return source[firstIndex];
    }

    @Override
    public E getLast() {
        if(size == 0)
            throw  new NoSuchElementException();
        int lastIndex = (firstIndex+ size-1) % source.length;
        return source[lastIndex];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return position < size;
            }

            @Override
            public E next() {
                if(position >= size)
                    throw new NoSuchElementException();

                int indexToReturn = (firstIndex+position)%source.length;
                position++;
                return source[indexToReturn];

            }
        };
    }
}
