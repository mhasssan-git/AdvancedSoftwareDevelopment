package application;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetAnnotatedMethodsOfAClass {

	public static void main(String[] args)  {
		Reflections reflections = new Reflections("");
		Class<?> serviceOne = MyServiceOne.class;
		Method[] methods = serviceOne.getDeclaredMethods();
		for (Method method : methods) {
			if (method.isAnnotationPresent(Print.class)) {
				System.out.println(method.getName());
			}
		}
	}
}
