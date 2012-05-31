package test.nio.example;
public class SocketResponse {
 
     private Session mSession;
     public SocketResponse(Session session) {
         mSession = session;
     }
     
     public void write(String msg) {
         mSession.setSendData(msg);
     }
 }