package com.semin.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.semin.app.member.MemberDTO;
import com.semin.app.product.ProductDTO;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/cart/*")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("create")
	public String create(HttpSession session, CartDTO cartDTO, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");
		cartDTO.setUsername(memberDTO.getUsername());

		int result = cartService.create(cartDTO);

		model.addAttribute("result", result);

		return "commons/ajaxResult";
	}

	@GetMapping("list")
	public String list(HttpSession session, Model model) throws Exception {
		MemberDTO memberDTO = (MemberDTO) session.getAttribute("member");

		if (memberDTO == null) {
			return "redirect:/member/login";
		}
		

	    List<ProductDTO> list = cartService.list(memberDTO);

	    model.addAttribute("list", list);

	    return "cart/list";
	}

}
