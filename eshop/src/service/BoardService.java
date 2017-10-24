package service;

import java.util.Date;

import dao.BoardDao;
import vo.Article;

public class BoardService {
	private BoardDao dao =BoardDao.getInstance(); 
	private static BoardService instance= new BoardService();
	public static BoardService getInstance() {
		return instance;
	}
	private BoardService(){
		
	}
	
	public boolean writeArticle(Article article) {
		article.setWriteTime(new Date());
		article.setReadCount(0);
		article.setArticleNum(0);
		article.setDepth("A");
		
		int result = dao.insert(article);
		if(result==1)
			return true;
		else 
			return false;
	}
}
