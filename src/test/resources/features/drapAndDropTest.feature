
Feature: drag



  @smoke @drag
  Scenario Outline: Prepare account for login.
    When On Web, I open url "https://www.seleniumeasy.com/test/drag-and-drop-demo.html"
    And I wait 10 seconds
    And I drag "Draggable 1" and drop to drop zone
    And I wait 500 seconds
    Examples:
      | phone      | country | displayName |
      | 0303305467 | VN      | Nguyen      |

  @smoke @drag-2
  Scenario Outline: Prepare account for login.
    When On Web, I open url "http://demo.guru99.com/test/drag_drop.html"
    And I drag and drop
    And I wait 500 seconds
    Examples:
      | phone      | country | displayName |
      | 0303305467 | VN      | Nguyen      |



  @smoke @slider
  Scenario Outline: Prepare account for login.
    When On Web, I open url "https://www.seleniumeasy.com/test/drag-drop-range-sliders-demo.html"
    And I set grey slider is 50
    And I wait 500 seconds
    Examples:
      | phone      | country | displayName |
      | 0303305467 | VN      | Nguyen      |


  @smoke @upload
  Scenario Outline: Prepare account for login.
    When On Web, I open url "https://css-tricks.com/examples/DragAndDropFileUploading/"
    And I upload file "src/test/resources/data/images/h1.jpg"
    And I wait 500 seconds
    Examples:
      | phone      | country | displayName |
      | 0303305467 | VN      | Nguyen      |


  @smoke @alert
  Scenario Outline: Prepare account for login.
    When On Web, I open url "https://www.seleniumeasy.com/test/javascript-alert-box-demo.html"
#    And I click on Java Script Alert Box
#    And I get Text on Alert
#    And I click on Alert
#    And I click on Java Script Confirm Box
#    And I get Text on Alert
#    And I cancel on Alert
    And I click on Java Script Prompt Box
#    And I get Text on Alert
    And I sendkey "testing" on Alert
    And I wait 5 seconds
    And I click on Alert
    And I wait 500 seconds
    Examples:
      | phone      | country | displayName |
      | 0303305467 | VN      | Nguyen      |





