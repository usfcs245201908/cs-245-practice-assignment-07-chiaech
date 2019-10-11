public class ArrayList<T> implements List<T> {

    protected T [] a;
    protected int size;

    public ArrayList(){
        a = (T[]) new Object[10];
        size=0;
    }

    @Override
    public void add(T item) {
        if (size == a.length)
            grow_array();
        a[size++] = item;
    }

    @Override
    public void add(int pos, T item){
        if (pos < 0 || pos > size)
            throw new RuntimeException();
        if (size == a.length)
            grow_array();
        for (int i = size-1; i >= pos; i--){
            a[i] = a[i-1];
        }
        a[pos]=item;
        size++;
    }

    @Override
    public T get(int pos){
        if (pos < 0 || pos >= size)
            throw new RuntimeException();
        return a[pos];
    }

    @Override
    public T remove(int pos) {
        if (pos < 0 || pos >= size)
            throw new RuntimeException();
        T item = a[pos];
        for (int i = pos; i < size-1; i++){
            a[i] = a[i+1];
        }
        size--;
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    void grow_array(){
        T[] new_array = (T[]) new Object[a.length*2];
        for (int i = 0; i < a.length; i++){
            new_array[i] = a[i];
        }
        a = new_array;
    }
}
