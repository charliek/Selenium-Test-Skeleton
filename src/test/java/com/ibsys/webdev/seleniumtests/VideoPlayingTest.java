package com.ibsys.webdev.seleniumtests;

import org.apache.commons.io.IOUtils;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import com.thoughtworks.selenium.DefaultSelenium;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;


/**
 * Load up the home page, click on the first video. Load that page and make sure
 * the video is playing within 15 seconds.
 */
public class VideoPlayingTest {

    static public String resourceAsString(String resource) throws IOException {
        InputStream is = VideoPlayingTest.class.getClassLoader().getResourceAsStream(resource);
        StringWriter sw = new StringWriter();
        IOUtils.copy(is, sw);
        return sw.toString();
    }

    private DefaultSelenium selenium;

    @BeforeClass
    public void setUp() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.wesh.com/");
        selenium.start();
    }

    @Test
    public void testVideoPlaying() throws Exception {
        selenium.open("/index.html");
        assertTrue(selenium.isTextPresent("As Seen On WESH"));
        selenium.click("playBtn80");
        selenium.waitForPageToLoad("30000");
        selenium.runScript(resourceAsString("com/ibsys/webdev/seleniumtests/testVideoPlaying.js"));
        selenium.waitForCondition("selenium.browserbot.getCurrentWindow().IBSYS.testing.selenium.videoPlaying === true;", "15000");
    }

    @AfterClass
    public void tearDown() {
        selenium.stop();
    }
}
