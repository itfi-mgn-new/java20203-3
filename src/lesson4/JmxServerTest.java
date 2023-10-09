package lesson4;

import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

public class JmxServerTest {
	public static void main(String[] args) throws IOException {
		try {
		    final ObjectName 	objectName = new ObjectName("jmx.example:type=basic,name=test");
		    final MBeanServer 	server = ManagementFactory.getPlatformMBeanServer();
		    
		    server.registerMBean(new JmxExample(), objectName);
		
		    System.err.println("Type enter to terminate");
		    System.in.read();
		    
		    server.unregisterMBean(objectName);		    
		    System.err.println("Exit");
		} catch (MalformedObjectNameException | InstanceAlreadyExistsException | MBeanRegistrationException | NotCompliantMBeanException | InstanceNotFoundException e) {
		    e.printStackTrace();
		}
	}
}
