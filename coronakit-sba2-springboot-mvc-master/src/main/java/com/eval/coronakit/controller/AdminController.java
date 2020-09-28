package com.eval.coronakit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.eval.coronakit.entity.ProductMaster;
import com.eval.coronakit.exception.CoronaException;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ProductService productService;

	@GetMapping("/home")
	public String home() {

		return "admin-home";
	}

	@GetMapping("/product-entry")
	public String productEntry(Model model) {
		model.addAttribute("product", new ProductMaster());
		return "add-new-item";
	}

	@PostMapping("/product-save")
	public String productSave(@ModelAttribute("product") ProductMaster product, BindingResult result)
			throws CoronaException {
		ModelAndView mv = null;
		if (result.hasErrors()) {
			mv = new ModelAndView("add-new-item", "product", product);
		} else {
			if (productService.addNewProduct(product) != null) {
				mv = new ModelAndView("show-all-item-admin", "products", productService.getAllProducts());
				mv.addObject("msg", "Product Added Successfully");
			} else {
				mv = new ModelAndView("show-all-item-admin", "product", productService.getAllProducts());
				mv.addObject("msg", "Unable to add product");
			}
		}
		return mv.getViewName();
	}

	@GetMapping("/product-list")
	public String productList(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "show-all-item-admin";
	}

	@GetMapping("/product-delete/{productId}")
	public String productDelete(@PathVariable("productId") int productId) {
		ModelAndView mv;
		if (productService.deleteProduct(productId) != null) {
			mv = new ModelAndView("show-all-item-admin", "products", productService.getAllProducts());
			mv.addObject("msg", "Product Deleted Successfully");
		} else {
			mv = new ModelAndView("show-all-item-admin", "products", productService.getAllProducts());
			mv.addObject("msg", "Unable to delete product");
		}
		return mv.getViewName();
	}

}
