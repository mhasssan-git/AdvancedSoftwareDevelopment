package application;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GetAnnotationParameter {

	public static void main(String[] args)  {
		Class<?> serviceOneClass = MyServiceOne.class;
		Annotation[] annotations=serviceOneClass.getAnnotations();
		for (Annotation annotation : annotations){
			System.out.println("Class with name "+serviceOneClass.getName()+" has annotation: "+annotation);
			System.out.println("This annotation: "+annotation+" has a 'name' parameter with value: "+((Service)annotation).name());
		}
	}
}
