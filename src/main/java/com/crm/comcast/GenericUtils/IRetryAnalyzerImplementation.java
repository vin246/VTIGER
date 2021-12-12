package com.crm.comcast.GenericUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
/***
 * 
 * @author Vinay_Dasari
 *
 */
public class IRetryAnalyzerImplementation implements IRetryAnalyzer{
	int count=0;
	int retryCount=4;
	public boolean retry(ITestResult result) {
		while(count<retryCount) {
			count++;
			return true;
		}
		return false;
	}
}
