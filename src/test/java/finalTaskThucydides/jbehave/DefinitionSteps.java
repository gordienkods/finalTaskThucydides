package finalTaskThucydides.jbehave;

import finalTaskThucydides.steps.TestSteps;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.*;
import org.junit.Assert;

public class DefinitionSteps {
    
    @Steps
    TestSteps operations;


    @Given("the user is on the ranorex main page and data base condition is '$requiredDataBaseCondition'")
    public void givenTheUserIsOnTheRanorexWebPage(String requiredDataBaseCondition) {
        operations.goToMainPage(requiredDataBaseCondition);
    }
    
    @When("the user click '$buttonTitle' button")
    public void whenTheUserClicksDisconnectButton(String buttonTitle) {
        operations.clickButton(buttonTitle);
    }
    
    @Then("the user should see that condition of database is '$conditionOfDataBase'")
    public void userShouldSeeConditionOfDatabase(String conditionOfDataBase){
        operations.checkConditionOfDatabase(conditionOfDataBase);
    }
    
    @When ("the user enters VIPs data: first name-'$firstName', last name-'$lastName', gender-'$gender', category-'$category'")
    public void fillNewVipData (String firstName, String lastName, String gender, String category){
        operations.fillNewVipData(firstName, lastName, gender, category);
    }
    
    @Then ("VIPs count should be '$expectedVipCountCondition'")
    public void compareVipCountCondition (String expectedVipCountCondition){
        operations.compareVipCountCondition(expectedVipCountCondition);
    }

    @Then ("entered VIPs data should be the same with VIPs data from the table")
    public void compareVipsData() {
        operations.compareVipsData();
    }
    
    @Then ("the user should see '$buttonTitle' button")
    public void findButtonOnPageByTitle(String buttonTitle){
        operations.findButtonOnPageByTitle(buttonTitle);
    }
    
    @Then ("'$buttonTitle' button condition should be '$buttonCondition'")
    public void getButtonConditionByTitle (String buttonTitle, String buttonCondition){
        operations.checkConditionOfButton(buttonTitle, buttonCondition);
    }
    
    @Then("the user should see pop-up window with the info message: '$popUpWindowsMessage'")
    public void comparePopUpWindowsInfoMessage(String popUpWindowsMessage){
        operations.compareInfoFromPopUpWindow(popUpWindowsMessage);
    }

    @Then("the user should see pop-up window with the question: '$popUpWindowsQuestion'")
    public void comparePopUpWindowsQuestion(String popUpWindowsQuestion){
        operations.compareQuestionFromPopUpWindow(popUpWindowsQuestion);
    }
    
    @When ("the user click radio button near vip number '$vipLineNumber'")
    public void checkVipsLineByNumber (int vipLineNumber){
        operations.checkVipsLineByNumber(vipLineNumber);
    }

    @Then ("quantity of Vips lines in table should be '$expectedQuantity'")
    public void countLineInVipsTable(int expectedQuantity){
        operations.compareLineQuantityInVipsTable(expectedQuantity);
    }

    @Then ("the user should see vips table with out VIP number '$deletedVipNumber'")
    public void compareVipsTable(int deletedVipNumber){
        operations.checkResultOfDeleteOperation(deletedVipNumber);
    }

    @When ("the user enters VIPs first name '$firstName'")
    public void fillVipFirstName(String firstName){
        operations.fillVipFirstName(firstName);
    }

    @When ("the user enters VIPs last name '$lastName'")
    public void fillVipLastName(String lastName){
        operations.fillVipLastName(lastName);
    }
}
