package application;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class GetClassesWithAnnotation {

	public static void main(String[] args)  {
		Reflections reflections = new Reflections("");
		Set<Class<?>> serviceClasses = reflections.getTypesAnnotatedWith(Service.class);
		for (Class<?> serviceClass : serviceClasses) {
			System.out.println(serviceClass.getName());
		}
	}
}
