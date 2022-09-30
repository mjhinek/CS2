### Introduction to Computer Science II
# Tutorial 3

## Objectives  

Using Java classes. String formatting : String and StringBuilder classes. Input using Scanner. 

---

In this tutorial, there will be a short quiz in Brightspace to complete. The quiz will open on Wednesday and you will have a few days to complete it. You will have two chances to write the quiz (and the higher grade will be recorded). 

---   

## Part One : String Formatting

Compare the following output of two Java methods (displaying the same information).

```java
price     price with taxes   
---------------------------
  1.01        12.1
.022     13.1000000021
-0.03        -1.2
1003.01      3316.222
 -20.02    -2.002e1
```

```java
   price    price with taxes   
------------------------------
   1.010          12.10
   0.022          13.10
  -0.030          -1.20
1003.010        3316.22
 -20.020         -20.02
```

It can be argued that the second table is more readable than the first. The numbers appear in columns that are formatted nicely. 

There are different ways that we can format strings in Java. We'll look at the `String.format()` method in this course. This is a _static_ method in the `String` class that creates a new string with a specified formatting. 

The `String.format()` method takes a string that we want to format and one or more values (of any type) as input. The `format()` method embeds the values into the input string subject to any specifications given. For example, 

```java
int x = 12;
String s1 = String.format("here is an integer : %d", x);
```
will take the string `"here is an integer : %d"` and replace `%d` with the value specified in `x`. The `%d` indicates that the value will be an integer. While, 

```java
double y = Math.sin(Math.PI*0.176);
String s2 = String.format("here is a floating point number : %f", y);
```

will take the string `"here is a floating point number : %f"` and replaces `%f` with the value in `y`. The `%f` denotes that the value is a floating pointing point number. 

What is more useful, though, is embedding more than one value into the string and/or adding formatting flags so that we can do things alight text, add leading zeroes to numbers, specify the number of decimal digits, etc. 

Here are some examples for integer formatting. We can specify a minimum width of characters that the embedded value will occupy.
```java
String.format("%10d", 12)  --> "        12" right-justified, min-len 10 
String.format("%08d", 12)  --> "00000012"   right-justified, min-len 8, leading 0s
String.format("%-9d", 12)  --> "12       "  left-justified, min-len 9
```
Any other characters in the input string are also included. 
```java
String.format("The time was #%10d! seconds", 12)  
   --> "The time was #       12! seconds" 
```

For floating point numbers, we can specify the minimum width of the embedded value, the number of decimal places to use, adding leading zeros, etc.
```java
String.format("%10.2f", 12.3)  --> "     12.30" right-justified, 
                                                min length 10, 2 decimal places
String.format("%+10.2f", 12.3) --> "    +12.30" as above but include sign + or -
String.format("%010.2f", 12.3) --> "0000012.30" leading zeros
String.format("%-10.4f", 12.3) --> "12.3000   " left-justified, 4 decimal places

String.format("%,5.2f", 123456789.8) -->  "123,456,789.80" add commas to big numbers
String.format("%,5.2f", 9.8651) -->  " 9.87" ROUNDS to correct decimal places
```
Notice that in the last two examples, the strings are longer than 5 characters. Remember that the width specified is a _minimum_ width. It will use more if needed. 

For strings, we can set minimum lengths, left and right justify text and conver to upper-case. 
```java
String.format("%5s", "hi!")     -->  "  hi!" right-justified, min length 5
String.format("%-5s", "hi!")    -->  "hi!  " left-justified, min length 5
String.format("%S", "hello123") -->  "HELLO123" convert lower-case letters to upper-case
```

Now, let's put it all together. You can embed multiple values into a string. You list them at the end in the same order as they appear. You have to make sure you have the correct number of values and that the data types match their corresponding `%` embedding.

```java
String.format("Listening to %S's talk cost $%,.2f dollars", "Cat", 17.7150001)
 -->  "Listening to CAT's talk cost $17.71 dollars"
```
In this example, it expects a string first and then a floating point number.  

There is much more you can do with String formatting. **Chapter 1.5** of the course textbook gives more explanation and examples. 

**Read** and then **modify** the `stringFormatting()` method in the provided `T3.java` file so that the output looks like a table like the following... (only the first 4 data lines are shown)

