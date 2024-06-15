package fitness;

import java.util.List;

public interface MemberDAO {
    int insertMember(MemberDTO member);
    int updateMember(MemberDTO member);
    int deleteMember(int no);
    MemberDTO selectMemberByno(int no);
    //List<MemberDTO> selectMemberByName(String name);
    List<MemberDTO> selectMemberAll();
    //MemberDTO selectMemberByphone(String phone);
}