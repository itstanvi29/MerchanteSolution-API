package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.annotations.BeforeSuite;

/**
 * @author tanvig
 * 
 *         TestBase class to load properties file
 * 
 */
public class TestBase {

	public static Properties propconfig = new Properties();
	public static Properties propData = new Properties();
	public static FileInputStream file;

	@BeforeSuite(alwaysRun = true)
	public void initialSetUp() {

		try {

			file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\resources\\config.properties");

			propconfig.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

		try {
			file = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\qa\\resources\\postData.properties");

			propData.load(file);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
