what is the difference between Streams and parallel streams
while coming to the Streams the elements will process in sequential manner 
while coming to the Parallel strams the data splits into chunks and will process them concurrently across the multiple
threads using forkjoinpool
Parallel streams aim to reduce execution time by utilizing multiple cores .however they introduce overhead (thread management,
splitting,merging), so they aren't always faster
streams are useful for smaller datasets and parllel streams are good for larger datasets like million of records
some times when we are using parallel streams for smaller datasets it will reduce the performance of the application.so we need to be ensure that
while using parllel streams never mutate shared variable inside parllel streams
List<Integer> result = new ArrayList<>();
numbers.parallelStream().forEach(result::add) //this is the bug

what is the difference between forEach and forEachOrdered?
forEachOrdered will preserve encounter order in parallel streams


what is the difference between map and flat map
map will help us process the list of elements and flat map will help to process the nested list of elements including the list
and will flaten the result.
map transforms each elemets into another object 
flatmap will transform each element into a stream of objects and flatten the results

