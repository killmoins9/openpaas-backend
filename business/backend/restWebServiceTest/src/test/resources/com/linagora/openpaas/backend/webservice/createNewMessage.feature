Feature: create a new message

  user create a new message
  a form is completed with subject and body


  Scenario: user create a new message
    Given user has already a current number of message to send
    When user creates one new message
    Then there is one more message for the user