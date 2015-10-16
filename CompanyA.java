import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

public class MultithreadingDemo 
{
	
   public static void main(String args[]) throws Throwable  
   {
	   InetAddress ip;
		try {
				
			ip = InetAddress.getLocalHost();
			System.out.println("Current IP address : " + ip.getHostAddress());
			NetworkInterface network = NetworkInterface.getByInetAddress(ip);
				
			byte[] mac = network.getHardwareAddress();
				
			System.out.print("Current MAC address : ");
				
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < mac.length; i++) {
				sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));		
			}
			System.out.println(sb.toString());
				
		} catch (UnknownHostException e) {
			
			e.printStackTrace();
			
		} catch (SocketException e){
				
			e.printStackTrace();
				
		}
      new MultithreadingDemo().myfunc();
   }

   void myfunc() throws Throwable
   {
      for (int i=0; i<5; i++) {
         System.out.println("thread "
            +Thread.currentThread().getName()+" step "+i);
         Thread.sleep(500);
      }
   }
}
