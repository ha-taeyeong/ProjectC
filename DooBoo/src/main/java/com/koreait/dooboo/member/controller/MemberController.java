package com.koreait.dooboo.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.koreait.dooboo.member.command.JoinCommand;
import com.koreait.dooboo.member.command.LoginCommand;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class MemberController {
	
	private SqlSession sqlSession;
	private JoinCommand joincommand;
	private LoginCommand loginCommand;
	
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
	
	
	
	
	
	
	
}
