package pl.academy.quiz.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;

import pl.academy.quiz.dto.PageDTO;

public interface ObjectConverter<OBJFROM, OBJTO> {
	OBJTO convert(OBJFROM model);

	default Collection<OBJTO> convert(Collection<OBJFROM> model) {
		Collection<OBJTO> converted = new ArrayList<>();
		model.forEach(m -> converted.add(convert(m)));
		return converted;
	}

	@SuppressWarnings("unchecked")
	default PageDTO<OBJTO> convert(Page<OBJFROM> page) {
		Collection<OBJFROM> content = page.getContent();

		return (PageDTO<OBJTO>) PageDTO.builder()//
				.pageNumber(page.getNumber())//
				.pageSize(page.getNumberOfElements())//
				.sortDirection(page.getSort().iterator().next().getDirection().name())
				.sortBy(page.getSort().iterator().next().getProperty())//
				.result((List<Object>) convert(content))//
				.build();//
	}
}
