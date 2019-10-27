package next.model;

import java.util.Date;

public class Answer {
	private long answerId;
	private String writer;
	private String contents;
	private Date createdDate;
	private long questionId;
	
	public Answer(String writer, String contents, long questionId) {
		this(0, writer, contents, new Date(), questionId);
	}
	
	public Answer(long answerId, String writer, String contents, Date createdDate, long questionId) {
		this.answerId = answerId;
		this.writer = writer;
		this.contents = contents;
		this.createdDate = createdDate;
		this.questionId = questionId;
	}
	
	public long getAnswerId() {
		return this.answerId;
	}
	
	public String getWriter() {
		return this.writer;
	}
	
	public String getContents() {
		return this.contents;
	}
	
	public Date getCreatedDate() {
		return this.createdDate;
	}
	
	public long getTimeFromCreatedDate() {
		return this.createdDate.getTime();
	}
	
	public long getQuestionId() {
		return questionId;
	}
}
