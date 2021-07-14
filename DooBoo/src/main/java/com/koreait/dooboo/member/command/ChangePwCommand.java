package com.koreait.dooboo.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;

import com.koreait.dooboo.member.dao.MemberDAO;
import com.koreait.dooboo.member.dto.MemberDTO;
import com.koreait.dooboo.member.util.SecurityUtils;

public class ChangePwCommand implements MemberCommand {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest)map.get("request");
		
		String pw =request.getParameter("pw");
		long no = Long.parseLong(request.getParameter("no"));
		
		MemberDTO member = new MemberDTO();
		member.setMember_PW(SecurityUtils.encodeBase64(pw));
		member.setMember_NO(no);
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		int count = memberDAO.changePw(member);
		
		if(count > 0 ) {
			HttpSession session = request.getSession();
			MemberDTO loginUser = (MemberDTO) session.getAttribute("loginUser");
			if(loginUser != null) {
				loginUser.setMember_PW(SecurityUtils.encodeBase64(pw));
			}
 		}

	}

}
