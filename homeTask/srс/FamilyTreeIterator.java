package srс;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator<T> implements Iterator<T> {
    private List<T> humans;
    private int index;

    public FamilyTreeIterator(List<T> humans) {
        this.humans = humans;
    }

    public int getIndex() {
        return index;
    }

    @Override
    public boolean hasNext() {
        return index < humans.size();
    }

    @Override
    public T next() {
        return humans.get(index++);
    }
}