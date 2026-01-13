
// Import required classes for Servlets
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/convert")
public class ConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // get the data from the form
        String type = request.getParameter("type");
        String from = request.getParameter("fromUnit");
        String to = request.getParameter("toUnit");
        String valueStr = request.getParameter("value");

        if (type == null || type.isEmpty()) { // default conversion if nothing was inputted
            type = "length";
        }

        double value = 0;

        // intialize result variable
        double result = 0;
        List<String> units = new ArrayList<>();

        if (valueStr != null && !valueStr.isEmpty() && from != null && to != null) {
            value = Double.parseDouble(valueStr);

            // route the correct converter

            if ("length".equals(type)) {
                units.add("millimeter");
                units.add("centimeter");
                units.add("meter");
                units.add("kilometer");
                units.add("inch");
                units.add("foot");
                units.add("yard");
                units.add("mile");

                result = LengthConverter.convert(value, from, to);

            } else if ("weight".equals(type)) {
                units.add("milligram");
                units.add("gram");
                units.add("kilogram");
                units.add("ounce");
                units.add("pound");

                result = WeightConverter.convert(value, from, to);

            } else if ("temperature".equals(type)) {
                units.add("celsius");
                units.add("fahrenheit");
                units.add("kelvin");

                result = TemperatureConverter.convert(value, from, to);
            }
        }

        // Send data to JSP
        request.setAttribute("units", units);
        request.setAttribute("type", type);
        request.setAttribute("result", result);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);

    }
}