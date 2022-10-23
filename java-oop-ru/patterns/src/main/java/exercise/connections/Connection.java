package exercise.connections;

public interface Connection {

    String getStateName();

    void connect();

    void disconnect();


    void write(String data);
}
