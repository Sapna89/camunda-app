package com.workflow.camunda.bpmn.notes;

/*

    Service Task with connector implementation(also known as REST from BPMN)

    Note: attows -> in BPMN are called Sequence Flow. Connector between two elements of a Process.

    Outgoing and incoming sequesnce flow

    a task/element can have multiple path of execution

    A Conditional Sequence Flow: the condition in the sequence flow.
    1. using script
            var result = false;
            if (numberOfCoins == 4) {
            result = true;
            }
            result;

    2. using expression
            ${numberOfCoins == 4}

    Default sequence flow is like else case in java.
*/

import org.camunda.bpm.model.bpmn.instance.Gateway;

public class CamundaBPMNNotes {

    /*
    Gateway: Exclusive Gateway:-
    ==========================

    Gateway is a component that controls the flow of execution in a process.

    Types of Gateway:
    Exclusive Gateway: only one path of execution is possible based on a condition.

    Execution of path: if multiple sequence pf path is true then the first one that
    comes in xml is execution. if none of it is tue and if default flow is not present,
    then that will lead to a run time exception.


    Exception:
    ---------
    2025-07-10T12:39:51.461-04:00 ERROR 3766 --- [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.camunda.bpm.engine.ProcessEngineException: ENGINE-02004 No outgoing sequence flow for the element with id 'Gateway_0mxvnjg' could be selected for continuing the process.] with root cause

org.camunda.bpm.engine.ProcessEngineException: ENGINE-02004 No outgoing sequence flow for the element with id 'Gateway_0mxvnjg' could be selected for continuing the process.
	at org.camunda.bpm.engine.impl.bpmn.behavior.BpmnBehaviorLogger.stuckExecutionException(BpmnBehaviorLogger.java:52) ~[camunda-engine-7.23.0.jar:7.23.0]
	at org.camunda.bpm.engine.impl.bpmn.behavior.ExclusiveGatewayActivityBehavior.doLeave(ExclusiveGatewayActivityBehavior.java:84) ~[camunda-engine-7.23.0.jar:7.23.0]


    Note:
    1. Diverging exclusive gateway: pathway will split into multiple pathways
    2. Converging exclusive gateway: paths will come together and connect to this exclusive gateway.

    */


    /*
    *   Parallel gateway:
    * ====================
    *
    * Diverging Parallel gateway:
    * --------------------------
    * This gateway is used to bring concurrency in the process model.
    * it is used to execute all outgoing flows without any condition.
    *
    *
    * Converging Parallel gateway:
    * ---------------------------
    * it waits for both the tasks to complete to continue.
    *
    *
    *
    * Inclusive Gateway:
    * =================
    *
    * Its a combination of Exclusive and Parallel gateways.
    * It can have conditions for outgoing flow which are evaluated.
    * All those contitions which evaluate to true are executed in parallel.
    *
    * Note: if default path is not provided below error will be thrown:-
    *
    * 2025-07-15T18:17:20.876-04:00 ERROR 10534 --- [nio-8080-exec-1] org.camunda.bpm.engine.context           : ENGINE-16004 Exception while closing command context: ENGINE-02004 No outgoing sequence flow for the element with id 'Gateway_0gqst69' could be selected for continuing the process.

org.camunda.bpm.engine.ProcessEngineException: ENGINE-02004 No outgoing sequence flow for the element with id 'Gateway_0gqst69' could be selected for continuing the process.
	at org.camunda.bpm.engine.impl.bpmn.behavior.BpmnBehaviorLogger.stuckExecutionException(BpmnBehaviorLogger.java:52) ~[camunda-engine-7.23.0.jar:7.23.0]

    * to resolve this error: lets create a default flow:
    * 1. we can create a default task box [rectangular box]
    *         -----OR--------
    * 2. We can create a default flow [an arrow --->]
    *
    */



    /*
    * Sub Process
    * ===========
    *
    * 1. It allows us to reuse the code
    * 2. it allows us to group the code
    *
    *
    * Call Activity Sub-Process
    * -------------------------
    *
    * 1. references to a process that is external to the process defenition
    * 2. the main use case is to have a reusable process definition that can be called from multiple other process definitions.
    *
    * Note: in the variables tab of the call-activity task we have
    * In mapping: all the variables in parent process is accessible by sub process
    * Out mapping: all the variables in the chile/sub process is accessible by parent process.
    *
    *
    * Embedded Sub-Process
    * --------------------
    * 1. It is defined inside the parent process.
    * 2. Can contain other tasks, gateways etc.
    *
    */

  // **************************************************************************************************************************

  /*
  *               DMN
  *               ---
  *
  * DMN: Decision Model and Notation
  * ================================
  *
  * It is a standard for Business Decision Management
  *
  * Decision Table
  * ==============
  * Represents a decision logic as a table.
  * It consists of Inputs, Outputs and Rules.
  *
  *
  * Hit Policy
  * ----------
  * hit policy specifies the result of evaluation of Decision Table.
  *
  * 1. Unique Hit Policy:
  *    only a single rule can be satisfied or no rule at all.
  *    if more than one rule is satisfied, then this policy is violated and throws error.
  *    o/p is the output entry of the satisfied rule.
  *
  * 2. Any Hit Policy:
  *    Multiple rules can be satisfied.
  *    All satisfied rules must generate same output.
  *    If multiple rules are satisfied that generate different outputs, then this policy is violated.
  *
  * 3. First Hit Policy:
  *    Multiple rules can be satisfied.
  *    All satisfied rules can generate same or different output.
  *    Output of Decision Table will be the output entries of first satisfied rule.
  *
  *    4. Rule Order Hit Policy:
  *    Multiple rules can be satisfied.
  *    All satisfied rules can generate same or different output.
  *    Output of Decision Table will be the output entries of all satisfied rule
  *     in the order of the rules defined.
  *
  *    By using the same DMN as First Hit Policy and in .bpmn file where this dmn is
  *     called I used ResultList type for the output and got the below
  *     Output: subjectAttributesObj is :: [{subjectTeacherId=15, subjectTeacherName=Sapna Naveen, subjectDisplayName=Mts, subjectCode=M4}, {subjectTeacherId=10, subjectTeacherName=Naveen, subjectDisplayName=Mts, subjectCode=M92}]
  *             SubjectObj after assigning attributes :: {"id":2,"name":"Maths"} //as its a list I have to iterate over the list.
  *
  *     But Lets see what this couch will teach us.????????
  *
  *    5. Collect Hit Policy
  *    Multiple rules can be satisfied.
  *    Output of Decision Table will be the output entries of all
  *     satisfied rules in an arbitrary order as a list.(order is not guaranteed)
  *
  * **********************************************************************************
  *
  *     Types of Multi-instance
  * =================================
  *
  * 1. Sequential Multi-instance: iterations happens sequentially.
  * 2. Parallel Multi-instance: Executes multiple instances of tasks in parallel.
  *
  * Script Task with multi-instance
  *
  *===============================================================================
  *
  * Note: we cant interate a JSON array directly in a BPMN, we have to use something called spinList.
  * Converting JSON array to Spinlist is super easy: with the help of the pom.xml dependency --> camunda-engine-plugin-spin.
  *
  * it involves 3 steps:
  *
  * |-----------| S() method is the spin method             |-----------------|                         |-----------|
  * |JSON Array |------------------------------------------>|Jacson JSON Node |------------------------>| Spin List |
  * |-----------| convert json to -> S(<Stringified JSON>)  |-----------------| and then to .elements() |-----------|
  *
  *
  */




}
