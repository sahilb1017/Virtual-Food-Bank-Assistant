# Virtual Food Bank Assistant
## Introducton
This is our final project for ENSF409. Our group members are:
* Sahil Bhatt
* Harshal Patel
* Siwon Kim
* Abhiraam Manchiraju

This program calculates the required nutrition for a particular family and outputs a food hamper(s) that meets their requirements. Upon running the program, users are presented with the GUI where they will be able to input the number of different family members for a desired hamper. Users can also make multiple hamper requests in the same order. Additionally, users can edit and delete specific hamper requests prior to submitting their order. Once the order has been submitted, a pop-up will appear indicating whether the order was successfully processed or not. If processed successfully, the pop-up will also indicate the food items picked for each hamper.

## How to Run the Program
1. Clone the repo into a directory of your choosing:
```
git clone
```
2. Compile the program:
```
javac edu/ucalgary/ensf409/GUI.java
```
3. Run the main GUI file to launch the program:
```
java -cp .;lib/mysql-connector-java-8.0.23.jar edu.ucalgary.ensf409.GUI
```
