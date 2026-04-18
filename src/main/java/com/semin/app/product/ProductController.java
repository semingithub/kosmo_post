package com.semin.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.pager.Pager;
import com.semin.app.product.pager.ProductPager;

@Controller
@RequestMapping("/product/*")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("list")
	public String list(ProductPager productPagerager, Model model) throws Exception {
		List<ProductDTO> li = productService.list(productPagerager);
		model.addAttribute("list", li);
		return "product/list";
	}
	
	@GetMapping("create")
	public String create() throws Exception{
		return "product/create";		
	}
	
	@PostMapping("create")
	public String create(ProductDTO productDTO,@RequestParam("attach") MultipartFile attach) throws Exception{
		int result = productService.create(productDTO, attach);
		return "redirect:./list";
	}
	
	@GetMapping("detail")
	public String detail(ProductDTO productDTO, Model model) throws Exception{
		productDTO = productService.detail(productDTO);
		model.addAttribute("detail", productDTO);
		return "product/detail";
	}
}
