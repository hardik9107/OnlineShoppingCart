package cart;

import java.sql.*;
import java.util.*;

public class ItemDAO
{
	Connection con;
	public ItemDAO() {		
	}
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3308/Shop","root","mikado");
		return con;
	}
	public void closeConnection() throws SQLException {
		con.close();
	}
	public Collection getAllItems() throws ClassNotFoundException, SQLException
	{
		Vector items = new Vector();
		getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Items");
		while(rs.next()){
			Item item = new Item();
			item.setId(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setImagePath(rs.getString(3));
			item.setDescription(rs.getString(4));
			item.setPrice(rs.getDouble(5));
			items.addElement(item);
		}
		rs.close();
		stmt.close();
		closeConnection();
		return items;
	}
	public Item getItem(final int itemId) throws ClassNotFoundException, SQLException
	{
		Item item = new Item();
		getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("Select * from Items where itemID=" + itemId);
		if(rs.next()){
			item.setId(rs.getInt(1));
			item.setName(rs.getString(2));
			item.setImagePath(rs.getString(3));
			item.setDescription(rs.getString(4));
			item.setPrice(rs.getDouble(5));
		}
		rs.close();
		stmt.close();
		closeConnection();
		return item;
	}
	public int getItemCount() throws ClassNotFoundException, SQLException
	{
		getConnection();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count(*) from items");
		rs.next();
		int itemCount = rs.getInt(1);
		rs.close();
		stmt.close();
		closeConnection();
		return itemCount;
	}
}