package service;

import java.util.List;

import bean.MemberBean;

public interface MemberService {
	
	 /* C.(=insert) ȸ������*/
    public int join(MemberBean bean);
   
    /*count ȸ����*/
    public int count();
    
    /*getElementById ȸ�� ������*/
    public MemberBean memberDetail(String id);
    
    /*getElementsByName (�̸�)�� �˻���� �˻�*/
    public List<Object> searchByKeyword(String keyword);
    
    /*List  ȸ�� ��ü ��� */
    public List<Object> memberList();
    
    /*ȸ���������� */
    public int updateMember(MemberBean ban);
    
    /*ȸ��Ż�� */   
    public int deleteMember(String id);

    /*�α��� */   
    public String login(String id, String password); 

}
