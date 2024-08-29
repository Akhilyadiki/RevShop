package com.revshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revshop.entity.Bill;
import com.revshop.entity.Category;
import com.revshop.entity.Order;
import com.revshop.entity.OrderDetails;
import com.revshop.entity.Item;
import com.revshop.entity.RateReview;
import com.revshop.utility.DatabaseConnection;

public class BuyerDAO implements BuyerDAOInterface{

	@Override
	public Item viewProductDetailsDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> browseProductsByCategoryDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String addProductsToCartDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeProductsToCartDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill checkoutDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getEmailNotificationsDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> viewOrderHistoryDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RateReview rateAndReviewProductsDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String complaintAgainstTheSellerDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String returnADefectiveProductDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String saveProductAsFavoriteDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetails generateInvoiceDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String makeaymentUsingThePaymentGatewayDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Item> getFeaturedItems() {
		List <Item> li = new ArrayList<>();
		  try {
		        Connection con = DatabaseConnection.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from items");
		        ResultSet i = ps.executeQuery();
		        while (i.next()) {
		            Item items = new Item();
		           items.setId(i.getInt("product_id"));
		           items.setName(i.getString("product_id"));
		           items.setDescription(i.getString("description"));
		           items.setPrice(i.getInt("price"));;
		           items.setImageUrl(i.getString("imageurl"));
		           items.setCategory(i.getString("category"));
		           items.setId(i.getInt("seller_id"));
		           items.setCreated_at(String.valueOf(i.getDate("created_at")));
		           items.setUpdated_at(String.valueOf(i.getDate("updated_at")));
		           items.setRating(i.getFloat("rating")); 
		           li.add(items);
		            if(li!=null)System.out.println("got items");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return li;
	}

	@Override
	public List<Category> getFeaturedCategory() {
		List <Category> li = new ArrayList<>();
		  try {
		        Connection con = DatabaseConnection.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from category");
		        ResultSet i = ps.executeQuery();
		        while (i.next()) {
		            Category c = new Category();
		           c.setName(i.getString("name"));
		           c.setImageUrl(i.getString("imageUrl"));
		           li.add(c);
		            if(li!=null)System.out.println("got categories");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return li;
	}

	@Override
	public List<Item> getItemsByCategory(String string) {
		List <Item> li = new ArrayList<>();
		  try {
		        Connection con = DatabaseConnection.getConnection();
		        PreparedStatement ps = con.prepareStatement("select * from items where category= ?");
		        ps.setString(1, string);
		        ResultSet i = ps.executeQuery();
		        while (i.next()) {
		            Item items = new Item();
		           items.setId(i.getInt("product_id"));
		           items.setName(i.getString("name"));
		           items.setDescription(i.getString("description"));
		           items.setPrice(i.getInt("price"));;
		           items.setImageUrl(i.getString("imageurl"));
		           items.setCategory(i.getString("category"));
		           items.setId(i.getInt("seller_id"));
		           items.setCreated_at(String.valueOf(i.getDate("created_at")));
		           items.setUpdated_at(String.valueOf(i.getDate("updated_at")));
		           items.setRating(i.getFloat("rating")); 
		           li.add(items);
		            if(li!=null)System.out.println("got Category items");
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
		    return li;
	}

}
