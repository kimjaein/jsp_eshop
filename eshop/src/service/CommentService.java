package service;

import java.util.Date;
import java.util.List;

import dao.CommentDao;
import vo.Article;
import vo.Comment;

public class CommentService {
	CommentDao dao =CommentDao.getInstance();
	
	private static CommentService instance = new CommentService();
	public static CommentService getInstance() {
		return instance;
	}
	
	private CommentService() {
		
	}
	public boolean writeComment(Comment comment) {
    	comment.setWriteTime(new Date());
    	comment.setC_list(0);
    	comment.setC_level("A");
    	
    	int result =  dao.insert(comment);
    	result=dao.insertCList(dao.selectLastId());
    	
    	if(result==1) {
			return true;
		}else {
			return false;
		}
	}
	public List<Comment> readComment(String title){
		return dao.selectCommentList(title);
	}
	
	public boolean setReplyComment(Comment comment) {
		//�θ���� B������ ������ �亯���� ������ ����� ������ ������ ä�� insert
		Comment newComment =comment;
		//list�� ��ӹް�
		//depth ã��
		//������ depth ���� ������ �� ���̺��� �ϳ� �� depth �����ϴ��� ã�� 
		//�����ϸ� �׷��� �������� ex)AAC ->AAD ����
		//�������� ������ A�ٿ��� ����
		String level = dao.ExistNextLevel(comment.getC_list(), comment.getC_level()+"_");
		if(level != null) {
			char c=level.charAt(level.length()-1);
			c=(char)(c+1);
			level=level.substring(0, level.length()-1)+c;
		}else {
			level=comment.getC_level()+"A";
		}
		// ������ ���� ä���
		newComment.setC_level(level);
		newComment.setWriteTime(new Date()); // ������ ���� ä��� 
		int result=0;
		result=dao.insert(newComment);
		
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}
	public Comment setCInfo(Comment comment,int commentNum) {
		String cInfo = dao.selectCInfo(commentNum);
		System.out.println(cInfo +"service");
		String[] ar= cInfo.split("/");
		int c_list= Integer.parseInt(ar[0]);
		String c_level = ar[1];
		comment.setC_list(c_list);
		comment.setC_level(c_level);
		return comment;
	}
}
