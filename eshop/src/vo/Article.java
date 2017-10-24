package vo;

import java.util.Date;

public class Article {
	private int articleNum;
	private String boardName;
	private String title;
	private String writer;
	private int readCount;
	private Date writeTime;
	private String contents;
	private int list;
	private String depth;
//	ARTICLE_NUM
//	BOARD_NAME
//	TITLE
//	WRITER
//	READ_COUNT
//	WRITE_DATE
//	CONTENTS
//	LIST
//	DEPTH
	
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getBoardName() {
		return boardName;
	}
	public void setBoardName(String boardName) {
		this.boardName = boardName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getReadCount() {
		return readCount;
	}
	public void setReadCount(int readCount) {
		this.readCount = readCount;
	}
	public Date getWriteTime() {
		return writeTime;
	}
	public void setWriteTime(Date writeTime) {
		this.writeTime = writeTime;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public int getList() {
		return list;
	}
	public void setList(int list) {
		this.list = list;
	}
	public String getDepth() {
		return depth;
	}
	public void setDepth(String depth) {
		this.depth = depth;
	}
	
	public Article(int articleNum, String boardName, String title, String writer, int readCount, Date writeTime,
			String contents, int list, String depth) {
		this.articleNum = articleNum;
		this.boardName = boardName;
		this.title = title;
		this.writer = writer;
		this.readCount = readCount;
		this.writeTime = writeTime;
		this.contents = contents;
		this.list = list;
		this.depth = depth;
	}
	
	
	public Article() {
	}
	
	@Override
	public String toString() {
		return "Article [articleNum=" + articleNum + ", boardName=" + boardName + ", title=" + title + ", writer="
				+ writer + ", readCount=" + readCount + ", writeTime=" + writeTime + ", contents=" + contents
				+ ", list=" + list + ", depth=" + depth + "]";
	}
	
	
	
	

}
