package com.semin.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.semin.app.board.BoardDTO;


@SpringBootTest
class QnaMapperTest {

	@Autowired
	private QnaMapper qnaMapper;

	@Test
	void testList() throws Exception {
		List<BoardDTO> li = qnaMapper.list();
		System.out.println(li);
		assertNotEquals(0, li);
	}

	@Test
	void testCreate() throws Exception {
		for (int i = 0; i < 23; i++) {
			QnaDTO qnaDTO = new QnaDTO();
			qnaDTO.setBoardTitle("Q&A Title" + i);
			qnaDTO.setBoardWriter("Q&A Writer" + i);
			qnaDTO.setBoardContents("Q&A Contetns" + i);		
			qnaMapper.create(qnaDTO);
			if(i%3 == 0) {
				Thread.sleep(500);
			}
			
		}
		System.out.println("finish");
	}

}
