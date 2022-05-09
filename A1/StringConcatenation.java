import java.rmi.*;
public interface StringConcatenation extends Remote{
 String StringConcat(String str1,String str2) throws RemoteException; 
}

