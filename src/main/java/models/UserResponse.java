package models;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



//Ignora atributos JSON que não foram mapeados na página
@JsonIgnoreProperties(ignoreUnknown = true) 

public class UserResponse {
	
	
	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private List<User> data;
	
	public int getPage() {
		return page;
	}
	public int getPer_page() {
		return per_page;
	}
	public int getTotal() {
		return total;
	}
	public int getTotal_pages() {
		return total_pages;
	}
	public List<User> getData() {
		return data;		
	}
	@Override
	public int hashCode() {
		return Objects.hash(data, page, per_page, total, total_pages);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserResponse other = (UserResponse) obj;
		return Objects.equals(data, other.data) && page == other.page && per_page == other.per_page
				&& total == other.total && total_pages == other.total_pages;
	}			
	

}
