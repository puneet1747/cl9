import URLReaderApp.*;
//import org.omg.*;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import java.util.*;

public class StartClient {
    public static void main(String args[]) {
        try {
            ORB orb = ORB.init(args, null);
            org.omg.CORBA.Object objref = orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objref);
            URLReader urlobj = URLReaderHelper.narrow(ncRef.resolve_str("ABC"));
            Scanner s = new Scanner(System.in);
            while (true) {
                System.out.println("Enter url:");
                String surl = s.nextLine();
                int len = urlobj.urlbytes(surl);
                System.out.println("Bytes got are url:" + len);
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
/*
1321  idlj -fall urlreader.idl
 1322  orbd -ORBInitialPort 1050&
 1323  javac *.java URLReaderApp/*.java
 1324  orbd -ORBInitialPort 1050&
 1325  clear
 1326  orbd -ORBInitialPort 1050&
 1327  clear
 1328  java StartServer -ORBInitialPort 1050& -ORBInitialHost localhost&
 1329  java StartClient -ORBInitialPort 1050 -ORBInitialHost localhost\n
*/
