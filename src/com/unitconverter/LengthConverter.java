import java.util.HashMap;
import java.util.Map;

public class LengthConverter {
    
    private static final Map<String, Double> units = new HashMap<>(); // base metric = meters
    static {
        units.put("millimeter", 0.001);
        units.put("centimeter", 0.01);
        units.put("meter",1.0);
        units.put("kilometer", 1000.0);
        units.put("inch", 0.0254);
        units.put("foot",0.3040);
        units.put("yard",0.9144);
        units.put("mile", 1609.34);
    }

    public static double convert(double value, String from, String to) {
        Double fromFactor = units.get(from);
        Double toFactor = units.get(to);

        double meterConversion = value * fromFactor;
        return meterConversion / toFactor;
    }
}
