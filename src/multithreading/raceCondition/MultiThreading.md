what exactly mean by Race condition?
Race condition means when two threads are trying to access shared resource and because of two threads are updating the value same time
and we will ended up with unpredectible result . that is called race condition

how we can ensure there is no race condition?
by using Synchronized function and Synchronized block we can make only one thread can access that function or block
so we can ensure only one thread will access for that shared resource
apart from synchronized blocks or synchronized function we can create a explicit locks by using reentrantLock
and we can use Concurrents objects like concurrent hash map ,copyOnWriteArrayList
and we can use volatile keyword for the variables

what is semaphores:
semaphores will help us to restrict the number of threads can access a shared resource
with help of semaphore object we can restrict the number of threads can access the sharedResource

what is volatile keyword
basically the Java will run on different CPU cores and when multiple threads are running in multiple CPU cores
if there is any update to the shared resource it will write to local CPU and those changes will not be avaialble
for other CPU cores
volatile is a keyword which will help to ensure always the value will read from main memory and not from local CPU
it will ensure all the threads will have updated value, threads will look for main memory for the value

what is atomic variable in java
when developing multithreaded applicaion there may be instances where you wish to perform an update on a variable
and immediately read the updated value . if we want to perform both of these operations in a atomic manner
where you are able to read your own updates. as we know this can be achieved by locking but however 
it will come at a significant cost in terms of overall performance
if it is a single variable which updated and read the updated value immediately as Atomic. the best solution is make use of 
built in Atomic variables in java


what is the use of synchronized.collection method
this method will help us to allow only one thread to non thread safe collections
same way we have a list specific synchronized method i.e Collections.synchronizedList()

but with Synchronized List when there is frequent write operations the lock will available on complete list and
we will ended up with performance issue and that time we can use copyOnWriteArrayList

what exactly mean by concurrent modification exception
when threads are reading the data from collection and another thread was trying to modify the data we will ended up with concurrent 
modification exception

what is executor service?
Executor service is a interface which will manage Runnable and Callable tasks. simplifies thread management by reusing a
pool of threads instead of creating new ones for each task
executor service will manage the pool of threads , if any free thread will be available it will assign task to the thread
and no free threads are available then 

what is countDownLatch:
CountDownLatch is a Synchnorzation tool which child threads will complete the execution and them selves will synchronize
with the main thread.

why we need executor service even though we have Runnble
basically when we created executor service we will create with fixed number of thread pool. even though in program we created
lot many threads still only fixed executor threads only will run. so it ensure there is no over load on system




