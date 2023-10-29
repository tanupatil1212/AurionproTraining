package com.aurionpro.entity;

public class InstructorTechDetail {
	private int id;
	private String youtubeUrl;
	private String gitUrl;

	public InstructorTechDetail(int id, String youtubeUrl, String gitUrl) {
		super();
		this.id = id;
		this.youtubeUrl = youtubeUrl;
		this.gitUrl = gitUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYoutubeUrl() {
		return youtubeUrl;
	}

	public void setYoutubeUrl(String youtubeUrl) {
		this.youtubeUrl = youtubeUrl;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	@Override
	public String toString() {
		return "InstructorTechDetail [id=" + id + ", youtubeUrl=" + youtubeUrl + ", gitUrl=" + gitUrl + "]";
	}

}
