import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * 25. Develop a program to write an array object or class object to a file?
 *     Here we can not use FOS or DOS objects
 *    		Limitation of FOS -> it can write only one byte at a time
 *    		Limitation of DOS -> it can write only one PDT value or one String at a time
 *    	Solution -> we must use ObjectOutputStream (OOS)
 *
 * OOS
 * ===
 *  1. The ObjectOutputStream is an OutputStream type object
 *  2. It is used for saving one object data inside the file
 *  3. It can connect to a file only via FOS object
 *  4. It has a constructor to take OutputStream type object as an argument
 *  		ObjectOutputStream(OutputStream out)
 *
 *  5. We must create object of this class by passing FOS object as argument
 *     to connect to a file for saving given object data inside the file
 *  		OOS oos = new OOS(new FOS("object.ser");
 *
 *  6. Inside OOS class we have a method writeObject() to save object state in a file
 *  		public void writeObject(Object obj)
 *
 *  7. oos.writeObject(obj) method performs serialization
 *
 * Serialization
 * =============
 *  8. The process of 'converting an object into stream of bytes' and
 *     saving object state inside a file permanently is called serialization
 *
 * 			====================================================================
 * 	             JVM, Java program									file
 * 			====================================================================
 * 					Student Object						        object.ser
 *               	  sno
 *               	  sname    ---> oos.wO(s1)---->byte[]--------> byte[]
 *                    course
 *                    fee
 * 			====================================================================
 *
 *  9. The rule in serialization is the object must be serializable type
 *       It means the serializing object's class must implement
 *		 java.io.Serializable interface
 *
 * 10. If this serializing object is not Serializable type, oos.writeObject() method
 *     throws NotSerializableException and terminates serialization.
 *
 *     Saving object data inside a file is not safe operation, because if anyone got
 *     access to serialized file, he can read our object data & we loose security
 *     hence oos.writeObject() throws NSE and saying this object does not have
 *     permissions to save its data in a file
 *
 *	   To provide serializing permission, this object's class must
 *	   implement Serializable interface
 *
 * Serializiable interface
 * ======================
 * 11. The Serializable interface is a 'marker interface', it is an empty interface
 *
 * 12. By implementing Serializable interface, we no need to override any method from
 *      this interface and we no need to develop serialization logic.
 *      The serialization logic is already available in oos.writeObject() method
 *
 * 13. By implementing Serializable interface, we are just providing permission to
 *      oos.writeObject() method to serialize our class object
 *
 * 14. Then oos.writeObject() method converts its argument object state into
 *     stream of bytes and saves this object's state in the file permanently
 *
 * .ser file structure
 * ===================
 * 15. The file that contains an object's serialized data is called serialized file
 *     this file extension is .ser
 *
 * 16. The .ser file must contain object'S information to reconstruct this object
 *     by ois.readObject() method in deserialization process
 *
 * 17. Hence this file contains below 3 information
 *      1. the current object's class name
 *		2. serialVersionUID of this class using which the object is created and serialized
 *      3. each field name, its data type and its value
 *
 */

public class SerializationTest1 {
    public static void main(String[] args) throws FileNotFoundException, IOException {

        //creating student object
        Student s1 = new Student();
        System.out.println(s1);

        //initializing student object
        s1.setSno(101);
        s1.setSname("HK");
        s1.setCourse("FSJD");
        s1.setFee(20000);
        s1.setUsername("hari");
        s1.setPassword("balayya");

        System.out.println(s1); // background toString() Overrided

        //creating OOS object connecting 'object.ser' file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.ser"));

        //writing s1 object state to the file (performing serialization)
        oos.writeObject(s1);  //object -> byte[] -> saving in the file

        System.out.println("student object data is saved");

        oos.close();
    }
}
