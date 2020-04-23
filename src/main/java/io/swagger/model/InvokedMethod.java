package io.swagger.model;

public class InvokedMethod {

    private String className;
    private String methodName;

    public InvokedMethod(String className, String methodName) {
        this.className = className;
        this.methodName = methodName;
    }

    public String getClassName() {
        return className;
    }

    public String getMethodName() {
        return methodName;
    }

}
