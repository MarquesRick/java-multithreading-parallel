# Java multithreading, concurrency and parallel

### [Inheritance](/src/main/java/thread/fundamentals/creation/inheritance/ThreadInheritanceMain.java)
To illustrate a case where more than two threads are running, we have created an example with two hacker threads running simultaneously trying to guess the password to a safe. Meanwhile, there is a thread called "police" that counts down to ten seconds. If any hacker thread guesses the password to the safe within those ten seconds, the hackers win, otherwise the police thread catches up to the hackers. 