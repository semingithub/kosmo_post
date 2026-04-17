package com.semin.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.semin.app.board.BoardDTO;
import com.semin.app.pager.Pager;

@Controller
@RequestMapping("/board/*")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {

		List<BoardDTO> li = noticeService.list(pager);
		model.addAttribute("list", li);

		return "board/list";
	}

}
