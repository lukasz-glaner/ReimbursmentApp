<%@ page import="com.handmadecode.reimbursmentapp.dto.CalcSettingsDto" %>
<%@ page import="java.util.Set" %>
<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin settings page</title>
</head>
<body>
<%
    CalcSettingsDto calcSettingsDto = (CalcSettingsDto) request.getAttribute("calcSettingsDto");
    float dailyAllowance = calcSettingsDto.getDailyAllowance();
    float mileageCost = calcSettingsDto.getMileageCost();
    Set<String> availableReceiptTypes = calcSettingsDto.getAvailableReceiptTypes();
    Map<String, Float> limits = calcSettingsDto.getLimits();
%>
<a href="userPage">Go to User Page</a><br>
<a href="index.html">Go to Main Page</a><br><br>

<form action="adminPage" method="post" id="receiptTypeForm">
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
    <br><br>
    <div id="receiptTypesContainer"></div>
    <button type="button" onclick="addReceiptTypeField()">Add new receipt type</button><br>
    <button type="button" onclick="removeReceiptTypeField()">Remove last receipt type</button><br>
    <input type="submit" value="Apply all">
</form>

<script>
    function addReceiptTypeField() {
        const container = document.getElementById('receiptTypesContainer');
        const receiptTypeDiv = document.createElement('div');
        receiptTypeDiv.className = 'receiptTypeDiv';

        const receiptTypeLabel = document.createElement('label');
        receiptTypeLabel.innerHTML = "New receipt type:";
        receiptTypeDiv.appendChild(receiptTypeLabel);

        const receiptTypeInput = document.createElement('input');
        receiptTypeInput.type = "text";
        receiptTypeInput.name = "newReceiptType";
        receiptTypeInput.required = true;
        receiptTypeDiv.appendChild(receiptTypeInput);

        const limitLabel = document.createElement('label');
        limitLabel.innerHTML = "Cost limit:";
        receiptTypeDiv.appendChild(limitLabel);

        const limitInput = document.createElement('input');
        limitInput.type = "number";
        limitInput.name = "limit";
        limitInput.required = true;
        receiptTypeDiv.appendChild(limitInput);

        container.appendChild(receiptTypeDiv);
    }
    function removeReceiptTypeField() {
        const container = document.getElementById('receiptTypesContainer');
        const receiptTypes = container.getElementsByClassName('receiptTypeDiv');
        const lastReceiptType = receiptTypes[receiptTypes.length - 1];

        if (lastReceiptType) {
            lastReceiptType.remove();
        }
    }

</script>
</body>
</html>
