# Test-Automation-FrameWork

_This is an example of a maintainable test automation Framework using Selenium with Java and TestNG_

## Description
This is a simple and maintainable test automation framework wich main purpose is to reduce maintenance costs and optimize the testing process. It has wrapper methods to perform
user actions, an aplication layer in order to implement Page Object Model as a design pattern, a reports and screenshots generator using Extent Report and another libraries.

##Getting Started
In order to have a local copy of this project, simply copy the HTTPS URL available in the project main page ([CLONE](https://github.com/francopetruu/Test-Automation-FrameWork.git)), open the Git Bash into the directory that you want have the local version, and write:

`git clone https://github.com/francopetruu/Test-Automation-FrameWork.git`

Press ENTER, and get started! 

## Pre-Requirements
It is recommended to have and IDE like Eclipse IDE for Java Developers.

## Instalation and Test Execution
The execution of the test is through an XML file. Right click on the class that we want to execute, and click on Convert to TestNG. Save it in TestXMLFiles folder. Then, we pass
the parameters (in loginTestExecution.xml case, the parameters are "username" and "pass" with their respective values) and then we go back to the test class and we declare them 
with a @Parameters annotation inside the public class (in LoginTest.java example, is the LoginTest public class).Then, right click on the XML that we have created before, and
click on Run As, TestNG Suite.
