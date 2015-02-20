# MySikuliExample
My Sikuli Example (with Maven)

Motivated by the example setup by Paul Hammant at the origin of this fork,<br>
I modified it a bit to make extensive use of 1.1.0 features and really be in the Maven default structure:

Main points:
 * the images are in the resources folder in images.sikuli, so they can be managed with the IDE
 * using ImagePath.add(class/folder) to point to the images 
 * made a generic function to start a browser, go to a link and wait for an image (currently for Mac only)
 * made the row clicks in a loop using calculated offset including the final deselect
 * uses Debug.user to print messages
 
The original is set up as testcase.<br>
I switched it to a normal run (was easier for me to debug and test ;-), <br>
so the final test for success is done with an if-exists-success/else-fault.
