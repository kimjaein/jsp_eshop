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
		result=dao.insertBList(dao.selectLastId());
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
	public Article readArticleInfo(int articleNum) {
		Article article=dao.selectReplyInfo(articleNum);
		return article;
	}
	
	public boolean setReplyArticle(Article article) {
		//부모글의 B정보를 가져와 답변글의 정보로 만들고 나머지 정보를 채워 insert
		Article newArticle = article;
		//list는 상속받고
		//depth 찾기
		//원래의 depth 길이 가져와 그 길이보다 하나 긴 depth 존재하는지 찾기 
		//존재하면 그레벨 다음글자 ex)AAC ->AAD 수정
		//존재하지 않으면 A붙여서 저장
		String level = dao.ExistNextLevel(article.getList(), article.getDepth()+"_");
		if(level != null) {
			char c=level.charAt(level.length()-1);
			c=(char)(c+1);
			level=level.substring(0, level.length()-1)+c;
		}else {
			level=article.getDepth()+"A";
		}
		// 나머지 정보 채우기
		newArticle.setDepth(level);
		newArticle.setReadCount(0);
		newArticle.setWriteDate(new Date()); // 나머지 정보 채우고 
		int result=0;
		result=dao.insert(newArticle);
		
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}
}
