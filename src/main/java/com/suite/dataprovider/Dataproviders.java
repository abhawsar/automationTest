/**
 * @author gaurav.wani
 *
 */
package com.suite.dataprovider;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.suite.base.Base;
import com.suite.utility.ExcelLibrary;

/**
 * @author gaurav.wani
 *
 */
public class Dataproviders extends Base {

	ExcelLibrary obj;

	String stagepath = System.getProperty("user.dir") + "/src/test/resources/TestData/TestDataSheet.xlsx";
	String devpath = System.getProperty("user.dir") + "/src/test/resources/TestData/TestDataDevSheet.xlsx";

	String url = prop.getProperty("url");

	@DataProvider(name = "AddUser")
	public Object[][] newUserTestData() {
		// Totals rows count
		if (url.equals("https://euapidevportiwbapp01.azurewebsites.net/home")) {

			obj = new ExcelLibrary(stagepath);

		} else if (url.equals("https://euapidevportdwbapp01.azurewebsites.net/home"))

		{

			obj = new ExcelLibrary(devpath);
		}

		int rows = obj.getRowCount("User"); // Sheet name
		System.out.println("Total No. of Rows:" + rows);
		// Total Columns
		int column = obj.getColumnCount("User");
		int actRows = rows - 1;
		System.out.println("Total No. of Rows:" + actRows);

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("User", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {

		if (url.equals("https://euapidevportiwbapp01.azurewebsites.net/home")) {

			obj = new ExcelLibrary(stagepath);

		} else if (url.equals("https://euapidevportdwbapp01.azurewebsites.net/home"))

		{

			obj = new ExcelLibrary(devpath);
		}

		int rows = obj.getRowCount("Credentials");
		// Total Columns
		int column = obj.getColumnCount("Credentials");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("Credentials", j, i + 2);
			}
		}
		return data;
	}

	// Class --> AccountCreationPage Test Case--> verifyCreateAccountPageTest
	@DataProvider(name = "CreateCompany")
	public Object[][] addEmpDetails() {

		if (url.equals("https://euapidevportiwbapp01.azurewebsites.net/home")) {

			obj = new ExcelLibrary(stagepath);

		} else if (url.equals("https://euapidevportdwbapp01.azurewebsites.net/home"))

		{

			obj = new ExcelLibrary(devpath);
		}

		// Totals rows count
		int rows = obj.getRowCount("createComapny"); // Sheet name
		// Total Columns
		int column = obj.getColumnCount("createComapny");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("createComapny", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "AddApplication")
	public Object[][] addReportsDetails() {
		
		if (url.equals("https://euapidevportiwbapp01.azurewebsites.net/home")) {

			obj = new ExcelLibrary(stagepath);

		} else if (url.equals("https://euapidevportdwbapp01.azurewebsites.net/home")) {

			obj = new ExcelLibrary(devpath);
		}

		// Totals rows count
		int rows = obj.getRowCount("appRegistration"); // Sheet name
		// Total Columns
		int column = obj.getColumnCount("appRegistration");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("appRegistration", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "AddPost")
	public Object[][] newPostTestData() {
		// Totals rows count
		int rows = obj.getRowCount("BuzzPageData"); // Sheet name
		// Total Columns
		int column = obj.getColumnCount("BuzzPageData");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("BuzzPageData", j, i + 2);
			}
		}
		return data;
	}

	// Class -->
	@DataProvider(name = "checkValidations")
	public Object[][] checkValidations() {
		// Totals rows count
		int rows = obj.getRowCount("FieldValidationErrorMsgs");
		// Total Columns
		int column = obj.getColumnCount("FieldValidationErrorMsgs");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("FieldValidationErrorMsgs", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "AssignLeaveDetails")
	public Object[][] getAssignLeaveDetails() {
		// Totals rows count
		int rows = obj.getRowCount("AssignLeave");
		// Total Columns
		int column = obj.getColumnCount("AssignLeave");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("AssignLeave", j, i + 2);
			}
		}
		return data;
	}

	@DataProvider(name = "newAcountDetailsData")
	public Object[][] accountCreation() {

		// Totals rows count
		int rows = obj.getRowCount("AccountCreationData");
		// Total Columns
		int column = obj.getColumnCount("AccountCreationData");
		int actRows = rows - 1;
		// Created an object of array to store data
		Object[][] data = new Object[actRows][1];

		for (int i = 0; i < actRows; i++) {
			Map<String, String> hashMap = new HashMap<String, String>();
			for (int j = 0; j < column; j++) {
				hashMap.put(obj.getCellData("AccountCreationData", j, 1),
						obj.getCellData("AccountCreationData", j, i + 2));
			}
			data[i][0] = hashMap;
		}
		return data;
	}

}
