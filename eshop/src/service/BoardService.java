package service;

import java.util.Date;

import dao.BoardDao;
import vo.Article;

public class BoardService {
	private static final int COUNT_PER_PAGE=10; // 게시판에서 한번에 보여질 페이지 개수
	
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
	
	public List<Article> makeArticleList(int page){
		
	}
}
