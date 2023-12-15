import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPv4Converter {
    public static long convertIPv4ToDigitForm(String ipAddress) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ipAddress);

        byte[] bytesOfAddress = inetAddress.getAddress();
        long digitForm = 0;

        for (byte byteInAddress : bytesOfAddress) {
            digitForm = digitForm << 8 | (byteInAddress & 0xFF);
        }

        return digitForm;

    }

    public static long convertIPv4ToNegativeDigitForm(String ipAddress) throws UnknownHostException {
        InetAddress inetAddress = InetAddress.getByName(ipAddress);

        byte[] bytesOfAddress = inetAddress.getAddress();
        long digitForm = 0;

        for (byte byteInAddress : bytesOfAddress) {
            digitForm = (digitForm << 8) | (byteInAddress & 0xFF);
        }

        if ((digitForm & (1L << 31)) != 0) digitForm |= 0xFFFFFFFF00000000L;

        return digitForm;

    }

    public static String convertDigitFormToIPv4(long digitForm) throws UnknownHostException {
        byte[] bytesOfAddress = new byte[]{
                (byte) ((digitForm >> 24) & 0xFF),
                (byte) ((digitForm >> 16) & 0xFF),
                (byte) ((digitForm >> 8) & 0xFF),
                (byte) (digitForm & 0xFF),
        };
        InetAddress inetAddress = InetAddress.getByAddress(bytesOfAddress);
        return inetAddress.getHostAddress();
    }
}