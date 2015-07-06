package service;

import java.util.List;

import bean.MemberBean;

public interface MemberService {
	
	 /* C.(=insert) 회원가입*/
    public int join(MemberBean bean);
   
    /*count 회원수*/
    public int count();
    
    /*getElementById 회원 상세정보*/
    public MemberBean memberDetail(String id);
    
    /*getElementsByName (이름)을 검색어로 검색*/
    public List<Object> searchByKeyword(String keyword);
    
    /*List  회원 전체 목록 */
    public List<Object> memberList();
    
    /*회원정보수정 */
    public int updateMember(MemberBean ban);
    
    /*회원탈퇴 */   
    public int deleteMember(String id);

    /*로그인 */   
    public String login(String id, String password); 

}
