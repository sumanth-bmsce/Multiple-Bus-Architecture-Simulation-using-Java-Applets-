
<h1> Multiple Bus Architecture Simulation System using Java Applets </h1>

<h3> Description </h3>

The project is an attempt to simulate the Multiple Bus Architecture. It can also be a tool for understanding the working of multiple bus architecture. Here, visualization of the processor data path is brought out with help of features provided by Java applets.

<h3> Multiple Bus Architecture Components </h3>

1. Instruction Register (IR) 
2. Program Counter (PC) 
3. Memory Address Register (MAR) 
4. Memory Data Register (MDR) 
5. Multiplexer (MUX) 
6. Arithmetic and Logical Unit (ALU) 

<h3> Components of the Simulation </h3>

1.	**Load**: In this module the objective is to take the instruction from the  user (drop down box) and upon click on the load button the instruction is loaded to main memory.

2.	**Fetch**: The objective of this module is to fetch the instruction input by the user and pointed by PC through data bus to the MDR then to IR.

 3.	**Execute**: This is the main module in which after an instruction is fetched, is decoded and the necessary control signals are generated and the instruction gets executed.
 
 <h3> Example of instruction with generation of control signals using Multiple Bus Architecture </h3>
 
 Instruction : **Add (R3), R1**
 
The sequence of control signals generated for this instruction using three bus architecture is: 

PCout , MARin , Read,</br>
Select4, Add, Z in</br>
Zout , PC in , Y in , WMFC</br>
MDRout , IR in</br>
R3out , MAR in , Read</br>
R1out , Y in , WMFC</br>
MDRout , SelectY, Add, Z in 7</br>
Z out , R1 in , End</br>



 
 

