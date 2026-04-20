package com.semin.app.board;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.pager.Pager;

@Service
public interface BoardService {

	public List<BoardDTO> list(Pager pager) throws Exception;

	public BoardDTO detail(BoardDTO boardDTO) throws Exception;

	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;

	public int update(BoardDTO boardDTO, MultipartFile[] attach) throws Exception;

	public int delete(BoardDTO boardDTO) throws Exception;

}
