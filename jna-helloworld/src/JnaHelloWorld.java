import com.sun.jna.Native;
import com.sun.jna.Pointer;

import java.nio.ByteBuffer;

public class JnaHelloWorld {
    public native void printHello();

    public native void printText(String text);

    public native void printByteArray(byte[] text, int len);

    public native byte printBuffer(Pointer pointer, int len);

    static {
        Native.register("Test");
    }

    static public void main(String argv[]) throws InterruptedException {
        JnaHelloWorld hw = new JnaHelloWorld();
        hw.printHello();

        hw.printText("Witaj");

        hw.printByteArray("Terve".getBytes(), 5);

        ByteBuffer buffer = ByteBuffer.allocateDirect(5);
        buffer.put("Czesc".getBytes());
        final Pointer pointer = Native.getDirectBufferPointer(buffer);
        hw.printBuffer(pointer, 5);
    }
}