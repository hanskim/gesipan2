package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import bean.MemberBean;
import util.DBmanager;
 
 
public class MemberDaoImpl implements commonDAO{
    Connection conn = null;
    PreparedStatement pstmt = null;
    Statement stmt = null;
      // 위 세개는 쿼리는 위해 존재 //
    // 위 자료 구조를 먼저 무조건 선언 //
    // dao는 무조건 Set으로 구현
    ResultSet rs = null;  
    String sql = "";
    // 위 자료구조를 담을 수 있는 객체  선언
    MemberBean bean = new MemberBean();
  // 위 자료구조를 담을 수 있는 객체  선언
    /*
     * 지금 보시는 내용이 싱글톤 + DBCP 정석입니다. 
     다만, 이것만 해서는 단위별 서버 실행에서 
     DB접속이 안됩니다. 그래서
     * DBmanager 를 만들었고 당분간은 DBmanager 를 
     사용하다가 프로젝트가 완성되면 철거하는 방식으로 하겠습니다.
     */
    private static MemberDaoImpl memberDao = new MemberDaoImpl();
 
    private MemberDaoImpl() {
        // 단위 테스트가 끝나고 프로젝트가 완성되면 걷어 낼 부분
        conn = DBmanager.getConnection();
    }
 
    public static MemberDaoImpl getInstance() {
        return memberDao;
    }
 
    // 현재는 작동하지 않지만 위 DBmanager 를 걷어내는 순간
    // 작동함. 미리 설정함.
    // 위 구조는 일종의 생성자 역할  싱글톤 
    
    public Connection getConnection() throws Exception {
        Connection conn = null;
        Context initContext = new InitialContext();
        Context envContext = (Context) initContext.lookup("java:/comp/env");
        DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
        conn = ds.getConnection();
        return conn;
    }
   
    

	@Override
	public int insert(Object obj) {
		int result = 0;
		// dao면 무조건 String sql 먼저 작성하고
		// 두꺼비에서 해당 쿼리가 잘 돌아가면 .... 
		// 여기에다 집어넣고 ?로만 변경할 것.
		// sql문이 insert 또는 ? 가 많다면 
		// 이것을 리터럴 타입으로 변경하려는 데 처리할 정보가 많으면 귀찮으니까
		// pstmt로 대체하여 처리
		// 
		// 
		
        String sql 
            = "insert into member(MEMBERID,PASSWORD,NAME,EMAIL,AGE)"
                +" values( ? , ? , ? , ? , ? )";
        try{
            pstmt = conn.prepareStatement(sql);           
            pstmt.setString(1, bean.getId());
            pstmt.setString(2, bean.getPassword());
            pstmt.setString(3, bean.getName());
            pstmt.setString(4, bean.getEmail());
            pstmt.setString(5, bean.getAge());
            result = pstmt.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
            System.out.println("MemberDAO 에서 에러가 발생 !!");
        }
        return result;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getElementById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> getElementsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> list() {
		List<Object> list = new ArrayList<Object>();
        try {
            stmt = conn.createStatement();
            sql = "select * from member";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                bean.setId(rs.getString("MEMBERID"));
                bean.setAge(rs.getString("AGE"));
                bean.setPassword(rs.getString("PASSWORD"));
                bean.setName(rs.getString("NAME"));
                bean.setEmail(rs.getString("EMAIL"));
 
                list.add(bean);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
 
            try {
                rs.close();
                stmt.close();
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
 
        }
        return list;
	}

	@Override
	public int update(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String id) {
		// TODO Auto-generated method stub
		return 0;
	}
 
   
    
    
}
