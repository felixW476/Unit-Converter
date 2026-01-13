<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Unit Converter</title>
</head>
<body>

<h1>Unit Converter</h1>

<%
    // Get selected conversion type (default = length)
    String type = request.getParameter("type");
    if (type == null) {
        type = "length";
    }
%>

<form action="convert" method="post">

    <!-- Conversion Type -->
    <label>Conversion Type:</label>
    <select name="type" onchange="this.form.submit()">
        <option value="length" <%= type.equals("length") ? "selected" : "" %>>Length</option>
        <option value="weight" <%= type.equals("weight") ? "selected" : "" %>>Weight</option>
        <option value="temperature" <%= type.equals("temperature") ? "selected" : "" %>>Temperature</option>
    </select>

    <br><br>

    <!-- From Unit -->
    <label>From:</label>
    <select name="fromUnit">
        <% if (type.equals("length")) { %>
            <option value="millimeter">Millimeter</option>
            <option value="centimeter">Centimeter</option>
            <option value="meter">Meter</option>
            <option value="kilometer">Kilometer</option>
            <option value="inch">Inch</option>
            <option value="foot">Foot</option>
            <option value="yard">Yard</option>
            <option value="mile">Mile</option>
        <% } %>

        <% if (type.equals("weight")) { %>
            <option value="gram">Gram</option>
            <option value="kilogram">Kilogram</option>
            <option value="pound">Pound</option>
            <option value="ounce">Ounce</option>
        <% } %>

        <% if (type.equals("temperature")) { %>
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
            <option value="kelvin">Kelvin</option>
        <% } %>
    </select>

    <br><br>

    <!-- To Unit -->
    <label>To:</label>
    <select name="toUnit">
        <% if (type.equals("length")) { %>
            <option value="millimeter">Millimeter</option>
            <option value="centimeter">Centimeter</option>
            <option value="meter">Meter</option>
            <option value="kilometer">Kilometer</option>
            <option value="inch">Inch</option>
            <option value="foot">Foot</option>
            <option value="yard">Yard</option>
            <option value="mile">Mile</option>
        <% } %>

        <% if (type.equals("weight")) { %>
            <option value="gram">Gram</option>
            <option value="kilogram">Kilogram</option>
            <option value="pound">Pound</option>
            <option value="ounce">Ounce</option>
        <% } %>

        <% if (type.equals("temperature")) { %>
            <option value="celsius">Celsius</option>
            <option value="fahrenheit">Fahrenheit</option>
            <option value="kelvin">Kelvin</option>
        <% } %>
    </select>

    <br><br>

    <!-- Value -->
    <label>Value:</label>
    <input type="number" name="value" step="any" required>

    <br><br>

    <button type="submit">Convert</button>
</form>

<br>

<%
    // Display result if servlet sent one
    Object result = request.getAttribute("result");
    if (result != null) {
%>
    <h3>Result: <%= result %></h3>
<%
    }
%>

</body>
</html>