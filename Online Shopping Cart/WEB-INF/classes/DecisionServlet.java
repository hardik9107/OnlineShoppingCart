package cart;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;

public class DecisionServlet extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		if(request.getParameter("update")!= null) {
			HttpSession hs = request.getSession();
			Cart cItems = (Cart)hs.getAttribute("cart");
			Vector v = cItems.getCartItems();
			//Enumeration en = v.elements();
			//System.out.println("Size = "+v.size());
			for(int i=0; i<v.size();i++) {
			//while(en.hasMoreElements()) {
				CartItem c = (CartItem) v.get(i);
				String s = request.getParameter(c.getCartItemId());
				//System.out.println("Id = "+c.getCartItemId());
				if(s!= null) {
					//System.out.println("1");
					v.remove(c);
					i--;
				}
				else {
					//System.out.println("2");
					String str = request.getParameter("T"+c.getCartItemId());
					c.setQuantity(Integer.parseInt(str));
				}
			}
			//request.getRequestDispatcher("/DisplayCart.jsp").forward(request,response);
			response.sendRedirect("/Shop/DisplayCart.jsp");
		}
		if(request.getParameter("shop")!=null) {
			//request.getRequestDispatcher("/fetchItems").forward(request,response);
			response.sendRedirect("/Shop/fetchItems");
		}
		if(request.getParameter("freeze")!=null) {
			//request.getRequestDispatcher("/FreezrCart").forward(request,response);
			response.sendRedirect("/Shop/FreezeCart.jsp");
		}
	}
}