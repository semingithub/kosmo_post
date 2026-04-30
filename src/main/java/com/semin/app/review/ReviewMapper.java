package com.semin.app.review;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReviewMapper {
	
	public List<ReviewDTO> list(ReviewDTO reviewDTO) throws Exception;
	
	public int add(ReviewDTO reviewDTO) throws Exception;
	
	public int delete(ReviewDTO reviewDTO) throws Exception;
	
	public int update(ReviewDTO reviewDTO) throws Exception;

}
