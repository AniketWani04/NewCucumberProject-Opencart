@smoke
Feature: Register
  Scenario Outline: Successfully Register
    Given User is on Home page and clicks on My Account
    Then User click on Register option
    Then User is on Register Page. Page title should be "Register Account"
    Then User enters First Name as "<firstName>" Last Name as "<lastName>" Email as "<email>" Telephone as "<telephone>" Password as "<password>" Password Confirm as "<passwordConfirm>"
    Then User select Newsletter Confirm as "<newsLetter>" and accept the Privacy Policy and click on Continue button
    Then Page title should be "Your Account Has Been Created!"

    Examples:
      | firstName | lastName | email | telephone | password | passwordConfirm | newsLetter |
      | Shivam | Dube | shivam1@gmail.com | 123456 | Shivam@123 | Shivam@123 | yes |