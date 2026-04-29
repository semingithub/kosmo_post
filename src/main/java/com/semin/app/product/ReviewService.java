package com.semin.app.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.semin.app.review.ReviewDTO;
import com.semin.app.review.ReviewMapper;

@Service
public class ReviewService {

	@Autowired
	private ReviewMapper reviewMapper;

	public List<ReviewDTO> list(Long productNo) throws Exception {
		return reviewMapper.list(productNo);
	}

	public int add(ReviewDTO reviewDTO) throws Exception {
		return reviewMapper.add(reviewDTO);
	}

}
