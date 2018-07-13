package com.opticdev.installer
import scala.sys.process._

object FindIDE {
  def byBundleId(bundleId: String): Option[String] = {
    val result = s"""mdfind kMDItemCFBundleIdentifier = "$bundleId"""".!!
    if (result != "") {
      Some(result.replace("\n", ""))
    } else {
      None
    }
  }
}
