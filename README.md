# discrete-data-structures-TI1-HelloKittyInc.
Task and Reminder Management System

Design a task and reminder management system that allows users to add, organize, and manage their pending tasks and reminders. The management system should contain the following components and functionalities:

**Storing Tasks and Reminders:** Use a hash table to store tasks and reminders. The key could be a unique identifier, and the value could be the task/reminder information. Each entry in the hash table could include the following information: title, description, deadline, priority, etc.

**User Interface:** Design a user interface that allows users to add, modify, and delete tasks and reminders. Users can view a list of all tasks and reminders, sorted by deadline or priority. Since tasks and reminders will be in a hash table, add a sorting functionality that utilizes a heapsort.

**Priority Management:** Create two categories for your tasks, "High Priority" and "Low Priority".

**High-Priority Tasks:** Use a priority queue to organize tasks according to their level of importance. When a user adds a new task, it is inserted into the priority queue based on its importance level, allowing important tasks to be handled first.

**Low-Priority Tasks:** A category for non-priority tasks should be created to manage tasks that have not been given priority. This will allow these tasks to be managed according to their order of arrival (FIFO).

Implement a Method to Undo User Actions in the System

To implement a feature that allows users to undo their actions in the system, a stack (LIFO) can be used to track the actions performed. Here’s a general approach to implement the "undo" function in the project:

**Create Action Stack:** First, create a stack to track user actions. Every time a user performs an action (add, modify, or delete a task), log the action in the stack. Each entry in the stack should contain information about the action taken and the details of the affected task.

**Log Actions:** Each time a user performs an action, record the action in the stack. For example, if the user adds a new task, log the action "Add Task" along with the details of the task. If the user modifies a task, log "Modify Task" along with the details before and after the modification.

**Method to Undo:** Implement a method that allows undoing the last action performed by the user. This method should pop the last action from the stack and reverse the corresponding action based on the information stored in the stack.

**Using the Undo Method:** In your user interface, provide users the option to undo the last action performed. When the user selects the "Undo" option, call the undo method. This will reverse the last action performed.

This implementation ensures that users can easily correct mistakes or change their minds about recent changes they have made to their tasks, enhancing user experience and system functionality.
