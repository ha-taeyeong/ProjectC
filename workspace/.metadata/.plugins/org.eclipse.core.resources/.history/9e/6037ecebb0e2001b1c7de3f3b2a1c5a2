package com.koreait.dooboo.member.command;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.ibatis.session.SqlSession;
import org.springframework.http.HttpRequest;
import org.springframework.ui.Model;

import com.koreait.dooboo.member.dao.MemberDAO;
import com.koreait.dooboo.member.dto.MemberDTO;

public class LoginCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request"); 
		HttpServletResponse response = (HttpServletResponse) map.get("response");
		MemberDTO dto = new MemberDTO();
		dto.setMember_ID(request.getParameter("id"));
		dto.setMember_PW(request.getParameter("pw"));
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		MemberDTO loginUser = memberDAO.login(dto);
		response.setContentType("text/html; charset=utf-8");
			try {
				if(loginUser != null) {
					request.getSession().setAttribute("loginUser",loginUser);
					response.getWriter().println("<script>");
					response.getWriter().println("alert('두부 마켓에 오신것을 환영합니다.')");
					response.getWriter().println("</script>");
				}else {
					response.getWriter().println("<script>");
					response.getWriter().println("alert('등록된 회원이 없습니다.')");
					response.getWriter().println("history.back();");
					response.getWriter().println("</script>");
			} 
		}
			catch (IOException e) {
				
				e.printStackTrace();
			}
		

	}

}
