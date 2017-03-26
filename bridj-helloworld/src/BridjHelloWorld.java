import org.bridj.BridJ;
import org.bridj.Pointer;
import org.bridj.ann.Library;

import java.nio.ByteBuffer;

@Library("BridjHelloWorld")
public class BridjHelloWorld {
    public native void printHello();

    public native void printText(Pointer<Byte> text);

    public native void printByteArray(Pointer<Byte> text, int len);

    public native void printBuffer(Pointer<Byte> text, int len);

    static {
        BridJ.register();
    }

    public static void main(String[] args) {
        BridjHelloWorld hw = new BridjHelloWorld();

        hw.printHello();

        hw.printText(Pointer.pointerToCString("Terve!"));

        hw.printByteArray(Pointer.pointerToBytes("Czesc!".getBytes()), 6);

        ByteBuffer buffer = ByteBuffer.allocateDirect(5);
        buffer.put("Czesc".getBytes());
        hw.printBuffer(Pointer.pointerToBytes(buffer), 5);
    }
}