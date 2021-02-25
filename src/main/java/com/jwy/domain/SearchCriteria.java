package com.jwy.domain;

public class SearchCriteria {
	private String searchType;  // 검색종류
	private String searchWord;  // 검색어
	
	public String getSearchType() {
		return searchType;
	}
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	@Override
	public String toString() {
		return "SearchCriteria [searchType=" + searchType + ", searchWord=" + searchWord + "]";
	}
	
}
