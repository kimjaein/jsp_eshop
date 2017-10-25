package service;

import java.util.Date;
import java.util.List;

import dao.BoardDao;
import vo.Article;
import vo.ArticlePage;

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
		article.setWriteDate(new Date());
		article.setReadCount(0);
		article.setArticleNum(0);
		article.setDepth("A");
		
		int result = dao.insert(article);
		if(result==1)
			return true;
		else 
			return false;
	}
	
	public ArticlePage makeArticlePage(int page ,String type){
//		private List<Article> articleList;
//		private int startPage;
//		private int endPage;
//		private int currentPage==page
//		private int totalPage; //DB 게시글 리스드의 개수 뽑아오익
		int startPage =(page/10)*10+1;
		int endPage = startPage+9;
		
		int articleCount = dao.selectArticleCount(type);
		int totalPage = articleCount/COUNT_PER_PAGE;
		if(articleCount % COUNT_PER_PAGE >0 ) {
			totalPage++;
		}
		
		if(endPage > totalPage) {
			endPage=totalPage;
		}
		int startRow=(page-1)*10;
		List<Article> articleList = dao.selectArticleList(startRow,COUNT_PER_PAGE,type);
		
		ArticlePage articlePage = new ArticlePage(articleList, startPage, endPage, page, totalPage);
		
		return articlePage;
	}
	
	public Article read(int articleNum,String loginId) {
		Article article = dao.selectArticle(articleNum);
		
		if(article.getWriter().equals(loginId)) {
			return article;
		}else {
			dao.updateReadCount(articleNum);
			article.setReadCount(article.getReadCount()+1);
			return article;
		}
		
	}
}
