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
import com.fsd.coronakit.service.KitItemServiceImpl;
import com.fsd.coronakit.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductRequestServlet
 */

@WebServlet({ "/newProductSave", "/doListProducts", "/doEdit", "/editSave", "/deleteProduct", "/logout", "/adminLogin",
		"/orderConfirmation", "/userDetailsSave", "/showKit", "/calculateTotals", "/addToKit", "/placeOrder" })

public class ProductRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ProductServiceImpl productServiceImpl;
	private KitItemServiceImpl kitItemServiceImpl;

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
		kitItemServiceImpl = new KitItemServiceImpl();
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
			view = getSelectedProductList(request, response);
			break;
		case "/calculateTotals":
			view = calculateTotal(request, response);
			break;
		case "/addToKit":
			view = addProductToKit(request, response);
			break;
		case "/placeOrder":
			view = placeKitOrder(request, response);
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
				view = "/doListProducts";
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

	private String getSelectedProductList(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		List<Product> products = new ArrayList<>();
		List<Integer> kitProductIds = new ArrayList<>();

		ProductServiceImpl productServiceImpl = new ProductServiceImpl();
		Product product = new Product();
		try {
			List<KitItem> items = (List<KitItem>) (request.getSession().getAttribute("kititems"));
			List<Integer> selectedIds = (List<Integer>) (request.getSession().getAttribute("selectedproductids"));

			if (items == null || items.isEmpty()) {
				items = new ArrayList<KitItem>();
			} else {
				for (KitItem KitItem : items) {
					kitProductIds.add(KitItem.getProduct().getProductId());
				}
			}
			if (!(selectedIds == null || selectedIds.isEmpty())) {
				for (int i = 0; i < selectedIds.size(); i++) {
					product = productServiceImpl.validateAndGetProduct(selectedIds.get(i));
					products.add(product);
				}
				for (Product p : products) {
					if ((!(kitProductIds.contains(p.getProductId()))) || (kitProductIds.isEmpty())) {
						items.add(kitItemServiceImpl.addItemToKit(p));
					}
				}
			}
			request.getSession().setAttribute("kititems", items);
			view = "showkit.jsp";
		} catch (CoronaException e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

	private String calculateTotal(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		List<KitItem> toBeRemoved = new ArrayList<KitItem>();
		List<Integer> kitProductIds = new ArrayList<>();
		try {
			List<KitItem> items = (List<KitItem>) (request.getSession().getAttribute("kititems"));
			if (items == null || items.isEmpty()) {
				items = new ArrayList<KitItem>();
			} else {
				for (KitItem p : items) {
					p = kitItemServiceImpl.updatePrice(p, Integer
							.parseInt(request.getParameter("quantityOfProduct" + p.getProduct().getProductId())));
					if (p.getPrice() == 0.0) {
						toBeRemoved.add(p);
						continue;
					}
					kitProductIds.add(p.getProduct().getProductId());
				}
				if (!toBeRemoved.isEmpty()) {
					items.removeAll(toBeRemoved);
				}
			}
			List<Integer> selectedProductIds = (List<Integer>) request.getSession().getAttribute("selectedproductids");
			if (!(selectedProductIds == null || selectedProductIds.isEmpty())) {
				selectedProductIds.retainAll(kitProductIds);
			}
			if (items.size() == 0) {
				request.getSession().setAttribute("kititems", null);
				request.setAttribute("Message", "Kit is Empty");
				request.getSession().setAttribute("selectedproductids", null);
			} else {
				request.getSession().setAttribute("kititems", items);
				request.setAttribute("Message", "Kit Items Saved");
				request.getSession().setAttribute("selectedproductids", selectedProductIds);
			}
			view = "showkit.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}

		return view;

	}

	private String addProductToKit(HttpServletRequest request, HttpServletResponse response) {
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

	private String placeKitOrder(HttpServletRequest request, HttpServletResponse response) {
		String view = "";
		try {
			List<KitItem> kitItems = (List<KitItem>) request.getSession().getAttribute("kititems");
			if (kitItems == null)
				kitItems = new ArrayList<>();
			request.getSession().setAttribute("total", kitItemServiceImpl.getTotalPrice(kitItems));
			view = "placeOrder.jsp";
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
			view = "error.jsp";
		}
		return view;
	}

}
