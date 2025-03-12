package Domain;

public abstract class FlightInstrumentConverter<T> {
    public abstract String toString(T shape);
    public abstract T fromString(String line);
}
