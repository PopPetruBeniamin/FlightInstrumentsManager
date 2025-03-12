package Domain;

public class SoftwareInstrument extends FlightInstrument {
    private final int version;

    public SoftwareInstrument(String code, boolean maintenance, int version) {
        super(code, maintenance);
        this.version = version;
    }

    @Override
    public double getPrice(){
        double price = 0;
        if(version < 10){
            price = 100;
        }
        else {
            price = 200;
        }

        if(maintenance){
            price *= 2;
        }

        return price;
    }

    @Override
    public String toString() {
        return "SoftwareInstrument," + code + "," + maintenance + "," + version;
    }
}
