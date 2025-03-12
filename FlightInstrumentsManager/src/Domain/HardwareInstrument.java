package Domain;

public class HardwareInstrument extends FlightInstrument {
    private String measurementType;

    public HardwareInstrument(String code, boolean maintenance, String measurementType) {
        super(code, maintenance);
        this.measurementType = measurementType;
    }

    @Override
    public double getPrice() {
        double price = 0;

        if(measurementType.equals("altitudine") || measurementType.equals("directie")){
            price = 50;
        }
        else {
            price = 500;
        }

        if(maintenance){
            price *= 2;
        }
        return price;
    }

    @Override
    public String toString() {
        return "HardwareInstrument," + code + "," + maintenance + "," + measurementType;
    }
}
