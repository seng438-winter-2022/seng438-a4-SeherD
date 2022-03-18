**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#4 – Mutation Testing and Web app testing**

| Group \#:       |   |
|-----------------|---|
| Student Names:  |   |
|                 |   |
|                 |   |
|                 |   |

## Introduction
The purpose of this lab was for the group to gain knowledge in the area of mutation testing, as well as GUI testing. By enhancing our test suites from assignment three with a focus on adding more thorough mutation coverage, we developed a comprehensive set of tests for the methods in the Range Class and Data Utilities Class. The use of mutation testing with the help of Pitclipse combined with the GUI testing of a website using Selenium was a great way to gain experience. Each section of the lab allowed the team to refine their skills in the design, development, and execution of tests. Lastly, it helped us evaluate the quality of the tests written.

## Analysis of 10 Mutants of the Range Class

**Mutation of line 91 number 5:** 

Negated double local variable number 1 -> SURVIVED.

This mutation involves the constructor function of class Range, and has survived. The line currently reads: 

String msg = “Range(double, double): require lower (“ + lower …

This ‘msg’ is a string that is returned as an IllegalArgumentException. Although we have a test case that enters this branch and expects an illegal argument exception to be thrown, it does not check the message of the exception, so if an exception is thrown with a different message than expected (negative val instead of positive val), then the test case will still pass, thus the mutant will survive.

**Mutation of line 95 number 4:** 

Decremented (a- -) double local variable number 1 -> SURVIVED.

This mutation involves again the constructor of the class Range. In this case, the line reads ‘this.lower = lower;’. The mutation replaces this line with:

this.lower = lower- -. 

Since ‘lower’ is a double function parameter, and this is the last time it is accessed, when it is decremented, this.lower will retain the original value of ‘lower’, and the parameter to the function will be decremented. Since this doesn’t affect the result of the program, this mutation is impossible to be caught, and is missed by our test cases.

**Mutation of line 95 number 3:**

Incremented (a++) double local variable number 1 -> SURVIVED.

This mutation is very similar to the previous, and involves again the constructor of the class Range. In this case, the line reads ‘this.lower = lower;’. The mutation replaces this line with:

this.lower = lower++. 

Since ‘lower’ is a double function parameter, and this is the last time it is accessed, when it is incremented, this.lower will retain the original value of ‘lower’, and the parameter to the function will be incremented. Since this doesn’t affect the result of the program, this mutation is impossible to be caught, and is missed by our test cases.

**Mutation of line 96 number 5:**

Incremented (++a) double local variable number 3 -> KILLED.

This mutation is again quite similar to the previous, and involves again the constructor of the class Range. In this case, the line reads ‘this.upper = upper;’. The mutation replaces this line with:

this.upper = ++upper. 

Because this will actually change the value assigned to this.upper (will become one less than the parameter passed in), our test cases that test the creation of a range class object will fail. They assert the correct range was created by testing the upper and lower bounds, but will receive an incorrect value for the upper bound. This means that the mutation will make a test case fail, which means that the mutation is killed.

**Mutation of line 114 number 6:**

Incremented (++a) double field upper -> KILLED.

This mutation concerns the line that says:

return this.upper; of the function getUpperBound(). 

The line is replaced with the following:

‘return ++this.upper;’

Because we have test cases that analyze the result of the function getUpperBound(), and instead of returning the correct and expected value, the mutation will cause it to return a value one greater than that expected, a test case will fail after this mutation is applied. Because of this, the mutation is killed.

**Mutation of line 123 number 10:**

Replaced double subtraction with division -> KILLED.

This mutation affects the function getLength() in the class Range. The line it affects reads the following:

‘return this.upper - this.lower;

After applying the mutation, the line reads the following:

‘return this.upper/this.lower;’

Because we have a test that results in a return value of 0, without this.upper being equal to 0, when division is applied instead of subtraction, an unexpected value is found. This means that the mutation is killed.

**Mutation of line 197 number 4:**

Incremented (a++) double local variable number 3 -> SURVIVED.

This mutation involves the function ‘constrain’ in class range. In this case, the line reads ‘return result;’. The mutation replaces this line with:

return result++. 

Since ‘result’ is a double created inside of the function, and this is the last time it is accessed, when it is incremented, the return value will retain the original value of ‘result’, and the function variable will be incremented. Since this doesn’t affect the result of the program, this mutation is impossible to be caught, and is missed by our test cases.

**Mutation of line 312 number 1:**

Replaced return value with null fro org/jfree/data/Range:expandToInclude -> KILLED

This mutation involves the function ‘expandToInclude’ in the class range. In this case, the line reads ‘return range;’. The mutation replaces this line with:

return null. 

Since we have a test case that expects expandToInclude to return the correct value, when a value of ‘null’ is returned, our test case fails. This causes the mutation to be killed, since our tests detected it.

**Mutation of line 394 number 12:**

Incremented (a++) double local variable number 0 -> NO_COVERAGE.

This mutation is neither killed nor survived, because the function ‘shiftWithNoZeroCrossing’ is not considered in our original test suite. Since it is never covered in a single test, a mutation result of ‘NO_COVERAGE’ is obtained.

**Mutation of line 464 number 4:**

Incremented (a++) integer local variable number 1 -> SURVIVED.

This mutation involves the function hasCode() of class Range.. In this case, the line reads ‘return = result;’. The mutation replaces this line with:

return = result++. 

Since ‘result’ is an integer created inside of the function, and this is the last time it is accessed, when it is incremented, the return value will retain the original value of ‘result’, and the integer created by the function will be incremented. Since this doesn’t affect the result of the program, this mutation is impossible to be caught, and is missed by our test cases.


## Report all the statistics and the mutation score for each test class

After running PITEST on the original test suite from Assignment 3, we got the following metrics from the PITEST summary:



<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image1.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image1.png "image_tooltip")




