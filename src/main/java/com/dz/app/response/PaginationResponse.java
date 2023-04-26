package com.dz.app.response;

import java.util.List;

import com.dz.app.dto.EmployeeDto;

public class PaginationResponse {

	
	Integer pageSize;
	Long totalPages;
	Long totalEmp;
	Integer currentPage;
	Integer nextPage;
	Integer previousPage;
	
	List<EmployeeDto> content;
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Long getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(Long totalPages) {
		this.totalPages = totalPages;
	}
	public Long getTotalEmp() {
		return totalEmp;
	}
	public void setTotalEmp(Long totalEmp) {
		this.totalEmp = totalEmp;
	}
	public Integer getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
	public List<EmployeeDto> getContent() {
		return content;
	}
	public void setContent(List<EmployeeDto> content) {
		this.content = content;
	}
	public Integer getNextPage() {
		return nextPage;
	}
	public void setNextPage(Integer nextPage) {
		this.nextPage = nextPage;
	}
	public Integer getPreviousPage() {
		return previousPage;
	}
	public void setPreviousPage(Integer previousPage) {
		this.previousPage = previousPage;
	}
	
}
