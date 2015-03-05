package cart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.io.*;
import java.util.*;

public class AddItemsServlet extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		ItemDAO dao = new ItemDAO();
		HttpSession hs = request.getSession();
		Cart cart = (Cart)hs.getAttribute("cart");
		if(cart == null) {
			cart = new Cart();
			hs.setAttribute("cart",cart);
		}
		try
		{
			int itemCount = dao.getItemCount();
			for(int i=1;i<=itemCount;i++) {
				String s = request.getParameter("item"+i);
				if(s != null) {
					Item item = dao.getItem(i);
					CartItem cartItem = new CartItem("cartItem"+item.getId(),item,1);
					cart.addCartItem(cartItem);
				}
			}
			//request.getRequestDispatcher("/DisplayCart.jsp").forward(request,response);
			response.sendRedirect("/Shop/DisplayCart.jsp");
		}
		catch (Exception e)
		{
			pw.println(e);
		}
	}
};