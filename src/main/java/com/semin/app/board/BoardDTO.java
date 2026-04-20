package com.semin.app.board;

import java.time.LocalDateTime;
import java.util.List;

import com.semin.app.file.FileDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardDTO {
	
	private Long boardNum;
	private String boardTitle;
	private String boardWriter;
	private String boardContents;
	private LocalDateTime boardDate;
	private Long boardHits;
	
	private List<FileDTO> list;
	

}
