Feature: A new user account can be created if a proper unused username and password are given

    Scenario: creation is successful with valid username and password
        Given command new is selected
        When  username "pietari" and password "portti99" are entered
        Then  system will respond with "new user registered"
    
    Scenario: creation fails with too short username and valid password
        Given command new is selected
        When  username "li" and password "portti99" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and too short password
        Given command new is selected
        When  username "pyry" and password "aabbccd" are entered
        Then  system will respond with "new user not registered"

    Scenario: creation fails with valid username and password long enough but consisting of only letters
        Given command new is selected
        When  username "pyry" and password "lumisade" are entered
        Then  system will respond with "new user not registered"
