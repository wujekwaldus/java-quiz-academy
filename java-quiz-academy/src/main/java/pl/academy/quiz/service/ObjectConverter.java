package pl.academy.quiz.service;

import java.util.ArrayList;
import java.util.Collection;

public interface ObjectConverter<OBJFROM, OBJTO> {
	OBJTO convert(OBJFROM model);

	default Collection<OBJTO> convert(Collection<OBJFROM> model) {
		Collection<OBJTO> converted = new ArrayList<>();
		model.forEach(m -> converted.add(convert(m)));
		return converted;
	}
}
