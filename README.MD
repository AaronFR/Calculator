## Java Calculator

#### Primary Goals
- Study of using Regex expressions and character replacement in Java
- Using Try-Catches to create a robust program
- Integrate direcltly with git through VSC (for frequent commiting)


#### Functionality
- Addition `+`
- Subtraction `-`
- Multiplication `*`
- Division `/`
- Exponentaion `^`
- Derivatives `d/dx ax^n` 
    - where x is any string, a and n are digits

Instead of Bemdas (or similar) calculations are done left to right.
Supports multiple operations simultaneously.
Eg dividing an exponent before adding this sum.
All numbers are represented as doubles.

To exit enter `quit`.


### Examples
Method | Result 
--- | ---
10 + 10 | 20.0
5 - 8 | -3.0
10^2^2 | 10000.0
7 / 2 | 3.5
5+10-2*7/3^1.5 | 167.063...
d/dx 4x^2 | 8.0x^1.0
d/dVolume 2Volume^3 | 6.0Volume^2.0


#### Features that could be developed
- Full error catching, fails if d/d is entered for derivative on its own or if a string of random characters are added
- Divide by negative numbers
- Take negative powers
- Bug: exponenting a negative number act like subtraction
