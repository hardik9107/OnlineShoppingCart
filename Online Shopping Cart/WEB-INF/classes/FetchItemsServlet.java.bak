package cart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class FetchItemsServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try
		{
			ItemDAO dao = new ItemDAO();
			Collection items = dao.getAllItems();
			request.setAttribute("items",items);
			request.getRequestDispatcher("/Catalog.jsp").forward(request,response);
		}
		catch(Exception e) {
			pw.println(e);
		}
	}
}