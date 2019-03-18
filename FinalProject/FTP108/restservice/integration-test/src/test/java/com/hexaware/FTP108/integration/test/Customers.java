package com.hexaware.FTP108.integration.test;

import java.util.Objects;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
public class Customers {
  private int cId;
  private String cName;
  private float cWallet;
  private String cPassword;
  private String cEmail;
  private int cPhone;
  private String cAddress;
  /**
   * Default Constructor.
   */
  public Customers() {

  }
  /**
 * @param argCId to initialize food id.
 * used to get details through constructor.
 * @param argCName to initialize food id.
 * used to get details through constructor.
 * @param argCWallet to initialize food id.
 * used to get details through constructor.
 * @param argCPassword to initialize food id.
 * used to get details through constructor.
 * @param argCEmail to initialize food id.
 * used to get details through constructor.
 * @param argCPhone to initialize food id.
 * used to get details through constructor.
 * @param argCAddress to initialize food id.
 * used to get details through constructor.
 *
 */
  public Customers(final int argCId, final String argCName, final float argCWallet,
      final String argCPassword, final String argCEmail, final int argCPhone,
      final String argCAddress) {
    this.cId = argCId;
    this.cName = argCName;
    this.cWallet = argCWallet;
    this.cPassword = argCPassword;
    this.cEmail = argCEmail;
    this.cPhone = argCPhone;
    this.cAddress = argCAddress;
  }
  @Override
  public final String toString() {
    return  this.cId + " " + this.cName + " " + this.cWallet + " " + this.cPassword + " " + this.cEmail + " " + this.cPhone + " " + this.cAddress;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Customers cus = (Customers) obj;
    if (Objects.equals(cId, cus.cId) && Objects.equals(cName, cus.cName)
        && Objects.equals(cWallet, cus.cWallet) && Objects.equals(cPassword, cus.cPassword)
        && Objects.equals(cEmail, cus.cEmail) && Objects.equals(cPhone, cus.cPhone)
        && Objects.equals(cAddress, cus.cAddress)) {
      return true;
    }
    return false;
  }

  @Override
public final int hashCode() {
    return Objects.hash(cId, cName, cWallet, cPassword, cEmail, cPhone, cAddress);
  }

  /**
   * @return the cId
   */
  public final int getCId() {
    return this.cId;
  }

  /**
   * @param argCId the cId to set
   */
  public final void setCId(final int argCId) {
    this.cId = argCId;
  }

  /**
   * @return the cName
   */
  public final String getCName() {
    return cName;
  }

  /**
   * @param argCName the cName to set
   */
  public final void setCName(final String argCName) {
    this.cName = argCName;
  }

  /**
   * @return the cWallet
   */
  public final float getCWallet() {
    return cWallet;
  }

  /**
   * @param argCWallet the cWallet to set
   */
  public final void setCWallet(final float argCWallet) {
    this.cWallet = argCWallet;
  }

  /**
   * @return the cPassword
   */
  public final String getCPassword() {
    return cPassword;
  }

  /**
   * @param argCPassword the cPassword to set
   */
  public final void setCPassword(final String argCPassword) {
    this.cPassword = argCPassword;
  }

  /**
   * @return the cEmail
   */
  public final String getCEmail() {
    return cEmail;
  }

  /**
   * @param argCEmail the cEmail to set
   */
  public final void setCEmail(final String argCEmail) {
    this.cEmail = argCEmail;
  }

  /**
   * @return the cPhone
   */
  public final int getCPhone() {
    return cPhone;
  }

  /**
   * @param argCPhone the cPhone to set
   */
  public final void setCPhone(final int argCPhone) {
    this.cPhone = argCPhone;
  }

  /**
   * @return the cAddress
   */
  public final String getCAddress() {
    return cAddress;
  }

  /**
   * @param argCAddress the cAddress to set
   */
  public final void setCAddress(final String argCAddress) {
    this.cAddress = argCAddress;
  }
}
