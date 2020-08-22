package com.fsd.coronakit.filters;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class notFoundFilter
 */
@WebFilter("/*")
public class notFoundFilter implements Filter {

	/**
	 * Default constructor.
	 */
	public notFoundFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		List<String> validURLs = Arrays.asList("/newProductSave", "/doListProducts", "/doEdit", "/editSave",
				"/deleteProduct", "/logout", "/adminLogin", "/orderConfirmation", "/userDetailsSave", "/showKit",
				"/calculateTotals", "/addToKit", "/placeOrder", "/listProducts.jsp", "/newProduct.jsp",
				"/deleteConfirmation.jsp", "/editProduct.jsp", "/error.jsp", "/footer.jsp", "/header.jsp", "/index.jsp",
				"/newUser.jsp", "/orderSummary.jsp", "/placeOrder.jsp", "/showkit.jsp", "/showProductsToAdd.jsp",
				"/unauthorized.jsp");
		String path = ((HttpServletRequest) request).getServletPath();
		if (!validURLs.contains(path)) {
			request.getRequestDispatcher("pageNotFound.jsp").forward(request, response);
		}

		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