<p id="gdcalert2" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image2.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert3">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image2.png "image_tooltip")


After we wrote our test cases to kill some of the mutants that had survived, we managed to increase our mutant coverage significantly.



<p id="gdcalert3" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image3.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert4">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image3.png "image_tooltip")




<p id="gdcalert4" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image4.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert5">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image4.png "image_tooltip")
	


## A discussion on the effect of equivalent mutants on mutation score accuracy, as well as a discussion on a possible way to detect equivalent mutations

Equivalent mutations are an important piece of mutation testing to consider when analyzing coverage. Some mutations are impossible to ‘kill’ with a test suite, regardless of how robust it is. This occurs when a mutation results in syntactically changed code, with the same performance and expected results as the original code. When an equivalent mutation is created, it will always be counted as ‘survived’. This means that even if a single equivalent mutation is created by a software like Pitclipse, mutant coverage cannot possibly reach 100%. When multiple equivalent mutations are created, say 100 out of 1000 total mutations, maximum possible mutant coverage becomes 90%. This is a significant drawback to the process of mutation testing, because actual (non-equivalent) mutant coverage could be significantly lower than displayed mutant coverage.

Our group spent time discussing how we could potentially detect equivalent mutations. We came up with one idea, which has some clear benefits and drawbacks, and is ultimately not clever enough to catch all equivalent mutations. Our strategy involves writing all of the forms of equivalent mutations we know into a database, in a very specific format. The format would include three key pieces of information to identify an equivalent mutation. First: the general syntax of a line of code that could allow for an equivalent mutation (for example: 'return result'). Second: an exact list of mutations (in Pitclipse syntax) that could be considered equivalent, for the aforementioned line of code (for example: 'Incremented (a++) double field lower'). Third: For each possibly equivalent mutation, conditions regarding the placement of the line in a function/class or the future use of variables the line accesses (for example, a variable ‘var’ used in a line reading ‘var2 = var’ would not be allowed to be accessed later in the function for it to be considered an equivalent mutation, where the mutation makes the line ‘var2 = var++’). Now, after running Pitclipse to create a list of all mutations, our program would reference every mutation that Pitclipse generates with the database, to see if a specific mutation meets all three pieces of criteria. If so, the mutation would be considered equivalent, and would be filtered out. The main benefit of this approach is that it would catch most equivalent mutations, and never remove non-equivalent mutations. The drawback to this approach is that it requires up-front manual work (populating the database), before a program would be able to filter out equivalent mutations.

