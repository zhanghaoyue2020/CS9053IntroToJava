# CS9053IntroToJava

2021spring  


## Part 1: Command

package includes only classes and interfaces, pictures must be put under the project file.

![image](https://user-images.githubusercontent.com/85269000/202542010-9c8e422e-c5cb-473e-8381-d9a3db748027.png)

Output

		Welcome to Java!  

Output Format  

		Degrees   Radians   Sine      Cosine    Tangent
		30        0.5236    0.5000    0.8660    0.5774  		
		60        1.0472    0.8660    0.5000    1.7321  

Input

		Enter an integer: 12  
		v1 is 12  
		Enter a double value: 12  
		v2 is 12.0  
		Enter a string: 12  
		v3 is 12  

Using Function

Lambda

Comparator

		original array: [Dean, Maria, Bob, Constantine, Ivan, Boris]  
		sorted array1 (default): 	[Bob, Boris, Constantine, Dean, Ivan, Maria]  
		sorted array2 (self-defined):	[Bob, Dean, Ivan, Boris, Maria, Constantine]  
		sorted array3 (lambda): 	[Bob, Dean, Ivan, Boris, Maria, Constantine]  
		sorted arraylist1 (lambda)	[Bob, Boris, Constantine, Dean, Ivan, Maria]  
		sorted arraylist2 (lambda)	[Maria, Ivan, Dean, Constantine, Boris, Bob]  
		sorted arraylist3 (lambda)	[Maria, Ivan, Constantine, Boris, Bob]  
		
## Part 2: Number, String and Time

Number Literals

		final int SIZE = 5;	5  
		double pi_val = Math.PI;	3.141592653589793  
		double square = Math.pow(5,2);	25.0  
		double num = Math.floor(5.5);	5.0  
		int INT_MIN = Integer.MIN_VALUE;	-2147483648  
		double doubleLiteral = 1.23456e2;	123.456  

Common Errors

		int value = 2147483647 + 1;  
		value is -2147483648  
		1.0 - 0.1 -0.1 - 0.1 -0.1 - 0.1 = 0.5000000000000001  
		1.0 -0.9 = 0.09999999999999998  
		
Number Pool

		Integer c = 127;  
		Integer d = 127;  
		c==d ? true  
		Integer e = 128;  
		Integer f = 128;  
		e==f ? false  
		e.equals(f) ? true  
		Integer g = -128;  
		Integer h = -128;  
		g==h ? true  
		Integer i = -129;  
		Integer j = -129;  
		i==j ? false  
		i.equals(j) ? true  
		
String Literals

		String a = "Circle";
		String b = "Circle";
		String c = new String("Circle");
		String d = new String("Circle");
		String e = c;
		a == b ? true
		b == c ? false
		c == d ? false
		c == e ? true
		c = new String("Circle");
		c == e ? false

String Indexes

		String className = "Introduction to Java Programming"  
		Index of the first occurence of 'n' is 1  
		Index of the last occurence of 'n' is 30  
		Index of the first occurence of "ro" is 3  
		Index of the last occurence of "ro" is 22  

Strings Sorting

		Enter the first city: Shanghai
		Enter the second city: Beijing
		The cities in alphabetical order are Beijing Shanghai

Convert Strings And Numbers

		Enter an integer: 1  
		You entered the number 1
		As a floating point value it would be 1.
		
Current Time

		Current time is 4:58:18 GMT

## Part 3: Classes

Default Value

		name?            null
		age?             0
		isScienceMajor?  false
		gender?     

Invoking Flow

		(1) Person's no-arg constructor is invoked
		(2) Invoke Employee’s overloaded constructor
		(3) Employee's no-arg constructor is invoked
		(4) Faculty's no-arg constructor is invoked

Class Inheritance

||Abstract class|Interface|
|:--|:---|:--|
||一个类只能继承一次abstract class|一个类可以满足多个interface|
|method|自定义的|public abstract|
|variable|default: friendly|public static final|
|invoking|extends|implements|

		Circle object1 = new Circle(1);
		Square object2 = new Square(1);
		GeometricObjectUnorderedSet<GeometricObject> objectlist = new GeometricObjectUnorderedSet<GeometricObject>();"
		objectlist.add(object1);
		objectlist.add(object2);

		displayObject(object1);
		Circle[Shape[Fri Feb 24 06:25:43 EST 2023,ID=1,color=white,filled=true,area=3.141592653589793],radius=1.0]
		displayObject(object2);
		Square[Rectangle[Shape[Fri Feb 24 06:25:43 EST 2023,ID=2,color=white,filled=true,area=1.0]width=1.0,height=1.0]]

		objectlist.printObjects();
		Circle[Shape[Fri Feb 24 06:25:43 EST 2023,ID=1,color=white,filled=true,area=3.141592653589793],radius=1.0]
		Square[Rectangle[Shape[Fri Feb 24 06:25:43 EST 2023,ID=2,color=white,filled=true,area=1.0]width=1.0,height=1.0]]

Show Inner Classes 

Show Wild Card

## Part 4: Container (lecture 09)

![image](https://user-images.githubusercontent.com/85269000/202549463-dfcec803-9005-4065-bec3-b2ecfea54622.png)

<table>
    <tr>
        <th></th><th>C++</th><th>Java</th><th>explanation</th>
    </tr>
    <tr>
        <td rowspan="6">List</td><td>array</td><td>[ ]</td><th></th>
    </tr>
    <tr>
        <td>vector</td><td>ArrayList</td><th>=ArrayList + (support synchronize)</th>
    </tr>
    <tr>
        <td>stack</td><td>Stack</td><td></td>
    </tr>
    <tr>
        <td>list</td><td>LinkedList</td><td></td>
    </tr>
    <tr>
        <td>forward_list</td><td></td><td>单链表，没有size()</td>
    </tr>
    <tr>
        <td>deque</td><td>ArrayDeque</td><td></td>
    </tr>
    <tr>
        <td rowspan="2">Queue</td><td>queue</td><td>Queue</td><td></td>
    </tr>
    <tr>
        <td>priority_queue</td><td>PriorityQueue</td><td>(heap sort)</td>
    </tr>	
    <tr>
        <td rowspan="5">Set</td><td>Set</td><td>TreeSet</td><td></td>
    </tr>	
    <tr>
        <td>multiset</td><td></td><td></td>
    </tr>	
    <tr>
        <td>unordered_set</td><td>HashSet</td><td></td>
    </tr>	
    <tr>
        <td>unordered_multiset</td><td></td><td></td>
    </tr>	
    <tr>
        <td></td><td>LinkedHashSet</td><td>保持插入顺序，支持查找</td>
    </tr>	
    <tr>
        <td rowspan="6">Map</td><td>map</td><td>TreeMap</td><td></td>
    </tr>	
    <tr>
        <td>multimap</td><td></td><td></td>
    </tr>	
    <tr>
        <td>unordered_map</td><td>HashMap</td><td></td>
    </tr>	
    <tr>
        <td></td><td>HashTable</td><td>=HashMap + (support synchronize)</td>
    </tr>	
    <tr>
        <td>unordered_multimap</td><td></td><td></td>
    </tr>	
    <tr>
        <td></td><td>LinkedHashMap</td><td>保持插入顺序，支持查找</td>
    </tr>
    <tr>
        <td></td><td>bitset</td><td>BitSet</td><td></td>
    </tr>
</table>

## Part 5:  Try and Catch
### Exception

Show Arithmetic Exception

Show Input Mismatch Exception

Show IO Exception

Show Illegal Argument Exception

Self Defining Exception

### file
Open

Reed

Write

## Part 6: Threads (Lecture 10)

Thread

ThreadPool

Priority

Without Sync

		Thread[#99,Thread-78,5,main]     515.91 from 15 to 61    Total Balance:   98636.78
		     168.52 from 12 to 59    Total Balance:   98805.30
		     380.03 from 50 to 34    Total Balance:   99185.34
		     814.66 from 19 to 26    Total Balance:  100000.00
		Thread[#95,Thread-74,5,main]Thread[#77,Thread-56,5,main]Thread[#40,Thread-19,5,main]Thread[#22,Thread-1,5,main]Thread[#87,Thread-66,5,main]Thread[#23,Thread-2,5,main]     371.00 from 45 to 56    Total Balance:   98294.53
		      41.71 from 74 to  8    Total Balance:   98336.25
		Thread[#102,Thread-81,5,main]      25.25 from 69 to 39    Total Balance:   97526.04
		Thread[#122,Thread-94,5,main]      60.88 from 86 to 51    Total Balance:   96778.77
		Thread[#94,Thread-73,5,main]     874.25 from 25 to 86    Total Balance:   97438.07
		     703.37 from 27 to 47    Total Balance:   98141.44
		Thread[#25,Thread-4,5,main]Thread[#127,Thread-99,5,main]     835.46 from 41 to 19    Total Balance:   98066.13
		Thread[#102,Thread-81,5,main]     808.15 from 24 to 78    Total Balance:   98739.60

Data Sync

		Thread[#53,Thread-32,5,main]     330.48 from  0 to  6    Total Balance:  100000.00
		Thread[#84,Thread-63,5,main]      40.41 from  0 to 34    Total Balance:  100000.00
		Thread[#95,Thread-74,5,main]     616.51 from 91 to 55    Total Balance:  100000.00
		Thread[#88,Thread-67,5,main]Thread[#65,Thread-44,5,main]     145.37 from  7 to 81    Total Balance:  100000.00
		Thread[#55,Thread-34,5,main]     304.97 from 36 to 52    Total Balance:  100000.00
		      20.36 from 43 to 93    Total Balance:  100000.00
		Thread[#21,Thread-0,5,main]     298.92 from 15 to 79    Total Balance:  100000.00
		Thread[#61,Thread-40,5,main]     181.16 from  5 to 45    Total Balance:  100000.00
		Thread[#120,Thread-92,5,main]     123.24 from 13 to 78    Total Balance:  100000.00

Method Sync

		Thread[#27,Thread-6,5,main]     305.15 from 89 to 48    Total Balance:  100000.00
		Thread[#25,Thread-4,5,main]     164.55 from 17 to 71    Total Balance:  100000.00
		Thread[#28,Thread-7,5,main]     200.96 from  3 to 22    Total Balance:  100000.00
		Thread[#22,Thread-1,5,main]     804.90 from 11 to 52    Total Balance:  100000.00
		Thread[#28,Thread-7,5,main]      82.65 from 31 to 33    Total Balance:  100000.00
		Thread[#28,Thread-7,5,main]     664.37 from 27 to 39    Total Balance:  100000.00
		Thread[#27,Thread-6,5,main]      48.80 from 51 to 58    Total Balance:  100000.00
		Thread[#24,Thread-3,5,main]     160.49 from 88 to  9    Total Balance:  100000.00
		Thread[#25,Thread-4,5,main]      88.49 from 50 to 25    Total Balance:  100000.00
		Thread[#25,Thread-4,5,main]     680.78 from 86 to 11    Total Balance:  100000.00

Lock

		task 2 about to deposit
		task 3 about to deposit
		task 0 about to deposit
		task 0 completed deposit
		task 1 about to deposit
		task 1 completed deposit
		task 2 completed deposit
		task 3 completed deposit
		What is balance ? 4

Sync collection

		unsyncCollection size is 564: [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6]
		syncCollection size is 600: [1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6, 1, 2, 3, 4, 5, 6]

Sync queue

## Part 7: GUI (Lecture 08, Lecture 09)

![image](https://user-images.githubusercontent.com/85269000/202547150-69c8bd60-2c7d-48b8-9f14-6662ef9f509d.png)

ActionListener; Timer

		Event source: javax.swing.Timer@106a6c13
		Event source: javax.swing.Timer@106a6c13
		Event source: javax.swing.Timer@106a6c13

Toolkit; JOptionPane

![image](https://user-images.githubusercontent.com/85269000/202549971-e7952a7b-f4bb-43c9-93f2-53c1b513fa21.png)

		At the tone, the time is 2022-11-14T18:55:06.058Z
		Interval is 1000
		At the tone, the time is 2022-11-14T18:55:07.059Z
		Interval is 1000


JLable, JTextField, JButton

![image](https://user-images.githubusercontent.com/85269000/202550418-72e1ce12-92df-4220-8c97-edd037f06fd4.png)

JTextArea, JScrollPane

![image](https://user-images.githubusercontent.com/85269000/202551009-3cfc3ccd-3425-4ab3-8ff9-f93d523c6d6c.png)

CaretListener

![image](https://user-images.githubusercontent.com/85269000/202551280-77dde9b1-3d84-4f56-98e1-417340742e3c.png)

JComboBox, JCheckBox, JRadioButton, ButtonGroup 

![image](https://user-images.githubusercontent.com/85269000/202551452-20d5ecd1-8f4f-431c-828e-486d5d632be2.png)

JMenuBar, JMenu, JMenuItem

![image](https://user-images.githubusercontent.com/85269000/202551650-83adfd05-7667-42ec-b39f-5b23eec9f6ba.png)

JSlider

![image](https://user-images.githubusercontent.com/85269000/202551765-721a043d-86bd-43ae-b057-f85ec29e37b2.png)

JPanel, JFrame

![image](https://user-images.githubusercontent.com/85269000/202552137-43771e93-73b1-4dc5-931f-bf6d3ef13d95.png)

![image](https://user-images.githubusercontent.com/85269000/202552543-400ac30e-c1b0-4b99-a30c-78b72a018965.png)

## Part 8: IO Stream (Lecture 11)
## Part 9: Data Base (Lecture 12)
## Part 10: Project (Final Exam)
