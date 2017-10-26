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
		//부모글의 B정보를 가져와 답변글의 정보로 만들고 나머지 정보를 채워 insert
		Comment newComment =comment;
		//list는 상속받고
		//depth 찾기
		//원래의 depth 길이 가져와 그 길이보다 하나 긴 depth 존재하는지 찾기 
		//존재하면 그레벨 다음글자 ex)AAC ->AAD 수정
		//존재하지 않으면 A붙여서 저장
		String level = dao.ExistNextLevel(comment.getC_list(), comment.getC_level()+"_");
		if(level != null) {
			char c=level.charAt(level.length()-1);
			c=(char)(c+1);
			level=level.substring(0, level.length()-1)+c;
		}else {
			level=comment.getC_level()+"A";
		}
		// 나머지 정보 채우기
		newComment.setC_level(level);
		newComment.setWriteTime(new Date()); // 나머지 정보 채우고 
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
