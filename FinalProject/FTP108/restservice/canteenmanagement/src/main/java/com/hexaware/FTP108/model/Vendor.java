package com.hexaware.FTP108.model;
import java.util.Objects;
/**
 * Vendor class used to display vendor information.
 * @author hexware
 */
public class Vendor {
  private int vId;
  private String vName;
  private String vUsername;
  private String vPass;
  private String vEmail;
  private String vPhone;
  private String vAddress;
  /**
   * Default Constructor.
   */
  public Vendor() {
  }
 /**
  * @param argVId to initialize vendor id.
  * @param argVName to initialize vendor name.
  * @param argVUsername to initialize vendor user name.
  * @param argVPass to initialize vendor password.
  * @param argVAddress to initialize vendor adress.
  * @param argVPhone to initialize vendor phone number.
  * @param argVEmail to initialize vendor email id.
  */
  public Vendor(final int argVId, final String argVName, final String argVUsername,
                final String argVPass, final String argVEmail, final String argVPhone,
                final String argVAddress) {
    this.vId = argVId;
    this.vName = argVName;
    this.vUsername = argVUsername;
    this.vPass = argVPass;
    this.vEmail = argVEmail;
    this.vPhone = argVPhone;
    this.vAddress = argVAddress;
  }
  @Override
  public final String toString() {
    return this.vId + " " + this.vName + " " + this.vUsername + " " + this.vPass + " " + this.vEmail + " " + this.vPhone + " " + this.vAddress;
  }
  @Override
  public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Vendor ven = (Vendor) obj;
    if (Objects.equals(vId, ven.vId) && Objects.equals(vName, ven.vName)
        && Objects.equals(vUsername, ven.vUsername) && Objects.equals(vPass, ven.vPass)
        && Objects.equals(vEmail, ven.vEmail) && Objects.equals(vPhone, ven.vPhone)
        && Objects.equals(vAddress, ven.vAddress)) {
      return true;
    }
    return false;
  }
  @Override
  public final int hashCode() {
    return Objects.hash(vId, vName, vUsername, vPass, vEmail, vPhone, vAddress);
  }
  /**
   *@return the vId
   */
  public final int getVId() {
    return this.vId;
  }
  /**
   * @param argVId the vId to set.
   */
  public final void setVId(final int argVId) {
    this.vId = argVId;
  }
  /**
   * @return the vName.
   */
  public final String getVName() {
    return this.vName;
  }
  /**
   * @param argVName the vName to set.
   */
  public final void setVName(final String argVName) {
    this.vName = argVName;
  }
  /**
   * @return the vUsername.
   */
  public final String getVUsername() {
    return this.vUsername;
  }
  /**
   * @param argVUsername the vUsername to set.
   */
  public final void setVUsername(final String argVUsername) {
    this.vUsername = argVUsername;
  }
  /**
   * @return the vPass.
   */
  public final String getVPass() {
    return this.vPass;
  }
  /**
   * @param argVPass the vPass to set.
   */
  public final void setVPass(final String argVPass) {
    this.vPass = argVPass;
  }
  /**
   * @return the vEmail.
   */
  public final String getVEmail() {
    return this.vEmail;
  }
  /**
   * @param argVEmail the vEmail to set.
   */
  public final void setvEmail(final String argVEmail) {
    this.vEmail = argVEmail;
  }
  /**
   * @return the vPhone.
   */
  public final String getVPhone() {
    return vPhone;
  }
  /**
   * @param argVPhone the vPhone to set.
   */
  public final void setVPhone(final String argVPhone) {
    this.vPhone = argVPhone;
  }
  /**
   * @return the vAddress.
   */
  public final String getVAddress() {
    return this.vAddress;
  }
  /**
   * @param argVAddress the vAddress to set.
   */
  public final void setVAddress(final String argVAddress) {
    this.vAddress = argVAddress;
  }
}
