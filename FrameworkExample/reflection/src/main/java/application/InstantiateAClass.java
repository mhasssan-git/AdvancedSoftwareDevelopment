package application;

import java.lang.reflect.InvocationTargetException;

public class InstantiateAClass {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
		Class<?> serviceOneClass = MyServiceOne.class;
		MyServiceOne serviceOneObject = (MyServiceOne) serviceOneClass.getDeclaredConstructor().newInstance();
		serviceOneObject.print();
	}
}
