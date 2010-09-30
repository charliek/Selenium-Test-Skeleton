package com.ibsys.webdev.selemiumtests;

import com.thoughtworks.selenium.DefaultSelenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


/**
 * Unit test for simple App.
 */
public class AppTest {

    private DefaultSelenium selenium;

    @BeforeClass
    public void setUp() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.clickondetroit.com/");
        selenium.start();
    }

    @Test
    public void testForNews() {
        selenium.open("/index.html");
	assertTrue(selenium.isTextPresent("More News"));
    }

    @AfterClass
    public void tearDown() {
        selenium.stop();
    }
}
