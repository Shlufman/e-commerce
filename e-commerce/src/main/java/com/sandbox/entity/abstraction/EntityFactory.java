package com.sandbox.entity.abstraction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sandbox.repository.abstraction.IUniversalRepo;

@Component
public class EntityFactory {
	@SuppressWarnings("rawtypes")
	private static Map<Class, IUniversalRepo> repositoryMapByClass;

	
	@SuppressWarnings("rawtypes")
	private EntityFactory(@Autowired List<IUniversalRepo> universalRepositories) {
		repositoryMapByClass = universalRepositories.stream()
				.collect(Collectors.toUnmodifiableMap(IUniversalRepo::getTypeClass, Function.identity()));
	}

	@SuppressWarnings("unchecked")
	public <T> IUniversalRepo<T> getRepository(Class<?> classE) {
		return Optional.ofNullable(repositoryMapByClass.get(classE)).orElseThrow(IllegalArgumentException::new);
	}
}
