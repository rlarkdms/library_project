package controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Dao.NoticeDao;
import Data.Member;
import Data.Notice;

public class NoticeController {

	private NoticeDao noticeDao;
	
	@GetMapping(value="/notice1")
	public String notice1(Model model) {
	List<Notice> memberList = noticeDao.selectAll();
	model.addAttribute("members", memberList);//멤버 리스트를 다 주는 것.
	return "notice1";
	}
	@GetMapping(value="/notice2")
	public String notice2(@RequestParam(value="number")Long id,Model model) {
//여기서 부터 다시하기.		
		
	return "notice2";
	}
	
}
