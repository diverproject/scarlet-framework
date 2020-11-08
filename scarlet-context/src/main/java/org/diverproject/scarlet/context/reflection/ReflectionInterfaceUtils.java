package org.diverproject.scarlet.context.reflection;

import static org.diverproject.scarlet.context.reflection.ReflectionConfig.getReflections;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public final class ReflectionInterfaceUtils {

	private ReflectionInterfaceUtils() { }

	public static <I> Set<Class<?>> getAllImplementationsOf(Class<I> interfaceClass) {
		if (!interfaceClass.isInterface()) {
			throw ReflectionInterfaceExceptionFactory.classIsNotAInterface(interfaceClass);
		}

		return getReflections()
			.getSubTypesOf(interfaceClass)
			.stream()
			.filter(aClass -> !aClass.isInterface())
			.collect(Collectors.toSet());
	}

	public static <I> Optional<Class<?>> getImplementationOf(Class<I> interfaceClass) {
		return getAllImplementationsOf(interfaceClass)
			.stream()
			.max(ReflectionUtils.maxPriorityAnnotation());
	}

}
