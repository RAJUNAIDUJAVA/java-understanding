package Exception;

public class DataSource implements AutoCloseable{
    @Override
    public void close() throws Exception {
        System.out.println("close the connection");
    }
}
