package com.fsd.coronakit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.exception.CoronaException;

public class ProductDaoImpl implements ProductDao {

	private String INSERT_PRODUCT_QUERY = "insert into products values(?,?,?,?);";
	private String FIND_PRODUCT_QUERY = "select * from products where productid=?;";
	private String DELETE_PRODUCT_QUERY = "delete from products where productid=?;";
	private String GET_ALL_PRODUCTS_QUERY = "select * from products;";
	private String UPDATE_PRODUCT_QUERY = "update products set pname=?,pcost=?,pdesc=? where productid=?";

	@Override
	public int addProduct(Product product) throws CoronaException {
		int rowsInserted = 0;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(INSERT_PRODUCT_QUERY);) {
			statement.setInt(1, product.getProductId());
			statement.setString(2, product.getpName());
			statement.setDouble(3, product.getPcost());
			statement.setString(4, product.getpDescription());
			rowsInserted = statement.executeUpdate();

		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return rowsInserted;
	}

	@Override
	public Product getProduct(int productId) throws CoronaException {
		Product product = new Product();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(FIND_PRODUCT_QUERY);) {
			statement.setInt(1, productId);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPcost(rs.getDouble(3));
				product.setpDescription(rs.getString(4));
			}

		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return product;
	}

	@Override
	public List<Product> getAllProducts() throws CoronaException {
		List<Product> products = new ArrayList<>();
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(GET_ALL_PRODUCTS_QUERY);) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Product product = new Product();
				product.setProductId(rs.getInt(1));
				product.setpName(rs.getString(2));
				product.setPcost(rs.getDouble(3));
				product.setpDescription(rs.getString(4));
				products.add(product);
			}

		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return products;
	}

	@Override
	public int deleteProduct(int productId) throws CoronaException {
		int rowsDeleted = 0;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(DELETE_PRODUCT_QUERY);) {
			statement.setInt(1, productId);
			rowsDeleted = statement.executeUpdate();

		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return rowsDeleted;
	}

	@Override
	public int updateProduct(Product p) throws CoronaException {
		int rowsUpdated = 0;
		try (Connection con = ConnectionFactory.getConnection();
				PreparedStatement statement = con.prepareStatement(UPDATE_PRODUCT_QUERY);) {
			statement.setString(1, p.getpName());
			statement.setDouble(2, p.getPcost());
			statement.setString(3, p.getpDescription());
			statement.setInt(4, p.getProductId());
			rowsUpdated = statement.executeUpdate();

		} catch (Exception e) {
			throw new CoronaException(e.getMessage());
		}
		return rowsUpdated;
	}

}
