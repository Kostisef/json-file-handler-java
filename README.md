# JAVA: Read/Write JSON files (or other types)


### FileHandler.java
````
Contains all the function to read/write simple files (e.x. .txt or .dat)
````
### JSONHandler.java
````
Contains all the functions to handle properly the JSON reading and writing
````
### Student.java
````
Contains the Student class for the JSON example
````
### Main.java
````
the main method
````

## Prerequisites
To use this package you need to have:

* JSON in Java [package org.json] (v.20210307) (https://github.com/stleary/JSON-java), as external library to your project
* JAVA Project SDK: openjdk-17 (17 - Sealed types, always-strict floating-point semantics)


## JSON example
````
{
  "STUDENTS": [
    {
      "Courses": [
        "Applications of TinyML",
        "JavaScript",
        "Algorithms"
      ],
      "Age":     55,
      "Name":    "John Doe"
    },
    {
      "Courses": [
        "Introduction to Computer Science",
        "Big Data Systems",
        "Dynamic Web Applications"
      ],
      "Age":     25,
      "Name":    "Adison Lee"
    },
    {
      "Courses": [
        "Data Science: Machine Learning",
        "Fundamentals of TinyML",
        "Deploying TinyML"
      ],
      "Age":     38,
      "Name":    "Lucy Hinton"
    }
  ]
}
````
