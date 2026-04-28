package com.semin.app.cart;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.semin.app.member.MemberDTO;
import com.semin.app.product.ProductDTO;

@Mapper
public interface CartMapper {
	
	public int create(CartDTO cartDTO) throws Exception;
	
	public List<ProductDTO> list(MemberDTO memberDTO) throws Exception;
}
