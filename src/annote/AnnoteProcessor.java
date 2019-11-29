package annote;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnoteProcessor {

	private AnnoteProcessor() { // Only to be used as a static method collection
	}

	/**
	 * @param process   Functional Interface, zero argument, the 'execution' when a
	 *                  specific Annotation is found on a given Implementing Class's
	 *                  field or method
	 * @param implClass The Class which defines Fields tagged with the given
	 *                  annotation
	 * @param annote    The Annotation to look for in a given Implementing Class
	 */
	public static void processFields(FieldProcess process, Class implClass, Class<? extends Annotation> annote) {
		for (Field field : implClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(annote)) {
				try {
					process.run(field);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void processMethods(MethodProcess process, Class implClass, Class<? extends Annotation> annote) {
		for (Method method : implClass.getDeclaredMethods()) {
			if (method.isAnnotationPresent(annote)) {
				try {
					process.run(method);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

}
