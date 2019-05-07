Right click on project select Run as --->5.maven build...

for goal provide name  package shade:shade

Go to project folder and target/lamda-0.0.1-SNAPSHOT-shaded.jar

Step 3:

Login to lambda console(skip blueprint)
Create new lambda
name: time-test

a) runtime-java

b) upload .zip(.jar) file (target/lamda-0.0.1-SNAPSHOT-shaded.jar)

Provide package.class-name::myhandler -> Handler

Role -> lambda-vpc-exceution-role

vpc provide rds-vpc details (this should work in same vpc group)

Create function
