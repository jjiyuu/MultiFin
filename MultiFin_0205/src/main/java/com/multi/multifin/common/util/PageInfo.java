package com.multi.multifin.common.util;


import lombok.Getter;

@Getter
public class PageInfo {
	private int currentPage;
	private int pageLimit;
	private int listCount;
	private int listLimit;	
	
	public PageInfo(int currentPage, int pageLimit, int listCount, int listLimit) {
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.listCount = listCount;
		this.listLimit = listLimit;
	}
	
	/* @return 전체 페이지 중 가장 마지막 페이지*/
	public int getMaxPage() {
		return (int)Math.ceil((double)this.listCount / this.listLimit);
	}
	
	/* @return 페이징 된 페이지 중 시작 페이지 */
	public int getStartPage() {
		return (this.pageLimit * ((this.currentPage - 1) / this.pageLimit)) + 1;
	}

	/* @return 페이징 된 페이지 중 마지막 페이지*/ 
	public int getEndPage() {
		int endPage = getStartPage() + this.pageLimit - 1;
		return endPage > getMaxPage() ? getMaxPage() : endPage;
	}	
	

	/*@return 이전 페이지*/ 
	public int getPrevPage() {
		int prevPage = this.getCurrentPage() - 1;
		return prevPage < 1 ? 1 : prevPage;
	}
	
	/* @return 다음 페이지*/ 
	public int getNextPage() {
		int nextPage = this.getCurrentPage() + 1;
		return nextPage > getMaxPage() ? getMaxPage() : nextPage;
	}
	
	/* @return 페이지의 시작 리스트 */ 	
	public int getStartList() {
		return (this.getCurrentPage() - 1) * this.listLimit + 1;
	}
	
	/* @return 페이지의 마지막 리스트 */ 	
	public int getEndList() {
		int endList = this.getStartList() + this.listLimit - 1;
		
		return endList > this.listCount ? this.listCount : endList;
	}
}
