package application;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class GetMethodsOfAClass {

	public static void main(String[] args)  {
		Class<?> serviceOne = MyServiceOne.class;
		Method[] methods = serviceOne.getDeclaredMethods();
		for (Method method : methods) {
			System.out.println(method.getName());
		}
	}
}
