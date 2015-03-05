<%@ page import="java.util.*, cart.Item" %>

<html>
<table width="100%" height="100%">
<tr>
<td width="100%" height="20%" bgcolor="cyan">&nbsp;</td>
</tr>
<tr>
<td width="100%" height="60%" bgcolor="#a6a6a6">
<form name="loginForm" method="GET" action="/Shop/addItems">
<table align="center">
<caption>Catalog</caption>
<tr>
<th>Image</th><th>Description</th><th>Rate</th><th>&nbsp;</th>
</tr>
<%
	Collection c = (Collection)request.getAttribute("items");
	Iterator it = c.iterator();
	while(it.hasNext()){
		Item item =(Item) it.next();	
%>
<tr>
<td cellpadding="30" ><img src ="<%= item.getImagePath() %>" width="90" height="75">
</td>
<td cellpadding="30"><B><%= item.getDescription() %></B>
</td>
<td cellpadding="30">INR <%= item.getPrice() %>
</td>
<td>&nbsp;<input type="checkbox" name="item<%= item.getId() %>" value="ON">
</td>
</tr>
<% } %>
<tr>
<td cellpadding="30" colspan="4" align="center"><input type="submit" name="submit" value="Purchase"/>
</td>
</tr>
</table>
</form>
</td>
</tr>
<tr>
<td width="100%" height="20%" bgcolor="cyan">&nbsp;
</td>
</tr>
<tr>
<td width="100%" height="20%" bgcolor="cyan"></td>
</tr>
</table>
</html>