package com.semin.app.board.qna;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.semin.app.board.BoardDTO;

import lombok.extern.slf4j.Slf4j;

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

}
