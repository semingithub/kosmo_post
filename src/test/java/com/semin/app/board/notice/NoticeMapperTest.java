package com.semin.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.semin.app.board.BoardDTO;

@SpringBootTest
@Commit
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	//@Test
	void testList() throws Exception {
		List<BoardDTO> li = noticeMapper.list();
		assertNotEquals(0, li);
	}
	
	@Test
	void testCreate() throws Exception {
		for(int i = 0; i < 23; i++) {			
			NoticeDTO noticeDTO = new NoticeDTO();
			noticeDTO.setBoardTitle("Title" + i);
			noticeDTO.setBoardWriter("Writer" + i);
			noticeDTO.setBoardContents("Contetns" + i);
			noticeMapper.create(noticeDTO);
			if(i%3 == 0 ) {
				Thread.sleep(500);
			}
		}
		System.out.println("완료");	
		
	}

}
