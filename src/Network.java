import java.util.Random;

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

    public void getData() throws NetworkStatusException, InvalidGradeException{
        Random random = new Random();
        int queryRandom = random.nextInt(2);
        if(queryRandom == 1){
            System.out.println("test connection");
        }else{
            throw new InvalidGradeException;
        }
        if(this.netConnection == false){
            throw new NetworkStatusException();
        }
    }
}

