<%@ page import="com.handmadecode.reimbursmentapp.dto.CalcSettingsDto" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello in admin settings page</title>
</head>
<body>
<%
    CalcSettingsDto calcSettingsDto = (CalcSettingsDto) request.getAttribute("calcSettingsDto");
    float dailyAllowance = calcSettingsDto.getDailyAllowance();
    float mileageCost = calcSettingsDto.getMileageCost();
    Set<String> availableReceiptTypes = calcSettingsDto.getAvailableReceiptTypes();
    Map<String, Float> limits = calcSettingsDto.getLimits();
%>

<form action="adminPage" method="post">
    <fieldset>
        <legend>Settings</legend>

        <label for="dailyAllowance">Daily Allowance:</label>
        <input type="number" step="0.01" name="dailyAllowance" id="dailyAllowance" value="<%= dailyAllowance %>"><br>

        <label for="mileageCost">Mileage Cost:</label>
        <input type="number" step="0.01" name="mileageCost" id="mileageCost" value="<%= mileageCost %>"><br>

        <h3>Receipt Types:</h3>
        <ul>
            <%
                for (String type : availableReceiptTypes) {
            %>
            <li><input type="text" name="availableReceiptTypes" value="<%= type %>"></li>
            <%
                }
            %>
        </ul>

        <h3>Limits:</h3>
        <ul>
            <%
                for (Map.Entry<String, Float> entry : limits.entrySet()) {
            %>
            <li>
                <label for="limit_<%= entry.getKey() %>"><%= entry.getKey() %>:</label>
                <input type="number" step="0.01" name="limits_<%= entry.getKey() %>" id="limit_<%= entry.getKey() %>" value="<%= entry.getValue() %>">
            </li>
            <%
                }
            %>
        </ul>
    </fieldset>
    <input type="submit" value="Apply">
</form>
</body>
</html>