**List of equivalent mutations we found manually:**

Line 84 of DataUtilities:

for(int i = 0; i&lt;a.length; i++)
-> 

for(int i = 0; i!=a.length; i++)

line 105 of DataUtilities:

for(int i = 0; i &lt; source.length; i++)

->

for(int i = 0; i != source.length; i++)

line 127 of DataUtilities:

for(int r = 0; r &lt; rowCount; i++)

->

for(int r = 0; r != rowCount; i++)

line 153 of DataUtilities:

for(int v = 0; v &lt; validRows.length; i++)

->

for(int v = 0; v != validRows.length; i++)

line 178 of DataUtilities:

for(int c = 0; c &lt; columnCount; i++)

->

for(int c = 0; c != columnCount; i++)

Line 204 of DataUtilities:

for (int v = 0; v &lt; validCols.length; v++)

->

for (int v = 0; v != validCols.length; v++)

Line 227 of DataUtilities:

for (int i = 0; i &lt; data.length; i++)

->

for (int i = 0; i != data.length; i++)

Line 245 of DataUtilities:

for (int i = 0; i &lt; l1; i++)

->

for (int i = 0; i != l1; i++)

Line 265 of DataUtilities:

for (int i = 0; i &lt; data.getItemCount(); i++)

->

for (int i = 0; i != data.getItemCount(); i++)

Line 272 of DataUtilities:

for (int i = 0; i &lt; data.getItemCount(); i++)

->

for (int i = 0; i != data.getItemCount(); i++)


## A discussion of what was done to improve the mutation score of the test suite

We had significantly lower mutant coverage than expected originally, given our line coverage. A lot of our test cases expected a return value of 0, so all mutants that changed lines like ‘return val1 - val2’ to ‘return val1 * val2’ survived. Fixing this problem was simple, as we only had to modify existing test cases to input values other than zero and expect values other than zero. Making these changes was the first step of our improvement plan, and increased our mutant coverage significantly.

Secondly, we went through each line and considered each mutant individually, and wrote a test case that would ‘kill’ it. Oftentimes, one test case would kill multiple mutants that had survived, because either a branch or function had been ignored completely by our original test suite. We found it prudent as we were killing ‘survived’ mutants to ignore ones that we found confusing. Pitclipse often created mutants for lines that didn’t make a whole lot of sense. Some of them were ‘killed’, and we didn’t understand why, and some ‘survived’, to our confusion. For example: ‘431 4. Substituted 0 with 1 → SURVIVED. This mutant references a returned boolean value. We assumed that ‘0’ meant false, and ‘1’ meant true, but we had written a test case that would have certainly killed this mutant. We decided trying to figure out the pitclipse syntax was not worth our while, as we were already able to increase our mutant coverage by 10% before considering cases like these. 


## Why do we need mutation testing ? Advantages and disadvantages of mutation testing

Mutation testing is a form of white-box testing. The purpose is to help the tester develop effective tests or locate weaknesses in the test data used for the program or in sections of the code that are seldom or never accessed during execution. 

**Advantages:**



* The ability to ensure the identification of weak tests or code.
* Has a high level of error detection.
* The increased use of object-oriented frameworks and unit tests have brought about more mutation testing tools.
* Mutation scores can give organizations an idea of how useful their testing suite is.

**Disadvantages:**



