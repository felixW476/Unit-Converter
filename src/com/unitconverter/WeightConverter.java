import java.util.HashMap;
import java.util.Map;

public class WeightConverter {
    
    private static final Map<String, Double> units = new HashMap<>(); // base metric = gram
    static {
        units.put("gram", 1.0);
        units.put("milligram", 0.001);
        units.put("kilogram", 1000.0);
        units.put("ounce", 28.3485);
        units.put("pound", 453.592);
    };

    public static double convert(double value, String from, String to) {
        Double fromFactor = units.get(from);
        Double toFactor = units.get(to);

        double gramConversion = value * fromFactor;

        return gramConversion / toFactor;
    }
}
