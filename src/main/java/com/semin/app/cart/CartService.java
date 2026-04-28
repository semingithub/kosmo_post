package com.semin.app.cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semin.app.member.MemberDTO;
import com.semin.app.product.ProductDTO;

@Service
public class CartService {
	
	@Autowired
	private CartMapper cartMapper;
	
	public int create(CartDTO cartDTO) throws Exception{
		int result = cartMapper.create(cartDTO);
		return result;
	}

	public List<ProductDTO> list(MemberDTO memberDTO) throws Exception{
		return cartMapper.list(memberDTO);
	}
}
