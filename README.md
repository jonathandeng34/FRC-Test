# FRC-Test

Simple Emulation package for FIRST Robotics Java code running on a roboRIO

### Adding it to your project

- Extract the [FRC-Test zip file](https://dl.dropboxusercontent.com/u/27566023/Software%20Host/FRC-Test.zip) into the root of your robot code project

- Add the following code at the bottom of your build.xml, right before `</project>`:
```
  <!-- +++++++++++++++++++++++++++++++++++++   FRC-Test   +++++++++++++++++++++++++++++++++++++ -->
  <import file="frctest.xml"/>
```

- Create a new Ant Run Configuration by right-clicking build.xml in the project explorer and choosing Run As > Ant Build...
Select the `runemulator` target in the targets tab.
Then, run the configuration, and the emulator will search for all classes extending RobotBase (ant IterativeRobot and SampleRobot) and ask which one you want to run. 


### Code
This project uses a significant amount of code from the NetworkTables and WPILib libraries.  This code is the property of its owners / authors.
Thank you, FIRST, for making this possible by making WPILib open-source.