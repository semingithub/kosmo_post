package com.semin.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.semin.app.pager.Pager;

@Mapper
public interface ProductMapper {
	
	public List<ProductDTO> list(Pager pager) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;
	
	public int create(ProductDTO productDTO) throws Exception;
	
	public int createFile(ProductFileDTO productFileDTO) throws Exception;
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception;
}
