package com.semin.app.product;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.semin.app.product.pager.ProductPager;

@Mapper
public interface ProductMapper {
	
	public List<ProductDTO> list(ProductPager productPager) throws Exception;
	
	public Long getCount(ProductPager productPager) throws Exception;
	
	public int create(ProductDTO productDTO) throws Exception;
	
	public int createFile(ProductFileDTO productFileDTO) throws Exception;
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception;
}
