package com.semin.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.file.FileManager;
import com.semin.app.pager.Pager;
import com.semin.app.product.pager.ProductPager;

@Service
public class ProductService {

	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private FileManager fileManager;
	
	@Value("${app.product}")
	private String name;

	public List<ProductDTO> list(ProductPager productPager) throws Exception {
		productPager.makePageNum(productMapper.getCount(productPager));
		productPager.makeStartNum();
		return productMapper.list(productPager);
	}
	
	public int create(ProductDTO productDTO, MultipartFile attach) throws Exception{
		int result = productMapper.create(productDTO);
		
		if(attach == null) {
			return result;
		}
		
		String fileName = fileManager.fileSave(name, attach);
		
		ProductFileDTO productFileDTO = new ProductFileDTO();
		productFileDTO.setProductNo(productDTO.getProductNo());
		productFileDTO.setOriName(attach.getOriginalFilename());
		productFileDTO.setFileName(fileName);
		
		result = productMapper.createFile(productFileDTO);
		
		return result;
	}
	
	public ProductDTO detail(ProductDTO productDTO) throws Exception{
		return productMapper.detail(productDTO);
	}

}
