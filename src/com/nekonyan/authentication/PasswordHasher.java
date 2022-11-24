package com.nekonyan.authentication;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHasher {
  private static final Charset UTF_8 = StandardCharsets.UTF_8;
  public byte[] shaInBytes;

  private static byte[] digest(byte[] input, String algorithm) {
    MessageDigest md;
    try {
      md = MessageDigest.getInstance(algorithm);
    } catch (NoSuchAlgorithmException e) {
      throw new IllegalArgumentException(e);
    }
    byte[] result = md.digest(input);
    return result;
  }

  private static String bytesToHex(byte[] bytes) {
    StringBuilder sb = new StringBuilder();
    for (byte b : bytes) {
      sb.append(String.format("%02x", b));
    }
    return sb.toString();
  }

  public byte[] passwordHasher(String password){
    shaInBytes = PasswordHasher.digest(password.getBytes(UTF_8), "SHA3-256");
    return shaInBytes;
  }
}
