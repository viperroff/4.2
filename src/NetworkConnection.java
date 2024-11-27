public class NetworkConnection {
    private boolean connectionStatus;

    public NetworkConnection(boolean connectionStatus) throws NetworkStatusException {
        if(connectionStatus == false){
            throw new NetworkStatusException();
        }
        this.connectionStatus = connectionStatus;
    }

    public void SetConnectionStatus(boolean connectionStatus) throws NetworkStatusException{

        if (connectionStatus == false){
            throw new NetworkStatusException("Соединение прервано");
        }
        this.connectionStatus = connectionStatus;
    }


}
