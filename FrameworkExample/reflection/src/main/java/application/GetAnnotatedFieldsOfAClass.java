package application;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class GetAnnotatedFieldsOfAClass {

	public static void main(String[] args)  {
		Class<?> serviceOne = MyServiceOne.class;
		Field[] fields = serviceOne.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(Inject.class)) {
				System.out.println(field.getName());
			}
		}
	}
}
