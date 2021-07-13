package com.koreait.dooboo.member.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.ui.Model;
import org.springframework.web.client.HttpServerErrorException;

import com.koreait.dooboo.member.dao.MemberDAO;
import com.koreait.dooboo.member.dto.MemberDTO;
import com.koreait.dooboo.member.util.SecurityUtils;
import com.mchange.util.Base64Encoder;

public class JoinCommand implements MemberCommand  {

	@Override
	public void execute(SqlSession sqlSession, Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MemberDTO dto = new MemberDTO();
		dto.setMember_ID(request.getParameter("id"));
		dto.setMember_PW(SecurityUtils.encodeBase64(request.getParameter("pw")));
		dto.setMember_BIRTHDAY(request.getParameter("bir_dd"));
		dto.setMember_CITY(request.getParameter("city"));
		dto.setMember_REGION(request.getParameter("region"));
		dto.setMember_LOCATION(request.getParameter("location"));
		dto.setMember_EMAIL(request.getParameter("email"));
		dto.setMember_GENDER(request.getParameter("gender"));
		dto.setMember_NAME(SecurityUtils.encodeBase64(request.getParameter("name")));
		dto.setMember_NICKNAME(request.getParameter("nickName"));
		dto.setMember_PHONE(request.getParameter("phone"));
		
		MemberDAO memberDAO = sqlSession.getMapper(MemberDAO.class);
		memberDAO.join(dto);
		
	}
	
}
