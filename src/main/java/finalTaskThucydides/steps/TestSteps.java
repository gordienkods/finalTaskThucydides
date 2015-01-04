package finalTaskThucydides.steps;

import finalTaskThucydides.pages.OperationsPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
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
    public void checkConditionOfDatabase(String conditionOfDataBase) {
       Assert.assertEquals(operationsPage.getDataBaseCondition(conditionOfDataBase), conditionOfDataBase);
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
        Assert.assertEquals(EXPECTED_RESULT, actualResult);
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
    
    @Step
    public void comparePopUpWindowsMessage(String popUpWindowsMessage){
        String actualResult = operationsPage.getPopUpWindowsMessage();
        Assert.assertEquals(popUpWindowsMessage,actualResult);
    }
    
    @Step
    public void checkVipsLineByNumber (int number){
        operationsPage.checkVipsLineByNumber(number);
    }
    
    @Step
    public void compareLineQuantityInVipsTable(int expectedQuantity){
        int actualResult = operationsPage.countLineInVipsTable();
        Assert.assertEquals(expectedQuantity,actualResult);
    }
    
    @Step
    public void checkResultOfDeleteOperation(int deletedVipNumber){
        ArrayList<String> gotVipsFromTable = null;
        String EXPECTED_RESULT="true", actualResult;
        gotVipsFromTable=operationsPage.getVipDataFromTable(2,2);
        actualResult = operationsPage.compareListVipsData(gotVipsFromTable, operationsPage.getVipsSentDataWithOutDeletedVip(deletedVipNumber-1));
        Assert.assertEquals(EXPECTED_RESULT, actualResult);
    }
    
    @Step
    public void fillVipFirstName(String firstName){
        operationsPage.fillVipFirstName(firstName);
    }

    @Step
    public void fillVipLastName(String lastName){
        operationsPage.fillVipLastName(lastName);
    }
}