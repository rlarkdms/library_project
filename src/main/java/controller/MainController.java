package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Dao.MemberDao;
import Data.Member;

@Controller
public class MainController {
	@Autowired
	private MemberDao memberDao;
	
	@GetMapping(value="/list")
	public String list(Model model) {
	List<Member> memberList = memberDao.selectAll();
	model.addAttribute("members", memberList);//멤버 리스트를 다 주는 것.
	return "list";
	}

}
