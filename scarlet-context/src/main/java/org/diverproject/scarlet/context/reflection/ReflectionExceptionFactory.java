package org.diverproject.scarlet.context.reflection;

import static org.diverproject.scarlet.util.ScarletUtils.nameOf;

public class ReflectionExceptionFactory {

    public static ReflectionException emptyConstructorException(NoSuchMethodException e, Class<?> classType) {
        return new ReflectionException(ReflectionExceptionError.EMPTY_CONSTRUCTOR_EXCEPTION, nameOf(classType));
    }

    public static ReflectionException failureOnCreateAInstance(Class<?> classType) {
        return new ReflectionException(ReflectionExceptionError.FAILURE_ON_CREATE_A_INSTANCE, nameOf(classType));
    }
}
