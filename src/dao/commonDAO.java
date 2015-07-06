package dao;

import java.util.List;

public interface commonDAO {
	
	 //�߰� create//	
	public int insert(Object obj);
	
	//����� ����, where���� ���� ������ �Ķ���� �ʿ����.//
	public int count();
	
	//id�� �ߺ��� ���� ����//
	public Object getElementById(String id);
	
	//Name���� �ߺ��� ���� ����//
	public List<Object> getElementsByName(String name);
	
	//��ü ��� ��� , where���� ���� ������ �Ķ���� �ʿ����.//
	public List<Object> list();
	
	//���� //
	public int update(Object obj);
	
	//���� //
	public int delete(String id);

}
