/**
 * @author gaurav.wani
 *
 */
package com.suite.utility;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

/**
 * @author gaurav.wani
 * To implement to be able to have a chance to retry a failed test.
 */
public class TestRetryAnalyzer implements IRetryAnalyzer{
	
	int counter = 1;
	int retryMaxLimit = 2;

	public boolean retry(ITestResult result) {
		if(counter<retryMaxLimit) {
			counter++;
			return true;
		}
		return false;
	}

}
