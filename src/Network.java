public class Network {
    private boolean netConnection;
    private String connectionAddress;

    public Network(String connectionAddress){
        this.connectionAddress = connectionAddress;
        this.netConnection = true;
    }

    public void setNetConnection(boolean netConnection){
        this.netConnection = netConnection;
    }

    public void getData() throws NetworkStatusException{
        if(this.netConnection == false){
            throw new NetworkStatusException();
        }
    }
}
