package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * This class represents factory of proxy wrappers around object to change their behaviour to immutable - all methods
 * except that begins with 'set' are allowed. Setter throws instance of {@link UnsupportedOperationException}.
 *
 * NOTE. Wrapped object can be easily changed using it's direct (not proxy) reference.
 *
 * @author oleksii.morenets@gmail
 */
public class ImmutableProxy {

    /**
     * Creates an 'immutable' proxy wrapper and returns it
     *
     * @param o the reference to the object to be wrapped by immutable proxy
     * @param <T> the future reference type of proxy which is creating
     * @return the reference to immutable proxy wrapper around object o
     */
    public static <T> T getImmutableProxy(Object o) {
        Class clazz = o.getClass();
        Class[] interfaces = clazz.getInterfaces();

        InvocationHandler invocationHandler = (proxy, method, args) -> {

            // in case of setter method - throw an exception
            if (method.getName().startsWith("set")) {
                throw new UnsupportedOperationException("Object is immutable!");
            }

            // return wrapped object method's result in other cases
            return method.invoke(o, args);
        };

        @SuppressWarnings("unchecked")
        T immutableObject = (T) Proxy.newProxyInstance(clazz.getClassLoader(), interfaces, invocationHandler);
        return immutableObject;
    }
}
