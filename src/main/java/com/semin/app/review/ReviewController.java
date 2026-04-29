package com.semin.app.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.semin.app.member.MemberDTO;
import com.semin.app.product.ReviewService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/review/*")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@GetMapping("list")
	public String list(@RequestParam("productNo") Long productNo, Model model) throws Exception {

		List<ReviewDTO> list = reviewService.list(productNo);

		model.addAttribute("list", list);

		return "review/list"; // JSP 조각
	}

	@PostMapping("add")
	public String addReview(ReviewDTO reviewDTO, HttpSession session, Model model) throws Exception {

		MemberDTO member = (MemberDTO) session.getAttribute("member");

		if (member == null) {
			return "redirect:/member/login";
		}

		reviewDTO.setUsername(member.getUsername());

		reviewService.add(reviewDTO);

		List<ReviewDTO> list = reviewService.list(reviewDTO.getProductNo());
		model.addAttribute("list", list);

		return "review/list";
	}

}
