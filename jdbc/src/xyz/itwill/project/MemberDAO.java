package xyz.itwill.project;

import java.util.List;

public interface MemberDAO {//동일한 메소드 작성 규칙 제공하기 위한 인터페이스
	int insertMember(MemberDTO member);
	int updateMember(MemberDTO member);
	//int deleteMember(int no);
	MemberDTO selectMemberByno(int no);
	List<MemberDTO> selectMemberByName(String name);
	List<MemberDTO> selectMemberAll();
}
