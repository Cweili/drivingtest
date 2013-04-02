Chinese Driving Test Practice
===========

* A simple Chinese Driving Test practice system written by Java.
* Store questions data and image in MongoDB(<http://www.mongodb.org/>).
* Display by ExtJS(<http://www.sencha.com/products/extjs>) and DWR(<http://directwebremoting.org/>).

Project Home: <https://github.com/Cweili/drivingtest>

Import Data
-----------

1. To import data first time, you have to configure src/main/resources/spring-mongo.xml for MongoDB connection.
2. Then enter "http://path/to/your/project/dwr/test/dwr/test/importData" in your browser and execute "importData()" method.
3. Wait for the data import is completed.