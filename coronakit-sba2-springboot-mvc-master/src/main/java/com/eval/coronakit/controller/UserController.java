package com.eval.coronakit.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributesModelMap;

import com.eval.coronakit.entity.CoronaKit;
import com.eval.coronakit.entity.KitDetail;
import com.eval.coronakit.service.CoronaKitService;
import com.eval.coronakit.service.KitDetailService;
import com.eval.coronakit.service.ProductService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	ProductService productService;

	@Autowired
	CoronaKitService coronaKitService;

	@Autowired
	KitDetailService kitDetailService;

	static List<KitDetail> kitDetails = new ArrayList<>();

	@RequestMapping("/home")
	public String home() {
		return "user-home";
	}

	@RequestMapping("/show-kit")
	public String showKit(Model model) {
		model.addAttribute("kitItems", kitDetails);
		return "show-cart";
	}

	@RequestMapping("/show-list")
	public String showList(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "show-all-item-user";
	}

	@RequestMapping("/add-to-cart/{productId}")
	public String showKit(@PathVariable("productId") int productId, Model model) {
		KitDetail kitDetail = new KitDetail(new Random().nextInt(100), 1, productId, 1,
				productService.getCostById(productId));
		kitDetails.add(kitDetail);
		model.addAttribute("kitItems", kitDetails);
		return "show-cart";
	}

	@RequestMapping("/checkout")
	public String checkout(Model model) {
		model.addAttribute("coronakit", new CoronaKit());
		model.addAttribute("kitItems", kitDetails);
		return "checkout-address";
	}

	@RequestMapping("/finalize")
	public String finalizeOrder(@RequestParam String address, Model model) {
		int amount = 0;
		for (KitDetail k : kitDetails) {
			amount += k.getAmount();
			kitDetailService.addKitItem(k);
		}
		LocalDate localDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String dateString = localDate.format(formatter);
		coronaKitService.saveKit(new CoronaKit(1, address, dateString, amount));
		model.addAttribute("TotalAmount", amount);
		model.addAttribute("deliveryAddress", coronaKitService.getKitById(1).getDeliveryAddress());
		model.addAttribute("kitItems", kitDetails);
		return "show-summary";

	}

	@RequestMapping("/delete/{itemId}")
	public String deleteItem(@PathVariable("itemId") int itemId, Model model) {
		for (KitDetail k : kitDetails) {
			if (k.getId() == itemId) {
				kitDetails.remove(k);
				break;
			}
		}
		model.addAttribute("kitItems", kitDetails);
		return "show-cart";
	}
}
