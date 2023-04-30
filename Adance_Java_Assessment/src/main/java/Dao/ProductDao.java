package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Connectivity.DBConnection;
import Model.Product;

public class ProductDao {
	public static void UploadProduct(Product p) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "insert into product (sid,image,pname,pprice,pcategory,pdesc) values(?,?,?,?,?,?)";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, p.getSid());
			pst.setString(2, p.getImage());
			pst.setString(3, p.getPname());
			pst.setInt(4, p.getPprice());
			pst.setString(5, p.getPcategory());
			pst.setString(6, p.getPdesc());
			pst.executeUpdate();
			System.out.println("data uploaded");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static List<Product> getProductBySid(int sid) {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "select * from product where sid=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPprice(rs.getInt("pprice"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPdesc(rs.getString("pdesc"));
				list.add(p);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	public static List<Product> getAllProduct() {
		List<Product> list = new ArrayList<Product>();
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "select * from product";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				Product p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPprice(rs.getInt("pprice"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPdesc(rs.getString("pdesc"));
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Product getProductByPid(int id) {
		Product p = null;
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "select * from product where pid=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				p = new Product();
				p.setPid(rs.getInt("pid"));
				p.setSid(rs.getInt("sid"));
				p.setImage(rs.getString("image"));
				p.setPname(rs.getString("pname"));
				p.setPprice(rs.getInt("pprice"));
				p.setPcategory(rs.getString("pcategory"));
				p.setPdesc(rs.getString("pdesc"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}
	public static Product updateProductByPid(Product p) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlString = "update product set image=?,pname=?,pprice=?,pcategory=?,pdesc=? where pid=?";
			PreparedStatement pst = connection.prepareStatement(sqlString);
			pst.setString(1, p.getImage());
			pst.setString(2, p.getPname());
			pst.setInt(3, p.getPprice());
			pst.setString(4, p.getPcategory());
			pst.setString(5, p.getPdesc());
			pst.setInt(6, p.getPid());
			pst.executeUpdate();
			System.out.println("product updated successfully.....");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return p;
	}
	public static void deleteProduct(int id) {
		try {
			Connection connection = DBConnection.createConnection();
			String sqlstString = "delete from product where pid=?";
			PreparedStatement pst = connection.prepareStatement(sqlstString);
			pst.setInt(1, id);
			pst.executeUpdate();
			System.out.println("data deleted...");
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
