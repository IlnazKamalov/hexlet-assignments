package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

import java.util.ArrayList;
import java.util.List;

public class TcpConnection {

    private String ip;
    private int port;
    private Connection state;
    List<String> list = new ArrayList<>();

    TcpConnection(String ip, int port) {
        this.port = port;
        this.ip = ip;
        this.state = new Disconnected(this);
    }

    public String getCurrentState() {
        return this.state.getStateName();
    }

    public Connection getCurrentState1() {
        return state;
    }

    public void write(String data) {
        this.getCurrentState1().write(data);
    }

    public void connect() {
        state.connect();
    }

    public void disconnect() {
        this.state = new Disconnected(this);
        this.state.disconnect();
    }

    public void setState(Connection state) {
        this.state = state;
    }

    public void addToBufferList(String data) {
        list.add(data);
    }
}
