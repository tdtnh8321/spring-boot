package com.example.demo.dto;

import java.util.List;

public class AbstractDTO <T>{
	List<T> listResult;
	Long id;
	public List<T> getListResult() {
		return listResult;
	}
	public void setListResult(List<T> listResult) {
		this.listResult = listResult;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
