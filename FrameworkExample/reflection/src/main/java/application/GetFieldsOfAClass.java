package application;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetFieldsOfAClass {

	public static void main(String[] args)  {
		Class<?> serviceOne = MyServiceOne.class;
		Field[] fields = serviceOne.getDeclaredFields();
		for (Field field : fields) {
			System.out.println(field.getName());
		}
	}
}
