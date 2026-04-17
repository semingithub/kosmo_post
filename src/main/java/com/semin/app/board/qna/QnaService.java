package com.semin.app.board.qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.board.BoardDTO;
import com.semin.app.board.BoardService;
import com.semin.app.file.FileManager;
import com.semin.app.pager.Pager;

@Service
public class QnaService implements BoardService {

	@Autowired
	private QnaMapper qnaMapper;

	@Autowired
	private FileManager fileManager;

	@Value("${app.board.qna}")
	private String name;

	@Override
	public List<BoardDTO> list(Pager pager) throws Exception {
		pager.makePageNum(qnaMapper.getCount(pager));
		pager.makeStartNum();

		return qnaMapper.list(pager);
	}

	@Override
	public BoardDTO detail(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int create(BoardDTO boardDTO, MultipartFile[] attach) throws Exception {
		// 1. 글 추가
		int result = qnaMapper.create(boardDTO);

		if (attach == null) {
			return result;
		}
		// 2. 하드 저장
		for (MultipartFile f : attach) {
			if (f.isEmpty()) {
				continue;
			}
			String fileName = fileManager.fileSave(name, f);
			// 3. 디비저장
			QnaFileDTO qnaFileDTO = new QnaFileDTO();
			qnaFileDTO.setBoardNum(boardDTO.getBoardNum());
			qnaFileDTO.setOriName(f.getOriginalFilename());
			qnaFileDTO.setFileName(fileName);
			
			result = qnaMapper.createFile(qnaFileDTO);
		}

		return result;
	}

	@Override
	public int update(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(BoardDTO boardDTO) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
