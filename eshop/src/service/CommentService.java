package service;

import java.util.Date;
import java.util.List;

import dao.CommentDao;
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
	public List<Comment> readComment(int articleNum){
		return dao.selectCommentList(articleNum);
	}
}
