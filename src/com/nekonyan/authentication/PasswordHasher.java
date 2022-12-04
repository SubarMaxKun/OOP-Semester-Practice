package com.nekonyan.authentication;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {

  private static final Charset UTF_8 = StandardCharsets.UTF_8;
  public String shaInBytes;

  /**
   * @param input
   * @return
   */
  private static byte[] digest(byte[] input) {
    MessageDigest md;
    try {
      md = MessageDigest.getInstance("SHA3-256");
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalArgumentException(e);
    }
    return md.digest(input);
  }

  /**
   * @param bytes
   * @return
   */
  private static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  /**
   * @param password
   */
  public void passwordHasher(String password) {
    shaInBytes = bytesToHex(PasswordHasher.digest(password.getBytes(UTF_8)));
  }
}
