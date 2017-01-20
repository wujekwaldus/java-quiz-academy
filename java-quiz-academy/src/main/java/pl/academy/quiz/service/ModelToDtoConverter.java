package pl.academy.quiz.service;

import java.util.ArrayList;
import java.util.Collection;

public interface ModelToDtoConverter<MODEL, DTO> {
	DTO convert(MODEL model);

	default Collection<DTO> convert(Collection<MODEL> model) {
		Collection<DTO> converted = new ArrayList<>();
		model.forEach(m -> converted.add(convert(m)));
		return converted;
	}
}
