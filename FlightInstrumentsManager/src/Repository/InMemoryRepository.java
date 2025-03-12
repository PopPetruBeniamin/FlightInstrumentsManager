package Repository;

import Domain.FlightInstrument;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T extends FlightInstrument> implements GenericRepository<T> {
    protected final List<T> items = new ArrayList<>();

    @Override
    public void add(T item) {
        items.add(item);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}
