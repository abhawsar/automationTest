/**
 * @author gaurav.wani
 *
 */
package com.suite.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

/**
 * @author gaurav.wani
 * 
 * This method will be invoked by TestNG to give you a chance to modify a TestNG annotation read
   * from your test classes. You can change the values you need by calling any of the setters on the
   * ITest interface.
   *
   * <p>Note that only one of the three parameters testClass, testConstructor and testMethod will be
   * non-null.
   *
   * @param annotation The annotation that was read from your test class.
   *
 */
public class TestRetryAnalyzerListner implements IAnnotationTransformer{

	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

		annotation.setRetryAnalyzer(TestRetryAnalyzer.class);
	}

}
