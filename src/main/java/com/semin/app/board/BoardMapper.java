package com.semin.app.board;

import java.util.List;

public interface BoardMapper {

	public List<BoardDTO> list() throws Exception;
	
	public BoardDTO detail(BoardDTO boardDTO) throws Exception;
	
	public int create(BoardDTO boardDTO) throws Exception;
	
	public int update(BoardDTO boardDTO) throws Exception;
	
	public int delete(BoardDTO boardDTO) throws Exception;
	
}
