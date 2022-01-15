package com.cananarslan.queapplication.requests;

public class CommentCreateRequest {
	Long id;
	Long userId;
	Long postId;
	String Text;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	public Long getPostId() {
		return postId;
	}
	
	public void setPostId(Long postId) {
		this.postId = postId;
	}
	
	public String getText() {
		return Text;
	}
	
	public void setText(String text) {
		Text = text;
	}
	
}
