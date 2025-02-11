# Java multithreading, concurrency and parallel

### [Inheritance](/br/com/fundamentals/creation/inheritance/ThreadInheritanceMain.java)
To illustrate a case where more than two threads are running, we have created an example with two hacker threads running simultaneously trying to guess the password to a safe. Meanwhile, there is a thread called "police" that counts down to ten seconds. If any hacker thread guesses the password to the safe within those ten seconds, the hackers win, otherwise the police thread catches up to the hackers.

## Daemon threads
background threads that do not prevent the application from existing if the main thread terminates.
If the main thread is terminated, the daemon thread will also be terminated.

## Sincronized - Monitor
It's a "monitor" that avoid a concurrency threads to make changes simultaneously in the same object.
The sincronized works like this:
- Locking mechanism
- Used to restrict access to a critical section or entire method to a single thread at a time