package com.semin.app.board;

import java.util.List;

import com.semin.app.file.FileDTO;
import com.semin.app.pager.Pager;

public interface BoardMapper {

	public List<BoardDTO> list(Pager pager) throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	public int create(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(BoardDTO boardDTO) throws Exception;
	
	public Long getCount(Pager pager) throws Exception;
	
	public int createFile(FileDTO fileDTO) throws Exception;
	
}
