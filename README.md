# OnlineShoppingProject

**Description**: This is an automation project which tests some scenarios of a demo site: http://shop.demoqa.com/

**Tools and Programming language Used**: Selenium WebDriver, TestNG, Maven, Eclipse, Java

**Design of the Project**: The project is designed using Page Object Model design pattern.

**Advantages of POM framework**: 

* It makes ease in maintaining the code (flow in the UI is separated from verification)
* Makes code readable (Methods get more realistic names)
* Makes the code reusable (element locators and test logic is independent of test cases)
* The Code becomes less and more optimised.

**Best Practices followed**:

The test scripts of the project follow Single Responsibility Principle where each script is responsible for only one task. This enable to 
figure out bugs easier and faster if any.

Assertions are added to each test script to check if it executs as expected.

Comments are added to the test script to understand the workflow even for a new engineer in the team.

Data is not hardcoded any where and no hardcoded sleeps are used.

Each test script is independent of other so that they can be run parallely and give a faster feedback about the status of the project.

The test scripts uses the shortcuts to navigate to the url directly(not from the home page everytime) and API tests for setting up the state.

Screenshots are added to the test cases failed to figure the location of the failure exactly.

TestNG report will be generation after the execution of the test cases.
