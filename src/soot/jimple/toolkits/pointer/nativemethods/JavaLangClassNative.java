/**
 * Simulates the native method side effects in class java.lang.Class
 *
 * @author Feng Qian
 * @author <XXX>
 */

package soot.jimple.toolkits.pointer.nativemethods;

import soot.*;
import soot.jimple.toolkits.pointer.representations.*;
import soot.jimple.toolkits.pointer.util.*;

public class JavaLangClassNative extends NativeMethodClass {

  private static JavaLangClassNative instance =
    new JavaLangClassNative();

  private JavaLangClassNative(){}

  public static JavaLangClassNative v() { return instance; }

  /**
   * Implements the abstract method simulateMethod.
   * It distributes the request to the corresponding methods 
   * by signatures.
   */
  public void simulateMethod(SootMethod method,
			     ReferenceVariable thisVar,
			     ReferenceVariable returnVar,
			     ReferenceVariable params[]){

    String subSignature = method.getSubSignature();

    if (subSignature.equals("java.lang.Class forName0(java.lang.String,boolean,java.lang.ClassLoader)")) {
      java_lang_Class_forName0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Object newInstance0()")) {
      java_lang_Class_newInstance0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.String getName()")) {
      java_lang_Class_getName(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.ClassLoader getClassLoader0()")){
      java_lang_Class_getClassLoader0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Class getSuperclass()")) {
      java_lang_Class_getSuperclass(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Class[] getInterfaces()")){
      java_lang_Class_getInterfaces(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Class getComponentType()")){
      java_lang_Class_getComponentType(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Object[] getSigners()")){
      java_lang_Class_getSigners(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("void setSigners(java.lang.Object[])")) {
      java_lang_Class_setSigners(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Class getDeclaringClass()")){
      java_lang_Class_getDeclaringClass(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("void setProtectionDomain0(java.security.ProtectionDomain)")){
      java_lang_Class_setProtectionDomain0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.security.ProtectionDomain getProtectionDomain0()")) {
      java_lang_Class_getProtectionDomain0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.Class getPrimitiveClass(java.lang.String)")) {
      java_lang_Class_getPrimitiveClass(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.reflect.Field[] getFields0()")){
      java_lang_Class_getFields0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.reflect.Method[] getMethods0()")){
      java_lang_Class_getMethods0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.reflect.Constructor[] getConstructors0(int)")) {
      java_lang_Class_getConstructors0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.reflect.Field getField0(java.lang.String,int)")) {
      java_lang_Class_getField0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.reflect.Method getMethod0(java.lang.String,java.lang.Class[],int)")) {
      java_lang_Class_getMethod0(method, thisVar, returnVar, params);
      return;

    } else if (subSignature.equals("java.lang.reflect.Constructor getConstructor0(java.lang.Class[],int)")) {
      java_lang_Class_getConstructor0(method, thisVar, returnVar, params);
      return;
   
    } else if (subSignature.equals("java.lang.Class[] getDeclaredClasses0()")){
      java_lang_Class_getDeclaredClasses0(method, thisVar, returnVar, params);
      return;

    } else {
      defaultMethod(method, thisVar, returnVar, params);
      return;

    }
  }

  /****************************** java.lang.Class **********************/
  /* A quick note for simulating java.lang.Class :
   *
   * In theory, the same class may have two or more representations 
   * at the runtime. But statically, we can assume that all variables
   * of java.lang.Class type are aliased together. By looking at
   * static class hierarchy, there is only one ReferenceVariable 
   * variable for a class in the hierarchy.
   */

  /**
   * NOTE: the semantic of forName0 follows forName method.  
   * 
   * Returns the Class object associated with the class or interface
   * with the given string name, using the given class loader. Given
   * the fully qualified name for a class or interface (in the same
   * format returned by getName) this method attempts to locate,
   * load, and link the class or interface. The specified class
   * loader is used to load the class or interface. If the parameter
   * loader is null, the class is loaded through the bootstrap class
   * loader. The class is initialized only if the initialize
   * parameter is true and if it has not been initialized earlier.
   *
   * If name denotes a primitive type or void, an attempt will be made
   * to locate a user-defined class in the unnamed package whose
   * name is name. Therefore, this method cannot be used to obtain
   * any of the Class objects representing primitive types or void.
   * 
   * If name denotes an array class, the component type of the array
   * class is loaded but not initialized.
   *
   * For example, in an instance method the expression: 
   *       Class.forName("Foo")       
   * is equivalent to: 
   *       Class.forName("Foo", true, this.getClass().getClassLoader()) 
   *
   * private static native java.lang.Class forName0(java.lang.String, 
   *                                                boolean, 
   *                                                java.lang.ClassLoader) 
   *                                throws java.lang.ClassNotFoundException;
   */
  public static void java_lang_Class_forName0(SootMethod method,
					      ReferenceVariable thisVar,
					      ReferenceVariable returnVar,
					      ReferenceVariable params[]){
    NativeHelper.assignObjectTo(returnVar, Environment.getClassObject());
  }

  /**
   * NOTE: creates an object.
   *
   * private native java.lang.Object newInstance0() 
   *           throws java.lang.InstantiationException, 
   *                  java.lang.IllegalAccessException
   */
  public static void java_lang_Class_newInstance0(SootMethod method,
						  ReferenceVariable thisVar,
						  ReferenceVariable returnVar,
						  ReferenceVariable params[]){
    ReferenceVariable instanceVar = NativeHelper.newInstanceOf(thisVar);
    NativeHelper.assign(returnVar, instanceVar);
  }

  /**
   * Returns the class name.
   *
   * public native java.lang.String getName();
   */
  public static void java_lang_Class_getName(SootMethod method,
					     ReferenceVariable thisVar,
					     ReferenceVariable returnVar,
					     ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getStringObject());
  }

  /**
   * returns the class loader object for this class.
   * 
   * it is almost impossible to distinguish the dynamic class loader
   * for classes. a conservative way is to use one static representation
   * for all class loader, which means all class loader variable aliased
   * together.
   *
   * private native java.lang.ClassLoader getClassLoader0();
   */
  public static 
    void java_lang_Class_getClassLoader0(SootMethod method,
					 ReferenceVariable thisVar,
					 ReferenceVariable returnVar,
					 ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getClassLoaderObject());
  }

  /**
   * returns the super class of this class
   *
   * public native java.lang.Class getSuperclass();
   */
  public static 
    void java_lang_Class_getSuperclass(SootMethod method,
				       ReferenceVariable thisVar,
				       ReferenceVariable returnVar,
				       ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getClassObject());
  }

  /**
   * Determines the interfaces implemented by the class or interface
   * represented by this object.
   *
   * public native java.lang.Class getInterfaces()[];
   */
  public static 
    void java_lang_Class_getInterfaces(SootMethod method,
				       ReferenceVariable thisVar,
				       ReferenceVariable returnVar,
				       ReferenceVariable params[]) {
    /* currently, we do not distinguish array object and scalar object.*/
    NativeHelper.assignObjectTo(returnVar, Environment.getClassObject());
  }

  /**
   * Returns the Class representing the component type of an array. If
   * this class does not represent an array class this method returns
   * null.  
   *
   *     public native java.lang.Class getComponentType();
   */
  public static 
    void java_lang_Class_getComponentType(SootMethod method,
					  ReferenceVariable thisVar,
					  ReferenceVariable returnVar,
					  ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getClassObject());
  }

  /**
   * Sets the signers of a class. This should be called after defining a
   * class.  Parameters: 
   *           c - the Class object 
   *     signers - the signers for the class
   *
   *     native void setSigners(java.lang.Object[]); 
   */
  public static 
    void java_lang_Class_setSigners(SootMethod method,
				    ReferenceVariable thisVar,
				    ReferenceVariable returnVar,
				    ReferenceVariable params[]) {
    ReferenceVariable tempFld = 
      NativeHelper.tempField("<java.lang.Class signers>");
    NativeHelper.assign(tempFld, params[0]);
  }

  /**
   * Gets the signers of this class.
   * We need an artificial field variable to connect setSigners 
   * and getSigners.
   *
   *     public native java.lang.Object getSigners()[];
   */
  public static 
    void java_lang_Class_getSigners(SootMethod method,
				    ReferenceVariable thisVar,
				    ReferenceVariable returnVar,
				    ReferenceVariable params[]) {
    ReferenceVariable tempFld = 
      NativeHelper.tempField("<java.lang.Class signers>");
    NativeHelper.assign(returnVar, tempFld);
  }

  /**
   * If the class or interface represented by this Class object is a
   * member of another class, returns the Class object representing the
   * class in which it was declared. This method returns null if this
   * class or interface is not a member of any other class. If this
   * Class object represents an array class, a primitive type, or
   * void,then this method returns null.
   *
   *  Returns:
   *      the declaring class for this class
   *
   *     public native java.lang.Class getDeclaringClass(); 
   */
  public static 
    void java_lang_Class_getDeclaringClass(SootMethod method,
					   ReferenceVariable thisVar,
					   ReferenceVariable returnVar,
					   ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getClassObject());
  }

  /**
   * Sets or returns the ProtectionDomain of this class,
   * called by getProtectiondomain.
   * 
   * We need an artificial field variable to handle this.
   *
   *     native void setProtectionDomain0(java.security.ProtectionDomain);
   */
  public static 
    void java_lang_Class_setProtectionDomain0(SootMethod method,
					      ReferenceVariable thisVar,
					      ReferenceVariable returnVar,
					      ReferenceVariable params[]) {
    ReferenceVariable protdmn = 
      NativeHelper.tempField("<java.lang.Class ProtDmn>");
    NativeHelper.assign(protdmn, params[0]);
  } 

  /**
   *     private native java.security.ProtectionDomain getProtectionDomain0();
   */
  public static 
    void java_lang_Class_getProtectionDomain0(SootMethod method,
					      ReferenceVariable thisVar,
					      ReferenceVariable returnVar,
					      ReferenceVariable params[]) {
    ReferenceVariable protdmn = 
      NativeHelper.tempField("<java.lang.Class ProtDmn>");
    NativeHelper.assign(returnVar, protdmn);
  }

  /**
   * Undocumented. It is supposed to return a class object for primitive
   * type named by @param0.
   * 
   *     static native java.lang.Class getPrimitiveClass(java.lang.String);
   */
  public static 
    void java_lang_Class_getPrimitiveClass(SootMethod method,
					   ReferenceVariable thisVar,
					   ReferenceVariable returnVar,
					   ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getClassObject());
  }

  /**
   * Returns an array containing Field objects reflecting all the
   * accessible public fields of the class or interface represented by
   * this Class object.  
   *
   *     private native java.lang.reflect.Field getFields0(int)[];
   */
  public static 
    void java_lang_Class_getFields0(SootMethod method,
				    ReferenceVariable thisVar,
				    ReferenceVariable returnVar,
				    ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getLeastArrayObject());
  }

  /**
   * Returns an array containing Method objects reflecting all the
   * public member methods of the class or interface represented by
   * this Class object, including those declared by the class or
   * interface and and those inherited from superclasses and
   * superinterfaces.
   *
   *     private native java.lang.reflect.Method getMethods0(int)[];
   */
  public static 
    void java_lang_Class_getMethods0(SootMethod method,
				     ReferenceVariable thisVar,
				     ReferenceVariable returnVar,
				     ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getLeastArrayObject());
  }

