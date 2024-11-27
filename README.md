# FitPeo_Automation_Code

Explanation:

Task 1: Open HomePage
•	Initialize WebDriver: A Chrome browser is started using ChromeDriver.
•	Set Wait: An explicit wait instance is initialized with a 20-second timeout.
•	JavaScript Executor: Enables executing JavaScript within the browser.
•	Navigate to URL: Opens Fitpeo's website and maximizes the browser window.

Task 2: Navigation	
•	Calls navigateTo() method to click a link with the text "Revenue Calculator".
•	The method waits until the link is clickable and performs a click().

Task 4: Adjust Slider
•	Adjusts a slider value to 820.
•	Logic:
•	Finds slider elements using their XPath.
•	Reads the slider's min, max, and computes the slider's target 
position using a formula.
•	Uses JavaScript to move the slider dynamically and fine-tunes it
with keyboard arrow keys (Keys.ARROW_RIGHT or Keys.ARROW_LEFT).
•	Verifies if the slider reaches the desired value.

Task 7: Select CPT Codes
•	Selects multiple checkboxes on the page.
•	Logic:
•	Uses XPath to locate checkbox elements.
•	Clicks the checkboxes in a sequence.
•	Retrieves text from a specific element to verify the selections.

Task 5: Update Slider via Text Input
•	Revisits the "Revenue Calculator" and updates a slider value through an input field.
•	Logic:
•	Locates the slider and input box.
•	Clears the input field by simulating backspace presses.
•	Inputs the desired value (560) into the text field.
•	Verifies the input box and slider display the correct value.

Methods
•	navigateTo(String linkText):
•	Waits for a clickable link matching linkText and clicks it.
•	adjustSlider(int value):
•	Adjusts a slider to the specified value using JavaScript and arrow keys.
•	selectCptCodes():
•	Interacts with checkboxes and prints selected options.
•	updateSliderTextBox(int value):
•	Updates a slider's value via the associated input box, verifies correctness, and prints results.

Features Demonstrated
•	JavaScript Execution:
Used to manipulate UI elements like sliders (jsx.executeScript).
•	Dynamic Waits:
Ensures elements are clickable before interacting (WebDriverWait).
•	Element Interaction:
Various types of interactions (e.g., click, send keys, read attributes).
•	Validation:
Ensures actions have the expected outcome by checking values and printing logs.

Enhancements
•	Replace Thread.sleep():
Replace Thread.sleep() with dynamic waits for better reliability and performance.
•	Error Handling:
Wrap interactions with try-catch blocks to gracefully handle failures.
•	Reusable Locators:
Store frequently used XPaths/CSS selectors in variables/constants for maintainability.
