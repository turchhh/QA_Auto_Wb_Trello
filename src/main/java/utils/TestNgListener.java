package utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.*;

public class TestNgListener implements ITestNGListener, ITestListener {
    Logger logger = LoggerFactory.getLogger(TestNgListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);
        logger.info(result.getTestClass() + " start test --> " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);
        logger.info(result.getTestName() + " test success --> " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);
        logger.info(result.getTestClass() +" test failed --> "+ result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);
        logger.info(result.getTestName()+" test skipped -->");
    }


    @Override
    public void onStart(ITestContext context) {
        ITestListener.super.onStart(context);
        logger.info("start "+ context.getStartDate());
        logger.info("start testing "+ context.getAllTestMethods());
    }

    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);
        logger.info("stop testing "+ context.getEndDate());
    }
}