```
+----------+------+---------+
|   name   | age  | value   |
+----------+------+---------+
|    Marwa | 321  | -00.969 |
|    Aidan | 265  | +02.478 |
|  Camilla | 1041 | +18.937 |
|    Hamda | 1748 | -22.350 |
.      .       .      .     .
.      .       .      .     .
.      .       .      .     .
+----------+------+---------+
```

Note that ll names are right-justified, all ages are left justified, all values have 3 decimal places, have 2 digits before the decimal with leading zeroes if needed and sign, and there is one space around each pipe `|`. 

Be sure that you understand what the code is doing before you modify it. You may want to read up on Java's `Random` class for this. 

https://docs.oracle.com/en/java/javase/18/docs/api/java.base/java/util/Random.html

---

## Part Two : Building up strings

Strings in Java are **immutable** sequences of Unicode characters. (This is what strings were in Python as well). You can concatenate two strings with the plus operator (`+`) to create a new string. For example, `String s = "a" + "b"` is the concatenation of the string `"a"` and `"b"` and will create the new string `"ab"`. Each time you concatenate strings, you are _creating_ a new string object. Consider the following code

```java
String s = "";
for(int i=0; i<1000; i+=1){
    s = s + String.valueOf(i); 
    // or s += String.valueOf(i);
    // or s += i; (it will automatically convert i to a string)
}
```
This will create many new strings ("1", "12", "123", ..., "123....998999") and it takes time to create each one. If you find that you are using concatenation often to build up your strings, then you are wasting time. There is a better way! 

Java's `StringBuilder` is a class that for **mutable** strings. To create the same string as above, using a `StringBuilder`, you would use

```java
StringBuilder sb = new StringBuilder("");  // begin with the empty string
for(int i=0; i<1000; i+=1){
    sb.append(String.valueOf(i));
}
String s = sb.toString(); // convert to String object
```
Here, we create only TWO objects! This is more efficient. (Although, several more objects may be 
created along the way as the StringBuilder grows... but not nearly as many using just Strings.)

Run the provided `StringBuildingExample.java` program. The program will generate a string in two ways; one using a `StringBuilder` and one using a `String` with repeated concatenation. You can vary the size of the string by passing in a command line argument (or change the value and recompile). Run the program for different size value (10, 100, 1000, 10000, 25000, 50000, 100000, etc).


---

## Part Three : User Input

Java's `Scanner` class allows you to parse strings. The string that we parse might be a string literal (a hard-coded sequence of characters between double-quotes, like "cat is not dog"), the contents of a file, or input from `System.in` (standard input stream). 

When reading from the standard input stream (a user's keyboard input), each time a user enters data and hits `enter`, all the characters are stored in a memory buffer that the Scanner object will use to parse. Suppose the user enter "cat is dog" (without quotes) and hits enter. The buffer will store the string

```java
"cat is dog\n"
```

The `nextLine()` method would read read and return everything up to but not including the newline character. So, nextLine() would return "cat is dog" and the memory buffer would be empty (it would throw away the newline)

Let's start with `"cat is dog\n"` again.

The `next()` method will grab the next token: it skips leading whitespace (space, newlines, tabs) and gets all characters until whitespace is encountered again. So, it would return "cat" and the buffer would now be " is dog\n". Calling `next()` again would return "is", leaving the buffer as " dog\n". Calling `next()` again will return "dog", leaving "\n" in the buffer. If we happen to call `nextLine()` next, it will read everything up to the next newline, and then throw away the newline. So, it would return "" and the buffer would be empty. 

Note then when you ask a Scanner object (reading from System.in), if there is anything in the buffer, it won't ask the user for more input. If the buffer is empty, then the program waits for the user to enter more data and it enter (moving the data to the memory buffer of the Scanner object). 

The `nextInt()`, `nextDouble`, etc., methods are similar to the `next()` method in that they grab the next token and leave the remaining characters in the buffer (without throwing out an ending newline), whereas `nextLine()` will throw out the ending newline. 

It is _recommended_ that you use `nextLine()` and simply `split` your string to separate out different things (further parsing). Using a combination of `next()`, `nextLine()` and any of the `nextInt()` (ect) methods can be **very tricky** and lead to lots of frustration. 

Question: why is using `nextLine()` and then `split`ting the resulting string preferred over using `next()` multiple times? Can you provide a short example to illustrate your answer?

---

In this tutorial, you will not be submitting any code to Brightspace. Instead, there will be a short quiz to complete for your grade. You will a couple of days to complete it and you will have two chances to write the quiz (before the deadline). 
