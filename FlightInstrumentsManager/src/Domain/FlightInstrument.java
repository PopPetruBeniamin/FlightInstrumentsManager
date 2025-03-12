package Domain;

import java.io.Serializable;

public abstract class FlightInstrument implements Serializable {
    protected String code;
    protected boolean maintenance;

    public FlightInstrument(String date, Boolean maintenance) {
        this.code = date;
        this.maintenance = maintenance;
    }


    //Get function
    public String getCode() {
        return code;
    }
    public abstract double getPrice();
    public abstract String toString();
}
