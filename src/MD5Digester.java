
/**
 * MD5Digester.java
 * @author:youxin
 * @date:2014-05-16
 */

import java.security.MessageDigest;

/**
 * DM5鍔犲瘑
 *  scp -r /oradata/exp_all_2014.zip root@10.88.123.25:/home
 * @author youxin
 * @version 0.9vvvvvvv
 */
public class MD5Digester {
	// 鍗佸叚杩涘埗涓嬫暟瀛楀埌瀛楃鐨勬槧灏勬暟缁�
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	/**
	 * 鍙栧埌鍔犲瘑鍚庣殑鏁版嵁
	 *
	 * @param inputString
	 * @return
	 */
	public static String encode(String inputString) throws Exception {
		return encodeByMD5(inputString);
	}

	/**
	 * 瀵瑰瓧绗︿覆杩涜MD5鍔犲瘑
	 *
	 * @param originString
	 * @return
	 */
	private static String encodeByMD5(String inputString) {

		if (inputString != null) {
			/*while (inputString.length() < 9) {
				inputString += "9";
			}*/
			try {
				// 鍒涘缓鍏锋湁鎸囧畾绠楁硶鍚嶇О鐨勪俊鎭憳瑕�
				MessageDigest md = MessageDigest.getInstance("MD5");
				// 浣跨敤鎸囧畾鐨勫瓧鑺傛暟缁勫鎽樿杩涜鏈�鍚庢洿鏂帮紝鐒跺悗瀹屾垚鎽樿璁＄畻
				byte[] results = md.digest(inputString.getBytes("utf-8"));
				// 灏嗗緱鍒扮殑瀛楄妭鏁扮粍鍙樻垚瀛楃涓茶繑鍥�
				String resultString = byteArrayToHexString(results);
				return resultString;
				//return resultString.toUpperCase();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}

	/**
	 * 杞崲瀛楄妭鏁扮粍涓哄崄鍏繘鍒跺瓧绗︿覆
	 *
	 * @param 瀛楄妭鏁扮粍
	 * @return 鍗佸叚杩涘埗瀛楃涓�
	 */
	private static String byteArrayToHexString(byte[] b) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			resultSb.append(byteToHexString(b[i]));
		}
		return resultSb.toString();
	}

	/**
	 * 灏嗕竴涓瓧鑺傝浆鍖栨垚鍗佸叚杩涘埗褰㈠紡鐨勫瓧绗︿覆
	 *
	 * @param b
	 * @return
	 */
	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n = 256 + n;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static void main(String[] args) throws Throwable {
		String pwd1 = "w5sVVi"; // E3A5D395F275185485468421CC2828B9
		// 202CB962AC59075B964B07152D234B70
	/*	MD5Digester cipher = new MD5Digester();
		String pwd2;

		try {
//			pwd2 = cipher.encode(pwd1);
//			System.out.println("鍔犲瘑鍚庣殑瀵嗙爜:" + pwd2);
			for(int i=0;i<10;i++){
				//String pwd = RandomCodeUtil.createRandomCode();
				//System.out.println(pwd+"--"+cipher.encode(pwd));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		System.out.print(MD5Digester.encode("123456"));
	}
}
增加测试222222