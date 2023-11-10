
import internal.GlobalVariable;
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint;
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase;
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData;
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject;
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject;

import com.kms.katalon.core.annotation.Keyword;
import com.kms.katalon.core.checkpoint.Checkpoint;
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords;
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords;
import com.kms.katalon.core.model.FailureHandling;
import com.kms.katalon.core.testcase.TestCase;
import com.kms.katalon.core.testdata.TestData;
import com.kms.katalon.core.testobject.TestObject;
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords;
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords;
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
//@RunWith(ExtendedCucumber.class)
@CucumberOptions(features = "Include/features/", glue = "",
plugin = {"pretty","html:Reports/cucumber-html-report",
		"junit:Reports/cucumber-junit-report/allcukes.xml",
		"json:Reports/cucumber-report.json",
		"json:Reports/cucumber.json",
		"usage:Reports/cucumber-usage.json"},
        tags= {"@DTC_VCI_AUDI_portal_QUICK_Regression"})
//@DTC_VCI_portal_QUICK_Regression,
//@DTC_Vroom_portal_QUICK_Regression, @DTC_VCI_volkswagen_portal_QUICK_Regression,@DTC_VCI_AUDI_portal_QUICK_Regression,@DTC_Nissan_portal_QUICK_Regression,@DTC_Schomp_portal_QUICK_Regressionion,
@RunWith(Cucumber.class)
public class TestRunner {

}

