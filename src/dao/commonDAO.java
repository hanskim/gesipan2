package dao;

import java.util.List;

public interface commonDAO {
	
	 //추가 create//	
	public int insert(Object obj);
	
	//요소의 갯수, where절이 없기 때문에 파라미터 필요없다.//
	public int count();
	
	//id로 중복값 없이 축출//
	public Object getElementById(String id);
	
	//Name으로 중복값 없이 축출//
	public List<Object> getElementsByName(String name);
	
	//전체 목록 출력 , where절이 없기 때문에 파라미터 필요없다.//
	public List<Object> list();
	
	//수정 //
	public int update(Object obj);
	
	//삭제 //
	public int delete(String id);

}
