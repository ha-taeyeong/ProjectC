package com.koreait.dooboo.member.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.koreait.dooboo.member.command.ChangePwCommand;
import com.koreait.dooboo.member.command.DeleteCommand;
import com.koreait.dooboo.member.command.EmailCommand;
import com.koreait.dooboo.member.command.IdCheckCommand;
import com.koreait.dooboo.member.command.JoinCommand;
import com.koreait.dooboo.member.command.LoginCommand;
import com.koreait.dooboo.member.command.PwCheckCommand;
import com.koreait.dooboo.member.command.UpdateCommand;
import com.koreait.dooboo.member.command.UpdateCommand2;
import com.koreait.dooboo.member.command.UpdateCommand3;
import com.koreait.dooboo.member.command.UpdateCommand4;
import com.koreait.dooboo.member.dto.MemberDTO;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class MemberController {
	
	private SqlSession sqlSession;
	private JoinCommand joincommand;
	private LoginCommand loginCommand;
	private UpdateCommand updateCommand;
	private UpdateCommand2 updateCommand2;
	private UpdateCommand3 updateCommand3;
	private UpdateCommand4 updateCommand4;
	private DeleteCommand deleteCommand;
	private IdCheckCommand idCheckCommand;
	private PwCheckCommand pwCheckCommand;
	private EmailCommand emailCommmand;
	private ChangePwCommand changePwCommand;
	
	@GetMapping(value="/")
	public String index(){
		return "index";
	}
	
	@GetMapping(value="m.joinPage")
	public String joinPage() {
		return "member/join";
	}
	
	@PostMapping(value="m.login")
	public String login(HttpServletRequest request, Model model
						,HttpServletResponse response) {
		model.addAttribute("request",request);
		model.addAttribute("response",response);
		loginCommand.execute(sqlSession, model);
		return "";
	}
	
	@PostMapping(value="m.join")
	public String join(HttpServletRequest request,Model model) {
		model.addAttribute("request",request);
		joincommand.execute(sqlSession, model);
		return "";
	}
	@GetMapping(value="m.logout")
	public String logOut(HttpSession session,
						 Model model) {
		model.addAttribute("session",session);
		return "redirect:index";
	}
	
	@PostMapping(value="m.update")
	public String update1(HttpServletRequest request,
						  Model model) {
		model.addAttribute("request",request);
		updateCommand.execute(sqlSession, model);
		return "member/myPage";
	}
	@PostMapping(value="m.update2")
	public String update2(HttpServletRequest request,
						  Model model) {
		model.addAttribute("request",request);
		updateCommand2.execute(sqlSession, model);
		return "member/myPage";
	}
	@PostMapping(value="m.update3")
	public String update3(HttpServletRequest request,
						  Model model) {
		model.addAttribute("request",request);
		updateCommand3.execute(sqlSession, model);
		return "member/myPage";
	}
	@PostMapping(value="m.update4")
	public String update4(HttpServletRequest request,
						  Model model) {
		model.addAttribute("request",request);
		updateCommand4.execute(sqlSession, model);
		return "member/myPage";
	}
	
	@GetMapping(value="m.leave.do")
	public String leave(HttpSession session,
						Model model) {
		model.addAttribute("session",session);
		deleteCommand.execute(sqlSession, model);
		return "redirect:/";
	}
	
	
	@GetMapping(value="m.idCheck",
				produces="application/json; charset=utf-8")
	@ResponseBody
	public Map<String, Integer> idCheck(HttpServletRequest request,
										Model model) {
		model.addAttribute("request", request);
		return idCheckCommand.execute(sqlSession, model);
	}
	
	@PostMapping(value="m.presentPwCheck",
				produces="application/json; charset=utf-8")
	@ResponseBody
	
	public Map<String,Boolean> presentPwCheck(@RequestBody MemberDTO member,
												HttpSession session,
												Model model){
		model.addAttribute("session",session);
		model.addAttribute("member",member);
		return pwCheckCommand.execute(sqlSession,model);
	}
	
	@GetMapping(value="m.verifyNum",
				produces="application/json; charset=utf-8")
	@ResponseBody 
	public Map<String, String> verifyNum(HttpServletRequest request,
										  Model model) {		
		model.addAttribute("request",request);
		return emailCommmand.execute(sqlSession, model);
	}
	
	@PostMapping(value="m.changePw")
	public String changePw(HttpServletRequest request,
							Model model) {	
		model.addAttribute("request",request);
		changePwCommand.execute(sqlSession, model);
		return "member/myPage";
	}
	
	
	
	
	
	
}
