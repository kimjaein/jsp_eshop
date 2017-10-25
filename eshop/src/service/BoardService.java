package service;

import java.util.Date;
import java.util.List;

import dao.BoardDao;
import vo.Article;
import vo.ArticlePage;

public class BoardService {
	private static final int COUNT_PER_PAGE=10; // �Խ��ǿ��� �ѹ��� ������ ������ ����
	
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
//		private int totalPage; //DB �Խñ� �������� ���� �̾ƿ���
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
		//�θ���� B������ ������ �亯���� ������ ����� ������ ������ ä�� insert
		Article newArticle = article;
		//list�� ��ӹް�
		//depth ã��
		//������ depth ���� ������ �� ���̺��� �ϳ� �� depth �����ϴ��� ã�� 
		//�����ϸ� �׷��� �������� ex)AAC ->AAD ����
		//�������� ������ A�ٿ��� ����
		String level = dao.ExistNextLevel(article.getList(), article.getDepth()+"_");
		if(level != null) {
			char c=level.charAt(level.length()-1);
			c=(char)(c+1);
			level=level.substring(0, level.length()-1)+c;
		}else {
			level=article.getDepth()+"A";
		}
		// ������ ���� ä���
		newArticle.setDepth(level);
		newArticle.setReadCount(0);
		newArticle.setWriteDate(new Date()); // ������ ���� ä��� 
		int result=0;
		result=dao.insert(newArticle);
		
		if(result==1) {
			return true;
		}else {
			return false;
		}
	}
}
