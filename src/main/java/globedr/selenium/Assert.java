package globedr.selenium;

import com.rest.core.Report;
import globedr.selenium.driver.DriverUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class Assert {

    static private String getLog() {
        return null;
    }

    static public void fail(String message) {
        org.testng.Assert.fail(message);
    }

    static public void assertEquals(String actual, String expected) {
        org.testng.Assert.assertEquals(actual, expected, getLog());
    }

    static public void assertEquals(Object actual, Object expected) {
        org.testng.Assert.assertEquals(actual, expected, getLog());
    }

    static public void assertEquals(String actual, String expected, String message) {
        org.testng.Assert.assertEquals(actual, expected, message);
    }

    static public void assertEquals(int actual, int expected) {
        org.testng.Assert.assertEquals(actual, expected, getLog());
    }

    static public void assertEquals(int actual, int expected, String message) {
        org.testng.Assert.assertEquals(actual, expected, message);
    }


    static public void assertTrue(boolean condition, String message) {
        org.testng.Assert.assertTrue(condition, message);
    }

    static public void assertTrue(boolean condition) {
        org.testng.Assert.assertTrue(condition, getLog());
    }

    static public void assertFalse(boolean condition) {
        org.testng.Assert.assertFalse(condition, getLog());
    }

    static public void assertFalse(boolean condition, String message) {
        org.testng.Assert.assertFalse(condition, message);
    }

    static public void assertNull(Object object) {
        assertNull(object, getLog());
    }

    static public void assertNull(Object object, String message) {
        org.testng.Assert.assertNull(object, message);
    }

    static public void assertEmpty(Object object) {
        assertEmpty(object, getLog());
    }

    static public void assertEmpty(Object object, String message) {

        if (object instanceof List<?>) {
            org.testng.Assert.assertTrue(((List<Object>) object).isEmpty(), message);
        } else {
            org.testng.Assert.assertTrue(((String) object).isEmpty(), message);
        }

    }



}
