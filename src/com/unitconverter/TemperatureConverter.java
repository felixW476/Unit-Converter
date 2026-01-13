
public class TemperatureConverter {
    
    public static double convert(double value, String from, String to) {

        double celsius = 0.0;

        // From conversion

        if (from.equals("celsius")) {
            celsius = value;
        } else if (from.equals("fahrenheit")) {
            celsius = (value - 32) * 5 / 9;
        } else if (from.equals("kelvin")) {
            celsius = value - 273.15;
        } else {
            return 0;
        }
        
        // To conversion
        if (to.equals("celsius")) {
            return celsius;
        } else if (to.equals("fahrenheit")) {
            return (celsius * 9 / 5) + 32;
        } else if (to.equals("kelvin")) {
            return (celsius + 273.15);
        } else {
            return 0;
        }

    }

}
