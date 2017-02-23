package pl.academy.quiz.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PageDTO<OBJ> {
	private String lastSortBy;
	private String sortBy;
	private String sortDirection;
	private int pageSize;
	private int pageNumber;
	private long totalElements;
	private int totalPages;
	
	private List<OBJ> result;
}
