package finalTaskThucydides.steps;

import finalTaskThucydides.pages.OperationsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
//import org.hamcrest.MatcherAssert.*;

import java.util.ArrayList;

public class TestSteps extends ScenarioSteps {
    
    OperationsPage operationsPage;
    
    @Step
    public void goToMainPage(){
        operationsPage.open();
    }
    
    @Step
    public void clickButton(String buttonTitle){
        operationsPage.clickButtonByTitle(buttonTitle);
    }

    @Step
    public String getDataBaseCondition(){
        return operationsPage.getDataBaseCondition();
    }

    @Step
    public String getVipCountCondition(){
        return operationsPage.getVipCountCondition();
    }

    @Step
    public void checkConditionOfDatabase(String conditionOfDataBase) {

       Assert.assertEquals(operationsPage.getDataBaseCondition(), conditionOfDataBase);
    }

    @Step
    public void fillNewVipData(String firstName, String lastName, String gender, String category){
        operationsPage.fillNewVipData(firstName, lastName, gender, category);
    }

    @Step
    public void compareVipCountCondition (String expectedVipCountCondition){
        Assert.assertEquals(expectedVipCountCondition, operationsPage.getVipCountCondition());
    }
    
    @Step
    public void compareVipsData(){
        ArrayList<String> gotVipsFromTable = null;
        String EXPECTED_RESULT = "true", actualResult;
        gotVipsFromTable=operationsPage.getVipDataFromTable(2,2);
        actualResult=operationsPage.compareListVipsData(gotVipsFromTable, operationsPage.getVipsSentData());
        //ASSERT
        Assert.assertEquals(EXPECTED_RESULT, actualResult);
//        log.info("test result: " + EXPECTED_RESULT + " " + actualResult);
    }
    
    @Step
    public void findButtonOnPageByTitle(String buttonTitle){
        String actualResult = operationsPage.findButtonOnPageByTitle(buttonTitle);
        Assert.assertEquals(buttonTitle,actualResult);
    }
    
    @Step
    public void checkConditionOfButton (String buttonTitle, String buttonCondition){
        String actualResult = operationsPage.getButtonCondition(buttonTitle);
        Assert.assertEquals(buttonCondition,actualResult);
    }
    
}
