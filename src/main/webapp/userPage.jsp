<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Expenses calculation form</title>
    <style>
        .expense {
            margin-bottom: 10px;
        }
        #add-button {
            display: block;
        }
    </style>
</head>
<body>
<%
    Set<String> availableReceiptTypes = (Set<String>) request.getAttribute("availableReceiptTypes");
%>
<h1>Enter all of expenses:</h1>
<form action="expensesCalculation" method="post">
    <fieldset>
        <legend>Main data</legend>
        <label for="tripDateFrom">Enter start date in format dd/mm/yyyy</label>
        <input type="text" name="tripDateFrom" id="tripDateFrom"><br>
        <label for="tripDateTo">Enter end date in format dd/mm/yyyy</label>
        <input type="text" name="tripDateTo" id="tripDateTo"><br>
        <label for="fullDaysNumber">Full business trip days</label>
        <input type="number" name="fullDaysNumber" id="fullDaysNumber" required><br>
    </fieldset>

    <fieldset id="expenses">
        <legend>Expenses</legend>
        <div class="expense">
            <label for="type1">Type:</label>
            <select name="type" id="type1">
                <%
                    for (String type : availableReceiptTypes) {
                %>
                <option value="<%=type%>"><%=type%></option>
                <%
                    }
                %>
            </select><br>
            <label for="description1">Description:</label>
            <input type="text" name="description" id="description1"><br>
            <label for="cost1">Cost:</label>
            <input type="number" name="cost" id="cost1" required><br>
        </div>
        <button type="button" id="add-button" onclick="addExpense()">Add Another Expense</button>
        <button type="button" id="delete-button" onclick="deleteExpense()">Delete Last Expense</button>
    </fieldset>
    <fieldset>
        <legend>Car Usage Reimbursement</legend>
        <label for="distance">Enter driven distance in miles:</label>
        <input type="number" name="distance" id="distance"><br>
    </fieldset>

    <input type="submit" value="Calculate">
</form>
<script>
    let expenseCount = 1;

    function addExpense() {
        expenseCount++;
        const expensesDiv = document.getElementById('expenses');
        const addButton = document.getElementById('add-button');
        const newExpenseDiv = document.createElement('div');
        newExpenseDiv.classList.add('expense');

        const availableTypes = "<%= availableReceiptTypes.toString().replace("[", "").replace("]", "") %>".split(", ");
        let selectHTML = '<label for="type' + expenseCount + '">Type:</label><select name="type" id="type' + expenseCount + '">';
        for (const type of availableTypes) {
            selectHTML += '<option value="' + type + '">' + type + '</option>';
        }
        selectHTML += '</select><br>';

        selectHTML += '<label for="description' + expenseCount + '">Description:</label><input type="text" name="description" id="description' + expenseCount + '"><br>';
        selectHTML += '<label for="cost' + expenseCount + '">Cost:</label><input type="number" name="cost" id="cost' + expenseCount + '" required><br>';

        newExpenseDiv.innerHTML = selectHTML;
        expensesDiv.insertBefore(newExpenseDiv, addButton);
    }
    function deleteExpense() {
        if (expenseCount > 1) {
            const expensesDiv = document.getElementById('expenses');
            const lastExpenseDiv = expensesDiv.getElementsByClassName('expense')[expenseCount - 1];
            expensesDiv.removeChild(lastExpenseDiv);
            expenseCount--;
        }
    }


</script>
</body>
</html>