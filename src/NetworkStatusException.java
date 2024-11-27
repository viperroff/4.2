public class NetworkStatusException extends Exception {

    public NetworkStatusException(){
        super();
    }

    public NetworkStatusException(String message) {
        super(message);
    }

    public NetworkStatusException(Throwable cause){
        super(cause);
    }

    public NetworkStatusException(String message, Throwable cause){
        super(message, cause);
    }

}
