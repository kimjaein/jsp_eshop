package vo;

import java.util.Date;

public class Comment {
//	create table comment(
//			comment_num int auto_increment primary key,
//			article_num int not null,
//			writer varchar(20) not null,
//			write_time datetime not null,
//			contents text,
//			c_list int not null,
//			c_level varchar(100) not null,
//			foreign key(article_num) references board_list(article_num)
//		);
	private int commentNum;
	private int articleNum;
	private String writer;
	private Date writeTime;
	private String contents;
	private int c_list;
	private String c_level;
	
	public int getCommentNum() {
		return commentNum;
	}
	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public int getC_list() {
		return c_list;
	}
	public void setC_list(int c_list) {
		this.c_list = c_list;
	}
	
	public String getC_level() {
		return c_level;
	}
	public void setC_level(String c_level) {
		this.c_level = c_level;
	}
	public Comment(int commentNum, int articleNum, String writer, Date writeTime, String contents, int c_list,
			String c_level) {
		this.commentNum = commentNum;
		this.articleNum = articleNum;
		this.writer = writer;
		this.writeTime = writeTime;
		this.contents = contents;
		this.c_list = c_list;
		this.c_level = c_level;
	}
	
	
	
	public Comment() {
	}
	
	@Override
	public String toString() {
		return "CommentVO [commentNum=" + commentNum + ", articleNum=" + articleNum + ", writer=" + writer
				+ ", writeTime=" + writeTime + ", contents=" + contents + ", c_list=" + c_list + ", c_level=" + c_level
				+ "]";
	}
	
	
	
	
}
