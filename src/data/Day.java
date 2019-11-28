package data;

import java.sql.Date;

public class Day extends Data {

  public Day(int yyyy, int mm, int dd) {
    this.val = Date.valueOf(yyyy + "-" + mm + "-" + dd);
  }

}