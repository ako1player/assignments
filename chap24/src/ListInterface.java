public interface ListInterface {
    public boolean isFull();

    public int lengthIs();

    public boolean isThere (Listable item);

    public Listable retrieve(Listable item);

    public void insert (Listable item);

    public void delete (Listable item);

    public void reset();

    public Listable getNextItem ();

}
