package com.ims.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class IMSRegexTest {

    Pattern emailPattern;
    Matcher matcher;

    @Before
    public void before() {
        emailPattern = Pattern.compile(IMSRegex.EMAIL_REGEX);
    }

    @Test
    public void emailMatchNormal() {

        matcher = emailPattern.matcher("test_name@company-name.com");
        assertTrue(matcher.matches());
        matcher = emailPattern.matcher("test-name@company_name.com");
        assertTrue(matcher.matches());
        matcher = emailPattern.matcher("test.name@company-name.com");
        assertTrue(matcher.matches());
        matcher = emailPattern.matcher("test.middle.name@company_name.com");
        assertTrue(matcher.matches());
        matcher = emailPattern.matcher("test-many_different.names@company-name.com");
        assertTrue(matcher.matches());

        matcher = emailPattern.matcher("test@company-name.com");
        assertTrue(matcher.matches());
        matcher = emailPattern.matcher("test@company_name.com");
        assertTrue(matcher.matches());

        matcher = emailPattern.matcher("test@company-name.co.uk");
        assertTrue(matcher.matches());
        matcher = emailPattern.matcher("test@company-name.uk");
        assertTrue(matcher.matches());

    }

}
