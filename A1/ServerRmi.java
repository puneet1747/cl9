import java.rmi.*;
import java.util.*;
public class ServerRmi {
 public static void main(String[] args) {

 Scanner s = new Scanner(System.in);
 try
 {
 StringConcatImp server = new StringConcatImp();
 Naming.rebind("AddServer", server);
 System.out.println("Server Started for RMI services");
 String end = "";
 System.out.println("Enter exit to close server : ");
 end = s.nextLine();

 if(end.equalsIgnoreCase("exit"))
 {
 System.out.println("Server Connection Closed");
 System.exit(0);
 }
 }
 catch (Exception e){
 System.out.println(e);
 }
 finally{
 s.close();
 }
 }
}