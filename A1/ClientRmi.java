import java.rmi.*;
import java.util.*;
public class ClientRmi {
 public static void main(String[] args) {
 Scanner s = new Scanner(System.in);
 try {
 String serverurl = "rmi://127.0.0.1/AddServer";
 StringConcatenation remoteObject = (StringConcatenation)Naming.lookup(serverurl);
 while (true) {

 System.out.println("ENTER STRING 1: ");
 String str1 = s.nextLine();
 String temp = str1.toLowerCase();
 if(temp.equals("exit"))
 {
 break;
 }
 System.out.println("ENTER STRING 2: ");
 String str2 = s.nextLine();
 System.out.println("CONCATENATED STRING RECIEVED : " +
remoteObject.StringConcat(str1, str2));
 }
 } catch (Exception e) {
 System.out.println(e);
 }
 finally {
 s.close();
 }
 }
}