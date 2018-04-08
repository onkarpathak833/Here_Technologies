# Here_Technologies
Repo to host solution for coding solution Here Technologies
####################################################################
# Notes :

To run this project, make use of jar placed in Jars folder

command to use : java -jar AutonomousDriving.jar

DrivingSimulator is the main class that drives this application

Its a menu driven programs which will guide you through choices required.

To Enter Driving Mode, enter either of three choices - Normal, Sport,Safe (Values are case insensitive)

Enter the Driving events as numeric choices given below :
--------------------------------------------|
EventID		Description						|
--------------------------------------------|
1		|	Traffic							|
--------------------------------------------|
2		|	Traffic Clear					|
--------------------------------------------|
3		|	Weather Rainy					|
--------------------------------------------|
4		|	Weather Clear					|
--------------------------------------------|
5		|	Slippery Road					|
--------------------------------------------|
6		|	Slippery Road Clear				|
--------------------------------------------|
7		|	Emergency Turbo					|
--------------------------------------------|-------------|
8		|	Speed Limit Sign X (X being the speed value)  |
----------------------------------------------------------|


Program will give you the speed at which car should be driven.


###################################################################
Type Ctrl+c or Ctrl+d to exit the program 
##################################################################
-------------
Features :
--------------
1. Program does not store results anywhere on disk
2. Values are populated in built from properties file
3. Provides better maintainance if values for various events need to be changed in future, only .properties file for respective driving modes needs to be changed.
4. Generic program whcih has better re-usability and can be used as API's or plu and play features.
 
