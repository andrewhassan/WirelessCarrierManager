package util;

/*
 * The ByteUtil class contains static methods that help to convert between bytes, kilobytes, megabytes, etc.
 */
public class ByteUtil {
	public static Long gigabytesToBytes(Long gB) {
		return gB*1024*1024*1024;
	}
	
	public static Long megabytesToBytes(Long mB) {
		return mB*1024*1024;
	}
	
	public static Long kilobytesToBytes(Long kB) {
		return kB*1024;
	}
}
