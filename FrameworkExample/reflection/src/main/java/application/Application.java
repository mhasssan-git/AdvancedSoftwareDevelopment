package application;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Application {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Reflections reflections = new Reflections("");
		// find and instantiate all classes annotated with the @TestClass annotation
		Set<Class<?>> serviceClasses = reflections.getTypesAnnotatedWith(Service.class);
		for (Class<?> serviceClass : serviceClasses) {
			Object object = serviceClass.getDeclaredConstructor().newInstance();
			System.out.println(serviceClass.getName());
			for (Field field : serviceClass.getDeclaredFields()){
				System.out.println("-------------------"+field.getName()+" "+field.getType());
			}

			for (Method method : serviceClass.getDeclaredMethods()){
				System.out.println("***************"+method.getName());
			}
		}
	}

}
