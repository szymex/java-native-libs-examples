import java.nio.ByteBuffer;

public class HelloWorld {
    public native void print();

    public native void printText(String text);

    public native void printBuffer(ByteBuffer bb);

    public native void printByteArray(byte[] bb);

    static {
        System.out.println("Loading shared lib");
        System.loadLibrary("HelloWorld");
    }

    public static void main(String[] args) {
        HelloWorld jniLib = new HelloWorld();

        jniLib.print();
        jniLib.printText("dupa");
        jniLib.printByteArray("dupa2".getBytes());

        ByteBuffer buffer = ByteBuffer.allocateDirect(10);
        buffer.put("perse".getBytes());
        jniLib.printBuffer(buffer);
    }

}
