package com.semin.app.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;

import com.semin.app.board.BoardDTO;
import com.semin.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest
@Slf4j
class NoticeMapperTest {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void testList() throws Exception {
		Pager pager = new Pager();
		pager.setPage(2L);
		pager.makeStartNum();
		pager.setSearch("1");
		List<BoardDTO> li = noticeMapper.list(pager);
		assertEquals(5, li.size());
		log.info("{}", li);
	}
	
	//@Test
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
