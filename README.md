# Assignment 2
**Sebastian Bentley - cph-sb287**

## 1 Reflections

### 1.1 Computer Mouse
*Identify the types of testing you would perform on a computer mouse, to make sure that it is of the highest quality.*

**answer:**


By following the guide of [artoftesting.com](https://artoftesting.com/mouse), I have found many test, which could be performed to a computer mouse.
1. Check the type of the computer mouse (optical or not).
2. Verify that right and left-clicks work as intended.
3. Verify that you can double click.
4. verify that the scroller works as inteded (and if it has one).
5. Verify the speed of the mouse, and the different dpi settings.
6. Check the pressure of a mouse click, neither to hard or too soft.
7. Verify the mouse-drag operation.
8. If the mouse is wireless, check the connection.
9. If the mouse is wired, check the wired connection...
10. Verify that the mouse fits the intended hand (right or left).
11. Check the strength of a mouse, by performing drop tests, and run above tests again.
12. Run the test many times, to get an idea of how long it will endure.


  

### 1.2 Catastrophic Failure
*Find a story where a software system defect had a bad outcome. Describe what happened. Can you identify a test that would have prevented it?*


**answer:**
The story I found, is from [dailysabah.com](https://www.dailysabah.com/business/automotive/tesla-to-recall-135000-vehicles-over-computer-memory-failure), which is about a bug from Tesla, where they had to recall nearly 135.000 cars.
This was due to the bug that occured, when the flash memory reached its end of life, and then causing failures in features, such as rearview camera, defrost control settings, and turn signal lighting.
A test to fix this, would have been to stress test the flash memory, and make it reach end of life on many cars. Tesla could then run automated test on the other features, to see which fails, due to flash memory failure.  

## 2 Two katas
*The code in this exercise, was done using the BDD method. See [StepsDefinitions.java](https://github.com/SebastianBentley/softTestAssignments/blob/main/assignment2/TestAssignment2/src/test/java/com/example/testassignment2/StepsDefinition.java)) for test automation*
  

### 2.1 String Utility &  2.2 Bowling game kata
Code for homemade string utils can be found here: [BootlegStringUtils.java](https://github.com/SebastianBentley/softTestAssignments/blob/main/assignment2/TestAssignment2/src/main/java/com/example/testassignment2/BootlegStringUtils.java)
Code for the bowling game can be found here: [Game.java](https://github.com/SebastianBentley/softTestAssignments/blob/main/assignment2/TestAssignment2/src/main/java/com/example/testassignment2/Game.java) 
 
 
 Feature files for automated acceptance test, can be found here [clickMe](https://github.com/SebastianBentley/softTestAssignments/tree/main/assignment2/TestAssignment2/src/test/resources/com.example.testassignment2)
Unit test for homemade string utils, can be found here [BootlegStringUtilsTest.java](https://github.com/SebastianBentley/softTestAssignments/blob/main/assignment2/TestAssignment2/src/test/java/com/example/testassignment2/BootlegStringUtilsTest.java)
Unit test for bowling game, can be found here [BowlingGameTest.java](https://github.com/SebastianBentley/softTestAssignments/blob/main/assignment2/TestAssignment2/src/test/java/com/example/testassignment2/BowlingGameTest.java)

 
## 3 Investigation of tools


### 3.1 JUnit 5

Link to a nice guide: [devqa.io](https://devqa.io/junit-5-annotations/)

* *@Tag* cab ve used to tag a test, so it can be used for filtering test. This way, we can easily distiguish which type of test we are running.

* *@Disabled* is used to skip/ignore a test.

* *@RepeatedTest* is used to repeat test, a paremeter (value) is given, to determine how many times the test should be repeated.

* *@BeforeEach, @AfterEach* are used, when something needs to run before or after each case. An example, could be initializing a database or value, and clearing after each test.

* *@DisplayName* is simply to declare a display name, that will be shown to test runners and test reports.

* *@Nested* is used, to group tests inside multiple nested classes. This way, we can test multiple classes in the same test file.

* *assumeFalse, assumeTrue* is used, to determine if the rest of the test is run or not, given the conditions apply in the assumeTrue/assumeFalse.

### Mocking Frameworks
The to frameworks I have chosen to compare, are [Mockito](https://site.mockito.org/) and [Easymock](https://easymock.org/).

* *What are their similarities?*


They are both mocking frameworks, that use the @Mock annotation to define mocks.

* *What are their differences?*


Mockito has special annotation for partial mocks. Easymock need to call EasyMock.replay(mock) each time you want to use a mock, or else an exception is thrown.

* *Which one would you prefer, if any, and why?*


I would prefer to use Mockito, since it is the most known in the community, and therefore easier to find help online.
