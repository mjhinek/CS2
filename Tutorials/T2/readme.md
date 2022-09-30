### Introduction to Computer Science II
# Tutorial 2

## Objectives  

Building Arrays

---


---   

## Part One : Methods that return an array

In Python, you could easily build a list like `[2,4,6,8]` with the single line

```python
[i*2 for i in range(1,5)]
```

In Java, it is a bit more work. In the provided `Tutorial2.java` file, complete the 
static `makeList(a,b)` method. This method will simulate the Python list `[i for i in range(a,b+1)]`.
For example, 

```java
makeList(1,3) -> [1,2,3]
makeList(5,5) -> [5]
makeList(0,9) -> [0,1,2,3,4,5,6,7,8,9]
```

What is the basic idea for this? You will first need to compute how big the output array should be. Once you allocate memory for this (`new int[size]`) you will then iterate new created array and populate it with the correct values. 

How do we create new arrays in Java?

```java
int[] x = new int[3];         // 3 integers
String[] s = new String[2];   // 2 Strings
```

## Part Two : Methods that return arrays of arrays

When we move from simple arrays to arrays of arrays, it is often difficult when getting started. Remember that when you allocate the memory for an array of arrays, you *must* specify the length of the main array. So, we can create an array as follows

```java
int[][] thing = new int[3][];
```

which will allocate memory for an array of size 3. Inside the array, each element can be an array (of any size). 

In the provided `Tutorial2.java` file, complete the static `makePlot()` method. This method takes in an array of numbers (integers) and creates a new array (of arrays of integers) where each of the original values is replaced with an array of numbers (using the `makeList()` method from above).

Note that the new (returned) array is the same size as the input array. 

Next, complete the `makePlotWithoutZeros()` method, which is essentially the same as `makePlot()` but does not include any of the zero data points. Here, the new (returned) array might be the same size as the input array but it also might be smaller (depending on how many zeros are in the input data).

For example, 

```java
makePLot(new int[]{1,2,3}) -> [ [0,1], [0,1,2], [0,1,2,3] ]
makePLot(new int[]{2,0,5}) -> [ [0,1,2], [0], [0,1,2,3,4,5] ]
```
and

```java
makePlotWithoutZeros(new int[]{1,2,3}) -> [ [0,1], [0,1,2], [0,1,2,3] ]
makePlotWithoutZeros(new int[]{2,0,5}) -> [ [0,1,2], [0,1,2,3,4,5] ]
```





---

## Part Three : User Input

Finish up your Assignment 1!

---