* The large number of mutants used to test a test suite can lead to a potentially confusing experience in testing each version, which may reduce mutation testing’s practicality without automation.
* Because of the large number of mutants being tested, mutation testing can be time-consuming and pricey.
* Equivalent mutants create a lot of issues while testing


## Explain your SELENIUM test case design process

We designed tests focussing on the core functionality of the SportCheck website, including buying, searching, getting store information, signing in, registering for mailing lists, and more. We created the test suite to be run with varying inputs, so you will see some duplicates with different test data to ensure robustness. Each of our tests are included in the GitHub file, but general descriptions have been included below.

Test 1: MailingListSignupCalgary, this test ensures that a user can sign up for the SportChek mailing address with a Calgary postal code. There are numerous asserts to ensure that the user can correctly enter their information into the webpage fields, and checks to ensure that the user has been successfully signed up upon clicking the “Sign up” button. 

Test 2: MailingListSignupToronto, this test ensures that a user can sign up for the SportChek mailing address with a Toronto postal code. There are numerous asserts to ensure that the user can correctly enter their information into the webpage fields, and checks to ensure that the user has been successfully signed up upon clicking the “Sign up” button. 

Test 3: SearchMensPants, this test ensures that users can search for items within the store catalog, in particular “Mens Pants”. It makes sure that the search bar on the home page is there, and that the correct search result is returned in the end. 

Test 4: SearchMensShoes, this test ensures that users can search for items within the store catalog, in particular “Nike mens running shoe”. It makes sure that the search bar on the home page is there, and that the correct search result is returned in the end. 

Test 5: SearchMensShoes, this test ensures that users can search for items within the store catalog, in particular “Nike womens running shoe”. It makes sure that the search bar on the home page is there, and that the correct search result is returned in the end.

Test 6: SetStoreCalgary, this test ensures that users can set their preferred SportCheck to a Calgary location to make it easy for them to see stock levels at that selected store. It asserts that a valid postal code can be entered to filter store locations, and that it returns results based only on locations near that postal code. Lastly, an assertExist is made to ensure that once returned from a list, the user can easily select their preferred store. 

Test 7: SetStoreToronto, this test ensures that users can set their preferred SportCheck to a Toronto location to make it easy for them to see stock levels at that selected store. It asserts that a valid postal code can be entered to filter store locations, and that it returns results based only on locations near that postal code. Lastly, an assertExist is made to ensure that once returned from a list, the user can easily select their preferred store. 

Test 8: registerAccontNoInput, ensures that the user is able to access the create account page upon clicking on the ‘register’ button and also tests the error checking of the create account input form, specifically when the user does not input anything. Firstly, it asserts the create account page has popped up by asserting the presence of the page header “Create your Triangle ID”.  Then after clicking the Create account button on the page after not inputting text in any of the fields, the error messages are asserted to be present. It is obvious that there can be various inputs for this test, however, anytime a ‘type’ command is made inside the input fields on the create account page, the test fails at that command, so it is impossible to test any input other than no input.

Test 9: customerServiceLink, This ensures that the user is able to access the customer service page from clicking on the link at the bottom of the home page. Since the user must scroll to the very bottom of the home page,  the test asserts that the bottom is reached by asserting the presence of some components, specifically the “Customer Service” Header, since its located nowhere else on the page. After the link is clicked, teh Customer service page is asserted to be visible by asserting that the Online Store Information page header is present and that the “Contact Us” Page header is present. There only needs to be a single test for this since there are not multiple ways to click a link.

Test 10: HomePageLogo, asserts that the user is able to navigate back to the home page,  by clicking  on the sport chek logo in the top left corner of the page. This is asserted by constructing a test case that can start on different pages and click on the logo in the top left corner of the page. Tes test then checks that the home page has been reached by asserting that the logo in the top left corner is present, the Under Armor advertisement is present, and lastly that the “woman” toolbar button is present.

