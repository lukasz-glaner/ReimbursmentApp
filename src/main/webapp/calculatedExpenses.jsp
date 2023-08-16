<%@ page import="com.handmadecode.reimbursmentapp.dto.CalculatedTicketDto" %>
<%@ page import="com.handmadecode.reimbursmentapp.model.Receipt" %>
<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Calculated Expenses</title>
</head>
<body>
<%
    CalculatedTicketDto calculatedTicketDto = (CalculatedTicketDto) request.getAttribute("calculatedExpenses");
    Float sumOfCosts = calculatedTicketDto.getSumOfCosts();
    String tripDateFrom = calculatedTicketDto.getTripDateFrom();
    String tripDateTo = calculatedTicketDto.getTripDateTo();
    String fullDaysNumber = String.valueOf(calculatedTicketDto.getFullDaysNumber());
    Set<Receipt> receipts = calculatedTicketDto.getReceipts();

%>
<h1>Hello in Reimbursement Application!</h1>
<h2>Details of the trip:</h2>
<p><strong>From:</strong> <%=tripDateFrom%></p>
<p><strong>To:</strong> <%=tripDateTo%></p>
<p><strong>Full business trip days:</strong> <%=fullDaysNumber%></p>
<h2>Expenses:</h2>
<table>
    <thead>
    <tr>
        <th>Type</th>
        <th>Description</th>
        <th>Cost</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (Receipt receipt : receipts) {
            String type = receipt.getType().replace("[", "").replace("]", "");
    %>
    <tr>
        <td><%=type%></td>
        <td><%=receipt.getDescription()%></td>
        <td><%=receipt.getCost()%> dollars</td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<p><strong>Total cost:</strong> <%=String.format("%s", sumOfCosts)%> dollars</p>

</body>
</html>