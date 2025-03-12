package Domain;

public class HardwareInstrumentConverter extends FlightInstrumentConverter<HardwareInstrument> {
    @Override
    public String toString(HardwareInstrument hardwareInstrument) {
        return hardwareInstrument.toString();
    }

    @Override
    public HardwareInstrument fromString(String line) {
        String[] parts = line.split(",");
        String code = parts[1];
        boolean maintenance = Boolean.parseBoolean(parts[2]);
        String measurementType = parts[3];
        return new HardwareInstrument(code, maintenance, measurementType);
    }
}
