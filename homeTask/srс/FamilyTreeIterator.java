package srс;

import java.util.Iterator;
import java.util.List;

public class FamilyTreeIterator implements Iterator<Human> {

    private List<Human> humans;
    private int index;

    public FamilyTreeIterator(List<Human> members) {
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
    public Human next() {
        return humans.get(index++);
    }
}