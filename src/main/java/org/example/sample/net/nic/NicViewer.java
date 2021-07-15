package org.example.sample.net.nic;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;
import java.util.Objects;
import java.util.StringJoiner;
import org.apache.commons.lang3.StringUtils;

/**
 * Network Interfaceを表示する.
 */
public class NicViewer {

  /**
   * main.
   *
   * @param args 引数
   * @throws SocketException 　SocketException
   */
  public static void main(String[] args) throws SocketException {
    var obj = new NicViewer();
    obj.show();
  }

  /**
   * 表示する.
   *
   * @throws SocketException SocketException
   */
  public void show() throws SocketException {
    Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
    while (networkInterfaces.hasMoreElements()) {
      NetworkInterface nic = networkInterfaces.nextElement();
      String macAddress = this.getMacAddress(nic);
      System.out.printf("%s : %s - %s%n", nic.getName(), nic.getDisplayName(), macAddress);
    }
  }

  /**
   * MACアドレスを取得する.
   *
   * @param nic NIC
   * @return MACアドレス
   * @throws SocketException SocketException
   */
  private String getMacAddress(final NetworkInterface nic) throws SocketException {
    byte[] macAddress = nic.getHardwareAddress();
    if (Objects.isNull(macAddress)) {
      return StringUtils.EMPTY;
    }

    var joiner = new StringJoiner(":");
    for (byte b : macAddress) {
      joiner.add(String.format("%02X", b));
    }
    return joiner.toString();
  }
}
