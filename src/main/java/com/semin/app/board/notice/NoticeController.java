package com.semin.app.board.notice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.semin.app.board.BoardDTO;
import com.semin.app.pager.Pager;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/board/*")
@Slf4j
public class NoticeController {
	
	@Value("${app.board.notice}")
	public String image;
	
	@ModelAttribute("image")
	public String getName() {
		return this.image;
	}

	@Autowired
	private NoticeService noticeService;

	@GetMapping("list")
	public String list(Pager pager, Model model) throws Exception {

		List<BoardDTO> li = noticeService.list(pager);
		model.addAttribute("list", li);

		return "board/list";
	}

	@GetMapping("create")
	public String create() throws Exception {
		return "board/create";
	}

	@PostMapping("create")
	public String create(NoticeDTO noticeDTO, @RequestParam("attach") MultipartFile[] attach) throws Exception {
		int result = noticeService.create(noticeDTO, attach);

		return "redirect:./list";
	}

	@GetMapping("detail")
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("detail", boardDTO);
		

		return "board/detail";
	}

}