  /**
   * Returns a Constructor object that reflects the specified public
   * constructor of the class represented by this Class object.  The
   * parameterTypes parameter is an array of Class objects that
   * identify the constructor's formal parameter types, in declared
   * order.  
   * 
   *     private native java.lang.reflect.Constructor getConstructors0(int)[];
   */
  public static 
    void java_lang_Class_getConstructors0(SootMethod method,
					  ReferenceVariable thisVar,
					  ReferenceVariable returnVar,
					  ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getLeastArrayObject());
  }

  /**
   * Returns a Field object that reflects the specified public member
   * field of the class or interface represented by this Class object.
   *
   * Called by getField(String)
   *
   * NOTE: getField0(String name), since the name can be dynamically 
   *       constructed, it may be not able to know exact field name
   *       in static analysis. Uses a C.F to represent the class field.
   *
   *     private native java.lang.reflect.Field getField0(java.lang.String, 
   *                                                      int);       
   */
  public static 
    void java_lang_Class_getField0(SootMethod method,
				   ReferenceVariable thisVar,
				   ReferenceVariable returnVar,
				   ReferenceVariable params[]){
    NativeHelper.assignObjectTo(returnVar, Environment.getFieldObject());
  }

  /**
   * Returns a Method object that reflects the specified public member
   * method of the class or interface represented by this Class
   * object.
   *
   * Called by getMethod()
   *
   *     private native java.lang.reflect.Method getMethod0(java.lang.String, 
   *                                                        java.lang.Class[],
   *                                                        int);
   */
  public static 
    void java_lang_Class_getMethod0(SootMethod method,
				    ReferenceVariable thisVar,
				    ReferenceVariable returnVar,
				    ReferenceVariable params[]){
    NativeHelper.assignObjectTo(returnVar, Environment.getMethodObject());
  }

  /**
   * Returns a constructor of a class
   *
   *     private native java.lang.reflect.Constructor 
   *                            getConstructor0(java.lang.Class[], int);
   */
  public static
    void java_lang_Class_getConstructor0(SootMethod method,
					 ReferenceVariable thisVar,
					 ReferenceVariable returnVar,
					 ReferenceVariable params[]){
    NativeHelper.assignObjectTo(returnVar, Environment.getConstructorObject());
  }

  /**
   * Returns an array of Class objects reflecting all the classes and
   * interfaces declared as members of the class represented by this
   * Class object.
   *
   *     private native java.lang.Class getDeclaredClasses0()[];  
   */
  public static 
    void java_lang_Class_getDeclaredClasses0(SootMethod method,
					     ReferenceVariable thisVar,
					     ReferenceVariable returnVar,
					     ReferenceVariable params[]) {
    NativeHelper.assignObjectTo(returnVar, Environment.getLeastArrayObject());
  }

  /**
   * Following methods have NO side effects.
   *
   * private static native void registerNatives();
   * public native boolean isInstance(java.lang.Object);
   * public native boolean isAssignableFrom(java.lang.Class);
   * public native boolean isInterface();
   * public native boolean isArray();
   * public native boolean isPrimitive();
   * public native int getModifiers();
   */

}