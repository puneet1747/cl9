import java.rmi.*;
import java.rmi.server.*;
public class StringConcatImp extends UnicastRemoteObject implements StringConcatenation {

 public StringConcatImp() throws RemoteException {
 super();
 }
 public String StringConcat(String str1,String str2) throws RemoteException {
 String msg;
 msg = str1 + str2;
 return msg;
 }
}