Test 11: invalidSignInNoEmail,  ensures that the user is able to access the sign in page upon clicking on the “Sign In” button and also tests the error checking of the create account input form, specifically when the user does not input an email in the email field. Firstly, it asserts the sign page has popped up by asserting the presence of the page header “Triangle ID Sign In”.  Then after clicking the “Sign In” button on the page after not inputting an email in the email field, the error messages are asserted to be present, more specifically, the message “This field is required”.

Test 12: invalidSignInNoInput. This test is the same as Test 11, only that none of the input fields were filled. Since the password input field was not filled the test asserts the error message below the password field “This field is required”.

Test 13: triangleRewards,  ensures that the user is able to access the Triangle Rewards page upon clicking on the “Triangle rewards” button and then asserts that the user is able to click the Join Now button to then be asked to create an account. This is done by first asserting that the page header message is present below the Join Now Button, then the test clicks the join now button and asserts the “Create Account button is present in the pop up dialog. There only needs to be a single test for this since there are not multiple ways to click a link.


## Explain the use of assertions and checkpoints

Asserts in Selenium are used to validate the test cases. They helped us understand if tests have passed or failed, and why this was the case. We used asserts and checkpoints throughout the test process to ensure our tests are running smoothly. Statements commonly used include assertExist that certain web elements exist to make sure the user can interact with them. This included buttons, text fields, and checkboxes. It was an easy way to ensure the process flow could continue as expected. We also used assertText to confirm actions such as successfully signing in, or joining mailing lists, because text was promoted to the user in these cases indicating confirmation, so we could assert that operations occurred smoothly. 


## How did you test each functionality with different test data?

Because of the nature of the web environment, we were able to run every test with multiple different data types. For instance, adding items to cart could be done with thousands of items that SportCheck offered, selecting stores could be done by entering any postal code in Canada, and item catalogs could be searched with any parameter types. We used this to our advantage to develop wholesome test suites, testing the same actions with different test data to ensure robustness. While the test functionality that was being tested was the same as well as the associated process, the ways in which the system was interacted was tested with different data. 


## Discuss advantages and disadvantages of Selenium vs. Sikulix

In terms of simplicity and convenience, there’s no doubt that Selenium is far more superior.  Selenium is an extension on not only google chrome, but firefox as well, making it very easy to access, where Sikulix come as a downloaded jar file that requires a certain Java version, meaning the user needs to download other things in order to use the ide, where Selenium does not need anything other than Chrome or FireFox. Selenium also just looks visually better.  In terms of features, Selenium has a much more dynamic scale of speed at which you can run your tests, making debugging easier. On the other hand Sikulix only has two speeds that you can run your tests at.  The main reason why Selenium is a far better IDE than Sikulix is that you are able to record actions in Selenium, where you have to take screenshots in Sikulix which we believe is not at all practical.


## How the team work/effort was divided and managed?

Each group member participated in creating their own unique mutation tests, and GUI test. We worked collaboratively to ensure tests were complete, accurate, and did not overlap with each other. This led to a successful increase in mutation coverage, as well as thorough testing of many important functions of the SportCheck website. 


## Difficulties encountered, challenges overcome, and lessons learned.

Piclipse only ran on one machine, so we had to each develop our own mutation test and send it to the person who could run them for testing. During the mutation testing, nothing was working because packages were missing from the Artifacts as well; one of the links to demo how selenium works was returning a 404 error. We didn't find the picclipse very user friendly, and our tests took about 15 mins to run for each one. On the GUI side, once we got Selenium working, it was a lot more intuitive, and the test design process was much more straightforward. 


## Comments/feedback on the lab itself

This lab was definitely the most interesting so far because we were able to work with real websites in part two. However, we do wish we had more resources to learn how to use the selenium IDE as the link provided does not work, causing us to figure it out ourselves, luckily Selenium is not hard to learn. The mutation testing was an important tool to learn, and despite our challenges, it brought the team together and challenged us to a new method of coverage testing. 
