# MapReduce
A simple Java Program to show how MapReduce works for large distributed processing

## How it works

In the project, you will find two hosts **host1** and **host2** which each hold a **latencies.txt** file. These hosts should
 demonstrate a
 Distributed System (even though in this project both are on your file system).

```bash
host1
    latencies.txt
host2 
    latencies.txt
```

Each file contains latencies between 1 and 10.000

```bash
#Example of latencies.txt
9848
1306
97
1083
88
10020
877
2062
9330
```

## Result

The result of the **MapReduce** job is to find the latencies **under_1_second** and **over_1_second** respectively.

```python
under_1_second: 204
over_1_second: 1803
```

## Usage

Simple pull the code and run the Main function.

```python
Run Main.main()
```

## Requirements

The requirements for this project are the followings:

- Java 11
- Maven

## License
[MIT](https://choosealicense.com/licenses/mit/)
