package com.hexaware.FTP108.integration.test;
import java.util.Objects;
import com.hexaware.FTP108.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.annotation.JsonProperty;

/*Menu Implementation*/
import java.util.Objects;
/**
 * Menu class used to display menu information.
 * @author hexware
 */
 public enum OStatus {
  /**
   * for place order.
   */
   PLACE_ORDER,
   /**
    * for deliver order.
    */
   DELIVERED,
   /**
    * for cancelled order.
    */
   CANCELLED;
}
