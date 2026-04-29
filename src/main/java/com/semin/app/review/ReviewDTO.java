package com.semin.app.review;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReviewDTO {
	
	private Long reviewNo;
	private String reviewContents;
	private Long reviewStar;
	private LocalDateTime reviewDate;
	private String username;
	private Long productNo;

}
