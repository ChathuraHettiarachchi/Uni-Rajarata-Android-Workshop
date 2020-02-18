package com.choota.splash.services.api.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class PopularMoviesResponse implements Serializable {

	@SerializedName("page")
	private int page;

	@SerializedName("total_results")
	private int totalResults;

	@SerializedName("total_pages")
	private int totalPages;

	@SerializedName("results")
	private List<PopularMovie> results;

	public void setPage(int page){
		this.page = page;
	}

	public int getPage(){
		return page;
	}

	public void setTotalResults(int totalResults){
		this.totalResults = totalResults;
	}

	public int getTotalResults(){
		return totalResults;
	}

	public void setTotalPages(int totalPages){
		this.totalPages = totalPages;
	}

	public int getTotalPages(){
		return totalPages;
	}

	public void setResults(List<PopularMovie> results){
		this.results = results;
	}

	public List<PopularMovie> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"PopularMoviesResponse{" +
			"page = '" + page + '\'' + 
			",total_results = '" + totalResults + '\'' + 
			",total_pages = '" + totalPages + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}