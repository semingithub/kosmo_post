package com.semin.app.review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	
	public List<ReviewDTO> list(Long productNo) throws Exception;
	
	public int add(ReviewDTO reviewDTO) throws Exception;

}
