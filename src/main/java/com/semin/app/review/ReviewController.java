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
	public void list(ReviewDTO reviewDTO, Model model) throws Exception {

		List<ReviewDTO> list = reviewService.list(reviewDTO);

		model.addAttribute("list", list);
	}

	@PostMapping("add")
	public String addReview(ReviewDTO reviewDTO, HttpSession session, Model model) throws Exception {

		MemberDTO member = (MemberDTO) session.getAttribute("member");

		if (member == null) {
			return "redirect:/member/login";
		}

		reviewDTO.setUsername(member.getUsername());

		int result = reviewService.add(reviewDTO);

		model.addAttribute("result", result);

		return "commons/ajaxResult";
	}
	
	@PostMapping("delete")
	public String delete(ReviewDTO reviewDTO, Model model) throws Exception {
		int result = reviewService.delete(reviewDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";	
	}
	
	@PostMapping("update")
	public String update(ReviewDTO reviewDTO, Model model) throws Exception {
		int result = reviewService.update(reviewDTO);
		model.addAttribute("result", result);
		return "commons/ajaxResult";	
	}

}
