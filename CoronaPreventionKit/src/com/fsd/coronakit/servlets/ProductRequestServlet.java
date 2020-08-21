package com.fsd.coronakit.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fsd.coronakit.entity.KitItem;
import com.fsd.coronakit.entity.Product;
import com.fsd.coronakit.entity.User;
import com.fsd.coronakit.exception.CoronaException;
import com.fsd.coronakit.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductRequestServlet
 */
@WebServlet({ "/newProductSave", "/doListProducts", "/doEdit", "/editSave", "/deleteProduct", "/logout", "/adminLogin",
		"/orderConfirmation", "/userDetailsSave", "/showKit", "/calculateTotals", "/addToKit" })
public class ProductRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductServiceImpl productServiceImpl;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProductRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		productServiceImpl = new ProductServiceImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String view = "";
		String action = request.getServletPath();
		switch (action) {
		case "/newProductSave":
			view = doAdd(request, response);
			break;

		case "/doListProducts":
			view = doList(request, response);
			break;

		case "/doEdit":
			view = doEdit(request, response);
			break;

		case "/editSave":
			view = doEditSave(request, response);
			break;

		case "/deleteProduct":
			view = doDeleteProduct(request, response);
			break;

		case "/logout":
			view = doLogout(request, response);
			break;

		case "/adminLogin":
			view = doAdminLoginValidation(request, response);
			break;

		case "/orderConfirmation":
			view = doOrderConfirmation(request, response);
			break;
		case "/userDetailsSave":
			view = userDetailsSave(request, response);
			break;
		case "/showKit":
			view = getSelectedList(request, response);
			break;
		case "/calculateTotals":
			view = calculateTotal(request, response);
			break;
		case "/addToKit":
			view = getProduct(request, response);
			break;
		default:
		}

		request.getRequestDispatcher(view).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private String doAdd(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("pid")));
		product.setpName(request.getParameter("pname"));
		product.setPcost(Double.parseDouble(request.getParameter("pcost")));
		product.setpDescription(request.getParameter("pdesc"));
		try {
			if (productServiceImpl.validateAndAddProduct(product) > 0) {
				request.setAttribute("Message", "Product Added Successfully");
				view = "newProduct.jsp";
			} else {
				throw new CoronaException("Product Not Added");
			}
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			List<Product> products = new ArrayList<>();
			products = productServiceImpl.getAllProducts();
			request.setAttribute("products", products);
			view = "listProducts.jsp";
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doEdit(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			Product product = new Product();
			product = productServiceImpl.validateAndGetProduct(Integer.parseInt(request.getParameter("pid")));
			request.setAttribute("product", product);
			view = "editProduct.jsp";
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doEditSave(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		Product product = new Product();
		product.setProductId(Integer.parseInt(request.getParameter("pid")));
		product.setpName(request.getParameter("pname"));
		product.setPcost(Double.parseDouble(request.getParameter("pcost")));
		product.setpDescription(request.getParameter("pdesc"));
		try {
			if (productServiceImpl.validateAndUpdate(product) > 0) {
				request.setAttribute("Message", "Product Updated Successfully");
				view = "editProduct.jsp";
			} else {
				throw new CoronaException("Product Not Updated");
			}
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doDeleteProduct(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			if (productServiceImpl.validateAndDeleteProduct(Integer.parseInt(request.getParameter("pid"))) > 0) {
				request.setAttribute("Message", "Product Deleted Successfully");
				view = "deleteConfirmation.jsp";
			} else {
				throw new CoronaException("Product Not Deleted");
			}
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doLogout(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			HttpSession session = request.getSession();
			session.setAttribute("isAdmin", null);
			view = "index.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doAdminLoginValidation(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			HttpSession session = request.getSession();
			if ((request.getParameter("username").equals("admin"))
					&& (request.getParameter("password").equals("admin"))) {
				session.setAttribute("isAdmin", "true");
				view = "welcomeAdmin.jsp";
			} else {
				request.setAttribute("message", "Incorrect User Name or Password");
				view = "index.jsp";
			}
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String doOrderConfirmation(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user = (User) session.getAttribute("userdetails");
			user.setAddress(request.getParameter("address"));
			session.setAttribute("userdetails", user);
			view = "orderSummary.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String userDetailsSave(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			User user = new User();
			HttpSession session = request.getSession();
			user.setpName(request.getParameter("pName"));
			user.setpContact(request.getParameter("pContact"));
			user.setpEmail(request.getParameter("pEmail"));
			session.setAttribute("userdetails", user);
			List<Product> products = new ArrayList<>();
			products = new ProductServiceImpl().getAllProducts();
			request.getSession().setAttribute("availableproducts", products);
			view = "showProductsToAdd.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String getSelectedList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		List<Product> products = new ArrayList<>();
		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		Product product = new Product();
		try {
			List<Integer> selectedIds = (List<Integer>) (request.getSession().getAttribute("selectedproductids"));
			for (int i = 0; i < selectedIds.size(); i++) {
				product = productServiceImpl.validateAndGetProduct(selectedIds.get(i));
				products.add(product);
			}
			request.getSession().setAttribute("selectedproducts", products);
			view = "showkit.jsp";
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String calculateTotal(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		double totalPrice = 0.0;
		List<KitItem> items = new ArrayList<>();
		try {
			List<Product> selectedProducts = (List<Product>) (request.getSession().getAttribute("selectedproducts"));
			for (Product p : selectedProducts) {
				double value = p.getPcost()
						* Integer.parseInt(request.getParameter("quantityOfProduct" + p.getProductId()));
				if (value == 0.0) {
					continue;
				}
				KitItem item = new KitItem();
				totalPrice += value;
				item.setPrice(value);
				item.setProduct(p);
				item.setQuantity(Integer.parseInt(request.getParameter("quantityOfProduct" + p.getProductId())));
				items.add(item);
			}
			request.getSession().setAttribute("kititems", items);
			request.setAttribute("Message", "Kit Items Saved");
			request.getSession().setAttribute("total", totalPrice);
			view = "showkit.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}

		return view;

	}

	private String getProduct(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		Product product = new Product();
		try {
			HttpSession session = request.getSession();
			product = new ProductServiceImpl().validateAndGetProduct(Integer.parseInt(request.getParameter("pid")));
			List<Integer> selectedProductIds = (List<Integer>) session.getAttribute("selectedproductids");
			if (selectedProductIds == null) {
				selectedProductIds = new ArrayList<Integer>();
			}
			selectedProductIds.add(product.getProductId());
			session.setAttribute("selectedproductids", selectedProductIds);
			view = "showProductsToAdd.jsp";
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

}
