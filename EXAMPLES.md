# Examples 
Examples of how to use these data structures and algorithms. 

## Data Structures

### Stack 
```Java
Stack<String> stack = new Stack<>();
stack.add("foobar1"); //Add element to stack. 
stack.pop(); //Remove first element from stack. 
int len = stack.length() //Amount of elements in queue. 
```

### Queue
```Java
Stack<String> queue = new Stack<>();
queue.enqueue("foobar1"); //Add to end of queue. 
queue.dequeue(); //Remove first element from queue. 
queue.peek(); //View the first element from the queue.
int len = queue.length(); //Amount of elements in stack. 
```


### Linked List 
```Java
SinglyLinkedList<String> list = new SinglyLinkedList<>();

list.append("foobar"); //Add to linked list.
list.length(); //Find length of linked list
//Loop through the list 
for (String s : list) { 
  System.out.println(s)
}
```


## Sorting Algorithms 

### Bubble Sort
```Java

int[] testData = {5, 4, 1, 2, 3};
BubbleSort.sort(testData); //1,2,3,4,5
```


