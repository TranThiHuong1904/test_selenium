package tests;

import core.BaseTest_Chrome;
import org.testng.annotations.Test;
import pages.Step;

public class RunProject_Chrome extends BaseTest_Chrome {
    Step step;

    @Test(priority = 1)
    public void testCase1() throws Exception {
        step = new Step(driver);
        step.gotToUrl();
        step.login();
        step.clickElement(step.signIn_Button);
        step.verifyText(step.text_hi_demo, "Hi, Demo Welcome Back");
    }

    @Test(priority = 2)
    public void testCase2() throws Exception {
        step = new Step(driver);
        step.gotToUrl();
        step.login();
        step.clickElement(step.radio_buttton_remember);
        step.isenable(step.radio_buttton_remember);
    }
}
