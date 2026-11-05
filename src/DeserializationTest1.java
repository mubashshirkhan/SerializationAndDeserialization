import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * 26. Develop a program to read object data from the file 
 *
 * De-serialization
 * ================
 * 1. The process of reading object data from the file and 
 *     restoring it in the object inside JVM is called deserialization
 *
 * 2. The deserialization operation is performed by 
 *     ObjectInputStream class readObject() method
 *
 * 3. The ois.readObject() method performs deserialization by following below steps
 * 		1. It reads the class name from the serialized file
 *         and loads this class into the JVM
 *
 * 		2. It compares the serialVersionUID number of this loaded class 
 *         with the serialVersionUID number available in the .ser file
 *
 *      3. If both are not same it throws exception InvalidClassException
 *         and terminates deserialization process
 *
 * 		4. If both values are same, it creates object from this loaded class with 
 *         all non-static fields available in this loaded class
 *
 *      5. It reads field name available in the object, 
 *         searches this field in the .ser file, 
 *             if found, reads its value from the file and stores in this object
 *             if not found, stores default value based on this field type     
 *
 * 4. Rule: To complete deserialization the .class file byte code must be equal to the 
 *    .class file byte code which was used for serialization. After serialization if we 
 *    modify the class either by adding new fields or methods (or) by removing existing fields 
 *    or methods, new serialVersionUID is generated, the deserialization process is failed
 *
 * 5. To continue deserialization even though we add or remove the class members,
 *    we must add serialVersionUID variable in the Student class by ourself
 *
 * 6. Rule: If a class is implementing Serializable interface, this class must contain 
 *    serialVersionUID variable to allow adding or removing members in this class and to continue 
 *    deserialization. If we donot create serialVersionUID variable, no CE, but we will get
 *    exception InvalidClassException during deserizalization if we modify the class after 
 *    serialization.  
 *
 *
 */
public class DeserializationTest1 {
    public static void main(String[] args)
            throws FileNotFoundException, IOException, ClassNotFoundException {

        ObjectInputStream ois =
                new ObjectInputStream(
                        new FileInputStream("object.ser"));

        Object obj = ois.readObject();
        Student st =(Student)obj;
        System.out.println(st);

        //Test case #1:
        //in Student class remove serialVersionUID variable
        //and run this class, O/P: InvalidClassException

        //Test Case #2:
        //in Student class remove serialVersionUID variable
        //run OOS class and then this class, O/P: no exception

        //Test Case #3:
        //in Student class add new field
        //run only this class, O/P: InvalidClassException

    }
}