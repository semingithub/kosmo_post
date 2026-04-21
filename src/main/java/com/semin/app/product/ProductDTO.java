package com.semin.app.product;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ProductDTO {
	
	private Long productNo;
	private String productName;
	private String productContents;
	private String productType;
	private Double productRate;
	private String fileName;
	
	private ProductFileDTO file;

}
