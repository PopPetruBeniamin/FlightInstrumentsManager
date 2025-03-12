package Domain;

public class SoftwareInstrumentConverter extends FlightInstrumentConverter<SoftwareInstrument> {
    @Override
    public String toString(SoftwareInstrument softwareInstrument) {
        return softwareInstrument.toString();
    }

    @Override
    public SoftwareInstrument fromString(String line) {
        String[] parts = line.split(",");
        String code = parts[1];
        boolean maintenance = Boolean.parseBoolean(parts[2]);
        int version = Integer.parseInt(parts[3]);
        return new SoftwareInstrument(code, maintenance, version);
    }
}
