package pl.waw.bk.kontakt;
public class Login {

	public static boolean authenticate(String username, String password) {
		String query;
		if (password.substring(0, 1).equals("$")) {
			query = "select login,MD5(password) password FROM user WHERE login='" + username + "' AND password='"
					+ password.substring(1) + "' ;";
		} else {
			query = "select login,MD5(password) password FROM user WHERE login='" + username + "' AND password='"
					+ MD5(password) + "' ;";
		}

		DBConnect con = new DBConnect(query);
		System.out.println(con.getQuery());
		System.out.println(con.count);

		// if (username.equals("bob") && password.equals("secret")) {
		if (con.count == 1) {
			return true;
		}
		return false;
	}

	public static String MD5(String md5) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
			byte[] array = md.digest(md5.getBytes());
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < array.length; ++i) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

}