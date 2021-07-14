package com.koreait.dooboo.member.dao;

import com.koreait.dooboo.member.dto.MemberDTO;

public interface MemberDAO {
	public void join(MemberDTO memberDTO);
	public MemberDTO login(MemberDTO memberDTO);
	public void update1(MemberDTO memberDTO);
	public void update2(MemberDTO memberDTO);
	public void update3(MemberDTO memberDTO);
	public void update4(MemberDTO memberDTO);
	public int  idCheck(String id);
	public int delete(long no);
	public int changePw(MemberDTO memberDTO);
}
