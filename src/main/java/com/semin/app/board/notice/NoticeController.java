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
	public String create(NoticeDTO noticeDTO, @RequestParam("attach") MultipartFile[] attach, Model model)
			throws Exception {
		int result = noticeService.create(noticeDTO, attach);
		if (result > 0) {
			model.addAttribute("result", "글 등록 성공");
			model.addAttribute("url", "./list");
		}

		return "commons/result";
	}

	@GetMapping("detail")
	public String detail(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		if (boardDTO == null) {
			model.addAttribute("result", "정보가 없습니다.");
			model.addAttribute("url", "./list");
			return "commons/result";
		} else {
			model.addAttribute("detail", boardDTO);
			return "board/detail";
		}
	}

	@GetMapping("update")
	public String update(NoticeDTO noticeDTO, Model model) throws Exception {
		BoardDTO boardDTO = noticeService.detail(noticeDTO);
		model.addAttribute("detail", boardDTO);

		return "board/update";
	}

	@PostMapping("update")
	public String update(NoticeDTO noticeDTO, @RequestParam("attach") MultipartFile[] attach) throws Exception {
		int result = noticeService.update(noticeDTO, attach);
		return "redirect:./list";
	}

	@PostMapping("delete")
	public String delete(NoticeDTO noticeDTO) throws Exception {

		int result = noticeService.delete(noticeDTO);

		return "redirect:./list";
	}
}
